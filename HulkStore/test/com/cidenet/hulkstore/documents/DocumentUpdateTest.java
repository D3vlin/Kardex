package com.cidenet.hulkstore.documents;

import com.cidenet.hulkstore.model.dto.document.DocumentDto;
import com.cidenet.hulkstore.model.dao.document.DocumentDaoException;
import com.cidenet.hulkstore.model.dao.document.DocumentDao;
import com.cidenet.hulkstore.model.dao.DaoFactory;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DocumentUpdateTest
{    
    private static final DocumentDao DOCUMENTDAO = DaoFactory.createDocumentDao();
    private int documentId;
    private String documentDescription;
    private short state;
    
    public DocumentUpdateTest(int documentId, String documentDescription, short state)
    {
        this.documentId = documentId;
        this.documentDescription = documentDescription;
        this.state = state;
    }
    
    @Parameterized.Parameters
    public static Collection data()
    {
        return  Arrays.asList(new Object[][]
        {
            {999999, "Update Test 1", (short) 1},
            {999998, "Update Test 2", (short) 0}
        });
    }
    
    @Test
    public void testUpdate()
    {
        try {
            DocumentDto documentDto = new DocumentDto(documentId, documentDescription, state);          
            
            assertTrue(DOCUMENTDAO.update(documentDto.createPk(), documentDto));
            
        } catch (DocumentDaoException exception) { fail(exception.getMessage()); }
    } 
}