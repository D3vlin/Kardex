package com.cidenet.hulkstore.documents;

import com.cidenet.hulkstore.factory.DaoFactory;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DocumentInsertTest 
{    
    DocumentDao documentDao = DaoFactory.createDocumentDao();
    private int documentId;
    private String documentDescription;
    private short state;
    private int expected;

    public DocumentInsertTest(int documentId, String documentDescription, short state)
    {
        this.documentId = documentId;
        this.documentDescription = documentDescription;
        this.state = state;
        this.expected = this.documentId;
    }
    
    @Parameterized.Parameters
    public static Collection data()
    {
        return  Arrays.asList(new Object[][]
        {
            {999999, "Insert Test 1", (short) 1},
            {999998, "Insert Test 2", (short) 0}
        });
    }
        
    @Test
    public void testInsert()
    {
        try {
            DocumentDto documentDto = new DocumentDto(documentId, documentDescription, state);          
            
            assertEquals(expected, documentDao.insert(documentDto).documentId);      
            
        } catch (DocumentDaoException exception) { fail(exception.getMessage()); }
    }
}