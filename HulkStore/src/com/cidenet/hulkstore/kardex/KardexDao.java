package com.cidenet.hulkstore.kardex;


public interface KardexDao
{
	/** 
	 * Inserts a new row in the kardex table.
	 */
	public KardexPk insert(KardexDto dto) throws KardexDaoException;

	/** 
	 * Updates a single row in the kardex table.
	 */
	public void update(KardexPk pk, KardexDto dto) throws KardexDaoException;

	/** 
	 * Deletes a single row in the kardex table.
	 */
	public void delete(KardexPk pk) throws KardexDaoException;

	/** 
	 * Returns the rows from the kardex table that matches the specified primary-key value.
	 */
	public KardexDto findByPrimaryKey(KardexPk pk) throws KardexDaoException;

	/** 
	 * Returns all rows from the kardex table that match the criteria 'productId = :productId AND storeId = :storeId'.
	 */
	public KardexDto findByPrimaryKey(int productId, int storeId) throws KardexDaoException;

	/** 
	 * Returns all rows from the kardex table that match the criteria ''.
	 */
	public KardexDto[] findAll() throws KardexDaoException;

	/** 
	 * Returns all rows from the kardex table that match the criteria 'productId = :productId'.
	 */
	public KardexDto[] findByProduct(int productId) throws KardexDaoException;

	/** 
	 * Returns all rows from the kardex table that match the criteria 'storeId = :storeId'.
	 */
	public KardexDto[] findByStore(int storeId) throws KardexDaoException;

	/** 
	 * Returns all rows from the kardex table that match the criteria 'productId = :productId'.
	 */
	public KardexDto[] findWhereProductIdEquals(int productId) throws KardexDaoException;

	/** 
	 * Returns all rows from the kardex table that match the criteria 'storeId = :storeId'.
	 */
	public KardexDto[] findWhereStoreIdEquals(int storeId) throws KardexDaoException;

	/** 
	 * Returns all rows from the kardex table that match the criteria 'quantity = :quantity'.
	 */
	public KardexDto[] findWhereQuantityEquals(double quantity) throws KardexDaoException;

	/** 
	 * Returns all rows from the kardex table that match the criteria 'unityValue = :unityValue'.
	 */
	public KardexDto[] findWhereUnityValueEquals(double unityValue) throws KardexDaoException;

	/** 
	 * Returns all rows from the kardex table that match the criteria 'totalValue = :totalValue'.
	 */
	public KardexDto[] findWhereTotalValueEquals(double totalValue) throws KardexDaoException;

	/** 
	 * Returns all rows from the kardex table that match the criteria 'state = :state'.
	 */
	public KardexDto[] findWhereStateEquals(short state) throws KardexDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the kardex table that match the specified arbitrary SQL statement
	 */
	public KardexDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws KardexDaoException;

	/** 
	 * Returns all rows from the kardex table that match the specified arbitrary SQL statement
	 */
	public KardexDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws KardexDaoException;

}
