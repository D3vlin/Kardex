package com.cidenet.hulkstore.controller.store;

import javax.swing.JTextField;

/**
 * Store insert interface
 * 
 * Available methods for the store insert controller
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-13
 */
public interface IInsertStore
{    
    public void upload(JTextField txtStoreId);
    
    public void accept(JTextField txtStoreId, JTextField txtStoreName, JTextField txtAddress);
    
    public void cancel();
}
