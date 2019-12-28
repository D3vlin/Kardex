package com.cidenet.hulkstore.products;

import com.cidenet.hulkstore.model.dao.DaoFactory;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ProductInsertTest
{    
    private static final ProductDao PRODUCTDAO = DaoFactory.createProductDao();
    private int productId;
    private String productName;
    private int unityId;
    private short state;
    private int expected;
    
    public ProductInsertTest(int productId, String productName, int unityId, short state)
    {        
        this.productId = productId;
        this.productName = productName;
        this.unityId = unityId;
        this.state = state;
        this.expected = this.productId;
    }  
    
    @Parameterized.Parameters
    public static Collection data()
    {
        return  Arrays.asList(new Object[][]
        {
            {999999, "Insert Test 1", 999999, (short) 1},
            {999998, "Insert Test 2", 999998, (short) 0}
        });
    }
    
    @Test
    public void testInsert()
    {
        try {
            ProductDto storeDto = new ProductDto(productId, productName, unityId, state);          
            
            assertEquals(expected, PRODUCTDAO.insert(storeDto).productId);      
            
        } catch (ProductDaoException exception) { fail(exception.getMessage()); }
    } 
}