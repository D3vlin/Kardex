package com.cidenet.hulkstore.controller.store;

import com.cidenet.hulkstore.controller.menu.CMenu;
import com.cidenet.hulkstore.stores.StoreDao;
import com.cidenet.hulkstore.stores.StoreDaoFactory;
import com.cidenet.hulkstore.stores.StoreDto;
import com.cidenet.hulkstore.users.UsersDao;
import com.cidenet.hulkstore.users.UsersDaoFactory;
import com.cidenet.hulkstore.users.UsersDto;
import com.cidenet.hulkstore.view.menu.UIMenu;
import com.cidenet.hulkstore.view.store.UIStore;
import com.mxrck.autocompleter.TextAutoCompleter;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Store Management Controller
 * 
 * Load existing stores with their data,
 * in addition to controlling the redirection to the insertion or modification windows.
 * Provides options to generate report and search records.
 * The enable, disable and delete functions are performed here.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-13
 */
public class CStore implements IStore{

    private UIStore window;
    private StoreDto[] stores;
    
    public CStore()
    {
        try {
            StoreDao dao = StoreDaoFactory.create();
            stores = dao.findAll();            
        }
        catch (Exception e) {
        }
        
        window = new UIStore(this);
    }
    
    @Override
    public void upload(JTable tblStore, JTextField txtSearch)
    {
        DefaultTableModel model = (DefaultTableModel) tblStore.getModel();
        model.setRowCount(0);
        String state;
        
        for (StoreDto store : stores) {
            if (store.getState() == 1) {
                state = "A";
            } else if (store.getState() == 2) {
                state = "I";
            } else {
                state = "*";
            }
            model.addRow(new Object[]{store.getStoreId(), store.getStoreName(), store.getAddress(), state});
        }
    }

    @Override
    public void updateState(JTable tblStore, JCheckBox chkActive) {
        int i = tblStore.getSelectedRow();
        
        if(i != -1)
        {
            chkActive.setEnabled(true);
            StoreDto dto = stores[i];
            
            if(dto.getState() != 3)
            {
                if(dto.getState() == 1) {
                    chkActive.setSelected(true);}
                else {
                    chkActive.setSelected(false);}
            } else {
                chkActive.setEnabled(false);}
        } else {
            chkActive.setEnabled(false);}
    }

    @Override
    public void menu() {
        new CMenu();        
        window.dispose();
    }

    @Override
    public void insert() {
        new CInsertStore();
        window.dispose();
    }

    @Override
    public void update(JTable tblStore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enableDisable(JTable tblStore, JCheckBox chkActive) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(JTable tblStore, JCheckBox chkActive) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void generateReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void searchStore(String filter, JTextField txtSearch, JTable tblStore) {
        
        txtSearch.setText("");      
        
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter(txtSearch);
        textAutoAcompleter.removeAllItems();
        textAutoAcompleter.setMode(0);
        textAutoAcompleter.setCaseSensitive(false);
        
        TableModel tableModel = tblStore.getModel();
        
        int i;
        for(i = 0; i < tableModel.getColumnCount(); i++)
        {
            if(filter.compareTo(tableModel.getColumnName(i)) == 0) {
                break;}
        }
        
        for(int k = 0; k < tableModel.getRowCount(); k++)
        {
            textAutoAcompleter.addItem(tableModel.getValueAt(k, i));
        }
    }
    
}
