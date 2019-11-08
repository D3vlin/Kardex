package com.cidenet.hulkstore.controller.login;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Login view controller interface
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-06
 */
public interface ILogin
{
    /**
     * Validate the username and password entered,
     * if the data is correct, access the main menu window
     * @param txtUser    username
     * @param txtPass    password
     */
    public void validate(JTextField txtUser, JPasswordField pwdPass);
    
    /**
     * Access to the database configuration window.
     */
    public void setting();
    
    /**
     * Close the system
     */
    public void close();
}
