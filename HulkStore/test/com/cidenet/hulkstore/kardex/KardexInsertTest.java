package com.cidenet.hulkstore.kardex;

import com.cidenet.hulkstore.factory.DaoFactory;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class KardexInsertTest
{
    KardexDao kardexDao = DaoFactory.createKardexDao();
    private int productId;
    private int storeId;
    private double quantity;
    private double unityValue;
    private double totalValue;
    private short state;
    private KardexPk expected;

    public KardexInsertTest(int productId, int storeId, double quantity, double unityValue, double totalValue, short state) {
        this.productId = productId;
        this.storeId = storeId;
        this.quantity = quantity;
        this.unityValue = unityValue;
        this.totalValue = totalValue;
        this.state = state;
        this.expected = new KardexPk(productId, storeId);
    }
    
    @Parameterized.Parameters
    public static Collection data()
    {
        return  Arrays.asList(new Object[][]
        {
            {999999, 999999, 0.0, 0.0, 0.0, (short) 1}
        });
    }
    
    @Test
    public void testInsert()
    {
        try {
            KardexDto kardexDto = new KardexDto(productId, storeId, quantity, unityValue, totalValue, state);          
            
            assertEquals(expected, kardexDao.insert(kardexDto));      
            
        } catch (KardexDaoException exception) { fail(exception.getMessage()); }
    } 
}