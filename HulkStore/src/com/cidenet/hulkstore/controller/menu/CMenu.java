package com.cidenet.hulkstore.controller.menu;

import com.cidenet.hulkstore.controller.document.CDocument;
import com.cidenet.hulkstore.controller.kardex.CKardex;
import com.cidenet.hulkstore.controller.login.CLogin;
import com.cidenet.hulkstore.controller.product.CProduct;
import com.cidenet.hulkstore.controller.settings.CSettings;
import com.cidenet.hulkstore.controller.store.CStore;
import com.cidenet.hulkstore.controller.unity.CUnity;
import com.cidenet.hulkstore.controller.user.CUser;
import com.cidenet.hulkstore.exceptions.DaoException;
import com.cidenet.hulkstore.model.dao.DaoFactory;
import com.cidenet.hulkstore.users.UsersDao;
import com.cidenet.hulkstore.users.UsersDaoException;
import com.cidenet.hulkstore.users.UsersDto;
import com.cidenet.hulkstore.view.menu.UIMenu;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Main Menu Controller.
 * 
 * Load the corresponding options depending on the type of user
 * and redirect to the different corresponding views.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-12
 */
public final class CMenu
{
    private UIMenu window;
    
    /**
     * Empty Constructor,
     */
    public CMenu() 
   {
        try {
            UsersDao dao = DaoFactory.createUsersDao();
            UsersDto user = dao.findWhereUserIdEquals(UIMenu.userId)[0];

            if (user != null) { window = new UIMenu(this, user); }
            else { JOptionPane.showMessageDialog(null, "Error al cargar el menú", "Error", JOptionPane.ERROR_MESSAGE, null); }
        
        } catch (UsersDaoException | HeadlessException exception) {}        
    }
    
    /**
     * Constructor.
     * 
     * @param user 
     */
    public CMenu(UsersDto user) { window = new UIMenu(this, user); }
    
    /**
     * Upload the user information logged in and enable the functions according to your profile.
     * 
     * @param user
     * @param lblRealName
     * @param lblIdentification
     * @param lblProfile
     * @param btnUser
     * @param btnProductExistence
     * @param btnProductEntry
     * @param btnProductExit 
     */
    public void upload(UsersDto user, JLabel lblRealName, JLabel lblIdentification, JLabel lblProfile, JButton btnUser, JButton btnProductExistence, JButton btnProductEntry, JButton btnProductExit) {
        UIMenu.userId = user.getUserId();
        lblRealName.setText(user.getRealName() + " " + user.getSurname());
        lblIdentification.setText("CC Nº " + user.getIdentification());
        
        if(user.getUserProfile() == 1) {
            lblProfile.setText("Administrador");
            
        } else {
            lblProfile.setText("Usuario");
            btnUser.setEnabled(false);
            btnProductExistence.setEnabled(false);
            btnProductEntry.setEnabled(false);
            btnProductExit.setEnabled(false);
        }
    }

    /**
     * Close the current user session and return to the login form.
     */
    public void logOut() {
        CLogin cLogin = new CLogin();
        window.dispose();
    }

    /**
     * Show the form to manage the stores.
     */
    public void store() {
        CStore cStore = new CStore();
        window.dispose();
    }

    /**
     * Show the form to manage users.
     */
    public void user() {
        CUser cUser = new CUser();
        window.dispose();
    }

    /**
     * Show the form to manage the units.
     */
    public void unity() {
        CUnity cUnity = new CUnity();
        window.dispose();
    }

    /**
     * Show the form to manage the documents.
     */
    public void document() {
        CDocument cDocument = new CDocument();
        window.dispose();
    }

    /**
     * Show the form to manage the products.
     */
    public void product() {
        CProduct cProduct = new CProduct();
        window.dispose();
    }

    /**
     * Show the configuration form.
     */
    public void setting() {
        CSettings cSettings = new CSettings(false);
        window.dispose();
    }

    /**
     * Show the form to manage kardex.
     */
    public void kardex() {
        try {
            CKardex cKardex = new CKardex();
            window.dispose();
            
        } catch (DaoException exception) {}
    }

    /**
     * Commercial message.
     */
    public void productExistence() {
        JOptionPane.showMessageDialog(null, "Adquiera una licencia premium plus lite", "Actualice su versión", JOptionPane.INFORMATION_MESSAGE, null);
    }

    /**
     * Commercial message.
     */
    public void productExit() {
        JOptionPane.showMessageDialog(null, "Adquiera una licencia premium plus lite", "Actualice su versión", JOptionPane.INFORMATION_MESSAGE, null);
    }

    /**
     * Commercial message.
     */
    public void producEntry() {
        JOptionPane.showMessageDialog(null, "Adquiera una licencia premium plus lite", "Actualice su versión", JOptionPane.INFORMATION_MESSAGE, null);
    }

    /**
     * Show the form.
     */
    public void showForm() {
        window.setVisible(true);
    }    
}