/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.cidenet.hulkstore.dao;

import com.cidenet.hulkstore.dto.*;
import com.cidenet.hulkstore.exceptions.*;

public interface ProductDao
{
	/** 
	 * Inserts a new row in the product table.
	 */
	public ProductPk insert(Product dto) throws ProductDaoException;

	/** 
	 * Updates a single row in the product table.
	 */
	public void update(ProductPk pk, Product dto) throws ProductDaoException;

	/** 
	 * Deletes a single row in the product table.
	 */
	public void delete(ProductPk pk) throws ProductDaoException;

	/** 
	 * Returns the rows from the product table that matches the specified primary-key value.
	 */
	public Product findByPrimaryKey(ProductPk pk) throws ProductDaoException;

	/** 
	 * Returns all rows from the product table that match the criteria 'productId = :productId'.
	 */
	public Product findByPrimaryKey(int productId) throws ProductDaoException;

	/** 
	 * Returns all rows from the product table that match the criteria ''.
	 */
	public Product[] findAll() throws ProductDaoException;

	/** 
	 * Returns all rows from the product table that match the criteria 'productId = :productId'.
	 */
	public Product[] findWhereProductIdEquals(int productId) throws ProductDaoException;

	/** 
	 * Returns all rows from the product table that match the criteria 'productName = :productName'.
	 */
	public Product[] findWhereProductNameEquals(String productName) throws ProductDaoException;

	/** 
	 * Returns all rows from the product table that match the criteria 'unityId = :unityId'.
	 */
	public Product[] findWhereUnityIdEquals(int unityId) throws ProductDaoException;

	/** 
	 * Returns all rows from the product table that match the criteria 'state = :state'.
	 */
	public Product[] findWhereStateEquals(short state) throws ProductDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the product table that match the specified arbitrary SQL statement
	 */
	public Product[] findByDynamicSelect(String sql, Object[] sqlParams) throws ProductDaoException;

	/** 
	 * Returns all rows from the product table that match the specified arbitrary SQL statement
	 */
	public Product[] findByDynamicWhere(String sql, Object[] sqlParams) throws ProductDaoException;

}
