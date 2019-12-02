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
import com.cidenet.hulkstore.factory.DaoFactory;
import com.cidenet.hulkstore.users.UsersDao;
import com.cidenet.hulkstore.users.UsersDaoException;
import com.cidenet.hulkstore.users.UsersDto;
import com.cidenet.hulkstore.view.menu.UIMenu;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Main Menu Controller
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
    
    public CMenu()
    {
        try {
            UsersDao dao = DaoFactory.createUsersDao();
            UsersDto user = dao.findWhereUserIdEquals(UIMenu.userId)[0];

            if (user != null) {
                window = new UIMenu(this, user);
            } else  {
                JOptionPane.showMessageDialog(null, "Error al cargar el menú", "Error", JOptionPane.ERROR_MESSAGE, null);
            }
        }
        catch (UsersDaoException | HeadlessException e) {}        
    }
    
    public CMenu(UsersDto user)
    {
        window = new UIMenu(this, user);
    }
    
    public void upload(UsersDto user, JLabel lblRealName, JLabel lblIdentification, JLabel lblProfile, JButton btnUser, JButton btnProductExistence, JButton btnProductEntry, JButton btnProductExit) {
        UIMenu.userId = user.getUserId();
        lblRealName.setText(user.getRealName() + " " + user.getSurname());
        lblIdentification.setText("CC Nº " + user.getIdentification());
        
        if(user.getUserProfile() == 1){
            lblProfile.setText("Administrador");
            
        }else{
            lblProfile.setText("Usuario");
            btnUser.setEnabled(false);
            btnProductExistence.setEnabled(false);
            btnProductEntry.setEnabled(false);
            btnProductExit.setEnabled(false);
        }
    }

    public void logOut() {
        new CLogin();
        window.dispose();
    }

    public void store() {
        new CStore();
        window.dispose();
    }

    public void user() {
        new CUser();
        window.dispose();
    }

    public void unity() {
        new CUnity();
        window.dispose();
    }

    public void document() {
        new CDocument();
        window.dispose();
    }

    public void product() {
        new CProduct();
        window.dispose();
    }

    public void setting() {
        new CSettings(false);
        window.dispose();
    }

    public void kardex() {
        try {
            new CKardex();
            window.dispose();
            
        } catch (DaoException ex) {}
    }

    public void productExistence() {
        JOptionPane.showMessageDialog(null, "Adquiera una licencia premium plus lite", "Actualice su versión", JOptionPane.INFORMATION_MESSAGE, null);
    }

    public void productExit() {
        JOptionPane.showMessageDialog(null, "Adquiera una licencia premium plus lite", "Actualice su versión", JOptionPane.INFORMATION_MESSAGE, null);
    }

    public void producEntry() {
        JOptionPane.showMessageDialog(null, "Adquiera una licencia premium plus lite", "Actualice su versión", JOptionPane.INFORMATION_MESSAGE, null);
    }

    public void showForm() {
        window.setVisible(true);
    }
    
}
