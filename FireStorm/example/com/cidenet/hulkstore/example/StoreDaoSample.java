/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.cidenet.hulkstore.example;

import java.math.*;
import java.util.Date;
import java.util.Collection;
import com.cidenet.hulkstore.dao.StoreDao;
import com.cidenet.hulkstore.dto.Store;
import com.cidenet.hulkstore.exceptions.StoreDaoException;
import com.cidenet.hulkstore.factory.StoreDaoFactory;

public class StoreDaoSample
{
	/**
	 * Method 'main'
	 * 
	 * @param arg
	 * @throws Exception
	 */
	public static void main(String[] arg) throws Exception
	{
		// Uncomment one of the lines below to test the generated code
		
		// findAll();
		// findWhereStoreIdEquals(0);
		// findWhereStoreNameEquals("");
		// findWhereAddressEquals("");
		// findWhereStateEquals(0);
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			StoreDao _dao = getStoreDao();
			Store _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereStoreIdEquals'
	 * 
	 * @param storeId
	 */
	public static void findWhereStoreIdEquals(int storeId)
	{
		try {
			StoreDao _dao = getStoreDao();
			Store _result[] = _dao.findWhereStoreIdEquals(storeId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereStoreNameEquals'
	 * 
	 * @param storeName
	 */
	public static void findWhereStoreNameEquals(String storeName)
	{
		try {
			StoreDao _dao = getStoreDao();
			Store _result[] = _dao.findWhereStoreNameEquals(storeName);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereAddressEquals'
	 * 
	 * @param address
	 */
	public static void findWhereAddressEquals(String address)
	{
		try {
			StoreDao _dao = getStoreDao();
			Store _result[] = _dao.findWhereAddressEquals(address);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereStateEquals'
	 * 
	 * @param state
	 */
	public static void findWhereStateEquals(short state)
	{
		try {
			StoreDao _dao = getStoreDao();
			Store _result[] = _dao.findWhereStateEquals(state);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getStoreDao'
	 * 
	 * @return StoreDao
	 */
	public static StoreDao getStoreDao()
	{
		return StoreDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(Store dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getStoreId() );
		buf.append( ", " );
		buf.append( dto.getStoreName() );
		buf.append( ", " );
		buf.append( dto.getAddress() );
		buf.append( ", " );
		buf.append( dto.getState() );
		System.out.println( buf.toString() );
	}

}
