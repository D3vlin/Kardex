package com.cidenet.hulkstore.TestSuite;

import com.cidenet.hulkstore.model.dao.DaoFactory;
import static com.cidenet.hulkstore.model.dao.ResourceManager.setConnection;
import com.cidenet.hulkstore.units.UnityDao;
import com.cidenet.hulkstore.units.UnityDaoException;
import com.cidenet.hulkstore.units.UnityDeleteTest;
import com.cidenet.hulkstore.units.UnityEnableDisableTest;
import com.cidenet.hulkstore.units.UnityInsertTest;
import com.cidenet.hulkstore.units.UnityPk;
import com.cidenet.hulkstore.units.UnityUpdateTest;
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
    UnityInsertTest.class,
    UnityUpdateTest.class,
    UnityDeleteTest.class,
    UnityEnableDisableTest.class
})
public class UnityTestSuite
{
    private static final UnityDao UNITYDAO = DaoFactory.createUnityDao();
    
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
            assertTrue(UNITYDAO.delete(new UnityPk(999999)));
            assertTrue(UNITYDAO.delete(new UnityPk(999998)));
            
        } catch (UnityDaoException exception) { fail(exception.getMessage()); }
    }    
}