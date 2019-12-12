package com.cidenet.hulkstore.users;

import com.cidenet.hulkstore.factory.DaoFactory;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class UserLoginTest 
{    
    private UsersDao usersDao = DaoFactory.createUsersDao();
    private String userName;
    private String userPass;
    
    public UserLoginTest(String userName, String userPass)
    {
        this.userName = userName;
        this.userPass = userPass;
    }
    
    @Parameterized.Parameters
    public static Collection data()
    {
        return  Arrays.asList(new Object[][]
        {
            {"AdminTest", "Test 1"},
            {"UserTest", "Test 2"}
        });
    }
    
    @Test
    public void testLogin()
    {
        try { assertNotNull(usersDao.validateUser(userName, userPass)); }
        catch (UsersDaoException exception) { fail(exception.getMessage()); }
    }
}