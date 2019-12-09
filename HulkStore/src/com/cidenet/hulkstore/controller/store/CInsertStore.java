package com.cidenet.hulkstore.controller.store;

import com.cidenet.hulkstore.stores.StoreDaoException;
import com.cidenet.hulkstore.stores.StoreDao;
import com.cidenet.hulkstore.stores.StoreDto;
import com.cidenet.hulkstore.view.store.UIInsertStore;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Store Insertion Controller.
 * 
 * Receive and validate data about a new store registration.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-13
 */
public final class CInsertStore
{
    private UIInsertStore window;
    
    /**
     * Empty Constructor.
     */
    public CInsertStore() { window = new UIInsertStore(this); }

    /**
     * Upload the store information to the form.
     * 
     * @param txtStoreId 
     */
    public void upload(JTextField txtStoreId) 
    {        
        try {
            StoreDao dao = new StoreDao();
            txtStoreId.setText(dao.findNextStoreId());
            
        } catch (StoreDaoException exception) {}
    }

    /**
     * Register the new store.
     * 
     * @param txtStoreId
     * @param txtStoreName
     * @param txtAddress 
     */
    public void accept(JTextField txtStoreId, JTextField txtStoreName, JTextField txtAddress)
    {                
        try {
            StoreDto dto = new StoreDto(Integer.parseInt(txtStoreId.getText()), txtStoreName.getText(), txtAddress.getText());
            StoreDao dao = new StoreDao();
            
            if(!dao.insert(dto).isStoreIdNull()){
                JOptionPane.showMessageDialog(null, "Se ha agregado el registro nuevo", "INSERCION", JOptionPane.INFORMATION_MESSAGE);
                CStore cStore = new CStore();
                window.dispose();
                
            } else { JOptionPane.showMessageDialog(null, "No se registro", "ERROR", JOptionPane.ERROR_MESSAGE); }
            
        } catch (StoreDaoException exception) {}
    }

    /**
     * Cancel the operation and return to the stores menu.
     */
    public void cancel() {
        CStore cStore = new CStore();
        window.dispose();
    }    
}