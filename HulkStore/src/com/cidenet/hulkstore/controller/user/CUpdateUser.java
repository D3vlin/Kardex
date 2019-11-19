package com.cidenet.hulkstore.controller.user;

import com.cidenet.hulkstore.factory.DaoFactory;
import com.cidenet.hulkstore.users.UsersDao;
import com.cidenet.hulkstore.users.UsersDaoException;
import com.cidenet.hulkstore.users.UsersDto;
import com.cidenet.hulkstore.view.users.UIUpdateUser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * User Modification Controller
 * 
 * Load data from the selected user, receive new values and validate them
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-19
 */
public final class CUpdateUser
{
    private UIUpdateUser window;
    private UsersDao userDao = DaoFactory.createUsersDao();
    private UsersDto user;
    
    public CUpdateUser(int userId)
    {
        try {
            user = userDao.findByPrimaryKey(userId);
            window = new UIUpdateUser(this);
            
        } catch (Exception e) {}
        
    }
    
    public void upload( JTextField txtUserId, JTextField txtUserName, JFormattedTextField ftxIdentification,
                        JTextField txtRealName, JTextField txtSurname, JRadioButton jrbAdmin, JRadioButton jrbUser)
    {
        txtUserId.setText(String.valueOf(user.getUserId()));
        txtUserName.setText(user.getUserName());
        ftxIdentification.setText(user.getIdentification());
        txtRealName.setText(user.getRealName());
        txtSurname.setText(user.getSurname());        
        
        if(user.getUserProfile() == 1)
        {
            jrbAdmin.setSelected(true);
            jrbUser.setSelected(false);
            
        } else {
            jrbAdmin.setSelected(false);
            jrbUser.setSelected(true);
        }
    }   
    
    public void accept( JTextField txtUserId, JTextField txtUserName, JPasswordField pwdPass, JPasswordField pwdRepeatPass,
                        JFormattedTextField ftxIdentification, JTextField txtRealName, JTextField txtSurname, JRadioButton jrbAdmin)
    {
        short userProfile = 0;
        
        if(jrbAdmin.isSelected())
         { userProfile = 1; }
        
        user.setUserId(Integer.parseInt(txtUserId.getText()));
        user.setUserName(txtUserName.getText());
        user.setIdentification(ftxIdentification.getText());
        user.setRealName(txtRealName.getText());
        user.setSurname(txtSurname.getText());
        user.setUserProfile(userProfile);
        
        if(String.valueOf(pwdPass.getPassword()).equals(String.valueOf(pwdRepeatPass.getPassword())))
        {
            if(String.valueOf(pwdPass.getPassword()).length() >= 5 && String.valueOf(pwdPass.getPassword()).length() <= 16)
            {
                try {
                    user.setUserPass(String.valueOf(pwdPass.getPassword()));
                    UsersDao dao = DaoFactory.createUsersDao();
                    
                    if(dao.update(user.createPk(), user))
                    {
                        JOptionPane.showMessageDialog(null, "Se ha modificado el registro", "MODIFICACIÓN", JOptionPane.INFORMATION_MESSAGE);
                        new CUser();
                        window.dispose();
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "No se modifico", "ERROR", JOptionPane.ERROR_MESSAGE); }
                    
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
