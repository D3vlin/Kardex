package com.cidenet.hulkstore.kardex;

import com.cidenet.hulkstore.model.dao.kardex.KardexDetailDaoException;
import com.cidenet.hulkstore.model.dao.kardex.KardexDetailDao;
import com.cidenet.hulkstore.model.dto.kardex.KardexDetailPk;
import com.cidenet.hulkstore.model.dto.kardex.KardexDetailDto;
import com.cidenet.hulkstore.model.dao.DaoFactory;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class KardexDetailInsertTest 
{
    private static KardexDetailDao kardexDetailDao = DaoFactory.createKardexDetailDao();
    private int detailId;
    private int productId;
    private int storeId;
    private int kardexDetailYear;
    private int kardexDetailMonth;
    private int kardexDetailday;
    private int userId;
    private int documentId;
    private int documentNumber;
    private short operation;
    private double quantity;
    private double unityValue;
    private double totalValue;
    private String observations;
    private short state;
    private KardexDetailPk expected;

    public KardexDetailInsertTest(int detailId, int productId, int storeId, int kardexDetailYear, int kardexDetailMonth, int kardexDetailday, int userId, int documentId, int documentNumber, short operation, double quantity, double unityValue, double totalValue, short state, String observations) 
    {
        this.detailId = detailId;
        this.productId = productId;
        this.storeId = storeId;
        this.kardexDetailYear = kardexDetailYear;
        this.kardexDetailMonth = kardexDetailMonth;
        this.kardexDetailday = kardexDetailday;
        this.userId = userId;
        this.documentId = documentId;
        this.documentNumber = documentNumber;
        this.operation = operation;
        this.quantity = quantity;
        this.unityValue = unityValue;
        this.totalValue = totalValue;
        this.observations = observations;
        this.state = state;
        this.expected = new KardexDetailPk(this.detailId, this.productId, this.storeId);
    }
    
    @Parameterized.Parameters
    public static Collection data()
    {
        return  Arrays.asList(new Object[][]
        {
            {999997, 999999, 999999, 2000, 1, 1, 999999, 999999, 12345678, (short) 1, 10.0, 1.0, 10.0, (short) 1, "Entry Test"},
            {999998, 999999, 999999, 2000, 1, 1, 999999, 999999, 87654321, (short) 1, 10.0, 2.0, 20.0, (short) 1, "Entry Test"},
            {999999, 999999, 999999, 2000, 1, 1, 999999, 999999, 12365478, (short) 0, 5.0, 1.0, 5.0, (short) 1, "Exit Test"}
        });
    }
        
    @Test
    public void testInsert()
    {
        try {
            KardexDetailDto kardexDetailDto = new KardexDetailDto(detailId, productId, storeId, kardexDetailYear, kardexDetailMonth, kardexDetailday, userId, documentId, documentNumber, operation, quantity, unityValue, totalValue, observations, state);
            
            assertEquals(expected, kardexDetailDao.insert(kardexDetailDto));      
            
        } catch (KardexDetailDaoException exception) { fail(exception.getMessage()); }
    } 
}