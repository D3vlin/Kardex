package com.cidenet.hulkstore.controller.product;

import com.cidenet.hulkstore.products.ProductDao;
import com.cidenet.hulkstore.products.ProductDaoException;
import com.cidenet.hulkstore.products.ProductDaoFactory;
import com.cidenet.hulkstore.products.ProductDto;
import com.cidenet.hulkstore.units.UnityDao;
import com.cidenet.hulkstore.units.UnityDaoException;
import com.cidenet.hulkstore.units.UnityDaoFactory;
import com.cidenet.hulkstore.units.UnityDto;
import com.cidenet.hulkstore.view.product.UIInsertProduct;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Product Insertion Controller
 * 
 * Receive and validate data about a new product registration
 * 
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-15
 */
public class CInsertProduct implements IInsertProduct
{
    private UIInsertProduct window;
    private UnityDto[] units;
        
    public CInsertProduct()
    {
        try {
            UnityDao dao = UnityDaoFactory.create();
            units = dao.findWhereStateEquals((short) 1);
            window = new UIInsertProduct(this);
        } catch (UnityDaoException ex) {}
    }

    @Override
    public void cancel() {
        new CProduct();
        window.dispose();
    }

    @Override
    public void upload(JTextField txtProductId, JComboBox cmbUnity) {
        
        try {
            ProductDao dao = ProductDaoFactory.create();
            txtProductId.setText(dao.findNextProductId());
            
            for(UnityDto unity : units)
            {
                cmbUnity.addItem(unity.getUnityDescription());
            }
        } catch (ProductDaoException ex) {}
    }

    @Override
    public void accept(JTextField txtProductId, JTextField txtProductName, JTextField txtUnityId) {
        
        try {
            ProductDto dto = new ProductDto(Integer.parseInt(txtProductId.getText()), txtProductName.getText(), Integer.parseInt(txtUnityId.getText()));
            ProductDao dao = ProductDaoFactory.create();
            
            if(!dao.insert(dto).isProductIdNull()){
                JOptionPane.showMessageDialog(null, "Se ha agregado el registro nuevo", "INSERCION", JOptionPane.INFORMATION_MESSAGE);
                new CProduct();
                window.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se registro", "ERROR", JOptionPane.ERROR_MESSAGE);}
        } catch (ProductDaoException ex) {}
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
    
}
