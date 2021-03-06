package com.cidenet.hulkstore.controller.unity;

import com.cidenet.hulkstore.model.dao.DaoFactory;
import com.cidenet.hulkstore.model.dao.unity.*;
import com.cidenet.hulkstore.model.dto.unity.UnityDto;
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
    private final UIInsertUnity window;
    private final UnityDao unityDao = DaoFactory.createUnityDao();
    
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
            txtUnityId.setText(unityDao.findNextUnityId());
            
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