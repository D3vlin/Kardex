package com.cidenet.hulkstore.controller.product;

import com.cidenet.hulkstore.products.ProductDao;
import com.cidenet.hulkstore.products.ProductDaoException;
import com.cidenet.hulkstore.products.ProductDaoFactory;
import com.cidenet.hulkstore.products.ProductDto;
import com.cidenet.hulkstore.units.UnityDao;
import com.cidenet.hulkstore.units.UnityDaoException;
import com.cidenet.hulkstore.units.UnityDaoFactory;
import com.cidenet.hulkstore.units.UnityDto;
import com.cidenet.hulkstore.view.product.UIUpdateProduct;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Product Modification Controller
 * 
 * Load data of the selected product, receive new values and validate them
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-15
 */
public class CUpdateProduct implements IUpdateProduct
{
    private UIUpdateProduct window;
    private ProductDao productDao = ProductDaoFactory.create();
    private ProductDto product;    
    private UnityDto[] units;
    
    public CUpdateProduct(int productId)
    {
        try {            
            product = productDao.findByPrimaryKey(productId);
            
            UnityDao unityDao = UnityDaoFactory.create();
            units = unityDao.findWhereStateEquals((short) 1);
            
            window = new UIUpdateProduct(this);
        } catch (ProductDaoException | UnityDaoException ex) {}
    }

    @Override
    public void upload(JTextField txtProductId, JTextField txtProductName, JTextField txtUnityId, JComboBox cmbUnity) {
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

    @Override
    public void cancel() {
        new CProduct();
        window.dispose();
    }

    @Override
    public void seeUnity(JComboBox cmbUnity, JTextField txtUnityId) {
        for(UnityDto unity : units) {
            if(unity.getUnityDescription().equals(cmbUnity.getSelectedItem().toString())) {
                txtUnityId.setText(String.valueOf(unity.getUnityId()));
                break;
            }
        }
    }

    @Override
    public void accept(JTextField txtProductId, JTextField txtProductName, JTextField txtUnityId) {
                
        try {
            product.setProductName(txtProductName.getText());
            product.setUnityId(Integer.parseInt(txtUnityId.getText())); 
            
            if(productDao.update(product.createPk(), product))
            {
                JOptionPane.showMessageDialog(null, "Se ha modificado el registro", "MODIFICACIÓN", JOptionPane.INFORMATION_MESSAGE);
                new CProduct();
                window.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha modificado el registro", "ERROR", JOptionPane.ERROR_MESSAGE);}
        } catch (ProductDaoException ex) {}
    }
    
}
