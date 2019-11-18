package com.cidenet.hulkstore.controller.unity;

import javax.swing.JTextField;

/**
 * Drive Insert Interface
 * 
 * Available methods for drive insertion controller
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-18
 */
public interface IInsertUnity
{
    public void upload(JTextField txtUnityId);
    
    public void accept(JTextField txtUnityId, JTextField txtUnityDescription);
    
    public void cancel();
}
