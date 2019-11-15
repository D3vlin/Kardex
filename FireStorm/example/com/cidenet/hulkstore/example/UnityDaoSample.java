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
import com.cidenet.hulkstore.dao.UnityDao;
import com.cidenet.hulkstore.dto.Unity;
import com.cidenet.hulkstore.exceptions.UnityDaoException;
import com.cidenet.hulkstore.factory.UnityDaoFactory;

public class UnityDaoSample
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
		// findWhereUnityIdEquals(0);
		// findWhereUnityDescriptionEquals("");
		// findWhereStateEquals(0);
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			UnityDao _dao = getUnityDao();
			Unity _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereUnityIdEquals'
	 * 
	 * @param unityId
	 */
	public static void findWhereUnityIdEquals(int unityId)
	{
		try {
			UnityDao _dao = getUnityDao();
			Unity _result[] = _dao.findWhereUnityIdEquals(unityId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereUnityDescriptionEquals'
	 * 
	 * @param unityDescription
	 */
	public static void findWhereUnityDescriptionEquals(String unityDescription)
	{
		try {
			UnityDao _dao = getUnityDao();
			Unity _result[] = _dao.findWhereUnityDescriptionEquals(unityDescription);
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
			UnityDao _dao = getUnityDao();
			Unity _result[] = _dao.findWhereStateEquals(state);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getUnityDao'
	 * 
	 * @return UnityDao
	 */
	public static UnityDao getUnityDao()
	{
		return UnityDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(Unity dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getUnityId() );
		buf.append( ", " );
		buf.append( dto.getUnityDescription() );
		buf.append( ", " );
		buf.append( dto.getState() );
		System.out.println( buf.toString() );
	}

}
