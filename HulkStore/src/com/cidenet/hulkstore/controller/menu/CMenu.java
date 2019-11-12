package com.cidenet.hulkstore.controller.menu;

import com.cidenet.hulkstore.controller.login.CLogin;
import com.cidenet.hulkstore.controller.settings.CSettings;
import com.cidenet.hulkstore.dto.users.Users;
import com.cidenet.hulkstore.view.menu.UIMenu;
import javax.swing.JButton;
import javax.swing.JLabel;

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
public class CMenu implements IMenu{

    private UIMenu window;
    
    public CMenu(Users user)
    {
        window = new UIMenu(this, user);
    }
    
    @Override
    public void upload(Users user, JLabel lblRealName, JLabel lblIdentification, JLabel lblProfile, JButton btnUser, JButton btnProductExistence, JButton btnProductEntry, JButton btnProductExit) {
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

    @Override
    public void logOut() {
        new CLogin();
        window.dispose();
    }

    @Override
    public void store() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void user() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void document() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void product() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setting() {
        new CSettings(false);
        window.dispose();
    }

    @Override
    public void kardex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void productExistence() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void productExit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void producEntry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showForm() {
        window.setVisible(true);
    }
    
}
