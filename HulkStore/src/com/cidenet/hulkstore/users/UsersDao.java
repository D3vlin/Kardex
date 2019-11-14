package com.cidenet.hulkstore.users;

public interface UsersDao
{
	/** 
	 * Inserts a new row in the users table.
	 */
	public UsersPk insert(UsersDto dto) throws UsersDaoException;

	/** 
	 * Updates a single row in the users table.
	 */
	public void update(UsersPk pk, UsersDto dto) throws UsersDaoException;

	/** 
	 * Deletes a single row in the users table.
	 */
	public void delete(UsersPk pk) throws UsersDaoException;

	/** 
	 * Returns the rows from the users table that matches the specified primary-key value.
	 */
	public UsersDto findByPrimaryKey(UsersPk pk) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'userId = :userId'.
	 */
	public UsersDto findByPrimaryKey(int userId) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria ''.
	 */
	public UsersDto[] findAll() throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'userId = :userId'.
	 */
	public UsersDto[] findWhereUserIdEquals(int userId) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'userName = :userName'.
	 */
	public UsersDto[] findWhereUserNameEquals(String userName) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'userPass = :userPass'.
	 */
	public UsersDto[] findWhereUserPassEquals(String userPass) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'identification = :identification'.
	 */
	public UsersDto[] findWhereIdentificationEquals(String identification) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'realName = :realName'.
	 */
	public UsersDto[] findWhereRealNameEquals(String realName) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'surname = :surname'.
	 */
	public UsersDto[] findWhereSurnameEquals(String surname) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'userProfile = :userProfile'.
	 */
	public UsersDto[] findWhereUserProfileEquals(short userProfile) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'state = :state'.
	 */
	public UsersDto[] findWhereStateEquals(short state) throws UsersDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the users table that match the specified arbitrary SQL statement
	 */
	public UsersDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the specified arbitrary SQL statement
	 */
	public UsersDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws UsersDaoException;

	/** 
	 * Validates the entry of a user, verifying its existence in the database
	 */
	public UsersDto validateUser(String userName, String userPass) throws UsersDaoException;

}
