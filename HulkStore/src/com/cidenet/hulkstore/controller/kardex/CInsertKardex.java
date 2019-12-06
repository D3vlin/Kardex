package com.cidenet.hulkstore.controller.kardex;

import com.cidenet.hulkstore.exceptions.DaoException;
import com.cidenet.hulkstore.factory.DaoFactory;
import com.cidenet.hulkstore.kardex.KardexDao;
import com.cidenet.hulkstore.kardex.KardexDto;
import com.cidenet.hulkstore.products.ProductDao;
import com.cidenet.hulkstore.products.ProductDaoException;
import com.cidenet.hulkstore.products.ProductDto;
import com.cidenet.hulkstore.stores.StoreDao;
import com.cidenet.hulkstore.stores.StoreDaoException;
import com.cidenet.hulkstore.stores.StoreDto;
import com.cidenet.hulkstore.view.kardex.UIInsertKardex;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Kardex insertion controller
 * 
 * Receive data about a new kardex record.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-25
 */
public final class CInsertKardex 
{
    private UIInsertKardex window;
    ProductDto[] products;
    StoreDto[] stores;
    
    /**
     * Empty Contructor.
     */
    public CInsertKardex()
    {
        try {
            ProductDao productDao = DaoFactory.createProductDao();
            StoreDao storeDao = DaoFactory.createStoreDao();
            
            products = productDao.findAll();
            stores = storeDao.findAll();
            
            window = new UIInsertKardex(this);
            
        } catch (ProductDaoException | StoreDaoException ex) {}
    }    
    
    /**
     * Load the description of active products and stores in the database.
     * 
     * @param cmbProductName
     * @param cmbStoreName
     */
    public void upload(JComboBox cmbProductName, JComboBox cmbStoreName)
    {
        for(int i = 0; i < products.length; i++)
        {
            cmbProductName.insertItemAt(products[i].getProductName(), i);
        }
        for(int i = 0; i < stores.length; i++)
        {
            cmbStoreName.insertItemAt(stores[i].getStoreName(), i);
        }
    }
    
    /**
     * Register the new kardex.
     * 
     * @param txtProductId
     * @param txtStoreId
     */
    public void accept(JTextField txtProductId, JTextField txtStoreId)
    {
        try {
            KardexDto kardex = new KardexDto(Integer.parseInt(txtProductId.getText()), Integer.parseInt(txtStoreId.getText()), 0, 0, 0, (short) 1);
            KardexDao kardexDao = DaoFactory.createKardexDao();
            
            if(!kardexDao.insert(kardex).isProductIdNull()) {
                JOptionPane.showMessageDialog(null, "Se ha agregado el registro nuevo", "INSERCION", JOptionPane.INFORMATION_MESSAGE);
                CKardex cKardex = new CKardex();
                window.dispose();
                
            } else { JOptionPane.showMessageDialog(null, "No se registro", "ERROR", JOptionPane.ERROR_MESSAGE); }
            
        } catch (DaoException exception) {}
    }
    
    /**
     * Cancel the operation and return to the kardex menu.
     */
    public void cancel()
    {
        try {
            CKardex cKardex = new CKardex();
            window.dispose();
            
        } catch (DaoException ex) {}
    }
    
    /**
     * Get the id of the selected product.
     * 
     * @param txtProductId
     * @param cmbProductName 
     */
    public void seeProduct(JTextField txtProductId, JComboBox cmbProductName)
    {
        txtProductId.setText(String.valueOf(products[cmbProductName.getSelectedIndex()].getProductId()));
    }
    
    /**
     * Get the id of the selected store.
     * 
     * @param txtStoreId
     * @param cmbStoreName 
     */
    public void seeStore(JTextField txtStoreId, JComboBox cmbStoreName)
    {
        txtStoreId.setText(String.valueOf(stores[cmbStoreName.getSelectedIndex()].getStoreId()));
    }
}