package com.cidenet.hulkstore.stores;

import com.cidenet.hulkstore.factory.DaoFactory;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class StoreUpdateTest {
    
    StoreDao storeDao = DaoFactory.createStoreDao();
    private int storeId;
    private String storeName;
    private String address;
    private short state;

    public StoreUpdateTest(int storeId, String storeName, String address, short state) {
        
        this.storeId = storeId;
        this.storeName = storeName;
        this.address = address;
        this.state = state;
    }
    
    @Parameterized.Parameters
    public static Collection data()
    {
        return  Arrays.asList(new Object[][]
        {
            {999999, "Modified Test 1", "Test", (short) 1},
            {999998, "Modified Test 2", "Test", (short) 0}
        });
    }  
        
    @Test
    public void testUpdate()
    {
        try {
            StoreDto storeDto = new StoreDto(storeId, storeName, address, state);          
            
            assertTrue(storeDao.update(storeDto.createPk(), storeDto));
            
        } catch (StoreDaoException exception) { fail(exception.getMessage()); }
    }    
}
