package com.cidenet.hulkstore.users;

import com.cidenet.hulkstore.factory.DaoFactory;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class UserUpdateTest
{
    private UsersDao usersDao = DaoFactory.createUsersDao();
    private int userId;
    private String userName;
    private String userPass;
    private String identification;
    private String realName;
    private String surname;
    private short userProfile;
    private short state;

    public UserUpdateTest(int userId, String userName, String userPass, String identification, String realName, String surname, short userProfile, short state)
    {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.identification = identification;
        this.realName = realName;
        this.surname = surname;
        this.userProfile = userProfile;
        this.state = state;
    }
    
    @Parameterized.Parameters
    public static Collection data()
    {
        return  Arrays.asList(new Object[][]
        {
            {999999, "AdminTest", "Test 1", "87654321", "Test", "Update", (short) 1, (short) 1},
            {999998, "UserTest", "Test 2", "12345678", "Test", "Update", (short) 0, (short) 1}
        });
    }
    
    @Test
    public void testUpdate()
    {
        try {
            UsersDto usersDto = new UsersDto(userId, userName, userPass, identification, realName, surname, userProfile, state);          
            
            assertTrue(usersDao.update(usersDto.createPk(), usersDto));
            
        } catch (UsersDaoException exception) { fail(exception.getMessage()); }
    } 
}