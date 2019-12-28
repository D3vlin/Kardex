package com.cidenet.hulkstore.TestSuite;

import com.cidenet.hulkstore.model.dao.document.DocumentDao;
import com.cidenet.hulkstore.model.dto.document.DocumentDto;
import com.cidenet.hulkstore.model.dto.document.DocumentPk;
import com.cidenet.hulkstore.model.dao.DaoException;
import com.cidenet.hulkstore.model.dao.DaoFactory;
import static com.cidenet.hulkstore.model.dao.ResourceManager.setConnection;
import com.cidenet.hulkstore.model.dao.kardex.KardexDao;
import com.cidenet.hulkstore.model.dao.kardex.KardexDetailDao;
import com.cidenet.hulkstore.kardex.KardexDetailInsertTest;
import com.cidenet.hulkstore.model.dto.kardex.KardexDetailPk;
import com.cidenet.hulkstore.kardex.KardexInsertTest;
import com.cidenet.hulkstore.model.dto.kardex.KardexPk;
import com.cidenet.hulkstore.model.dao.product.ProductDao;
import com.cidenet.hulkstore.model.dto.product.ProductDto;
import com.cidenet.hulkstore.model.dto.product.ProductPk;
import com.cidenet.hulkstore.model.dao.store.StoreDao;
import com.cidenet.hulkstore.model.dto.store.*;
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
    private static final UsersDao USERSDAO = DaoFactory.createUsersDao();
    private static final StoreDao STOREDAO = DaoFactory.createStoreDao();
    private static final DocumentDao DOCUMENTDAO = DaoFactory.createDocumentDao();
    private static final UnityDao UNITYDAO = DaoFactory.createUnityDao();
    private static final ProductDao PRODUCTDAO = DaoFactory.createProductDao();
    private static final KardexDao KARDEXDAO = DaoFactory.createKardexDao();
    private static final KardexDetailDao KARDEXDETAILDAO = DaoFactory.createKardexDetailDao();
    
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
            
            USERSDAO.insert(usersDto);
            STOREDAO.insert(storeDto); 
            DOCUMENTDAO.insert(documentDto);
            UNITYDAO.insert(unityDto); 
            PRODUCTDAO.insert(productDto); 
            
        } catch (DaoException exception) { fail(exception.getMessage()); }
    }
    
    @AfterClass
    public static void deleteDataTest()
    {
        try {         
            assertTrue(KARDEXDETAILDAO.delete(new KardexDetailPk(999999, 999999, 999999)));
            assertTrue(KARDEXDETAILDAO.delete(new KardexDetailPk(999998, 999999, 999999)));
            assertTrue(KARDEXDETAILDAO.delete(new KardexDetailPk(999997, 999999, 999999)));
            assertTrue(KARDEXDAO.delete(new KardexPk(999999, 999999)));
            
            assertTrue(USERSDAO.delete(new UsersPk(999999)));
            assertTrue(PRODUCTDAO.delete(new ProductPk(999999)));
            assertTrue(UNITYDAO.delete(new UnityPk(999999)));
            assertTrue(STOREDAO.delete(new StorePk(999999)));
            assertTrue(DOCUMENTDAO.delete(new DocumentPk(999999)));
            
        } catch (DaoException exception) { fail(exception.getMessage()); }
    }
}