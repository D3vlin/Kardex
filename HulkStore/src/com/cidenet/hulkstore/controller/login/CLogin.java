package com.cidenet.hulkstore.controller.login;

import com.cidenet.hulkstore.controller.menu.CMenu;
import com.cidenet.hulkstore.controller.settings.CSettings;
import com.cidenet.hulkstore.factory.DaoFactory;
import com.cidenet.hulkstore.users.UsersDao;
import com.cidenet.hulkstore.users.UsersDaoException;
import com.cidenet.hulkstore.users.UsersDto;
import com.cidenet.hulkstore.view.login.UILogin;
import java.awt.HeadlessException;
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

public final class CLogin
{
    private UILogin window;
    
    public CLogin()
    {
        this.window = new UILogin(this);
    }
    
    public void validate(JTextField txtUser, JPasswordField pwdPass)
    {
        try {
            UsersDao dao = DaoFactory.createUsersDao();
            UsersDto user = dao.validateUser(txtUser.getText(), pwdPass.getText());
            
            if (user != null) {
                new CMenu(user);
                window.dispose();
            }
            else
                JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE, null);
        }
        catch (UsersDaoException | HeadlessException e) {
            e.printStackTrace();
        }
    }
    
    public void setting()
    {
        new CSettings(true);
        window.dispose();
    }
    
    public void close()
    {
        window.dispose();
    }
}
