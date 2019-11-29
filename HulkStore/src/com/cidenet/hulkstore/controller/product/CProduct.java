package com.cidenet.hulkstore.controller.product;

import com.cidenet.hulkstore.controller.menu.CMenu;
import com.cidenet.hulkstore.controller.reports.CReports;
import com.cidenet.hulkstore.products.ProductDao;
import com.cidenet.hulkstore.products.ProductDaoException;
import com.cidenet.hulkstore.factory.DaoFactory;
import com.cidenet.hulkstore.products.ProductDto;
import com.cidenet.hulkstore.products.ProductView;
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
public final class CProduct
{
    private UIProduct window;
    private ProductDto[] products;
    
    public CProduct()
    {
        try {
            ProductDao dao = DaoFactory.createProductDao();
            products = dao.findAll();
        } catch (Exception e) {}
        
        
        window = new UIProduct(this);
    }

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

    public void menu()
    {
        new CMenu();
        window.dispose();
    }

    public void insert()
    {
        new CInsertProduct();
        window.dispose();
    }

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

    public void enableDisable(JTable tblProduct, JCheckBox chkActive) {
        int i = tblProduct.getSelectedRow();
        
        DefaultTableModel model = (DefaultTableModel) tblProduct.getModel();
        
        if(i != -1) {
            ProductDto dto = products[i];
            ProductDao dao = DaoFactory.createProductDao();
            
            if(chkActive.isSelected())
            {      
                try {
                    dto.setState((short) 1);
                    if(dao.update(dto.createPk(), dto)){
                        model.setValueAt("A", i, 3);}
                } catch (ProductDaoException e) {}
            } 
            else
            {
                try {
                    dto.setState((short) 2);
                    if(dao.update(dto.createPk(), dto)){
                        model.setValueAt("I", i, 3);}
                } catch (ProductDaoException e) {}
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro", "ERROR", JOptionPane.ERROR_MESSAGE);}
    }

    public void delete(JTable tblProduct, JCheckBox chkActive) {
        int i = tblProduct.getSelectedRow();
        
        if(i != -1)
        {
            ProductDto dto = products[i];
            if(dto.getState() != 3)
            {
                if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    try {
                        ProductDao dao =  DaoFactory.createProductDao();
                        dto.setState((short) 3);
                        if(dao.update(dto.createPk(), dto)){
                            DefaultTableModel model = (DefaultTableModel) tblProduct.getModel();
                            model.setValueAt("*", i, 3);
                            chkActive.setEnabled(false);
                        } 
                    } catch (Exception e) {}
                }
            }
            else
                JOptionPane.showMessageDialog(null, "El registro ya está eliminado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Seleccione un registro a eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public void generateReport() {        
        try {
            ProductDao dao = DaoFactory.createProductDao();
            ProductView[] viewProducts = dao.getViewProduct();
            
            CReports report = new CReports();
            report.generateProductReport(viewProducts);
        } catch (ProductDaoException ex) {ex.printStackTrace();}
    }

    public void searchProduct(JTextField txtSearch, JTable tblProduct) {
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter( txtSearch );
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
                { if(fact.compareTo((String) tableModel.getValueAt(row, column)) == 0) { break; } }

            if(row == 0)
                { tblProduct.changeSelection(0,0,false,true); }
            else
                { tblProduct.getSelectionModel().setSelectionInterval(row - 1, row); }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "No se encontraron los datos buscados", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
