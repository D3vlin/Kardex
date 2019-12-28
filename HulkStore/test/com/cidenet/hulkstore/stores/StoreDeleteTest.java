package com.cidenet.hulkstore.stores;

import com.cidenet.hulkstore.model.dao.store.*;
import com.cidenet.hulkstore.model.dto.store.StoreDto;
import com.cidenet.hulkstore.model.dao.DaoFactory;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class StoreDeleteTest
{    
    private static final StoreDao STOREDAO = DaoFactory.createStoreDao();
    private int storeId;
    private String storeName;
    private String address;
    private short state;

    public StoreDeleteTest(int storeId, String storeName, String address, short state)
    {        
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
            {999999, "Delete Test 1", "Test", (short) 3},
            {999998, "Delete Test 2", "Test", (short) 3}
        });
    }  
        
    @Test
    public void testDelete()
    {
        try {
            StoreDto storeDto = new StoreDto(storeId, storeName, address, state);          
            
            assertTrue(STOREDAO.update(storeDto.createPk(), storeDto));
            
        } catch (StoreDaoException exception) { fail(exception.getMessage()); }
    }    
}