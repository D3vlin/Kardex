package com.cidenet.hulkstore.controller.document;

import com.cidenet.hulkstore.model.dao.DaoFactory;
import com.cidenet.hulkstore.documents.DocumentDao;
import com.cidenet.hulkstore.documents.DocumentDaoException;
import com.cidenet.hulkstore.documents.DocumentDto;
import com.cidenet.hulkstore.view.document.UIInsertDocument;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Document Insertion Controller
 * 
 * Receive and validate data on a new document record
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class CInsertDocument
{
    private final UIInsertDocument window;
    private final DocumentDao documentDao = DaoFactory.createDocumentDao();
    
    /**
     * Empty Contructor.
     */
    public CInsertDocument()
    {
        window = new UIInsertDocument(this);
    }
    
    /**
     * Upload the documentId to the form.
     * 
     * @param txtDocumentId 
     */
    public void upload(JTextField txtDocumentId) {
        
        try { txtDocumentId.setText(documentDao.findNextDocumentId()); }
        catch (DocumentDaoException exeption) {}
    }

    /**
     * Register the new document.
     * 
     * @param txtDocumentId
     * @param txtDescription 
     */
    public void accept(JTextField txtDocumentId, JTextField txtDescription) 
    {      
        try {
            DocumentDto dto = new DocumentDto(Integer.parseInt(txtDocumentId.getText()), txtDescription.getText());
            
            if(!documentDao.insert(dto).isDocumentIdNull()){
                JOptionPane.showMessageDialog(null, "Se ha agregado el registro nuevo", "INSERCION", JOptionPane.INFORMATION_MESSAGE);
                CDocument cDocument = new CDocument();
                window.dispose();
                
            } else { JOptionPane.showMessageDialog(null, "No se registro", "ERROR", JOptionPane.ERROR_MESSAGE); }
            
        } catch (DocumentDaoException ex) {}
    }

    /**
     * Cancel the operation and return to the documents menu.
     */
    public void cancel()
    {
        CDocument cDocument = new CDocument();
        window.dispose();
    }    
}