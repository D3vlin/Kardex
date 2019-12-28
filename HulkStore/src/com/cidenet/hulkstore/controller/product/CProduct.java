package com.cidenet.hulkstore.controller.product;

import com.cidenet.hulkstore.controller.menu.CMenu;
import com.cidenet.hulkstore.controller.reports.CReports;
import com.cidenet.hulkstore.model.dao.product.*;
import com.cidenet.hulkstore.model.dao.DaoFactory;
import com.cidenet.hulkstore.model.dto.product.ProductDto;
import com.cidenet.hulkstore.model.dto.product.ProductView;
import com.cidenet.hulkstore.view.product.UIProduct;
import com.mxrck.autocompleter.TextAutoCompleter;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Product Management Controller.
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
public final class CProduct
{
    private final UIProduct window;
    private ProductDao productDao = DaoFactory.createProductDao();
    private ProductDto[] products;
    private ProductDto productDto;
    private DefaultTableModel defaultTableModel;
    
    /**
     * Empty Constructor.
     */
    public CProduct()
    {
        try {
            productDao = DaoFactory.createProductDao();
            products = productDao.findAll();
            
        } catch (ProductDaoException exception) {}        
        
        window = new UIProduct(this);
    }

    /**
     * Upload the products in the database to the form table and set their status.
     * 
     * @param tblProduct 
     */
    public void upload(JTable tblProduct)
    {
        defaultTableModel = (DefaultTableModel) tblProduct.getModel();
        defaultTableModel.setRowCount(0);        
        String state;
		
        for (ProductDto product : products) {
            switch (product.getState()) {
                case 1:
                    state = "A";
                    break;
                case 2:
                    state = "I";
                    break;
                default:
                    state = "*";
                    break;
            }
            
            defaultTableModel.addRow(new Object[]{product.getProductId(), product.getProductName(), product.getUnityId(), state});
        }
    }

    /**
     * Depending on the status of the registered product, the status of the chkActive control changes.
     * 
     * @param tblProduct
     * @param chkActive 
     */
    public void updateState(JTable tblProduct, JCheckBox chkActive)
    {
        int i = tblProduct.getSelectedRow();
        
        if(i != -1)
        {
            productDto = products[i];
            
            if(productDto.getState() != 3)
            {
                chkActive.setEnabled(true);
                
                if(productDto.getState() == 1) { chkActive.setSelected(true); }
                else { chkActive.setSelected(false); }
                
            } else {
                chkActive.setEnabled(false);
                chkActive.setSelected(false);
            }
        } else {
            chkActive.setEnabled(false);
            chkActive.setSelected(false);
        }
    }

    /**
     * Return to the initial menu.
     */
    public void menu()
    {
        CMenu cMenu = new CMenu();
        window.dispose();
    }

    /**
     * Show the form to insert a new product.
     */
    public void insert()
    {
        CInsertProduct cInsertProduct = new CInsertProduct();
        window.dispose();
    }

    /**
     * Show the form to modify a product.
     * 
     * @param tblProduct 
     */
    public void update(JTable tblProduct)
    {
        int i = tblProduct.getSelectedRow();
        
        if(i != -1)
        {
            productDto = products[i];
                        
            CUpdateProduct update;
            
            if(productDto.getState() == 1)
            {
                update = new CUpdateProduct(productDto.getProductId());
                window.dispose();
                
            } else { JOptionPane.showMessageDialog(null, "Solo se permite modificar registros activos", "ERROR", JOptionPane.ERROR_MESSAGE); }
            
        } else { JOptionPane.showMessageDialog(null, "Seleccione un registro a modificar", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }

    /**
     * Enable or disable the status of the registered product.
     * 
     * @param tblProduct
     * @param chkActive 
     */
    public void enableDisable(JTable tblProduct, JCheckBox chkActive) 
    {
        int i = tblProduct.getSelectedRow();
        
        defaultTableModel = (DefaultTableModel) tblProduct.getModel();
        
        if(i != -1) {
            productDto = products[i];
            productDao = DaoFactory.createProductDao();
            
            if(chkActive.isSelected())
            {      
                try {
                    productDto.setState((short) 1);
                    if(productDao.update(productDto.createPk(), productDto)) { defaultTableModel.setValueAt("A", i, 3); }
                    
                } catch (ProductDaoException e) {}
                
            } else {
                try {
                    productDto.setState((short) 2);
                    if(productDao.update(productDto.createPk(), productDto)) { defaultTableModel.setValueAt("I", i, 3); }
                    
                } catch (ProductDaoException exception) {}
            }
            
        } else { JOptionPane.showMessageDialog(null, "Seleccione un registro", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }

    /**
     * Change the status of a registered product to deleted.
     * 
     * @param tblProduct
     * @param chkActive 
     */
    public void delete(JTable tblProduct, JCheckBox chkActive) {
        int i = tblProduct.getSelectedRow();
        
        if(i != -1)
        {
            productDto = products[i];
            if(productDto.getState() != 3)
            {
                if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    try {
                        productDao =  DaoFactory.createProductDao();
                        productDto.setState((short) 3);
                        if(productDao.update(productDto.createPk(), productDto)) {
                            defaultTableModel = (DefaultTableModel) tblProduct.getModel();
                            defaultTableModel.setValueAt("*", i, 3);
                            chkActive.setEnabled(false);
                        } 
                        
                    } catch (ProductDaoException exception) {}
                }
                
            } else { JOptionPane.showMessageDialog(null, "El registro ya está eliminado", "ERROR", JOptionPane.ERROR_MESSAGE); }
        
        } else { JOptionPane.showMessageDialog(null, "Seleccione un registro a eliminar", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }

    /**
     * Generate the report of products.
     */
    public void generateReport() {        
        try {
            productDao = DaoFactory.createProductDao();
            ProductView[] viewProducts = productDao.getViewProduct();
            
            CReports report = new CReports();
            report.generateProductReport(viewProducts);
            
        } catch (ProductDaoException ex) {}
    }

    /**
     * Add the available records to the autocompleter.
     * 
     * @param txtSearch
     * @param tblProduct 
     */
    public void loadAutoCompleter(JTextField txtSearch, JTable tblProduct) {
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter( txtSearch );
        textAutoAcompleter.setMode(0);
        textAutoAcompleter.setCaseSensitive(false);
        TableModel tableModel = tblProduct.getModel();
        String filter = "Nombre";
        
        int i;
        for(i = 0; i < tableModel.getColumnCount(); i++)
        {
            if(filter.compareTo(tableModel.getColumnName(i)) == 0) { break; }
        }
        
        for(int k = 0; k < tableModel.getRowCount(); k++)
        {
            textAutoAcompleter.addItem(tableModel.getValueAt(k, i));
        }
    }

    /**
     * Select the row where the searched product is located.
     * 
     * @param txtSearch
     * @param tblProduct 
     */
    public void selectRow(JTextField txtSearch, JTable tblProduct)
    {        
        TableModel tableModel = tblProduct.getModel();
        String fact = txtSearch.getText();
        String filter = "Nombre";
        
        int column;
        int columns = tableModel.getColumnCount();
            
        for(column = 0; column < columns; column++)
            { if(filter.compareTo(tableModel.getColumnName(column)) == 0) { break; } }
        
        int row;
        try
        {
            int rows = tableModel.getRowCount();
            for(row = 0; row < rows; row++)
            {
                if(fact.compareTo((String) tableModel.getValueAt(row, column)) == 0) { break; } 
            }

            if(row == 0) { tblProduct.changeSelection(0,0,false,true); }
            else { tblProduct.getSelectionModel().setSelectionInterval(row - 1, row); }
            
        } catch(Exception exception) { JOptionPane.showMessageDialog(null, "No se encontraron los datos buscados", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }    
}