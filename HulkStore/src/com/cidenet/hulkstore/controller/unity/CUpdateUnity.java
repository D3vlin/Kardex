package com.cidenet.hulkstore.controller.unity;

import com.cidenet.hulkstore.units.UnityDao;
import com.cidenet.hulkstore.units.UnityDaoException;
import com.cidenet.hulkstore.units.UnityDaoFactory;
import com.cidenet.hulkstore.units.UnityDto;
import com.cidenet.hulkstore.view.unity.UIUpdateUnity;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Unit Modification Controller
 * 
 * Load data from the selected unit, receive new values and validate them
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-18
 */
public class CUpdateUnity implements IUpdateUnity
{
    private UIUpdateUnity window;
    private UnityDao unityDao = UnityDaoFactory.create();
    private UnityDto unity;
    
    public CUpdateUnity(int unityId)
    {
        try {
            unity = unityDao.findByPrimaryKey(unityId);
            window = new UIUpdateUnity(this);
            
        } catch (Exception e) {}
    }

    @Override
    public void upload(JTextField txtUnityId, JTextField txtUnityDescription)
    {
        txtUnityId.setText(String.valueOf(unity.getUnityId()));
        txtUnityDescription.setText(unity.getUnityDescription());
    }

    @Override
    public void accept(JTextField txtUnityDescription) {
        
        try {
            unity.setUnityDescription(txtUnityDescription.getText());
            
            if(unityDao.update(unity.createPk(), unity))
            {
                JOptionPane.showMessageDialog(null, "Se ha modificado el registro", "MODIFICACIÓN", JOptionPane.INFORMATION_MESSAGE);
                new CUnity();
                window.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha modificado el registro", "ERROR", JOptionPane.ERROR_MESSAGE); }
        } catch (UnityDaoException e) {}
    }

    @Override
    public void cancel() {
        new CUnity();
        window.dispose();
    }
    
}
