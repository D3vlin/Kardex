package com.cidenet.hulkstore.factory.users;

import com.cidenet.hulkstore.jdbc.users.UsersDaoImpl;
import com.cidenet.hulkstore.dao.users.UsersDao;
import java.sql.Connection;
import com.cidenet.hulkstore.jdbc.*;

public class UsersDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return UsersDao
	 */
	public static UsersDao create()
	{
		return new UsersDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return UsersDao
	 */
	public static UsersDao create(Connection conn)
	{
		return new UsersDaoImpl( conn );
	}

}
