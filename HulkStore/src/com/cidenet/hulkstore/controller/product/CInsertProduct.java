package com.cidenet.hulkstore.controller.product;

import com.cidenet.hulkstore.model.dao.product.*;
import com.cidenet.hulkstore.model.dao.DaoFactory;
import com.cidenet.hulkstore.model.dto.product.ProductDto;
import com.cidenet.hulkstore.model.dao.unity.*;
import com.cidenet.hulkstore.model.dto.unity.UnityDto;
import com.cidenet.hulkstore.view.product.UIInsertProduct;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Product Insertion Controller.
 * 
 * Receive and validate data about a new product registration
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-15
 */
public final class CInsertProduct
{
    private UIInsertProduct window;
    private UnityDto[] units;
    
    /**
     * Empty Constructor.
     */
    public CInsertProduct()
    {
        try {
            UnityDao dao = DaoFactory.createUnityDao();
            units = dao.findWhereStateEquals((short) 1);
            window = new UIInsertProduct(this);
            
        } catch (UnityDaoException exception) {}
    }

    /**
     * Cancel the operation and return to the products menu.
     */
    public void cancel() 
    {
        CProduct cProduct = new CProduct();
        window.dispose();
    }

    /**
     * Upload the productId to the form.
     * 
     * @param txtProductId
     * @param cmbUnity 
     */
    public void upload(JTextField txtProductId, JComboBox cmbUnity)
    {        
        try {
            ProductDao dao = DaoFactory.createProductDao();
            txtProductId.setText(dao.findNextProductId());
            
            for(UnityDto unity : units)
            {
                cmbUnity.addItem(unity.getUnityDescription());
            }
            
        } catch (ProductDaoException exception) {}
    }

    /**
     * Register the new product.
     * 
     * @param txtProductId
     * @param txtProductName
     * @param txtUnityId 
     */
    public void accept(JTextField txtProductId, JTextField txtProductName, JTextField txtUnityId) {
        
        try {
            ProductDto dto = new ProductDto(Integer.parseInt(txtProductId.getText()), txtProductName.getText(), Integer.parseInt(txtUnityId.getText()));
            ProductDao dao = DaoFactory.createProductDao();
            
            if(!dao.insert(dto).isProductIdNull()){
                JOptionPane.showMessageDialog(null, "Se ha agregado el registro nuevo", "INSERCION", JOptionPane.INFORMATION_MESSAGE);
                CProduct cProduct = new CProduct();
                window.dispose();
            
            } else { JOptionPane.showMessageDialog(null, "No se registro", "ERROR", JOptionPane.ERROR_MESSAGE); }
            
        } catch (ProductDaoException exception) {}
    }

    /**
     * Get the id of the selected unity.
     * 
     * @param cmbUnity
     * @param txtUnityId 
     */
    public void seeUnity(JComboBox cmbUnity, JTextField txtUnityId) {
        for(UnityDto unity : units) {
            if(unity.getUnityDescription().equals(cmbUnity.getSelectedItem().toString())) {
                txtUnityId.setText(String.valueOf(unity.getUnityId()));
                break;
            }
        }
    }    
}