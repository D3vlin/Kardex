package com.cidenet.hulkstore.controller.store;

import javax.swing.JTextField;

/**
 * Store Modification Interface
 * 
 * Available methods for store modification controller
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-13
 */
public interface IUpdateStore
{
    public void upload(JTextField txtstoreId, JTextField txtStoreName, JTextField txtAddress);
    
    public void accept(JTextField txtStoreName, JTextField txtAddress);
    
    public void cancel();
}
