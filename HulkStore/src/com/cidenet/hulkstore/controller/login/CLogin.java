package com.cidenet.hulkstore.controller.login;

import com.cidenet.hulkstore.controller.menu.CMenu;
import com.cidenet.hulkstore.controller.settings.CSettings;
import com.cidenet.hulkstore.users.UsersDao;
import com.cidenet.hulkstore.users.UsersDto;
import com.cidenet.hulkstore.users.UsersDaoFactory;
import com.cidenet.hulkstore.view.login.UILogin;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Login view controller
 * 
 * Validates the entry of a user, verifying its existence in the database.
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-06
 */

public class CLogin implements ILogin
{
    private UILogin window;
    
    public CLogin()
    {
        this.window = new UILogin(this);
    }
    
    @Override
    public void validate(JTextField txtUser, JPasswordField pwdPass)
    {
        try {
            UsersDao dao = UsersDaoFactory.create();
            UsersDto user = dao.validateUser(txtUser.getText(), pwdPass.getText());
            
            if (user != null) {
                new CMenu(user);
                window.dispose();
            }
            else
                JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE, null);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void setting()
    {
        new CSettings(true);
        window.dispose();
    }
    
    @Override
    public void close()
    {
        window.dispose();
    }
}
