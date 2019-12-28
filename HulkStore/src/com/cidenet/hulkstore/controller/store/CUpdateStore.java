package com.cidenet.hulkstore.controller.store;

import com.cidenet.hulkstore.model.dao.DaoFactory;
import com.cidenet.hulkstore.stores.StoreDaoException;
import com.cidenet.hulkstore.stores.StoreDao;
import com.cidenet.hulkstore.stores.StoreDto;
import com.cidenet.hulkstore.view.store.UIUpdateStore;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Store Modification Controller
 * 
 * Load data from the selected store, receive new values and validate them
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-13
 */
public final class CUpdateStore
{
    private UIUpdateStore window;
    private StoreDao storeDao = DaoFactory.createStoreDao();
    private StoreDto storeDto;
    
    /**
     * Constructor.
     * 
     * @param storeId 
     */
    public CUpdateStore(int storeId)
    {
        try {
            storeDto = storeDao.findByPrimaryKey(storeId);            
            window = new UIUpdateStore(this);
            
        } catch (StoreDaoException exception) {}       
    }

    /**
     * Upload the store information to the form.
     * 
     * @param txtstoreId
     * @param txtStoreName
     * @param txtAddress 
     */
    public void upload(JTextField txtstoreId, JTextField txtStoreName, JTextField txtAddress) {
        txtstoreId.setText(String.valueOf(storeDto.getStoreId()));
        txtStoreName.setText(storeDto.getStoreName());
        txtAddress.setText(storeDto.getAddress());
    }

    /**
     * Modify the store.
     * 
     * @param txtStoreName
     * @param txtAddress 
     */
    public void accept(JTextField txtStoreName, JTextField txtAddress) {
        try {
            storeDto.setStoreName(txtStoreName.getText());
            storeDto.setAddress(txtAddress.getText());
            
            if(storeDao.update(storeDto.createPk(), storeDto)){
                JOptionPane.showMessageDialog(null, "Se ha modificado el registro", "MODIFICACIÓN", JOptionPane.INFORMATION_MESSAGE);
                CStore cStore = new CStore();
                window.dispose();
                
            } else { JOptionPane.showMessageDialog(null, "No se ha modificado el registro", "ERROR", JOptionPane.ERROR_MESSAGE); }
            
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