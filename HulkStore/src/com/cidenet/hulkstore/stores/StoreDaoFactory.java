package com.cidenet.hulkstore.stores;

import java.sql.Connection;

public class StoreDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return StoreDao
	 */
	public static StoreDao create()
	{
		return new StoreDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return StoreDao
	 */
	public static StoreDao create(Connection conn)
	{
		return new StoreDaoImpl( conn );
	}

}
