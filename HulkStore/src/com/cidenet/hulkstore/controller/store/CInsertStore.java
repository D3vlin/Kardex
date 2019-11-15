package com.cidenet.hulkstore.controller.store;

import com.cidenet.hulkstore.stores.StoreDao;
import com.cidenet.hulkstore.stores.StoreDaoException;
import com.cidenet.hulkstore.stores.StoreDaoImpl;
import com.cidenet.hulkstore.stores.StoreDto;
import com.cidenet.hulkstore.view.store.UIInsertStore;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Store Insertion Controller
 * 
 * Receive and validate data about a new store registration
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-13
 */
public class CInsertStore implements IInsertStore
{
    private UIInsertStore window;
    
    public CInsertStore()
    {
        window = new UIInsertStore(this);
    }

    @Override
    public void upload(JTextField txtStoreId) {        
        try {
            StoreDao dao = new StoreDaoImpl();
            txtStoreId.setText(dao.findNextStoreId());
        } catch (StoreDaoException ex)
        {
        }
    }

    @Override
    public void accept(JTextField txtStoreId, JTextField txtStoreName, JTextField txtAddress) {        
        
        try {
            StoreDto dto = new StoreDto(Integer.parseInt(txtStoreId.getText()), txtStoreName.getText(), txtAddress.getText());
            StoreDao dao = new StoreDaoImpl();
            
            if(!dao.insert(dto).isStoreIdNull()){
                JOptionPane.showMessageDialog(null, "Se ha agregado el registro nuevo", "INSERCION", JOptionPane.INFORMATION_MESSAGE);
                new CStore();
                window.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se registro", "ERROR", JOptionPane.ERROR_MESSAGE);}
        } catch (StoreDaoException ex) {
        }
    }

    @Override
    public void cancel() {
        new CStore();
        window.dispose();
    }
    
}
