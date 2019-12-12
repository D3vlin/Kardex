package com.cidenet.hulkstore.products;

import com.cidenet.hulkstore.factory.DaoFactory;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ProductDeleteTest
{    
    ProductDao productDao = DaoFactory.createProductDao();
    private int productId;
    private String productName;
    private int unityId;
    private short state;
    
    public ProductDeleteTest(int productId, String productName, int unityId, short state)
    {        
        this.productId = productId;
        this.productName = productName;
        this.unityId = unityId;
        this.state = state;
    } 
    
    @Parameterized.Parameters
    public static Collection data()
    {
        return  Arrays.asList(new Object[][]
        {
            {999999, "Delete Test 1", 999998, (short) 3},
            {999998, "Delete Test 2", 999999, (short) 3}
        });
    }
    
    @Test
    public void testDelete()
    {
        try {
            ProductDto productDto = new ProductDto(productId, productName, unityId, state);          
            
            assertTrue(productDao.update(productDto.createPk(), productDto));
            
        } catch (ProductDaoException exception) { fail(exception.getMessage()); }
    } 
}