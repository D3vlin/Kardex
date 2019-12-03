package com.cidenet.hulkstore.controller.document;

import com.cidenet.hulkstore.controller.menu.CMenu;
import com.cidenet.hulkstore.documents.DocumentDao;
import com.cidenet.hulkstore.documents.DocumentDaoException;
import com.cidenet.hulkstore.documents.DocumentDto;
import com.cidenet.hulkstore.factory.DaoFactory;
import com.cidenet.hulkstore.view.document.UIDocument;
import com.mxrck.autocompleter.TextAutoCompleter;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Document Management Controller.
 * 
 * Load the existing documents with your data,
 * in addition to controlling the redirection to the insertion or modification windows.
 * Provides options to search records. 
 * The enable, disable and delete functions are performed here.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class CDocument
{
    private UIDocument window;
    private DocumentDto[] documents;
    
    /**
     * Empty Contructor.
     */
    public CDocument()
    {
        try {
            DocumentDao dao = DaoFactory.createDocumentDao();
            documents = dao.findAll();
            
        } catch (Exception exception) {}
        
        window = new UIDocument(this);
    }
    
    /**
     * Upload the documents registered in the database to the form table and set their status.
     * 
     * @param tblDocument 
     */
    public void upload(JTable tblDocument)
    {
        DefaultTableModel model = (DefaultTableModel) tblDocument.getModel();
        model.setRowCount(0);
        String state;
		
        for (DocumentDto document : documents) {
            if (document.getState() == 1) { state = "A"; } 
            else if (document.getState() == 2) { state = "I"; } 
            else { state = "*"; }
            model.addRow(new Object[]{document.getDocumentId(), document.getDocumentDescription(), state});
        }
    }
    
    /**
     * Depending on the status of the registered document, the status of the chkActive control changes.
     * 
     * @param tblDocument
     * @param chkActive 
     */
    public void updateState(JTable tblDocument, JCheckBox chkActive)
    {
        int i = tblDocument.getSelectedRow();
        
        if(i != -1)
        {
            DocumentDto dto = documents[i];
            
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
    
    /**
     * Add the available records to the autocompleter.
     * 
     * @param txtSearch
     * @param tblDocument 
     */
    public void loadAutoCompleter(JTextField txtSearch, JTable tblDocument) {
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter( txtSearch );
        textAutoAcompleter.setMode(0);
        textAutoAcompleter.setCaseSensitive(false);
        TableModel tableModel = tblDocument.getModel();
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

    /**
     * Show the form to insert a new document.
     */
    public void insert()
    {
        CInsertDocument cInsertDocument = new CInsertDocument();
        window.dispose();
    }

    /**
     * Show the form to modify a document.
     * 
     * @param tblDocument 
     */
    public void update(JTable tblDocument)
    {
        int i = tblDocument.getSelectedRow();
        
        if(i != -1)
        {
            DocumentDto dto = documents[i];                        
            
            if(dto.getState() == 1)
            {
                CUpdateDocument update = new CUpdateDocument(dto.getDocumentId());
                window.dispose();
                
            } else { JOptionPane.showMessageDialog(null, "Solo se permite modificar registros activos", "ERROR", JOptionPane.ERROR_MESSAGE); }
            
        } else { JOptionPane.showMessageDialog(null, "Seleccione un registro a modificar", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }
    
    /**
     * Change the status of a registered document to deleted.
     * 
     * @param tblDocument
     * @param chkActive 
     */
    public void delete(JTable tblDocument, JCheckBox chkActive) {
        int i = tblDocument.getSelectedRow();
        
        if(i != -1)
        {
            DocumentDto dto = documents[i];
            if(dto.getState() != 3)
            {
                if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    try {
                        DocumentDao dao =  DaoFactory.createDocumentDao();
                        dto.setState((short) 3);
                        if(dao.update(dto.createPk(), dto)){
                            DefaultTableModel model = (DefaultTableModel) tblDocument.getModel();
                            model.setValueAt("*", i, 2);
                            chkActive.setEnabled(false);
                        } 
                    } catch (Exception exception) {}
                }
                
            } else { JOptionPane.showMessageDialog(null, "El registro ya está eliminado", "ERROR", JOptionPane.ERROR_MESSAGE); }
            
        } else { JOptionPane.showMessageDialog(null, "Seleccione un registro a eliminar", "ERROR", JOptionPane.ERROR_MESSAGE); }
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
     * Enable or disable the status of the registered document.
     * 
     * @param tblDocument
     * @param chkActive 
     */
    public void enableDisable(JTable tblDocument, JCheckBox chkActive) {
        int i = tblDocument.getSelectedRow();
        
        DefaultTableModel model = (DefaultTableModel) tblDocument.getModel();
        
        if(i != -1) {
            DocumentDto dto = documents[i];
            DocumentDao dao = DaoFactory.createDocumentDao();
            
            if(chkActive.isSelected()) {      
                try {
                    dto.setState((short) 1);
                    if(dao.update(dto.createPk(), dto)) { model.setValueAt("A", i, 2); }
                    
                } catch (DocumentDaoException e) {}
                
            } else {
                try {
                    dto.setState((short) 2);
                    if(dao.update(dto.createPk(), dto)){ model.setValueAt("I", i, 2); }
                    
                } catch (DocumentDaoException e) {}
            }
            
        } else { JOptionPane.showMessageDialog(null, "Seleccione un registro", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }
    
    /**
     * Select the row where the searched document is located.
     * 
     * @param txtSearch
     * @param tblDocument 
     */
    public void selectRow(JTextField txtSearch, JTable tblDocument)
    {        
        TableModel tableModel = tblDocument.getModel();
        String fact = txtSearch.getText();
        String filter = "Nombre";
        
        int column;
        int columns = tableModel.getColumnCount();
            
        for(column = 0; column < columns; column++)
            { if(filter.compareTo(tableModel.getColumnName(column)) == 0) { break; } }
        
        int row;
        try {
            int rows = tableModel.getRowCount();
            for(row = 0; row < rows; row++) { 
                if(fact.compareTo((String) tableModel.getValueAt(row, column)) == 0) { break; }
            }

            if(row == 0) { tblDocument.changeSelection(0,0,false,true); }
            else { tblDocument.getSelectionModel().setSelectionInterval(row - 1, row); }
            
        } catch(Exception exception) { JOptionPane.showMessageDialog(null, "No se encontraron los datos buscados", "ERROR", JOptionPane.ERROR_MESSAGE); }
    }    
}