package com.cidenet.hulkstore.controller.login;

import com.cidenet.hulkstore.controller.menu.CMenu;
import com.cidenet.hulkstore.controller.settings.CSettings;
import com.cidenet.hulkstore.model.dao.DaoFactory;
import com.cidenet.hulkstore.model.dao.users.*;
import com.cidenet.hulkstore.model.dto.users.UsersDto;
import com.cidenet.hulkstore.view.login.UILogin;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.apache.log4j.Logger;

/**
 * Login view controller.
 * 
 * Validates the entry of a user, verifying its existence in the database.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-06
 */
public final class CLogin {
    
    private static final Logger LOG = Logger.getLogger(CLogin.class.getName());
    private int entryAttempts;
    private final UILogin window;
    
    /**
     * Empty Constructor.
     */
    public CLogin() {        
        LOG.info("Initializing view UILogin...");
        entryAttempts = 0;
        this.window = new UILogin(this);
    }
    
    /**
     * Valid if the user's credentials are valid.
     * 
     * @param txtUser
     * @param pwdPass 
     */
    public void validate(JTextField txtUser, JPasswordField pwdPass) {        
        try {
            UsersDao dao = DaoFactory.createUsersDao();
            UsersDto user = dao.validateUser(txtUser.getText(), pwdPass.getText());
            
            if (user != null) {
                LOG.info("Closed UILogin view...");
                window.dispose();
                CMenu cMenu = new CMenu(user);
            
            } else {
                entryAttempts++;
                LOG.info("Username or password incorrect, Entry Attempts = " + entryAttempts);
                JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE, null);
                
                if(entryAttempts >= 3) {
                    LOG.info("The number of attempts exceeded");
                    JOptionPane.showMessageDialog(null, "A superado el número de intentos", "Info", JOptionPane.INFORMATION_MESSAGE, null);
                    close();
                }
            }
        
        } catch (UsersDaoException | HeadlessException exception) {
            LOG.fatal("Error validating user = " + exception);
        }
    }
    
    /**
     * Show the configuration form.
     */
    public void setting() {
        LOG.info("Closed UILogin view...");
        window.dispose(); 
        CSettings cSettings = new CSettings(true);
    }
    
    /**
     * Close the form and finish the application.
     */
    public void close() { 
        LOG.info("Closed UILogin view...");
        window.dispose(); 
    }
}