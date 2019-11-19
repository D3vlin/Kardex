package com.cidenet.hulkstore.example;

import com.cidenet.hulkstore.factory.DaoFactory;
import com.cidenet.hulkstore.users.UsersDao;
import com.cidenet.hulkstore.users.UsersDto;

public class UsersDaoSample
{
	/**
	 * Method 'main'
	 * 
	 * @param arg
	 * @throws Exception
	 */
	public static void main(String[] arg) throws Exception
	{
		// Uncomment one of the lines below to test the generated code
		
		// findAll();
		// findWhereUserIdEquals(1);
		// findWhereUserNameEquals("admin");
		// findWhereUserPassEquals("admin");
		// findWhereIdentificationEquals("00000000");
		// findWhereRealNameEquals("Admin");
		// findWhereSurnameEquals("ADMIN");
		// findWhereUserProfileEquals((short) 1);
		// findWhereStateEquals((short) 1);
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			UsersDao _dao = getUsersDao();
			UsersDto _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereUserIdEquals'
	 * 
	 * @param userId
	 */
	public static void findWhereUserIdEquals(int userId)
	{
		try {
			UsersDao _dao = getUsersDao();
			UsersDto _result[] = _dao.findWhereUserIdEquals(userId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereUserNameEquals'
	 * 
	 * @param userName
	 */
	public static void findWhereUserNameEquals(String userName)
	{
		try {
			UsersDao _dao = getUsersDao();
			UsersDto _result[] = _dao.findWhereUserNameEquals(userName);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereUserPassEquals'
	 * 
	 * @param userPass
	 */
	public static void findWhereUserPassEquals(String userPass)
	{
		try {
			UsersDao _dao = getUsersDao();
			UsersDto _result[] = _dao.findWhereUserPassEquals(userPass);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereIdentificationEquals'
	 * 
	 * @param identification
	 */
	public static void findWhereIdentificationEquals(String identification)
	{
		try {
			UsersDao _dao = getUsersDao();
			UsersDto _result[] = _dao.findWhereIdentificationEquals(identification);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereRealNameEquals'
	 * 
	 * @param realName
	 */
	public static void findWhereRealNameEquals(String realName)
	{
		try {
			UsersDao _dao = getUsersDao();
			UsersDto _result[] = _dao.findWhereRealNameEquals(realName);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereSurnameEquals'
	 * 
	 * @param surname
	 */
	public static void findWhereSurnameEquals(String surname)
	{
		try {
			UsersDao _dao = getUsersDao();
			UsersDto _result[] = _dao.findWhereSurnameEquals(surname);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereUserProfileEquals'
	 * 
	 * @param userProfile
	 */
	public static void findWhereUserProfileEquals(short userProfile)
	{
		try {
			UsersDao _dao = getUsersDao();
			UsersDto _result[] = _dao.findWhereUserProfileEquals(userProfile);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereStateEquals'
	 * 
	 * @param state
	 */
	public static void findWhereStateEquals(short state)
	{
		try {
			UsersDao _dao = getUsersDao();
			UsersDto _result[] = _dao.findWhereStateEquals(state);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getUsersDao'
	 * 
	 * @return UsersDao
	 */
	public static UsersDao getUsersDao()
	{
		return DaoFactory.createUsersDao();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(UsersDto dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getUserId() );
		buf.append( ", " );
		buf.append( dto.getUserName() );
		buf.append( ", " );
		buf.append( dto.getUserPass() );
		buf.append( ", " );
		buf.append( dto.getIdentification() );
		buf.append( ", " );
		buf.append( dto.getRealName() );
		buf.append( ", " );
		buf.append( dto.getSurname() );
		buf.append( ", " );
		buf.append( dto.getUserProfile() );
		buf.append( ", " );
		buf.append( dto.getState() );
		System.out.println( buf.toString() );
	}

}
