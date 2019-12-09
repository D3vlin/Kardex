package com.cidenet.hulkstore.controller.store;

import com.cidenet.hulkstore.controller.menu.CMenu;
import com.cidenet.hulkstore.controller.reports.CReports;
import com.cidenet.hulkstore.factory.DaoFactory;
import com.cidenet.hulkstore.stores.StoreDaoException;
import com.cidenet.hulkstore.stores.StoreDao;
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
public final class CStore
{
    private UIStore window;
    private StoreDto[] stores;
    
    /**
     * Empty Constructor.
     */
    public CStore()
    {
        try {
            StoreDao dao = DaoFactory.createStoreDao();
            stores = dao.findAll();            
        
        } catch (Exception exception) {}
        
        window = new UIStore(this);
    }    
    
    /**
     * Upload the stores registered in the database to the form table and set their status.
     * 
     * @param tblStore
     * @param txtSearch 
     */
    public void upload(JTable tblStore, JTextField txtSearch)
    {
        DefaultTableModel model = (DefaultTableModel) tblStore.getModel();
        model.setRowCount(0);
        String state;
        
        for (StoreDto store : stores) 
        {
            if (store.getState() == 1) { state = "A"; }
            else if (store.getState() == 2) { state = "I"; }
            else { state = "*"; }
            
            model.addRow(new Object[]{store.getStoreId(), store.getStoreName(), store.getAddress(), state});
        }
    }
    
    /**
     * Depending on the status of the registered store, the status of the chkActive control changes.
     * 
     * @param tblStore
     * @param chkActive 
     */
    public void updateState(JTable tblStore, JCheckBox chkActive) 
    {
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

    /**
     * Return to the initial menu.
     */
    public void menu() {
        CMenu cMenu = new CMenu();        
        window.dispose();
    }

    /**
     * Show the form to insert a new store.
     */
    public void insert() {
        CInsertStore cInsertStore = new CInsertStore();
        window.dispose();
    }

    /**
     * Show the form to modify a store.
     * 
     * @param tblStore 
     */
    public void update(JTable tblStore)
    {
        int i = tblStore.getSelectedRow();
        
        if(i != -1)
        {
            StoreDto dto = stores[i];
            
            if(dto.getState() == 1)
            {
                CUpdateStore update = new CUpdateStore(dto.getStoreId());
                window.dispose();
                
            } else { JOptionPane.showMessageDialog(null, "Solo se permite modificar registros activos", "ERROR", JOptionPane.ERROR_MESSAGE); }
            
        } else { JOptionPane.showMessageDialog(null, "Seleccione un registro a modificar", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }

    /**
     * Enable or disable the status of the registered store.
     * 
     * @param tblStore
     * @param chkActive 
     */
    public void enableDisable(JTable tblStore, JCheckBox chkActive) {
        int i = tblStore.getSelectedRow();
        
        DefaultTableModel model = (DefaultTableModel) tblStore.getModel();        
        
        if(i != -1) {
            StoreDto dto = stores[i];
            StoreDao dao = new StoreDao();
            
            if(chkActive.isSelected())
            {
                try {
                    dto.setState((short) 1);
                    if(dao.update(dto.createPk(), dto)) { model.setValueAt("A", i, 3); }
                    
                } catch (StoreDaoException exception) {}
            
            } else {
                try {
                    dto.setState((short) 2);
                    if(dao.update(dto.createPk(), dto)) { model.setValueAt("I", i, 3); }
                    
                } catch (StoreDaoException exception) {}
            }
            
        } else { JOptionPane.showMessageDialog(null, "Seleccione un registro", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }

    /**
     * Change the status of a registered store to deleted.
     * 
     * @param tblStore
     * @param chkActive 
     */
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
                        StoreDao dao = DaoFactory.createStoreDao();
                        dto.setState((short) 3);
                        if(dao.update(dto.createPk(), dto)){
                            DefaultTableModel model = (DefaultTableModel) tblStore.getModel();
                            model.setValueAt("*", i, 3);
                            chkActive.setEnabled(false);
                        }    
                    } catch (StoreDaoException ex) {}                    
                }
                
            } else { JOptionPane.showMessageDialog(null, "El registro ya está eliminado", "ERROR", JOptionPane.ERROR_MESSAGE); }
            
        } else { JOptionPane.showMessageDialog(null, "Seleccione un registro a eliminar", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }

    /**
     * Generate the report of stores.
     */
    public void generateReport() {
        try {
            StoreDao dao = DaoFactory.createStoreDao();
            stores = dao.getViewStore();
            
            CReports report = new CReports();
            report.generateStoreReport(stores);
            
        } catch (StoreDaoException exception) {}
    }

    /**
     * Add the available records to the autocompleter.
     * 
     * @param filter
     * @param txtSearch
     * @param tblStore 
     */
    public void loadAutoCompleter(String filter, JTextField txtSearch, JTable tblStore)
    {        
        txtSearch.setText("");      
        
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter(txtSearch);
        textAutoAcompleter.removeAllItems();
        textAutoAcompleter.setMode(0);
        textAutoAcompleter.setCaseSensitive(false);
        
        TableModel tableModel = tblStore.getModel();        
        
        int i;
        for(i = 0; i < tableModel.getColumnCount(); i++)
        {
            if(filter.compareTo(tableModel.getColumnName(i)) == 0) { break; }
        }
        
        for(int k = 0; k < tableModel.getRowCount(); k++)
        {
            textAutoAcompleter.addItem(tableModel.getValueAt(k, i));
        }
    }

    /**
     * Select the row where the searched store is located.
     * 
     * @param keyCode
     * @param filter
     * @param store
     * @param tblStore 
     */
    public void searchStore(int keyCode, String filter, String store, JTable tblStore)
    {       
        if(keyCode == KeyEvent.VK_ENTER) {
            TableModel tableModel = tblStore.getModel();
        
            int i;
            for(i = 0; i < tableModel.getColumnCount(); i++)
            {
                if(filter.compareTo(tableModel.getColumnName(i)) == 0) { break; }
            }

            for(int k = 0; k < tableModel.getRowCount(); k++)
            {
                if(store.compareToIgnoreCase(tableModel.getValueAt(k, i).toString()) == 0){
                    tblStore.setRowSelectionInterval(k, k);
                    break;
                    
                } else { tblStore.clearSelection(); }
            }
        }        
    }    
}