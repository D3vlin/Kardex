package com.cidenet.hulkstore.controller.kardex;

import com.cidenet.hulkstore.documents.DocumentDao;
import com.cidenet.hulkstore.documents.DocumentDto;
import com.cidenet.hulkstore.exceptions.DaoException;
import com.cidenet.hulkstore.factory.DaoFactory;
import com.cidenet.hulkstore.kardex.KardexDetailDao;
import com.cidenet.hulkstore.kardex.KardexDetailDto;
import com.cidenet.hulkstore.view.kardex.UIUpdateKardexDetails;
import com.cidenet.hulkstore.view.menu.UIMenu;
import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Kardex detail log modification driver
 * 
 * Load, receive and validate data on an existing entry or exit movement record of a product
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-27
 */
public final class CUpdateKardexDetails
{
    private UIUpdateKardexDetails window;
    private DocumentDao documentDao = DaoFactory.createDocumentDao();
    private KardexDetailDao kardexDetailDao = DaoFactory.createKardexDetailDao();
    private DocumentDto[] documents;
    private KardexDetailDto kardexDetailDto;
    
    /**
     * Builder that loads the kardex details.
     * 
     * @param kardexDetailDto
     */
    public CUpdateKardexDetails(KardexDetailDto kardexDetailDto)
    {
        try {
            this.documents = documentDao.findWhereStateEquals((short) 1);
            this.kardexDetailDto = kardexDetailDto;
            
            window = new UIUpdateKardexDetails(this);
        } catch (DaoException exception) {}
    }
    
    /**
     * Load the kardex details.
     * 
     * @param txtDetailId
     * @param txtProductId
     * @param txtStoreId
     * @param dtcDate
     * @param txtDocumentId
     * @param cmbDocumentDescription
     * @param txtDocumentNumber
     * @param cmbOperation
     * @param txtQuantity
     * @param txtUnityValue
     * @param txtTotalValue
     * @param txaObservations 
     */
    public void upload(JTextField txtDetailId, JTextField txtProductId, JTextField txtStoreId, JDateChooser dtcDate, JTextField txtDocumentId, JComboBox cmbDocumentDescription, JTextField txtDocumentNumber, JComboBox cmbOperation, JTextField txtQuantity, JTextField txtUnityValue, JTextField txtTotalValue, JTextArea txaObservations)
    {
        txtDetailId.setText(String.valueOf(kardexDetailDto.getDetailId()));
        txtProductId.setText(String.valueOf(kardexDetailDto.getProductId()));
        txtStoreId.setText(String.valueOf(kardexDetailDto.getStoreId()));
        txtDocumentId.setText(String.valueOf(kardexDetailDto.getDocumentId()));
        txtDocumentNumber.setText(String.valueOf(kardexDetailDto.getDocumentNumber()));
        txtQuantity.setText(String.valueOf(kardexDetailDto.getQuantity()));
        txtUnityValue.setText(String.valueOf(kardexDetailDto.getUnityValue()));
        txtTotalValue.setText(String.valueOf(kardexDetailDto.getTotalValue()));
        txaObservations.setText(kardexDetailDto.getObservations());
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(kardexDetailDto.getKardexDetailYear(), kardexDetailDto.getKardexDetailMonth() - 1, kardexDetailDto.getKardexDetailday());        
        dtcDate.setCalendar(calendar);
        
        int operation = 0;
        if(kardexDetailDto.getOperation() == 1) { operation = 1; }        
        cmbOperation.setSelectedIndex(operation);        

        for(int i = 0; i < documents.length; i++) 
        {
            cmbDocumentDescription.insertItemAt(documents[i].getDocumentDescription(), i);
            
            if(documents[i].getDocumentId() == kardexDetailDto.getDocumentId()) {
                cmbDocumentDescription.setSelectedItem(documents[i].getDocumentDescription());
            }
        }
    }
    
    /**
     * Modify kardex detail
     * 
     * @param txtDetailId
     * @param dtcDate
     * @param txtDocumentId
     * @param txtDocumentNumber
     * @param cmbOperation
     * @param txtQuantity
     * @param txtUnityValue
     * @param txtTotalValue
     * @param txaObservations 
     */
    public void accept(JTextField txtDetailId, JDateChooser dtcDate, JTextField txtDocumentId, JTextField txtDocumentNumber, JComboBox cmbOperation, JTextField txtQuantity, JTextField txtUnityValue, JTextField txtTotalValue, JTextArea txaObservations)
    {
        Calendar calendar = dtcDate.getCalendar();
        
        try
        {
            short operation;
            if(cmbOperation.getSelectedIndex() == 0) { operation = 0; }
            else { operation = 1; }
            
            kardexDetailDto.setDetailId(Integer.parseInt(txtDetailId.getText()));
            kardexDetailDto.setKardexDetailYear(calendar.get(Calendar.YEAR));
            kardexDetailDto.setKardexDetailMonth(calendar.get(Calendar.MONTH) + 1);
            kardexDetailDto.setKardexDetailday(calendar.get(Calendar.DATE));
            kardexDetailDto.setUserId(UIMenu.userId);
            kardexDetailDto.setDocumentId(Short.valueOf(txtDocumentId.getText()));
            kardexDetailDto.setDocumentNumber(Integer.parseInt(txtDocumentNumber.getText()));
            kardexDetailDto.setOperation(operation);
            kardexDetailDto.setQuantity(Double.parseDouble(txtQuantity.getText()));
            kardexDetailDto.setUnityValue(Double.parseDouble(txtUnityValue.getText()));
            kardexDetailDto.setTotalValue(Double.parseDouble(txtTotalValue.getText()));
            kardexDetailDto.setObservations(txaObservations.getText());
                                          
            if(kardexDetailDao.update(kardexDetailDto.createPk(), kardexDetailDto)) {
                JOptionPane.showMessageDialog(null, "Se ha modificado el registro", "MODIFICACIÓN", JOptionPane.INFORMATION_MESSAGE);
                CKardex cKardex = new CKardex();
                window.dispose();
                
            } else { JOptionPane.showMessageDialog(null, "No se ha modificado el registro", "ERROR", JOptionPane.ERROR_MESSAGE); }
        
        } catch(NumberFormatException | DaoException exception) {
            JOptionPane.showMessageDialog(null, "Exception: " + exception.toString(), "Error", JOptionPane.ERROR_MESSAGE);
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