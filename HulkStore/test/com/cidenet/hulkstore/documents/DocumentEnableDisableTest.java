package com.cidenet.hulkstore.documents;

import com.cidenet.hulkstore.factory.DaoFactory;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DocumentEnableDisableTest
{    
    DocumentDao documentDao = DaoFactory.createDocumentDao();
    private int documentId;
    private String documentDescription;
    private short state;
    
    public DocumentEnableDisableTest(int documentId, String documentDescription, short state)
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
            {999999, "Enable Test 1", (short) 1},
            {999999, "Disable Test 1", (short) 0},
            {999998, "Enable Test 2", (short) 1},
            {999998, "Disable Test 2", (short) 0}
        });
    }
    
    @Test
    public void testEnableDisable()
    {
        try {
            DocumentDto documentDto = new DocumentDto(documentId, documentDescription, state);          
            
            assertTrue(documentDao.update(documentDto.createPk(), documentDto));
            
        } catch (DocumentDaoException exception) { fail(exception.getMessage()); }
    }  
}