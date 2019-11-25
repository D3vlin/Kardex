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

public interface KardexDetailDao
{
	/** 
	 * Inserts a new row in the kardex_detail table.
	 */
	public KardexDetailPk insert(KardexDetail dto) throws KardexDetailDaoException;

	/** 
	 * Updates a single row in the kardex_detail table.
	 */
	public void update(KardexDetailPk pk, KardexDetail dto) throws KardexDetailDaoException;

	/** 
	 * Deletes a single row in the kardex_detail table.
	 */
	public void delete(KardexDetailPk pk) throws KardexDetailDaoException;

	/** 
	 * Returns the rows from the kardex_detail table that matches the specified primary-key value.
	 */
	public KardexDetail findByPrimaryKey(KardexDetailPk pk) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'detailId = :detailId AND productId = :productId AND storeId = :storeId'.
	 */
	public KardexDetail findByPrimaryKey(int detailId, int productId, int storeId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria ''.
	 */
	public KardexDetail[] findAll() throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'documentId = :documentId'.
	 */
	public KardexDetail[] findByDocument(int documentId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'productId = :productId AND storeId = :storeId'.
	 */
	public KardexDetail[] findByKardex(int productId, int storeId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'userId = :userId'.
	 */
	public KardexDetail[] findByUsers(int userId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'detailId = :detailId'.
	 */
	public KardexDetail[] findWhereDetailIdEquals(int detailId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'productId = :productId'.
	 */
	public KardexDetail[] findWhereProductIdEquals(int productId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'storeId = :storeId'.
	 */
	public KardexDetail[] findWhereStoreIdEquals(int storeId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'kardexDetailYear = :kardexDetailYear'.
	 */
	public KardexDetail[] findWhereKardexDetailYearEquals(int kardexDetailYear) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'kardexDetailMonth = :kardexDetailMonth'.
	 */
	public KardexDetail[] findWhereKardexDetailMonthEquals(int kardexDetailMonth) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'kardexDetailday = :kardexDetailday'.
	 */
	public KardexDetail[] findWhereKardexDetaildayEquals(int kardexDetailday) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'userId = :userId'.
	 */
	public KardexDetail[] findWhereUserIdEquals(int userId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'documentId = :documentId'.
	 */
	public KardexDetail[] findWhereDocumentIdEquals(int documentId) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'documentNumber = :documentNumber'.
	 */
	public KardexDetail[] findWhereDocumentNumberEquals(int documentNumber) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'operation = :operation'.
	 */
	public KardexDetail[] findWhereOperationEquals(short operation) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'quantity = :quantity'.
	 */
	public KardexDetail[] findWhereQuantityEquals(double quantity) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'unityValue = :unityValue'.
	 */
	public KardexDetail[] findWhereUnityValueEquals(double unityValue) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'totalValue = :totalValue'.
	 */
	public KardexDetail[] findWhereTotalValueEquals(double totalValue) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'observations = :observations'.
	 */
	public KardexDetail[] findWhereObservationsEquals(String observations) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the criteria 'state = :state'.
	 */
	public KardexDetail[] findWhereStateEquals(short state) throws KardexDetailDaoException;

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
	public KardexDetail[] findByDynamicSelect(String sql, Object[] sqlParams) throws KardexDetailDaoException;

	/** 
	 * Returns all rows from the kardex_detail table that match the specified arbitrary SQL statement
	 */
	public KardexDetail[] findByDynamicWhere(String sql, Object[] sqlParams) throws KardexDetailDaoException;

}
