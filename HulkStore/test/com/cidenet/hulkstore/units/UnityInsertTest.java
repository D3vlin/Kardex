package com.cidenet.hulkstore.units;

import com.cidenet.hulkstore.model.dao.DaoFactory;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class UnityInsertTest
{    
    private static final UnityDao UNITYDAO = DaoFactory.createUnityDao();
    private int unityId;
    private String unityDescription;
    private short state;
    private int expected;
    
    public UnityInsertTest(int unityId, String unityDescription, short state)
    {
        this.unityId = unityId;
        this.unityDescription = unityDescription;
        this.state = state;
        this.expected = this.unityId;
    }
    
    @Parameterized.Parameters
    public static Collection data()
    {
        return  Arrays.asList(new Object[][]
        {
            {999999, "Insert Test 1", (short) 1},
            {999998, "Insert Test 2", (short) 0}
        });
    }
    
    @Test
    public void testInsert()
    {
        try {
            UnityDto unityDto = new UnityDto(unityId, unityDescription, state);          
            
            assertEquals(expected, UNITYDAO.insert(unityDto).unityId);      
            
        } catch (UnityDaoException exception) { fail(exception.getMessage()); }
    }
}