package com.cidenet.hulkstore.controller.product;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * Product insertion interface
 * 
 * Available methods for the product insert controller
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-15
 */
public interface IInsertProduct
{
    public void cancel();
    
    public void upload(JTextField txtProductId, JComboBox cbmUnity);
    
    public void accept(JTextField txtProductId, JTextField txtProductName, JTextField txtUnityId);
    
    public void seeUnity(JComboBox cbmUnity, JTextField txtUnityId);
    
}
