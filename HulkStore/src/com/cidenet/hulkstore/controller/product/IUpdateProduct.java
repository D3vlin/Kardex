package com.cidenet.hulkstore.controller.product;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * Product modification interface
 * 
 * Available methods for the product modification controller
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-15
 */
public interface IUpdateProduct {
    
    public void upload(JTextField txtProductId, JTextField txtProductName, JTextField txtUnityId, JComboBox cmbUnity);
    
    public void cancel();
    
    public void seeUnity(JComboBox cmbUnity, JTextField txtUnityId);
    
    public void accept(JTextField txtProductId, JTextField txtProductName, JTextField txtUnityId);
}
