package com.cidenet.hulkstore.controller.product;

import com.cidenet.hulkstore.model.dao.product.*;
import com.cidenet.hulkstore.model.dao.DaoFactory;
import com.cidenet.hulkstore.model.dto.product.ProductDto;
import com.cidenet.hulkstore.model.dao.unity.*;
import com.cidenet.hulkstore.model.dto.unity.UnityDto;
import com.cidenet.hulkstore.view.product.UIUpdateProduct;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Product Modification Controller.
 * 
 * Load data of the selected product, receive new values and validate them
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-15
 */
public final class CUpdateProduct
{
    private UIUpdateProduct window;
    private final ProductDao productDao = DaoFactory.createProductDao();
    private ProductDto product;    
    private UnityDto[] units;
    
    /**
     * Constructor.
     * 
     * @param productId 
     */
    public CUpdateProduct(int productId)
    {
        try {            
            product = productDao.findByPrimaryKey(productId);
            
            UnityDao unityDao = DaoFactory.createUnityDao();
            units = unityDao.findWhereStateEquals((short) 1);
            
            window = new UIUpdateProduct(this);
            
        } catch (ProductDaoException | UnityDaoException exception) {}
    }

    /**
     * Upload the product information to the form.
     * 
     * @param txtProductId
     * @param txtProductName
     * @param txtUnityId
     * @param cmbUnity 
     */
    public void upload(JTextField txtProductId, JTextField txtProductName, JTextField txtUnityId, JComboBox cmbUnity)
    {
        txtProductId.setText(String.valueOf(product.getProductId()));
        txtProductName.setText(product.getProductName());
        txtUnityId.setText(String.valueOf(product.getUnityId()));
        
        for(UnityDto unity : units)
        {
            cmbUnity.addItem(unity.getUnityDescription());
            
            if(unity.getUnityId() == product.getUnityId()){
                cmbUnity.setSelectedItem(unity.getUnityDescription());
            }
        }
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
     * Get the id of the selected unity.
     * 
     * @param cmbUnity
     * @param txtUnityId 
     */
    public void seeUnity(JComboBox cmbUnity, JTextField txtUnityId) 
    {
        for(UnityDto unity : units) {
            if(unity.getUnityDescription().equals(cmbUnity.getSelectedItem().toString())) {
                txtUnityId.setText(String.valueOf(unity.getUnityId()));
                break;
            }
        }
    }

    /**
     * Modify the product.
     * 
     * @param txtProductId
     * @param txtProductName
     * @param txtUnityId 
     */
    public void accept(JTextField txtProductId, JTextField txtProductName, JTextField txtUnityId)
    {                
        try {
            product.setProductName(txtProductName.getText());
            product.setUnityId(Integer.parseInt(txtUnityId.getText())); 
            
            if(productDao.update(product.createPk(), product))
            {
                JOptionPane.showMessageDialog(null, "Se ha modificado el registro", "MODIFICACIÓN", JOptionPane.INFORMATION_MESSAGE);
                CProduct cProduct = new CProduct();
                window.dispose();
            
            } else { JOptionPane.showMessageDialog(null, "No se ha modificado el registro", "ERROR", JOptionPane.ERROR_MESSAGE); }
        
        } catch (ProductDaoException exception) {}
    }    
}