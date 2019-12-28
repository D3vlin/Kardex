package com.cidenet.hulkstore.TestSuite;

import com.cidenet.hulkstore.model.dao.DaoFactory;
import static com.cidenet.hulkstore.model.dao.ResourceManager.setConnection;
import com.cidenet.hulkstore.users.UserDeleteTest;
import com.cidenet.hulkstore.users.UserInsertTest;
import com.cidenet.hulkstore.users.UserLoginTest;
import com.cidenet.hulkstore.users.UserUpdateTest;
import com.cidenet.hulkstore.model.dao.users.*;
import com.cidenet.hulkstore.model.dto.users.UsersPk;
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
    private static final UsersDao USERSDAO = DaoFactory.createUsersDao();
    
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
            assertTrue(USERSDAO.delete(new UsersPk(999999)));
            assertTrue(USERSDAO.delete(new UsersPk(999998)));
            
        } catch (UsersDaoException exception) { fail(exception.getMessage()); }
    }  
}