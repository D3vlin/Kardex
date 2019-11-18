package com.cidenet.hulkstore.controller.unity;

import com.cidenet.hulkstore.units.UnityDao;
import com.cidenet.hulkstore.units.UnityDaoException;
import com.cidenet.hulkstore.units.UnityDaoFactory;
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
public class CInsertUnity implements IInsertUnity
{
    private UIInsertUnity window;
    
    public CInsertUnity()
    {
        window = new UIInsertUnity(this);
    }
    
    @Override
    public void upload(JTextField txtUnityId) {
        try {
            UnityDao dao = UnityDaoFactory.create();
            txtUnityId.setText(dao.findNextUnityId());
        } catch (UnityDaoException ex) {}
    }

    @Override
    public void accept(JTextField txtUnityId, JTextField txtUnityDescription) 
    {      
        try {
            UnityDto dto = new UnityDto(Integer.parseInt(txtUnityId.getText()), txtUnityDescription.getText());
            UnityDao dao = UnityDaoFactory.create();
            
            if(!dao.insert(dto).isUnityIdNull()){
                JOptionPane.showMessageDialog(null, "Se ha agregado el registro nuevo", "INSERCION", JOptionPane.INFORMATION_MESSAGE);
                new CUnity();
                window.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se registro", "ERROR", JOptionPane.ERROR_MESSAGE);}
            
        } catch (UnityDaoException ex) {}
    }

    @Override
    public void cancel()
    {
        new CUnity();
        window.dispose();
    }    
}
