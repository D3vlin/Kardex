package com.cidenet.hulkstore.controller.kardex;

import com.cidenet.hulkstore.model.dao.document.DocumentDao;
import com.cidenet.hulkstore.model.dao.document.DocumentDaoException;
import com.cidenet.hulkstore.model.dto.document.DocumentDto;
import com.cidenet.hulkstore.model.dao.DaoException;
import com.cidenet.hulkstore.model.dao.DaoFactory;
import com.cidenet.hulkstore.model.dao.kardex.KardexDetailDao;
import com.cidenet.hulkstore.model.dao.kardex.KardexDetailDaoException;
import com.cidenet.hulkstore.model.dto.kardex.KardexDetailDto;
import com.cidenet.hulkstore.view.kardex.UIInsertKardexDetails;
import com.cidenet.hulkstore.view.menu.UIMenu;
import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Kardex detail registration insert controller
 * 
 * Receive and validate data on a new registration of movement of entry or exit of a product
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-26
 */
public final class CInsertKardexDetails 
{
    private UIInsertKardexDetails window;
    private final KardexDetailDao kardexDetailDao = DaoFactory.createKardexDetailDao();
    private DocumentDto[] documents;
    private int productId;
    private int storeId; 
    
    /**
     * Builder that loads the data from the kardex header.
     * 
     * @param productId
     * @param storeId 
     */
    public CInsertKardexDetails(int productId, int storeId)
    {
        try {
            this.productId = productId;
            this.storeId = storeId;
            
            DocumentDao documentDao = DaoFactory.createDocumentDao();
            documents = documentDao.findWhereStateEquals((short) 1);
            window = new UIInsertKardexDetails(this);
            
        } catch (DocumentDaoException exception) {}
    }    
    
    /**
     * Load the description of active products, stores ans documents in the database.
     * 
     * @param cmbDocumentDescription
     * @param txtDetailId
     * @param txtProductId
     * @param txtStoreId
     */
    public void upload(JComboBox cmbDocumentDescription, JTextField txtDetailId ,JTextField txtProductId, JTextField txtStoreId)
    {
        try {
            for(int i = 0; i < documents.length; i++)
            {  
                cmbDocumentDescription.insertItemAt(documents[i].getDocumentDescription(), i);
            }
            txtDetailId.setText(kardexDetailDao.findNextDetailId());
            txtProductId.setText(String.valueOf(productId));
            txtStoreId.setText(String.valueOf(storeId));
            
        } catch (KardexDetailDaoException exception) {}
    }
    
    /**
     * Register the new kardex detail.
     * 
     * @param txtDetailId
     * @param txtProductId
     * @param txtStoreId
     * @param dtcDate
     * @param txtDocumentId
     * @param txtDocumentNumber
     * @param cmbOperation
     * @param txtQuantity
     * @param txtUnityValue
     * @param txtTotalValue
     * @param txaObservations
     */
    public void accept(JTextField txtDetailId, JTextField txtProductId, JTextField txtStoreId, JDateChooser dtcDate, JTextField txtDocumentId, JTextField txtDocumentNumber ,JComboBox cmbOperation, JTextField txtQuantity, JTextField txtUnityValue, JTextField txtTotalValue, JTextArea txaObservations)
    {
        Calendar c = dtcDate.getCalendar();
        
        try {
            short operation;
            if(cmbOperation.getSelectedIndex() == 0) { operation = 1; }
            else { operation = 0; }
            
            KardexDetailDto kardexDetailDto = new KardexDetailDto(Integer.parseInt(txtDetailId.getText()),
                                                                  Short.valueOf(txtProductId.getText()),
                                                                  Short.valueOf(txtStoreId.getText()),
                                                                  c.get(Calendar.YEAR),
                                                                  c.get(Calendar.MONTH) + 1,
                                                                  c.get(Calendar.DATE),
                                                                  UIMenu.userId,
                                                                  Short.valueOf(txtDocumentId.getText()),
                                                                  Integer.parseInt(txtDocumentNumber.getText()),
                                                                  operation,
                                                                  Double.parseDouble(txtQuantity.getText()),
                                                                  Double.parseDouble(txtUnityValue.getText()),
                                                                  Double.parseDouble(txtTotalValue.getText()),
                                                                  txaObservations.getText()
                    
            );
                      
            if(!kardexDetailDao.insert(kardexDetailDto).isDetailIdNull()) {
                JOptionPane.showMessageDialog(null, "Se ha agregado el registro nuevo", "INSERCION", JOptionPane.INFORMATION_MESSAGE);
                CKardex cKardex = new CKardex();
                window.dispose();
                
            } else { JOptionPane.showMessageDialog(null, "No se registro", "ERROR", JOptionPane.ERROR_MESSAGE); }
            
        } catch(NumberFormatException | DaoException exception) {
            JOptionPane.showMessageDialog(null, "Cantidad o Valor Total inválido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Cancel the operation and return to the kardex menu.
     */
    public void cancel()
    {
        try {
            CKardex cKardex = new CKardex();
            window.dispose();
            
        } catch (DaoException exception) {}
    }
    
    /**
     * Get the id of the selected document.
     * 
     * @param cmbDocumentDescription
     * @param txtDocumentId
     */
    public void seeDocument(JComboBox cmbDocumentDescription, JTextField txtDocumentId)
    {
        txtDocumentId.setText(String.valueOf(documents[cmbDocumentDescription.getSelectedIndex()].getDocumentId()));
    }
    
    /**
     * Calculate the quantity, unit value and total value.
     * 
     * @param txtQuantity
     * @param txtUnitValue
     * @param txtTotalValue
     * @param field 
     */
    public void calculate(JTextField txtQuantity, JTextField txtUnitValue, JTextField txtTotalValue, int field)
    {
        boolean validQuantity    = !(txtQuantity.getText().length() == 0);
        boolean validUnitValue = !(txtUnitValue.getText().length() == 0);
        boolean validTotalValue = !(txtTotalValue.getText().length() == 0);
        
        double quantity  = 0;
        double unitValue = 0;
        double totalValue = 0;
        
        try { quantity = Double.parseDouble(txtQuantity.getText()); }
        catch(NumberFormatException e) { validQuantity = false; }
        
        try { unitValue = Double.parseDouble(txtUnitValue.getText()); }
        catch(NumberFormatException e) { validUnitValue = false; }
        
        try { totalValue = Double.parseDouble(txtTotalValue.getText()); }
        catch(NumberFormatException e) { validTotalValue = false; }
             
        if(validQuantity && validUnitValue && field != 3) {
            totalValue = roundOutDecimals((quantity * unitValue), 2);
            txtTotalValue.setText(String.valueOf(totalValue));
        
        } else if(validQuantity && validTotalValue && field != 2) {
            unitValue = roundOutDecimals((totalValue / quantity), 2);
            if(!Double.isFinite(unitValue)) { unitValue = 0; }
            txtUnitValue.setText(String.valueOf(unitValue));
            
        } else if(validUnitValue && validTotalValue && field != 1) {
            quantity = roundOutDecimals((totalValue / unitValue), 2);
            if(!Double.isFinite(quantity)) { quantity = 0; }
            txtQuantity.setText(String.valueOf(quantity));
        }
    }
    
    /**
     * round the decimals of a number according to the specified quantity.
     * 
     * @param initialValue
     * @param decimalNumbers
     * @return 
     */
    private double roundOutDecimals(double initialValue, int decimalNumbers) {
        double integerPart;
        double result;
        
        result = initialValue;
        integerPart = Math.floor(result);
        
        result = (result-integerPart) * Math.pow(10, decimalNumbers);
        result = Math.round(result);
        result = (result/Math.pow(10, decimalNumbers))+integerPart;
        
        return result;
    }        
}