package com.cidenet.hulkstore.kardex;

public interface KardexDetailDao
{
	/** 
	 * Inserts a new row in the kardex_detail table.
	 */
	public KardexDetailPk insert(KardexDetailDto dto) throws KardexDetailDaoException;

	/** 
	 * Updates a single row in the kardex_detail table.
	 */
	public void update(KardexDetailPk pk, KardexDetailDto dto) throws KardexDetailDaoException;

	/** 
	 * Deletes a single row in the kardex_detail table.
	 */
	public void delete(KardexDetailPk pk) throws KardexDetailDaoException;

	/** 
	 * Returns the rows from the kardex_detail table that matches the specified primary-key value.
	 */
	public KardexDetailDto findByPrimaryKey(KardexDetailPk pk) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'detailId = :detailId AND productId = :productId AND storeId = :storeId'.
	 */
	public KardexDetailDto findByPrimaryKey(int detailId, int productId, int storeId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria ''.
	 */
	public KardexDetailDto[] findAll() throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'documentId = :documentId'.
	 */
	public KardexDetailDto[] findByDocument(int documentId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'productId = :productId AND storeId = :storeId'.
	 */
	public KardexDetailDto[] findByKardex(int productId, int storeId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'userId = :userId'.
	 */
	public KardexDetailDto[] findByUsers(int userId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'detailId = :detailId'.
	 */
	public KardexDetailDto[] findWhereDetailIdEquals(int detailId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'productId = :productId'.
	 */
	public KardexDetailDto[] findWhereProductIdEquals(int productId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'storeId = :storeId'.
	 */
	public KardexDetailDto[] findWhereStoreIdEquals(int storeId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'kardexDetailYear = :kardexDetailYear'.
	 */
	public KardexDetailDto[] findWhereKardexDetailYearEquals(int kardexDetailYear) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'kardexDetailMonth = :kardexDetailMonth'.
	 */
	public KardexDetailDto[] findWhereKardexDetailMonthEquals(int kardexDetailMonth) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'kardexDetailday = :kardexDetailday'.
	 */
	public KardexDetailDto[] findWhereKardexDetaildayEquals(int kardexDetailday) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'userId = :userId'.
	 */
	public KardexDetailDto[] findWhereUserIdEquals(int userId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'documentId = :documentId'.
	 */
	public KardexDetailDto[] findWhereDocumentIdEquals(int documentId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'documentNumber = :documentNumber'.
	 */
	public KardexDetailDto[] findWhereDocumentNumberEquals(int documentNumber) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'operation = :operation'.
	 */
	public KardexDetailDto[] findWhereOperationEquals(short operation) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'quantity = :quantity'.
	 */
	public KardexDetailDto[] findWhereQuantityEquals(double quantity) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'unityValue = :unityValue'.
	 */
	public KardexDetailDto[] findWhereUnityValueEquals(double unityValue) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'totalValue = :totalValue'.
	 */
	public KardexDetailDto[] findWhereTotalValueEquals(double totalValue) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'observations = :observations'.
	 */
	public KardexDetailDto[] findWhereObservationsEquals(String observations) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'state = :state'.
	 */
	public KardexDetailDto[] findWhereStateEquals(short state) throws KardexDetailDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the kardex_detail table that match the specified arbitrary SQL statement
	 */
	public KardexDetailDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the specified arbitrary SQL statement
	 */
	public KardexDetailDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws KardexDetailDaoException;

}
