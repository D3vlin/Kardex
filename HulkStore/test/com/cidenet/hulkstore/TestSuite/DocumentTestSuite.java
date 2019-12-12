package com.cidenet.hulkstore.TestSuite;

import com.cidenet.hulkstore.documents.DocumentDao;
import com.cidenet.hulkstore.documents.DocumentDaoException;
import com.cidenet.hulkstore.documents.DocumentDeleteTest;
import com.cidenet.hulkstore.documents.DocumentEnableDisableTest;
import com.cidenet.hulkstore.documents.DocumentInsertTest;
import com.cidenet.hulkstore.documents.DocumentPk;
import com.cidenet.hulkstore.documents.DocumentUpdateTest;
import com.cidenet.hulkstore.factory.DaoFactory;
import static com.cidenet.hulkstore.jdbc.ResourceManager.setConnection;
import java.sql.SQLException;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses
({
    DocumentInsertTest.class,
    DocumentUpdateTest.class,
    DocumentDeleteTest.class,
    DocumentEnableDisableTest.class
})
public class DocumentTestSuite {
    
    private static DocumentDao documentDao = DaoFactory.createDocumentDao();
            
    @BeforeClass
    public static void connect()
    {
        try { setConnection(); }
        catch (SQLException exception) { fail(exception.getMessage()); }
    }
            
    @AfterClass
    public static void deleteDataTest()
    {
        try {
            assertTrue(documentDao.delete(new DocumentPk(999999)));
            assertTrue(documentDao.delete(new DocumentPk(999998)));
        
        } catch (DocumentDaoException exception) { fail(exception.getMessage()); }
    }   
}