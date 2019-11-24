package com.cidenet.hulkstore.controller.document;

import com.cidenet.hulkstore.factory.DaoFactory;
import com.cidenet.hulkstore.documents.DocumentDao;
import com.cidenet.hulkstore.documents.DocumentDaoException;
import com.cidenet.hulkstore.documents.DocumentDto;
import com.cidenet.hulkstore.units.UnityDto;
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
    private UIInsertDocument window;
    
    public CInsertDocument()
    {
        window = new UIInsertDocument(this);
    }
    
    public void upload(JTextField txtDocumentId) {
        try {
            DocumentDao dao = DaoFactory.createDocumentDao();
            txtDocumentId.setText(dao.findNextDocumentId());
        } catch (DocumentDaoException ex) {}
    }

    public void accept(JTextField txtDocumentId, JTextField txtDescription) 
    {      
        try {
            DocumentDto dto = new DocumentDto(Integer.parseInt(txtDocumentId.getText()), txtDescription.getText());
            DocumentDao dao = DaoFactory.createDocumentDao();
            
            if(!dao.insert(dto).isDocumentIdNull()){
                JOptionPane.showMessageDialog(null, "Se ha agregado el registro nuevo", "INSERCION", JOptionPane.INFORMATION_MESSAGE);
                new CDocument();
                window.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se registro", "ERROR", JOptionPane.ERROR_MESSAGE);}
            
        } catch (DocumentDaoException ex) {}
    }

    public void cancel()
    {
        new CDocument();
        window.dispose();
    }    
}
