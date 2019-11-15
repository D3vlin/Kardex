package com.cidenet.hulkstore.units;

public interface UnityDao
{
	/** 
	 * Inserts a new row in the unity table.
	 */
	public UnityPk insert(UnityDto dto) throws UnityDaoException;

	/** 
	 * Updates a single row in the unity table.
	 */
	public void update(UnityPk pk, UnityDto dto) throws UnityDaoException;

	/** 
	 * Deletes a single row in the unity table.
	 */
	public void delete(UnityPk pk) throws UnityDaoException;

	/** 
	 * Returns the rows from the unity table that matches the specified primary-key value.
	 */
	public UnityDto findByPrimaryKey(UnityPk pk) throws UnityDaoException;

	/** 
	 * Returns all rows from the unity table that match the criteria 'unityId = :unityId'.
	 */
	public UnityDto findByPrimaryKey(int unityId) throws UnityDaoException;

	/** 
	 * Returns all rows from the unity table that match the criteria ''.
	 */
	public UnityDto[] findAll() throws UnityDaoException;

	/** 
	 * Returns all rows from the unity table that match the criteria 'unityId = :unityId'.
	 */
	public UnityDto[] findWhereUnityIdEquals(int unityId) throws UnityDaoException;

	/** 
	 * Returns all rows from the unity table that match the criteria 'unityDescription = :unityDescription'.
	 */
	public UnityDto[] findWhereUnityDescriptionEquals(String unityDescription) throws UnityDaoException;

	/** 
	 * Returns all rows from the unity table that match the criteria 'state = :state'.
	 */
	public UnityDto[] findWhereStateEquals(short state) throws UnityDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the unity table that match the specified arbitrary SQL statement
	 */
	public UnityDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws UnityDaoException;

	/** 
	 * Returns all rows from the unity table that match the specified arbitrary SQL statement
	 */
	public UnityDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws UnityDaoException;

}
