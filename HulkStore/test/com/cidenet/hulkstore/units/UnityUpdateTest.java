package com.cidenet.hulkstore.units;

import com.cidenet.hulkstore.model.dto.unity.UnityDto;
import com.cidenet.hulkstore.model.dao.unity.*;
import com.cidenet.hulkstore.model.dao.DaoFactory;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class UnityUpdateTest
{    
    private static final UnityDao UNITYDAO = DaoFactory.createUnityDao();
    private int unityId;
    private String unityDescription;
    private short state;
    
    public UnityUpdateTest(int unityId, String unityDescription, short state)
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
            {999999, "Update Test 1", (short) 1},
            {999998, "Update Test 2", (short) 0}
        });
    }
    
    @Test
    public void testUpdate()
    {
        try {
            UnityDto unityDto = new UnityDto(unityId, unityDescription, state);          
            
            assertTrue(UNITYDAO.update(unityDto.createPk(), unityDto));
            
        } catch (UnityDaoException exception) { fail(exception.getMessage()); }
    } 
}