package com.cidenet.hulkstore.controller.store;

import com.cidenet.hulkstore.stores.StoreDao;
import com.cidenet.hulkstore.stores.StoreDaoException;
import com.cidenet.hulkstore.stores.StoreDaoImpl;
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
public class CUpdateStore implements IUpdateStore
{
    private UIUpdateStore window;
    private StoreDao dao = new StoreDaoImpl();
    private StoreDto dto;
    
    public CUpdateStore(int storeId)
    {
        try {
            dto = dao.findByPrimaryKey(storeId);
            
            window = new UIUpdateStore(this);
        } catch (StoreDaoException ex) 
        {
        }       
    }

    @Override
    public void upload(JTextField txtstoreId, JTextField txtStoreName, JTextField txtAddress) {
        txtstoreId.setText(String.valueOf(dto.getStoreId()));
        txtStoreName.setText(dto.getStoreName());
        txtAddress.setText(dto.getAddress());
    }

    @Override
    public void accept(JTextField txtStoreName, JTextField txtAddress) {
        try {
            dto.setStoreName(txtStoreName.getText());
            dto.setAddress(txtAddress.getText());
            
            if(dao.update(dto.createPk(), dto)){
                JOptionPane.showMessageDialog(null, "Se ha modificado el registro", "MODIFICACIÓN", JOptionPane.INFORMATION_MESSAGE);
                new CStore();
                window.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha modificado el registro", "ERROR", JOptionPane.ERROR_MESSAGE);}
        } catch (StoreDaoException ex) {
        }
    }

    @Override
    public void cancel() {
        new CStore();
        window.dispose();
    }
    
}
