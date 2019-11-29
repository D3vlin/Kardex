package com.cidenet.hulkstore.factory;

import com.cidenet.hulkstore.documents.DocumentDao;
import com.cidenet.hulkstore.kardex.KardexDao;
import com.cidenet.hulkstore.kardex.KardexDetailDao;
import com.cidenet.hulkstore.products.ProductDao;
import com.cidenet.hulkstore.stores.StoreDao;
import com.cidenet.hulkstore.units.UnityDao;
import com.cidenet.hulkstore.users.UsersDao;
import java.sql.Connection;

public final class DaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return ProductDao
	 */
	public static ProductDao createProductDao()
	{
		return new ProductDao();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return ProductDao
	 */
	public static ProductDao createProductDao(Connection conn)
	{
		return new ProductDao( conn );
	}
        
	/**
	 * Method 'create'
	 * 
	 * @return StoreDao
	 */
	public static StoreDao createStoreDao()
	{
		return new StoreDao();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return StoreDao
	 */
	public static StoreDao createStoreDao(Connection conn)
	{
		return new StoreDao( conn );
	}
        
	/**
	 * Method 'create'
	 * 
	 * @return UnityDao
	 */
	public static UnityDao createUnityDao()
	{
		return new UnityDao();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return UnityDao
	 */
	public static UnityDao createUnityDao(Connection conn)
	{
		return new UnityDao( conn );
	}
        
	/**
	 * Method 'create'
	 * 
	 * @return UsersDao
	 */
	public static UsersDao createUsersDao()
	{
		return new UsersDao();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return UsersDao
	 */
	public static UsersDao createUsersDao(Connection conn)
	{
		return new UsersDao( conn );
	}
        
        /**
	 * Method 'create'
	 * 
	 * @return DocumentDao
	 */
	public static DocumentDao createDocumentDao()
	{
		return new DocumentDao();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return DocumentDao
	 */
	public static DocumentDao createDocumentDao(Connection conn)
	{
		return new DocumentDao( conn );
	}
        
	/**
	 * Method 'create'
	 * 
	 * @return KardexDao
	 */
	public static KardexDao createKardexDao()
	{
		return new KardexDao();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return KardexDao
	 */
	public static KardexDao createKardexDao(Connection conn)
	{
		return new KardexDao( conn );
	}
        
	/**
	 * Method 'create'
	 * 
	 * @return KardexDetailDao
	 */
	public static KardexDetailDao createKardexDetailDao()
	{
		return new KardexDetailDao();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return KardexDetailDao
	 */
	public static KardexDetailDao createKardexDetailDao(Connection conn)
	{
		return new KardexDetailDao( conn );
	}

}
