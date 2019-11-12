package com.cidenet.hulkstore.dao.users;

import com.cidenet.hulkstore.exceptions.users.UsersDaoException;
import com.cidenet.hulkstore.dto.users.UsersPk;
import com.cidenet.hulkstore.dto.users.Users;
import com.cidenet.hulkstore.exceptions.*;

public interface UsersDao
{
	/** 
	 * Inserts a new row in the users table.
	 */
	public UsersPk insert(Users dto) throws UsersDaoException;

	/** 
	 * Updates a single row in the users table.
	 */
	public void update(UsersPk pk, Users dto) throws UsersDaoException;

	/** 
	 * Deletes a single row in the users table.
	 */
	public void delete(UsersPk pk) throws UsersDaoException;

	/** 
	 * Returns the rows from the users table that matches the specified primary-key value.
	 */
	public Users findByPrimaryKey(UsersPk pk) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'userId = :userId'.
	 */
	public Users findByPrimaryKey(int userId) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria ''.
	 */
	public Users[] findAll() throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'userId = :userId'.
	 */
	public Users[] findWhereUserIdEquals(int userId) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'userName = :userName'.
	 */
	public Users[] findWhereUserNameEquals(String userName) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'userPass = :userPass'.
	 */
	public Users[] findWhereUserPassEquals(String userPass) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'identification = :identification'.
	 */
	public Users[] findWhereIdentificationEquals(String identification) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'realName = :realName'.
	 */
	public Users[] findWhereRealNameEquals(String realName) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'surname = :surname'.
	 */
	public Users[] findWhereSurnameEquals(String surname) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'userProfile = :userProfile'.
	 */
	public Users[] findWhereUserProfileEquals(short userProfile) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the criteria 'state = :state'.
	 */
	public Users[] findWhereStateEquals(short state) throws UsersDaoException;

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
	public Users[] findByDynamicSelect(String sql, Object[] sqlParams) throws UsersDaoException;

	/** 
	 * Returns all rows from the users table that match the specified arbitrary SQL statement
	 */
	public Users[] findByDynamicWhere(String sql, Object[] sqlParams) throws UsersDaoException;

	/** 
	 * Validates the entry of a user, verifying its existence in the database
	 */
	public Users validateUser(String userName, String userPass) throws UsersDaoException;

}
