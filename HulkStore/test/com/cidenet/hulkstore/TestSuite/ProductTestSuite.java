package com.cidenet.hulkstore.TestSuite;

import com.cidenet.hulkstore.exceptions.DaoException;
import com.cidenet.hulkstore.factory.DaoFactory;
import static com.cidenet.hulkstore.jdbc.ResourceManager.setConnection;
import com.cidenet.hulkstore.products.ProductDao;
import com.cidenet.hulkstore.products.ProductDeleteTest;
import com.cidenet.hulkstore.products.ProductEnableDisableTest;
import com.cidenet.hulkstore.products.ProductInsertTest;
import com.cidenet.hulkstore.products.ProductPk;
import com.cidenet.hulkstore.products.ProductUpdateTest;
import com.cidenet.hulkstore.units.UnityDao;
import com.cidenet.hulkstore.units.UnityDaoException;
import com.cidenet.hulkstore.units.UnityDto;
import com.cidenet.hulkstore.units.UnityPk;
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
    ProductInsertTest.class,
    ProductUpdateTest.class,
    ProductDeleteTest.class,
    ProductEnableDisableTest.class
})
public class ProductTestSuite {
    
    private static ProductDao productDao = DaoFactory.createProductDao();
    private static UnityDao unityDao = DaoFactory.createUnityDao();
    
    @BeforeClass
    public static void connect()
    {
        try { setConnection(); }
        catch (SQLException exception) { fail(exception.getMessage()); }
        
        try {
            UnityDto unityDto0 = new UnityDto(999999, "Unity Test 1", (short) 1);          
            UnityDto unityDto1 = new UnityDto(999998, "Unity Test 2", (short) 1);          
            
            unityDao.insert(unityDto0); 
            unityDao.insert(unityDto1); 
            
        } catch (UnityDaoException exception) { fail(exception.getMessage()); }
    }
    
    @AfterClass
    public static void deleteDataTest()
    {
        try {            
            assertTrue(productDao.delete(new ProductPk(999999)));
            assertTrue(productDao.delete(new ProductPk(999998)));
            
            assertTrue(unityDao.delete(new UnityPk(999999)));
            assertTrue(unityDao.delete(new UnityPk(999998)));
            
        } catch (DaoException exception) { fail(exception.getMessage()); }
    }
}