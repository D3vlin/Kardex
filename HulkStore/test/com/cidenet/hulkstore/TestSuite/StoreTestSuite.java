package com.cidenet.hulkstore.TestSuite;

import static com.cidenet.hulkstore.jdbc.ResourceManager.setConnection;
import com.cidenet.hulkstore.stores.StoreDao;
import com.cidenet.hulkstore.stores.StoreDaoException;
import com.cidenet.hulkstore.stores.StoreDeleteTest;
import com.cidenet.hulkstore.stores.StoreEnableDisableTest;
import com.cidenet.hulkstore.stores.StoreInsertTest;
import com.cidenet.hulkstore.stores.StorePk;
import com.cidenet.hulkstore.stores.StoreUpdateTest;
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
    StoreInsertTest.class,
    StoreUpdateTest.class,
    StoreDeleteTest.class,
    StoreEnableDisableTest.class
})
public class StoreTestSuite {
            
    @BeforeClass
    public static void connect()
    {
        try {
            setConnection();
            
            StoreDao storeDao = new StoreDao();
            
        } catch (SQLException exception) {
            fail(exception.getMessage());
        }
    }
            
    @AfterClass
    public static void deleteDataTest()
    {
        try {            
            StoreDao storeDao = new StoreDao();
            assertTrue(storeDao.delete(new StorePk(999999)));
            assertTrue(storeDao.delete(new StorePk(999998)));
            
        } catch (StoreDaoException exception) {
            fail(exception.getMessage());
        }
    }
}