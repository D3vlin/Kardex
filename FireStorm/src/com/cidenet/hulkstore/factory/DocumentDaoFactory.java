/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.cidenet.hulkstore.factory;

import java.sql.Connection;
import com.cidenet.hulkstore.dao.*;
import com.cidenet.hulkstore.jdbc.*;

public class DocumentDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return DocumentDao
	 */
	public static DocumentDao create()
	{
		return new DocumentDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return DocumentDao
	 */
	public static DocumentDao create(Connection conn)
	{
		return new DocumentDaoImpl( conn );
	}

}
