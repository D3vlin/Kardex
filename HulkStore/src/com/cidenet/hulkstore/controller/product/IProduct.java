package com.cidenet.hulkstore.controller.product;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Store Management Interface
 * 
 * Available methods for the product management controller
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-14
 */
public interface IProduct {
    
    public void upload(JTable tblProduct);
    
    public void updateState(JTable tblProduct, JCheckBox chkActive);
    
    public void menu();
    
    public void insert();
    
    public void update(JTable tblProduct);
    
    public void enableDisable(JTable tblProduct, JCheckBox chkActive);
    
    public void delete(JTable tblProduct, JCheckBox chkActive);
    
    public void generateReport();
    
    public void searchProduct( JTextField search, JTable tblProduct);
    
    public void selectRow(JTextField search, JTable tblProduct);
}
