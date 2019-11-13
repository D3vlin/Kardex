package com.cidenet.hulkstore.controller.store;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Store Management Interface
 * 
 * Available methods for the store management controller
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-13
 */
public interface IStore {
    
    public void upload(JTable tblStore, JTextField txtSearch);
    
    public void updateState(JTable tblStore, JCheckBox chkActive);
    
    public void menu();
    
    public void insert();
    
    public void update(JTable tblStore);
    
    public void enableDisable(JTable tblStore, JCheckBox chkActive);
    
    public void delete(JTable tblStore, JCheckBox chkActive);
    
    public void generateReport();
    
    public void searchStore(String filter, JTextField txtSearch, JTable tblStore);
}
