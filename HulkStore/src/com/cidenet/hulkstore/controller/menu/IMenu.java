package com.cidenet.hulkstore.controller.menu;

import com.cidenet.hulkstore.users.UsersDto;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Menu view controller interface
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-12
 */

public interface IMenu
{
    /**
     * Upload user data that entered the system (real name, identification, profile)
     * In addition for those non-administrator users certain options are disabled
     * (User Management, Existence queries, Product Entry and Product Exit).
     * 
     * @param user                  Store the user that uses the menu
     * @param lblRealName           User name
     * @param lblIdentification     User identification
     * @param lblProfile            User profile
     * @param btnUser               User Management Button
     * @param btnProductExistence   Product existence query button
     * @param btnProductEntry       Product input query button
     * @param btnProductExit        Product Exit Query Button
     */
    public void upload(UsersDto user, JLabel lblRealName, JLabel lblIdentification, JLabel lblProfile, JButton btnUser, JButton btnProductExistence, JButton btnProductEntry, JButton btnProductExit);
    
    /**
     * Log out of the current user, and return to the Login window.
     */
    public void logOut();
    
    /**
     * Access to the Store Management window.
     */
    public void store();
    
    /**
     * Access to the Store Management window.
     */
    public void user();
    
    /**
     * Access to the Unit Management window.
     */
    public void unity();
    
    /**
     * Access to the Document Management window.
     */
    public void document();
    
    /**
     * Access to the Product Management window.
     */
    public void product();
    
    /**
     * Access to the database configuration window.
     */
    public void setting();
    
    /**
     * Access to the Kardex Management window.
     */
    public void kardex();
    
    /**
     * Access to the Product Existence Query window.
     */
    public void productExistence();
    
    /**
     * Access to the Product Exit Query window.
     */
    public void productExit();
    
    /**
     * Access to the Product Entry Query window.
     */
    public void producEntry();
    
    /**
     * Show the form
     */
    public void showForm();
    
}
