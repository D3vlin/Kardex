package com.cidenet.hulkstore.units;

import com.cidenet.hulkstore.factory.DaoFactory;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class UnityDeleteTest {
    
    UnityDao unityDao = DaoFactory.createUnityDao();
    private int unityId;
    private String unityDescription;
    private short state;
    
    public UnityDeleteTest(int unityId, String unityDescription, short state)
    {
        this.unityId = unityId;
        this.unityDescription = unityDescription;
        this.state = state;
    }
    
    @Parameterized.Parameters
    public static Collection data()
    {
        return  Arrays.asList(new Object[][]
        {
            {999999, "Delete Test 1", (short) 3},
            {999998, "Delete Test 2", (short) 3}
        });
    }
    
    @Test
    public void testDelete()
    {
        try {
            UnityDto unityDto = new UnityDto(unityId, unityDescription, state);          
            
            assertTrue(unityDao.update(unityDto.createPk(), unityDto));
            
        } catch (UnityDaoException exception) { fail(exception.getMessage()); }
    }  
}