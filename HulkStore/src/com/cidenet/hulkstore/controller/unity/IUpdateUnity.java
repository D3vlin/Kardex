package com.cidenet.hulkstore.controller.unity;

import javax.swing.JTextField;

/**
 * Unit Modification Interface
 * 
 * Available methods for the unit modification controller
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-18
 */
public interface IUpdateUnity
{
    public void upload(JTextField txtUnityId, JTextField txtUnityDescription);
    
    public void accept(JTextField txtUnityDescription);
    
    public void cancel();
}
