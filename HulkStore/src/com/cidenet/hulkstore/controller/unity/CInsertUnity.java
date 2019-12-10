package com.cidenet.hulkstore.controller.unity;

import com.cidenet.hulkstore.factory.DaoFactory;
import com.cidenet.hulkstore.units.UnityDao;
import com.cidenet.hulkstore.units.UnityDaoException;
import com.cidenet.hulkstore.units.UnityDto;
import com.cidenet.hulkstore.view.unity.UIInsertUnity;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Drive Insertion Controller
 * 
 * Receive and validate data on a new unit record
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-18
 */
public final class CInsertUnity
{
    private UIInsertUnity window;
    
    /**
     * Empty Constructor.
     */
    public CInsertUnity() { window = new UIInsertUnity(this); }
    
    /**
     * Upload the unity information to the form.
     * 
     * @param txtUnityId 
     */
    public void upload(JTextField txtUnityId)
    {
        try {
            UnityDao dao = DaoFactory.createUnityDao();
            txtUnityId.setText(dao.findNextUnityId());
            
        } catch (UnityDaoException exception) {}
    }

    /**
     * Register the new unity.
     * 
     * @param txtUnityId
     * @param txtUnityDescription
     */
    public void accept(JTextField txtUnityId, JTextField txtUnityDescription) 
    {      
        try {
            UnityDto unityDto = new UnityDto(Integer.parseInt(txtUnityId.getText()), txtUnityDescription.getText());
            UnityDao unityDao = DaoFactory.createUnityDao();
            
            if(!unityDao.insert(unityDto).isUnityIdNull()){
                JOptionPane.showMessageDialog(null, "Se ha agregado el registro nuevo", "INSERCION", JOptionPane.INFORMATION_MESSAGE);
                CUnity cUnity = new CUnity();
                window.dispose();
                
            } else { JOptionPane.showMessageDialog(null, "No se registro", "ERROR", JOptionPane.ERROR_MESSAGE); }
            
        } catch (UnityDaoException exception) {}
    }

    /**
     * Cancel the operation and return to the unities menu.
     */
    public void cancel()
    {
        CUnity cUnity = new CUnity();
        window.dispose();
    }    
}
