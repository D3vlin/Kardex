package com.cidenet.hulkstore.controller.user;

import com.cidenet.hulkstore.factory.DaoFactory;
import com.cidenet.hulkstore.users.UsersDao;
import com.cidenet.hulkstore.users.UsersDaoException;
import com.cidenet.hulkstore.users.UsersDto;
import com.cidenet.hulkstore.view.users.UIInsertUser;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * User Insertion Controller
 * 
 * Receive and validate data about a new user registration
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-19
 */
public final class CInsertUser
{
    private UIInsertUser window;
    
    public CInsertUser()
    {
        window = new UIInsertUser(this);
    }
    
    public void upload(JTextField txtUserId)
    {
        try {
            UsersDao dao = DaoFactory.createUsersDao();
            txtUserId.setText(dao.findNextUserId());
        } catch (UsersDaoException ex) {
            Logger.getLogger(CInsertUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void accept(JTextField txtUserId, JTextField txtUserName, JPasswordField pwdPass, JPasswordField pwdRepeatPass, JFormattedTextField ftxIdentification, JTextField txtRealName, JTextField txtSurname, JRadioButton jrbAdmin)
    {
        short userProfile = 0;
        
        if(jrbAdmin.isSelected())
         { userProfile = 1; }
        
        UsersDto dto = new UsersDto(Integer.parseInt(txtUserId.getText()),
                                    txtUserName.getText(),
                                    ftxIdentification.getText(),
                                    txtRealName.getText(),
                                    txtSurname.getText(),
                                    userProfile,
                                    (short) 1);
        
        if(String.valueOf(pwdPass.getPassword()).equals(String.valueOf(pwdRepeatPass.getPassword())))
        {            
            if(String.valueOf(pwdPass.getPassword()).length() >= 5 && String.valueOf(pwdPass.getPassword()).length() <= 12)
            {
                try {
                    dto.setUserPass(String.valueOf(pwdPass.getPassword()));
                    UsersDao dao = DaoFactory.createUsersDao();
                    
                    if(!dao.insert(dto).isUserIdNull())
                    {
                        JOptionPane.showMessageDialog(null, "Se ha agregado el registro nuevo", "INSERCION", JOptionPane.INFORMATION_MESSAGE);
                        new CUser();
                        window.dispose();
                        
                    } else { JOptionPane.showMessageDialog(null, "No se registro", "ERROR", JOptionPane.ERROR_MESSAGE); }
                    
                } catch (UsersDaoException ex) {}
                
            } else {
                
                JOptionPane.showMessageDialog(null, "La contraseña debe tener entre 5 y 12 caracteres.", "ERROR", JOptionPane.ERROR_MESSAGE);
                pwdPass.setText("");
                pwdRepeatPass.setText("");
            }
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.\nIntente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
            pwdPass.setText("");
            pwdRepeatPass.setText("");
        }
    }
    
    public void cancel()
    {
        new CUser();
        window.dispose();
    }
}
