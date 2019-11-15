package com.cidenet.hulkstore.products;


public interface ProductDao
{
	/** 
	 * Inserts a new row in the product table.
	 */
	public ProductPk insert(ProductDto dto) throws ProductDaoException;

	/** 
	 * Updates a single row in the product table.
	 */
	public boolean update(ProductPk pk, ProductDto dto) throws ProductDaoException;

	/** 
	 * Deletes a single row in the product table.
	 */
	public void delete(ProductPk pk) throws ProductDaoException;

	/** 
	 * Returns the rows from the product table that matches the specified primary-key value.
	 */
	public ProductDto findByPrimaryKey(ProductPk pk) throws ProductDaoException;

	/** 
	 * Returns all rows from the product table that match the criteria 'productId = :productId'.
	 */
	public ProductDto findByPrimaryKey(int productId) throws ProductDaoException;

	/** 
	 * Returns all rows from the product table that match the criteria ''.
	 */
	public ProductDto[] findAll() throws ProductDaoException;

	/** 
	 * Returns all rows from the product table that match the criteria 'unityId = :unityId'.
	 */
        public ProductDto[] findByUnity(int unityId) throws ProductDaoException;

	/** 
	 * Returns all rows from the product table that match the criteria 'productId = :productId'.
	 */
	public ProductDto[] findWhereProductIdEquals(int productId) throws ProductDaoException;

	/** 
	 * Returns all rows from the product table that match the criteria 'productName = :productName'.
	 */
	public ProductDto[] findWhereProductNameEquals(String productName) throws ProductDaoException;

	/** 
	 * Returns all rows from the product table that match the criteria 'unityId = :unityId'.
	 */
	public ProductDto[] findWhereUnityIdEquals(int unityId) throws ProductDaoException;

	/** 
	 * Returns all rows from the product table that match the criteria 'state = :state'.
	 */
	public ProductDto[] findWhereStateEquals(short state) throws ProductDaoException;

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
	public ProductDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws ProductDaoException;

	/** 
	 * Returns all rows from the product table that match the specified arbitrary SQL statement
	 */
	public ProductDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws ProductDaoException;
        
        /** 
	 * Returns the next available id for the next record
	 */
        public String findNextProductId() throws ProductDaoException;
}
