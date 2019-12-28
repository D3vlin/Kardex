package com.cidenet.hulkstore.TestSuite;

import com.cidenet.hulkstore.model.dao.document.DocumentDao;
import com.cidenet.hulkstore.model.dao.document.DocumentDaoException;
import com.cidenet.hulkstore.documents.DocumentDeleteTest;
import com.cidenet.hulkstore.documents.DocumentEnableDisableTest;
import com.cidenet.hulkstore.documents.DocumentInsertTest;
import com.cidenet.hulkstore.model.dto.document.DocumentPk;
import com.cidenet.hulkstore.documents.DocumentUpdateTest;
import com.cidenet.hulkstore.model.dao.DaoFactory;
import static com.cidenet.hulkstore.model.dao.ResourceManager.setConnection;
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
    
    private static final DocumentDao DOCUMENTDAO = DaoFactory.createDocumentDao();
            
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
            assertTrue(DOCUMENTDAO.delete(new DocumentPk(999999)));
            assertTrue(DOCUMENTDAO.delete(new DocumentPk(999998)));
        
        } catch (DocumentDaoException exception) { fail(exception.getMessage()); }
    }   
}