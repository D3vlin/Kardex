package com.cidenet.hulkstore.products;

import java.sql.Connection;

public class ProductDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return ProductDao
	 */
	public static ProductDao create()
	{
		return new ProductDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return ProductDao
	 */
	public static ProductDao create(Connection conn)
	{
		return new ProductDaoImpl( conn );
	}

}
