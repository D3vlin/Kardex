package com.cidenet.hulkstore.controller.ini;

import com.cidenet.hulkstore.controller.login.CLogin;
import static com.cidenet.hulkstore.model.dao.ResourceManager.setConnection;
import java.sql.SQLException;
import javax.swing.UIManager;
import org.apache.log4j.Logger;

/**
 * Main Class of Inventory Control System
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-06
 */
public final class HulkStoreIni {
    
    private static final Logger LOG = Logger.getLogger(HulkStoreIni.class.getName());
    //private static final String CLASS_NAME = HulkStoreIni.class.getName();
    
    /**
     * Start the application.
     * 
     * @param args
     * @throws SQLException 
     */
    public static void main(String[] args) throws SQLException { HulkStoreIni hulkStoreIninew = new HulkStoreIni(); }
    
    /**
     * Main constructor, initializes the plaf JTattoo library and establish connection.
     * 
     * @throws java.sql.SQLException
     */
    public HulkStoreIni() throws SQLException
    {   
        //log(CLASS_NAME, "info", Initializing HulkStore...");
        LOG.info("Initializing HulkStore...");
        try { 
            
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            LOG.info("LookAndFeel loaded = 'com.jtattoo.plaf.noire.NoireLookAndFeel'");            
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        
            LOG.error("LookAndFeel Not charged = 'com.jtattoo.plaf.noire.NoireLookAndFeel': " + ex);
        }
        
        if (setConnection()) { 
            
            LOG.info("HulkStore run");
            CLogin cLogin = new CLogin(); 
        }        
    }
}