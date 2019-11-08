package com.cidenet.hulkstore.controller.login;

import com.cidenet.hulkstore.dao.UsersDao;
import com.cidenet.hulkstore.factory.UsersDaoFactory;
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
    public void validate(JTextField txtUser, JPasswordField txtPass)
    {
        try {
            UsersDao dao = UsersDaoFactory.create();
            if (dao.validateUser(txtUser.getText(), txtPass.getText())) {
                //new CKardexMenu();
                //form.dispose();
                JOptionPane.showMessageDialog(null, "ingresa!", "ingresa!", JOptionPane.INFORMATION_MESSAGE, null);
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
//        new CConfiguracion(true);
//        form.dispose();
    }
    
    @Override
    public void close()
    {
        window.dispose();
    }
    
//    public static UsersDao getUsersDao()
//    {
//        return UsersDaoFactory.create();
//    }
}
