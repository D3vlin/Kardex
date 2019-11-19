package com.cidenet.hulkstore.factory;

import com.cidenet.hulkstore.products.ProductDao;
import com.cidenet.hulkstore.products.ProductDaoImpl;
import com.cidenet.hulkstore.stores.StoreDao;
import com.cidenet.hulkstore.stores.StoreDaoImpl;
import com.cidenet.hulkstore.units.UnityDao;
import com.cidenet.hulkstore.units.UnityDaoImpl;
import com.cidenet.hulkstore.users.UsersDao;
import com.cidenet.hulkstore.users.UsersDaoImpl;
import java.sql.Connection;

public class DaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return ProductDao
	 */
	public static ProductDao createProductDao()
	{
		return new ProductDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return ProductDao
	 */
	public static ProductDao createProductDao(Connection conn)
	{
		return new ProductDaoImpl( conn );
	}
        
	/**
	 * Method 'create'
	 * 
	 * @return StoreDao
	 */
	public static StoreDao createStoreDao()
	{
		return new StoreDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return StoreDao
	 */
	public static StoreDao createStoreDao(Connection conn)
	{
		return new StoreDaoImpl( conn );
	}
        
	/**
	 * Method 'create'
	 * 
	 * @return UnityDao
	 */
	public static UnityDao createUnityDao()
	{
		return new UnityDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return UnityDao
	 */
	public static UnityDao createUnityDao(Connection conn)
	{
		return new UnityDaoImpl( conn );
	}
        
	/**
	 * Method 'create'
	 * 
	 * @return UsersDao
	 */
	public static UsersDao createUsersDao()
	{
		return new UsersDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return UsersDao
	 */
	public static UsersDao createUsersDao(Connection conn)
	{
		return new UsersDaoImpl( conn );
	}

}
