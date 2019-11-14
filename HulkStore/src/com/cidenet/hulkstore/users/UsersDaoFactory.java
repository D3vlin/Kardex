package com.cidenet.hulkstore.users;

import java.sql.Connection;

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
