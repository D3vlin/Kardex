package com.cidenet.hulkstore.controller.settings;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Settings view controller interface
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-08
 */
public interface ISettings {
    
    /**
     * Close the settings form
     */
    public void cancel();
    
    /**
     * Upload the host and user parameters from the 'connection.dat' file to the
     * corresponding text fields.
     * 
     * @param txtHost     text field for host
     * @param txtUser     text field for user
     */
    public void upload(JTextField txtHost, JTextField txtUser);
    
    /**
     * Verify that the settings set by the user are correct,
     * Make a connection attempt and return via messages if the 
     * connection was successful or not.
     * 
     * @param txtHost    text field for host
     * @param txtUser    text field for user
     * @param pwdPass    text field for password
     * @param lblState   label indicating the result of the message
     */
    public void validate(JTextField txtHost, JTextField txtUser, JPasswordField pwdPass, JLabel lblState);
    
    /**
     * Accept and update the data in the configuration file 'connection.dat'
     * with those entered by the user.
     * 
     * @param txtHost   text field for host
     * @param txtUser   text field for user
     * @param pwdPass   text field for password
     * @param lblState  label indicating the result of the message
     */
    public void accept(JTextField txtHost, JTextField txtUser, JPasswordField pwdPass, JLabel lblState);
}
