package com.cidenet.hulkstore.stores;

import com.cidenet.hulkstore.stores.StoreDto;
import com.cidenet.hulkstore.stores.StorePk;
import com.cidenet.hulkstore.stores.StoreDaoException;

public interface StoreDao
{
	/** 
	 * Inserts a new row in the store table.
	 */
	public StorePk insert(StoreDto dto) throws StoreDaoException;

	/** 
	 * Updates a single row in the store table.
	 */
	public void update(StorePk pk, StoreDto dto) throws StoreDaoException;

	/** 
	 * Deletes a single row in the store table.
	 */
	public void delete(StorePk pk) throws StoreDaoException;

	/** 
	 * Returns the rows from the store table that matches the specified primary-key value.
	 */
	public StoreDto findByPrimaryKey(StorePk pk) throws StoreDaoException;

	/** 
	 * Returns all rows from the store table that match the criteria 'storeId = :storeId'.
	 */
	public StoreDto findByPrimaryKey(int storeId) throws StoreDaoException;

	/** 
	 * Returns all rows from the store table that match the criteria ''.
	 */
	public StoreDto[] findAll() throws StoreDaoException;

	/** 
	 * Returns all rows from the store table that match the criteria 'storeId = :storeId'.
	 */
	public StoreDto[] findWhereStoreIdEquals(int storeId) throws StoreDaoException;

	/** 
	 * Returns all rows from the store table that match the criteria 'storeName = :storeName'.
	 */
	public StoreDto[] findWhereStoreNameEquals(String storeName) throws StoreDaoException;

	/** 
	 * Returns all rows from the store table that match the criteria 'address = :address'.
	 */
	public StoreDto[] findWhereAddressEquals(String address) throws StoreDaoException;

	/** 
	 * Returns all rows from the store table that match the criteria 'state = :state'.
	 */
	public StoreDto[] findWhereStateEquals(short state) throws StoreDaoException;

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
	public StoreDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws StoreDaoException;

	/** 
	 * Returns all rows from the store table that match the specified arbitrary SQL statement
	 */
	public StoreDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws StoreDaoException;

}
