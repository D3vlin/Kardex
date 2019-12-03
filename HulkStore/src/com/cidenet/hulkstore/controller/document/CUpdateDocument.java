package com.cidenet.hulkstore.controller.document;

import com.cidenet.hulkstore.documents.DocumentDao;
import com.cidenet.hulkstore.documents.DocumentDaoException;
import com.cidenet.hulkstore.documents.DocumentDto;
import com.cidenet.hulkstore.factory.DaoFactory;
import com.cidenet.hulkstore.view.document.UIUpdateDocument;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Document Modification Controller
 * 
 * Load data from the selected document, receive new values and validate them
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class CUpdateDocument
{
    private UIUpdateDocument window;
    private DocumentDao documentDao = DaoFactory.createDocumentDao();
    private DocumentDto document;
    
    /**
     * Constructor.
     * 
     * @param documentId 
     */
    public CUpdateDocument(int documentId)
    {
        try {
            document = documentDao.findByPrimaryKey(documentId);
            window = new UIUpdateDocument(this);
            
        } catch (Exception e) {}
    }

    /**
     * Upload the documentId to the form.
     * 
     * @param txtDocumentId
     * @param txtDescription 
     */
    public void upload(JTextField txtDocumentId, JTextField txtDescription)
    {
        txtDocumentId.setText(String.valueOf(document.getDocumentId()));
        txtDescription.setText(document.getDocumentDescription());
    }

    /**
     * Modify the document.
     * 
     * @param txtDescription 
     */
    public void accept(JTextField txtDescription) {
        
        try {
            document.setDocumentDescription(txtDescription.getText());
            
            if(documentDao.update(document.createPk(), document))
            {
                JOptionPane.showMessageDialog(null, "Se ha modificado el registro", "MODIFICACIÓN", JOptionPane.INFORMATION_MESSAGE);
                CDocument cDocument = new CDocument();
                window.dispose();
                
            } else { JOptionPane.showMessageDialog(null, "No se ha modificado el registro", "ERROR", JOptionPane.ERROR_MESSAGE); }
            
        } catch (DocumentDaoException e) {}
    }

    /**
     * Cancel the operation and return to the documents menu.
     */
    public void cancel() {
        CDocument cDocument = new CDocument();
        window.dispose();
    }    
}