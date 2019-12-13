package com.cidenet.hulkstore.TestSuite;

import com.cidenet.hulkstore.documents.DocumentDao;
import com.cidenet.hulkstore.documents.DocumentDto;
import com.cidenet.hulkstore.documents.DocumentPk;
import com.cidenet.hulkstore.exceptions.DaoException;
import com.cidenet.hulkstore.factory.DaoFactory;
import static com.cidenet.hulkstore.jdbc.ResourceManager.setConnection;
import com.cidenet.hulkstore.kardex.KardexDao;
import com.cidenet.hulkstore.kardex.KardexDetailDao;
import com.cidenet.hulkstore.kardex.KardexDetailInsertTest;
import com.cidenet.hulkstore.kardex.KardexDetailPk;
import com.cidenet.hulkstore.kardex.KardexInsertTest;
import com.cidenet.hulkstore.kardex.KardexPk;
import com.cidenet.hulkstore.products.ProductDao;
import com.cidenet.hulkstore.products.ProductDto;
import com.cidenet.hulkstore.products.ProductPk;
import com.cidenet.hulkstore.stores.StoreDao;
import com.cidenet.hulkstore.stores.StoreDto;
import com.cidenet.hulkstore.stores.StorePk;
import com.cidenet.hulkstore.units.UnityDao;
import com.cidenet.hulkstore.units.UnityDto;
import com.cidenet.hulkstore.units.UnityPk;
import com.cidenet.hulkstore.users.UsersDao;
import com.cidenet.hulkstore.users.UsersDto;
import com.cidenet.hulkstore.users.UsersPk;
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
    KardexInsertTest.class,
    KardexDetailInsertTest.class
})
public class KardexTestSuite 
{   
    private static UsersDao usersDao = DaoFactory.createUsersDao();
    private static StoreDao storeDao = DaoFactory.createStoreDao();
    private static DocumentDao documentDao = DaoFactory.createDocumentDao();
    private static UnityDao unityDao = DaoFactory.createUnityDao();
    private static ProductDao productDao = DaoFactory.createProductDao();
    private static KardexDao kardexDao = DaoFactory.createKardexDao();
    private static KardexDetailDao kardexDetailDao = DaoFactory.createKardexDetailDao();
    
    @BeforeClass
    public static void connect()
    {
        try { setConnection(); }
        catch (SQLException exception) { fail(exception.getMessage()); }
        
        try {
            UsersDto usersDto = new UsersDto(999999, "User Test", "Test", "12345678", "Test", "Test", (short) 1, (short) 1);
            StoreDto storeDto = new StoreDto(999999, "Store Test", "Test", (short) 1);
            DocumentDto documentDto = new DocumentDto(999999, "Document Test", (short) 1);       
            UnityDto unityDto = new UnityDto(999999, "Unity Test 1", (short) 1);
            ProductDto productDto = new ProductDto(999999, "Product Test", 999999, (short) 1);             
            
            usersDao.insert(usersDto);
            storeDao.insert(storeDto); 
            documentDao.insert(documentDto);
            unityDao.insert(unityDto); 
            productDao.insert(productDto); 
            
        } catch (DaoException exception) { fail(exception.getMessage()); }
    }
    
    @AfterClass
    public static void deleteDataTest()
    {
        try {         
            assertTrue(kardexDetailDao.delete(new KardexDetailPk(999999, 999999, 999999)));
            assertTrue(kardexDetailDao.delete(new KardexDetailPk(999998, 999999, 999999)));
            assertTrue(kardexDetailDao.delete(new KardexDetailPk(999997, 999999, 999999)));
            assertTrue(kardexDao.delete(new KardexPk(999999, 999999)));
            
            assertTrue(usersDao.delete(new UsersPk(999999)));
            assertTrue(productDao.delete(new ProductPk(999999)));
            assertTrue(unityDao.delete(new UnityPk(999999)));
            assertTrue(storeDao.delete(new StorePk(999999)));
            assertTrue(documentDao.delete(new DocumentPk(999999)));
            
        } catch (DaoException exception) { fail(exception.getMessage()); }
    }
}