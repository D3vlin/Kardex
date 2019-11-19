package com.cidenet.hulkstore.ini;

import com.cidenet.hulkstore.controller.login.CLogin;
import static com.cidenet.hulkstore.jdbc.ResourceManager.setConnection;
import java.sql.SQLException;
import javax.swing.UIManager;

/**
 * Main Class of Inventory Control System
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-06
 */

public final class HulkStoreIni {
    
    public static void main(String[] args) throws SQLException { new HulkStoreIni(); }
    
    /**
     * Main constructor, initializes the LaF JTattoo
     */
    public HulkStoreIni() throws SQLException
    {
        
        try { UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel"); }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {}
        
        if (setConnection()) { new CLogin(); }        
    }
}
