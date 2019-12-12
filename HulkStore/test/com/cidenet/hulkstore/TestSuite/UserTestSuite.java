package com.cidenet.hulkstore.TestSuite;

import com.cidenet.hulkstore.factory.DaoFactory;
import static com.cidenet.hulkstore.jdbc.ResourceManager.setConnection;
import com.cidenet.hulkstore.users.UserDeleteTest;
import com.cidenet.hulkstore.users.UserInsertTest;
import com.cidenet.hulkstore.users.UserLoginTest;
import com.cidenet.hulkstore.users.UserUpdateTest;
import com.cidenet.hulkstore.users.UsersDao;
import com.cidenet.hulkstore.users.UsersDaoException;
import com.cidenet.hulkstore.users.UsersPk;
import java.sql.SQLException;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses
({
    UserInsertTest.class,
    UserLoginTest.class,
    UserUpdateTest.class,
    UserDeleteTest.class
})
public class UserTestSuite
{
    private static UsersDao usersDao = DaoFactory.createUsersDao();
    
    @BeforeClass
    public static void connect()
    {
        try { setConnection(); }
        catch (SQLException exception) { fail(exception.getMessage()); }
    }
    
    @AfterClass
    public static void deleteDataTest()
    {
        try {            
            assertTrue(usersDao.delete(new UsersPk(999999)));
            assertTrue(usersDao.delete(new UsersPk(999998)));
            
        } catch (UsersDaoException exception) { fail(exception.getMessage()); }
    }  
}