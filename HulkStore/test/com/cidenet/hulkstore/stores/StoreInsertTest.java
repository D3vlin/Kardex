package com.cidenet.hulkstore.stores;

import com.cidenet.hulkstore.model.dao.DaoFactory;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class StoreInsertTest
{        
    private static final StoreDao STOREDAO = DaoFactory.createStoreDao();
    private int storeId;
    private String storeName;
    private String address;
    private short state;
    private int expected;

    public StoreInsertTest(int storeId, String storeName, String address, short state)
    {        
        this.storeId = storeId;
        this.storeName = storeName;
        this.address = address;
        this.state = state;
        this.expected = this.storeId;
    }    
    
    @Parameterized.Parameters
    public static Collection data()
    {
        return  Arrays.asList(new Object[][]
        {
            {999999, "Insert Test 1", "Test", (short) 1},
            {999998, "Insert Test 2", "Test", (short) 0}
        });
    }
        
    @Test
    public void testInsert()
    {
        try {
            StoreDto storeDto = new StoreDto(storeId, storeName, address, state);          
            
            assertEquals(expected, STOREDAO.insert(storeDto).storeId);      
            
        } catch (StoreDaoException exception) { fail(exception.getMessage()); }
    }    
}