package com.cidenet.hulkstore.controller.product;

import com.cidenet.hulkstore.controller.menu.CMenu;
import com.cidenet.hulkstore.products.ProductDao;
import com.cidenet.hulkstore.products.ProductDaoFactory;
import com.cidenet.hulkstore.products.ProductDto;
import com.cidenet.hulkstore.view.product.UIProduct;
import com.mxrck.autocompleter.TextAutoCompleter;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Product Management Controller
 * 
 * Load existing products with your data,
 * in addition to controlling the redirection to the insertion or modification windows.
 * Provides options to generate report and search records.
 * The enable, disable and delete functions are performed here.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-14
 */
public class CProduct implements IProduct
{
    private UIProduct window;
    private ProductDto[] products;
    
    public CProduct()
    {
        try {
            ProductDao dao = ProductDaoFactory.create();
            products = dao.findAll();
        } catch (Exception e) {}
        
        
        window = new UIProduct(this);
    }

    @Override
    public void upload(JTable tblProduct)
    {
        DefaultTableModel model = (DefaultTableModel) tblProduct.getModel();
        model.setRowCount(0);
        String state;
		
        for (ProductDto product : products) {
            if (product.getState() == 1) {
                state = "A";
            } else if (product.getState() == 2) {
                state = "I";
            } else {
                state = "*";
            }
            model.addRow(new Object[]{product.getProductId(), product.getProductName(), product.getUnityId(), state});
        }
    }

    @Override
    public void updateState(JTable tblProduct, JCheckBox chkActive)
    {
        int i = tblProduct.getSelectedRow();
        
        if(i != -1)
        {
            ProductDto dto = products[i];
            
            if(dto.getState() != 3)
            {
                chkActive.setEnabled(true);
                
                if(dto.getState() == 1) {
                    chkActive.setSelected(true);}
                else {
                    chkActive.setSelected(false);}
                
            } else {
                chkActive.setEnabled(false);
                chkActive.setSelected(false);
            }
        } else {
            chkActive.setEnabled(false);
            chkActive.setSelected(false);
        }
    }

    @Override
    public void menu()
    {
        new CMenu();
        window.dispose();
    }

    @Override
    public void insert()
    {
        new CInsertProduct();
        window.dispose();
    }

    @Override
    public void update(JTable tblProduct)
    {
        int i = tblProduct.getSelectedRow();
        
        if(i != -1)
        {
            ProductDto dto = products[i];
                        
            CUpdateProduct update;
            
            if(dto.getState() == 1)
            {
                update = new CUpdateProduct(dto.getProductId());
                window.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Solo se permite modificar registros activos", "ERROR", JOptionPane.ERROR_MESSAGE);}
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro a modificar", "ERROR", JOptionPane.ERROR_MESSAGE);}
    }

    @Override
    public void enableDisable(JTable tblProduct, JCheckBox chkActive) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(JTable tblProduct, JCheckBox chkActive) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void generateReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void searchProduct(JTextField search, JTable tblProduct) {
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter( search );
        textAutoAcompleter.setMode(0);
        textAutoAcompleter.setCaseSensitive(false);
        TableModel tableModel = tblProduct.getModel();
        String filter = "Nombre";
        
        int i;
        for(i = 0; i < tableModel.getColumnCount(); i++)
        {
            if(filter.compareTo(tableModel.getColumnName(i)) == 0)
                break;
        }
        
        for(int k = 0; k < tableModel.getRowCount(); k++)
        {
            textAutoAcompleter.addItem(tableModel.getValueAt(k, i));
        }
    }

    @Override
    public void selectRow(JTextField search, JTable tblProduct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
