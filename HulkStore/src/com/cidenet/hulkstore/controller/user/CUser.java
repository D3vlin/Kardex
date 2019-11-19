package com.cidenet.hulkstore.controller.user;

import com.cidenet.hulkstore.controller.menu.CMenu;
import com.cidenet.hulkstore.factory.DaoFactory;
import com.cidenet.hulkstore.users.UsersDao;
import com.cidenet.hulkstore.users.UsersDaoException;
import com.cidenet.hulkstore.users.UsersDto;
import com.cidenet.hulkstore.view.users.UIUser;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * User Management Controller
 * 
 * Load existing users with their data,
 * in addition to controlling the redirection to the insertion or modification windows.
 * The delete function is performed here.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-19
 */
public final class CUser
{ 
    private UIUser window;
    private UsersDto[] users;
    
    public CUser()
    {
        try {
            UsersDao dao = DaoFactory.createUsersDao();
            users = dao.findAll();
        } catch (UsersDaoException ex) {}
        
        window = new UIUser(this);
    }   
    
    public void upload(JTable tblUser)
    {
        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
        model.setRowCount(0);
        String state;
        String profile;
		
        for (UsersDto user : users) {
            
            if (user.getUserProfile() == 1)
                { profile = "Administrador"; }
            else
                { profile = "Usuario"; }
            
            if (user.getState() == 1) 
                { state = "A"; }
            else
                { state = "*"; }
            
            model.addRow(new Object[]{user.getUserId(), user.getUserName(), user.getIdentification(), user.getRealName(), user.getSurname(), profile, state});
        }
    }
    
    public void menu()
    {
        new CMenu();
        window.dispose();
    }
    
    public void insert()
    {
        new CInsertUser();
        window.dispose();
    }
    
    public void update(JTable tblUser)
    {
        int i = tblUser.getSelectedRow();
        
        if(i != -1)
        {
            UsersDto dto = users[i];
            
            CUpdateUser update;
            
            if(dto.getState() == 1)
            {
                update = new CUpdateUser(dto.getUserId());
                window.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Solo se permite modificar registros activos", "ERROR", JOptionPane.ERROR_MESSAGE); }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro a modificar", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }
    
    public void delete(JTable tblUser)
    {
        int i = tblUser.getSelectedRow();
        
        if(i != -1)
        {
            UsersDto dto = users[i];
            
            if(dto.getState() != 3)
            {
                if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    try {
                        UsersDao dao = DaoFactory.createUsersDao();
                        dto.setState((short) 3);
                        
                        if(dao.update(dto.createPk(), dto)){
                        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
                            model.setValueAt("*", i, 6);
                        }                        
                    } catch (UsersDaoException ex) {}
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "El registro ya está eliminado", "ERROR", JOptionPane.ERROR_MESSAGE); }
            
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro a eliminar", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }
    
    public void searchUser(int keyCode, String filter, String user, JTable tblUser) {
        

        if(keyCode == KeyEvent.VK_ENTER) {
            TableModel tableModel = tblUser.getModel();
        
            int i;
            for(i = 0; i < tableModel.getColumnCount(); i++)
            {
                if(filter.compareTo(tableModel.getColumnName(i)) == 0) {
                    break;}
            }

            for(int k = 0; k < tableModel.getRowCount(); k++)
            {
                if(user.compareToIgnoreCase(tableModel.getValueAt(k, i).toString()) == 0){
                    tblUser.setRowSelectionInterval(k, k);
                    break;
                    
                } else {
                    tblUser.clearSelection();
                }
            }
        }        
    }
}
