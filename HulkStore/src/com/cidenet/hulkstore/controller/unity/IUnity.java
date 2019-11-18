package com.cidenet.hulkstore.controller.unity;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Unit Management Interface
 * 
 * Available methods for the unit management controller
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-18
 */
public interface IUnity
{    
    public void upload(JTable tblUnit);
    
    public void updateState(JTable tblUnit, JCheckBox chkActive);
    
    public void menu();
    
    public void insert();
    
    public void update(JTable tblUnit);
    
    public void delete(JTable tblUnit, JCheckBox chkActive);
    
    public void enableDisable(JTable tblUnit, JCheckBox chkActive);
    
    public void searchUnity( JTextField txtSearch, JTable tblUnit);
    
    public void selectRow(JTextField txtSearch, JTable tblUnit);
}
