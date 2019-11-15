package com.cidenet.hulkstore.units;

import java.sql.Connection;

public class UnityDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return UnityDao
	 */
	public static UnityDao create()
	{
		return new UnityDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return UnityDao
	 */
	public static UnityDao create(Connection conn)
	{
		return new UnityDaoImpl( conn );
	}

}
