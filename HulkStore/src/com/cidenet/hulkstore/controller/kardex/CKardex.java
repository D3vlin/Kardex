package com.cidenet.hulkstore.controller.kardex;

import com.cidenet.hulkstore.controller.menu.CMenu;
import com.cidenet.hulkstore.controller.reports.CReports;
import com.cidenet.hulkstore.documents.DocumentDao;
import com.cidenet.hulkstore.documents.DocumentDto;
import com.cidenet.hulkstore.exceptions.DaoException;
import com.cidenet.hulkstore.factory.DaoFactory;
import com.cidenet.hulkstore.kardex.KardexDao;
import com.cidenet.hulkstore.kardex.KardexDaoException;
import com.cidenet.hulkstore.kardex.KardexDetailDao;
import com.cidenet.hulkstore.kardex.KardexDetailDaoException;
import com.cidenet.hulkstore.kardex.KardexDetailDto;
import com.cidenet.hulkstore.kardex.KardexDetailView;
import com.cidenet.hulkstore.kardex.KardexDto;
import com.cidenet.hulkstore.kardex.KardexView;
import com.cidenet.hulkstore.products.ProductDao;
import com.cidenet.hulkstore.products.ProductDaoException;
import com.cidenet.hulkstore.products.ProductDto;
import com.cidenet.hulkstore.stores.StoreDao;
import com.cidenet.hulkstore.stores.StoreDaoException;
import com.cidenet.hulkstore.stores.StoreDto;
import com.cidenet.hulkstore.users.UsersDao;
import com.cidenet.hulkstore.users.UsersDto;
import com.cidenet.hulkstore.view.kardex.UIKardex;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Kardex management main controller
 * 
 * Load the products - existing stores with their data,
 * in addition to controlling the redirection to the insertion or modification windows. 
 * Kardex removal is done here.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-25
 */
public class CKardex
{
    private UIKardex window;
    private KardexDao kardexDao = DaoFactory.createKardexDao();  
    private KardexDto[] kardex;
    private KardexDetailDao kardexDetailDao = DaoFactory.createKardexDetailDao();
    private KardexDetailDto[] kardexDetails;
    private KardexDetailDto[] kardexDetailsActive;
    private int productId;
    private int storeId;   
    
    public CKardex() throws DaoException
    {
        try 
        {          
            kardex = kardexDao.findAll();
            
            window = new UIKardex(this);
            
        } catch (KardexDaoException ex) {}
    }
    
    public void upload(JTable tblKardex) throws DaoException
    {
        DefaultTableModel model = (DefaultTableModel) tblKardex.getModel();
        model.setRowCount(0);
        
        ProductDto product;
        ProductDao productDao = DaoFactory.createProductDao();
        StoreDto store;
        StoreDao storeDao = DaoFactory.createStoreDao();
        
	int kardezSize = kardex.length;
        for(int i = 0; i < kardezSize; i++)
        {
            try {
                product = productDao.findByPrimaryKey(kardex[i].getProductId());
                store = storeDao.findByPrimaryKey(kardex[i].getStoreId());
                String state;
                
                if(kardex[i].getState() == 1)
                    { state = "A"; }
                else
                    { state = "*"; }
                
                model.addRow(new Object[]{ product.getProductId(),
                                           product.getProductName(),
                                           store.getStoreId(),
                                           store.getStoreName(),
                                           state}
                );
                
            } catch (ProductDaoException | StoreDaoException ex) {}
        }
    }
    
    public void updateStateKardex(JTable tblKardex, JTable tblKardexDetails, JTextField txtQuantity, JTextField txtUnityValue, JTextField txtTotalValue)
    {
        try {
            DefaultTableModel model = (DefaultTableModel) tblKardexDetails.getModel();
            model.setRowCount(0);
            int i = tblKardex.getSelectedRow();
            
            txtQuantity.setText(String.valueOf(kardex[i].getQuantity()));
            txtUnityValue.setText(String.valueOf(kardex[i].getUnityValue()));
            txtTotalValue.setText(String.valueOf(kardex[i].getTotalValue()));
            
            productId = kardex[i].getProductId();
            storeId = kardex[i].getStoreId();
            kardexDetails = kardexDetailDao.findWhereProductIdAndStoreIdEquals(productId, storeId);
            
            int detailSize = kardexDetails.length;
            String operation;
            String state;
            
            for(i = 0; i < detailSize; i++)
            {
                if(kardexDetails[i].getOperation()== 1)
                { operation = "Entrada"; }
                else
                { operation = "Salida"; }
                
                if(kardexDetails[i].getState()== 1)
                { state = "A"; }
                else
                { state = "*"; }
                
                model.addRow(new Object[]{ kardexDetails[i].getDetailId(),
                    kardexDetails[i].getKardexDetailDate(),
                    operation,
                    kardexDetails[i].getQuantity(),
                    kardexDetails[i].getUnityValue(),
                    kardexDetails[i].getTotalValue(),
                    state}
                );
            }
            
        } catch (KardexDetailDaoException ex) {}
    }
    
    public void updateStateKardexDetail(JTable tblKardex, JTable tblKardexDetails, JTextField txtUser, JTextField txtDocumentDescription, JTextField txtDocumentNumber, JTextArea txaObservations, JTextField txtState)
    {
        try {
            int i = tblKardex.getSelectedRow();
            int j = tblKardexDetails.getSelectedRow();
            
            if(i != -1 && j != -1)
            {
            
                productId = kardex[i].getProductId();
                storeId = kardex[i].getStoreId();
                kardexDetails = kardexDetailDao.findWhereProductIdAndStoreIdEquals(productId, storeId);

                UsersDto userdto;
                UsersDao userDao = DaoFactory.createUsersDao();
                userdto = userDao.findByPrimaryKey(kardexDetails[j].getUserId());
                String userName = userdto.getRealName() + " " + userdto.getSurname();

                DocumentDto documentDto;
                DocumentDao documentDao = DaoFactory.createDocumentDao();
                documentDto = documentDao.findByPrimaryKey(kardexDetails[j].getDocumentId());

                String state;
                
                txtUser.setText(userName);
                txtDocumentDescription.setText(documentDto.getDocumentDescription());
                txtDocumentNumber.setText(String.valueOf(kardexDetails[j].getDocumentNumber()));
                txaObservations.setText(kardexDetails[j].getObservations());
                
                if(kardexDetails[j].getState() == 1) { state = "Activo"; }
                else { state = "Eliminado"; }
                
                txtState.setText(state);
            }
            else
            {
                txtUser.setText("");
                txtDocumentDescription.setText("");
                txtDocumentNumber.setText("");
                txaObservations.setText("");
                txtState.setText("");
            }
            
        } catch (DaoException ex) {}
    }
    
    public void insertKardex()
    {
        new CInsertKardex();
        window.dispose();
    }
    
    public void deleteKardex(JTable tblKardex, JTable tblKardexDetails, JTextField txtState)
    {
        int i = tblKardex.getSelectedRow();
        
        if(i != -1)
        {
            KardexDto kardexDto = kardex[i];
            
            if(kardexDto.getState() != 3 && 
                JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                try {
                    KardexDao kardexDao = DaoFactory.createKardexDao();
                    kardexDto.setState((short) 3);
                    
                    if(kardexDao.update(kardexDto.createPk(), kardexDto))
                    {
                        DefaultTableModel model = (DefaultTableModel) tblKardex.getModel();
                        model.setValueAt("*", i, 4);
                        
                        if(tblKardexDetails.getSelectedRow() != -1)
                            { txtState.setText("Eliminado"); }
                        
                        kardexDetails = kardexDetailDao.findWhereProductIdAndStoreIdEquals(productId, storeId);                        
                        for(int j = 0; j < kardexDetails.length; j++)
                        {
                            KardexDetailDto kardexDetailDto = kardexDetails[j];
                            kardexDetailDto.setState((short) 3);
                            kardexDetailDao.update(kardexDetailDto.createPk(), kardexDetailDto);
                        }
                    }
                    
                } catch (DaoException ex) {}
                
            } else { JOptionPane.showMessageDialog(null, "El registro ya está eliminado", "ERROR", JOptionPane.ERROR_MESSAGE); }
                
        } else { JOptionPane.showMessageDialog(null, "Seleccione un registro a eliminar", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }
    
    public void insertKardexDetails(JTable tblKardex)
    {
        int i = tblKardex.getSelectedRow();
        
        if(i != -1)
        {
            KardexDto kardexDto = kardex[i];
            
            if(kardexDto.getState() == 1)
            {                
                new CInsertKardexDetails(productId, storeId);
                window.dispose();
                
            } else { JOptionPane.showMessageDialog(null, "Solo se permite insertar en registros activos", "ERROR", JOptionPane.ERROR_MESSAGE); }
            
        } else { JOptionPane.showMessageDialog(null, "Seleccione un Kardex Cabecera", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }
    
    public void updateKardexDetails(JTable tblKardex)
    {
        int i = tblKardex.getSelectedRow();
        
        if(i != -1)
        {
            try
            {
                KardexDetailDto kardexDetailDto = kardexDetailDao.findLastKardexDetail(kardex[i].getProductId(), kardex[i].getStoreId());
                
                if(kardexDetailDto.getState() == 1)
                {        
                    new CUpdateKardexDetails(kardexDetailDto);
                    window.dispose();
                        
                } else { JOptionPane.showMessageDialog(null, "Solo se permite modificar registros activos", "ERROR", JOptionPane.ERROR_MESSAGE); }
            }
            catch(ArrayIndexOutOfBoundsException | DaoException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Nada por modificar", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
        } else { JOptionPane.showMessageDialog(null, "Seleccione un Kardex Cabecera", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }
    
    public void deleteKardexDetails(JTable tblKardex)
    {
        int i = tblKardex.getSelectedRow();
        
        if(i != -1)
        {
            try
            {
                KardexDetailDto kardexDetailDto = kardexDetailDao.findLastKardexDetail(kardex[i].getProductId(), kardex[i].getStoreId());
                if(kardexDetailDto.getState() != 3)
                {
                    if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    {
                        kardexDetailDto.setState((short) 3);
                        kardexDetailDao.update(kardexDetailDto.createPk(), kardexDetailDto);
                        new CKardex();
                        window.dispose();
                    }
                    
                } else { JOptionPane.showMessageDialog(null, "El registro ya está eliminado", "ERROR", JOptionPane.ERROR_MESSAGE); }
            }
            catch(ArrayIndexOutOfBoundsException | DaoException e)
            {
                JOptionPane.showMessageDialog(null, "Exception: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } else { JOptionPane.showMessageDialog(null, "Seleccione un Kardex Cabecera", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }
    
    public void menu()
    {
        new CMenu();
        window.dispose();
    }
    
    public void generateReport(JTable tblKardex)
    {
        int i = tblKardex.getSelectedRow();
        
        if(i != -1)
        {
            KardexDto kardexDto = kardex[i];
            if(kardexDto.getState() == 1)
            {
                try {
                    KardexView kardexView = kardexDao.getKardexView(kardexDto.getProductId(), kardexDto.getStoreId())[0];
                    KardexDetailView[] kardexDetailView = kardexDetailDao.getKardexDetailView(kardexDto.getProductId(), kardexDto.getStoreId());
                    CReports report = new CReports();
                    report.generateKardexReport(kardexView, kardexDetailView);
                    
                } catch (KardexDaoException ex) {}
            }
            
            else{ JOptionPane.showMessageDialog(null, "El registro no está activo", "ERROR", JOptionPane.ERROR_MESSAGE); }
            
        } else { JOptionPane.showMessageDialog(null, "Seleccione un registro de Kardex Cabecera", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }
}
