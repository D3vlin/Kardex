package com.cidenet.hulkstore.controller.unity;

import com.cidenet.hulkstore.controller.menu.CMenu;
import com.cidenet.hulkstore.factory.DaoFactory;
import com.cidenet.hulkstore.units.UnityDao;
import com.cidenet.hulkstore.units.UnityDaoException;
import com.cidenet.hulkstore.units.UnityDto;
import com.cidenet.hulkstore.view.unity.UIUnity;
import com.mxrck.autocompleter.TextAutoCompleter;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Unit Management Controller
 * 
 * Load the existing units with their data,
 * in addition to controlling the redirection to the insertion or modification windows.
 * The enable, disable and delete functions are performed here.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-18
 */
public final class CUnity
{
    private UIUnity window;
    private UnityDto[] units; 
    
    public CUnity()
    {
        try {
            UnityDao dao = DaoFactory.createUnityDao();
            units = dao.findAll();
        } catch (UnityDaoException ex) {}
        
        
        window = new UIUnity(this);
    }

    public void upload(JTable tblUnit)
    {
        DefaultTableModel model = (DefaultTableModel) tblUnit.getModel();
        model.setRowCount(0);   
        String state;
        
        for(UnityDto unity: units) {
            if (unity.getState() == 1) {
                state = "A";
            } else if (unity.getState() == 2) {
                state = "I";
            } else {
                state = "*";
            }
            model.addRow(new Object[]{unity.getUnityId(), unity.getUnityDescription(), state});
        }
    }

    public void updateState(JTable tblUnit, JCheckBox chkActive)
    {
        int i = tblUnit.getSelectedRow();
        
        if(i != -1)
        {
            UnityDto dto = units[i];
            
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

    public void menu() {
        new CMenu();
        window.dispose();
    }

    public void insert() {
        new CInsertUnity();
        window.dispose();
    }

    public void update(JTable tblUnit)
    {
        int i = tblUnit.getSelectedRow();
        
        if(i != -1)
        {
            UnityDto dto = units[i];
            
            CUpdateUnity update;
            
            if(dto.getState() == 1)
            {
                update = new CUpdateUnity(dto.getUnityId());
                window.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Solo se permite modificar registros activos", "ERROR", JOptionPane.ERROR_MESSAGE); }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro a modificar", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }

    public void delete(JTable tblUnit, JCheckBox chkActive) {        
        int i = tblUnit.getSelectedRow();
        
        if(i != -1)
        {
            UnityDto dto = units[i];
            if(dto.getState() != 3)
            {
                if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    try {
                        UnityDao dao = DaoFactory.createUnityDao();
                        dto.setState((short) 3);
                        if(dao.update(dto.createPk(), dto)){
                            DefaultTableModel model = (DefaultTableModel) tblUnit.getModel();
                            model.setValueAt("*", i, 2);
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

    public void enableDisable(JTable tblUnit, JCheckBox chkActive) {
        int i = tblUnit.getSelectedRow();
        
        DefaultTableModel model = (DefaultTableModel) tblUnit.getModel();
        
        if(i != -1) {
            UnityDto dto = units[i];
            UnityDao dao = DaoFactory.createUnityDao();
            
            if(chkActive.isSelected())
            {
                try {
                    dto.setState((short) 1);
                    if(dao.update(dto.createPk(), dto)){
                        model.setValueAt("A", i, 2); }
                } catch (UnityDaoException e) {}
            }
            else
            {
                try {
                    dto.setState((short) 2);
                    if(dao.update(dto.createPk(), dto)){
                        model.setValueAt("I", i, 2); }
                } catch (UnityDaoException e) {}
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }

    public void searchUnity(JTextField txtSearch, JTable tblUnit) {
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter( txtSearch );
        textAutoAcompleter.setMode(0);
        textAutoAcompleter.setCaseSensitive(false);
        TableModel tableModel = tblUnit.getModel();
        String filtro = "Descripción";
        
        int i;        
        for(i = 0; i < tableModel.getColumnCount(); i++)
        {
            if(filtro.compareTo(tableModel.getColumnName(i)) == 0)
                break;
        }
        
        for(int k = 0; k < tableModel.getRowCount(); k++)
        {
            textAutoAcompleter.addItem(tableModel.getValueAt(k, i));
        }
    }

    public void selectRow(JTextField txtSearch, JTable tblUnit)
    {
        TableModel tableModel = tblUnit.getModel();
        String fact = txtSearch.getText();
        String filter = "Descripción";
        
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
                { tblUnit.changeSelection(0,0,false,true); }
            else
                { tblUnit.getSelectionModel().setSelectionInterval(row - 1, row); }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "No se encontraron los datos buscados", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
