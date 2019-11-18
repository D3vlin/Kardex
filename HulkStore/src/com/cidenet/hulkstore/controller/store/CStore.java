package com.cidenet.hulkstore.controller.store;

import com.cidenet.hulkstore.controller.menu.CMenu;
import com.cidenet.hulkstore.controller.reports.CReports;
import com.cidenet.hulkstore.controller.reports.IReports;
import com.cidenet.hulkstore.stores.StoreDao;
import com.cidenet.hulkstore.stores.StoreDaoException;
import com.cidenet.hulkstore.stores.StoreDaoFactory;
import com.cidenet.hulkstore.stores.StoreDaoImpl;
import com.cidenet.hulkstore.stores.StoreDto;
import com.cidenet.hulkstore.view.store.UIStore;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.event.KeyEvent;
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
            StoreDto dto = stores[i];
            
            if(dto.getState() != 3)
            {                
                chkActive.setEnabled(true);
                
                if(dto.getState() == 1) {
                    chkActive.setSelected(true);}
                else {
                    chkActive.setSelected(false);}
                
            } else {
                chkActive.setEnabled(false);
                chkActive.setSelected(false);
            }
        } else {
            chkActive.setEnabled(false);
            chkActive.setSelected(false);
        }
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
        int i = tblStore.getSelectedRow();
        
        if(i != -1)
        {
            StoreDto dto = stores[i];
            CUpdateStore update;
            if(dto.getState() == 1)
            {
                update = new CUpdateStore(dto.getStoreId());
                window.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Solo se permite modificar registros activos", "ERROR", JOptionPane.ERROR_MESSAGE);}
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro a modificar", "ERROR", JOptionPane.ERROR_MESSAGE);}
    }

    @Override
    public void enableDisable(JTable tblStore, JCheckBox chkActive) {
        int i = tblStore.getSelectedRow();
        
        DefaultTableModel model = (DefaultTableModel) tblStore.getModel();        
        
        if(i != -1) {
            StoreDto dto = stores[i];
            StoreDao dao = new StoreDaoImpl();
            
            if(chkActive.isSelected())
            {
                try {
                    dto.setState((short) 1);
                    if(dao.update(dto.createPk(), dto)){
                        model.setValueAt("A", i, 3);}
                } catch (StoreDaoException ex) {}
            }
            else
            {
                try {
                    dto.setState((short) 2);
                    if(dao.update(dto.createPk(), dto)){
                        model.setValueAt("I", i, 3);}
                } catch (StoreDaoException ex) {}
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro", "ERROR", JOptionPane.ERROR_MESSAGE);}
    }

    @Override
    public void delete(JTable tblStore, JCheckBox chkActive) {
        int i = tblStore.getSelectedRow();
        
        if(i != -1)
        {
            StoreDto dto = stores[i];
            if(dto.getState() != 3)
            {
                if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {                    
                    try {
                        StoreDao dao = StoreDaoFactory.create();
                        dto.setState((short) 3);
                        if(dao.update(dto.createPk(), dto)){
                            DefaultTableModel model = (DefaultTableModel) tblStore.getModel();
                            model.setValueAt("*", i, 3);
                            chkActive.setEnabled(false);
                        }    
                    } catch (StoreDaoException ex) {}                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "El registro ya está eliminado", "ERROR", JOptionPane.ERROR_MESSAGE);}
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro a eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);}
    }

    @Override
    public void generateReport() {
        try {
            StoreDao dao = StoreDaoFactory.create();
            stores = dao.getStoreView();
            
            IReports report = new CReports();
            report.generateStoreReport(stores);
        } catch (StoreDaoException ex) {}
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

    @Override
    public void searchStore(int keyCode, String filter, String store, JTable tblStore) {
        

        if(keyCode == KeyEvent.VK_ENTER) {
            TableModel tableModel = tblStore.getModel();
        
            int i;
            for(i = 0; i < tableModel.getColumnCount(); i++)
            {
                if(filter.compareTo(tableModel.getColumnName(i)) == 0) {
                    break;}
            }

            for(int k = 0; k < tableModel.getRowCount(); k++)
            {
                if(store.compareToIgnoreCase(tableModel.getValueAt(k, i).toString()) == 0){
                    tblStore.setRowSelectionInterval(k, k);
                    break;
                    
                } else {
                    tblStore.clearSelection();
                }
            }
        }        
    }
    
}
