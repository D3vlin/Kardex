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

public interface StoreDao
{
	/** 
	 * Inserts a new row in the store table.
	 */
	public StorePk insert(Store dto) throws StoreDaoException;

	/** 
	 * Updates a single row in the store table.
	 */
	public void update(StorePk pk, Store dto) throws StoreDaoException;

	/** 
	 * Deletes a single row in the store table.
	 */
	public void delete(StorePk pk) throws StoreDaoException;

	/** 
	 * Returns the rows from the store table that matches the specified primary-key value.
	 */
	public Store findByPrimaryKey(StorePk pk) throws StoreDaoException;

	/** 
	 * Returns all rows from the store table that match the criteria 'storeId = :storeId'.
	 */
	public Store findByPrimaryKey(int storeId) throws StoreDaoException;

	/** 
	 * Returns all rows from the store table that match the criteria ''.
	 */
	public Store[] findAll() throws StoreDaoException;

	/** 
	 * Returns all rows from the store table that match the criteria 'storeId = :storeId'.
	 */
	public Store[] findWhereStoreIdEquals(int storeId) throws StoreDaoException;

	/** 
	 * Returns all rows from the store table that match the criteria 'storeName = :storeName'.
	 */
	public Store[] findWhereStoreNameEquals(String storeName) throws StoreDaoException;

	/** 
	 * Returns all rows from the store table that match the criteria 'address = :address'.
	 */
	public Store[] findWhereAddressEquals(String address) throws StoreDaoException;

	/** 
	 * Returns all rows from the store table that match the criteria 'state = :state'.
	 */
	public Store[] findWhereStateEquals(short state) throws StoreDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the store table that match the specified arbitrary SQL statement
	 */
	public Store[] findByDynamicSelect(String sql, Object[] sqlParams) throws StoreDaoException;

	/** 
	 * Returns all rows from the store table that match the specified arbitrary SQL statement
	 */
	public Store[] findByDynamicWhere(String sql, Object[] sqlParams) throws StoreDaoException;

}
