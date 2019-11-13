package com.cidenet.hulkstore.controller.settings;

import com.cidenet.hulkstore.controller.login.CLogin;
import com.cidenet.hulkstore.controller.menu.CMenu;
import com.cidenet.hulkstore.users.UsersDao;
import com.cidenet.hulkstore.users.UsersDto;
import com.cidenet.hulkstore.users.UsersDaoFactory;
import static com.cidenet.hulkstore.jdbc.ResourceManager.getDataConnection;
import static com.cidenet.hulkstore.jdbc.ResourceManager.setDataConnection;
import static com.cidenet.hulkstore.jdbc.ResourceManager.testConnection;
import com.cidenet.hulkstore.view.menu.UIMenu;
import com.cidenet.hulkstore.view.settings.UISettings;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Setting view controller
 * 
 * Modify configuration values with the database, in addition to checking
 * if the connection provided by the user is correct.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-08
 */

public class CSettings implements ISettings {

    private UISettings window;
    private boolean returnToLogin;
    
    public CSettings(boolean returnToLogin)
    {
        this.returnToLogin = returnToLogin;
        window = new UISettings(this);
    }

    @Override
    public void upload(JTextField txtHost, JTextField txtUser) {
        String[] dataConection = getDataConnection();

        txtHost.setText(dataConection[0]);
        txtUser.setText(dataConection[1]);
    }
    
    @Override
    public void cancel() {
        CLogin login;
        if(returnToLogin) {
            login = new CLogin();
        } else {
            new CMenu();
        }
        
        window.dispose();
    }

    @Override
    public void validate(JTextField txtHost, JTextField txtUser, JPasswordField pwdPass, JLabel lblState) {        
        
        if(testConnection(txtHost.getText(), txtUser.getText(), pwdPass.getText()))
        {
            lblState.setForeground(new Color(0, 150, 0));
            lblState.setText("Configuración correcta");
        }
        else
        {
            lblState.setForeground(new Color(255, 0, 0));
            lblState.setText("Configuración incorrecta");
        }
    }

    @Override
    public void accept(JTextField txtHost, JTextField txtUser, JPasswordField pwdPass, JLabel lblState) {
        if(lblState.getText().equals("Configuración correcta")) {
            setDataConnection(txtHost.getText(), txtUser.getText(), pwdPass.getText());
            cancel();
        } else {
            JOptionPane.showMessageDialog(null, "Esta conexión no pasó el test.\nConfigure la conexión correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
