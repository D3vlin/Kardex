package com.cidenet.hulkstore.users;

import com.cidenet.hulkstore.jdbc.AbstractDAO;
import com.cidenet.hulkstore.jdbc.ResourceManager;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersDaoImpl extends AbstractDAO implements UsersDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
         * takes no arguments and one that takes a Connection argument. If the Connection version
         * is chosen then the connection will be stored in this attribute and will be used by all
         * calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT userId, userName, userPass, identification, realName, surname, userProfile, state FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( userId, userName, userPass, identification, realName, surname, userProfile, state ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET userId = ?, userName = ?, userPass = ?, identification = ?, realName = ?, surname = ?, userProfile = ?, state = ? WHERE userId = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE userId = ?";

	/** 
	 * Index of column userId
	 */
	protected static final int COLUMN_USER_ID = 1;

	/** 
	 * Index of column userName
	 */
	protected static final int COLUMN_USER_NAME = 2;

	/** 
	 * Index of column userPass
	 */
	protected static final int COLUMN_USER_PASS = 3;

	/** 
	 * Index of column identification
	 */
	protected static final int COLUMN_IDENTIFICATION = 4;

	/** 
	 * Index of column realName
	 */
	protected static final int COLUMN_REAL_NAME = 5;

	/** 
	 * Index of column surname
	 */
	protected static final int COLUMN_SURNAME = 6;

	/** 
	 * Index of column userProfile
	 */
	protected static final int COLUMN_USER_PROFILE = 7;

	/** 
	 * Index of column state
	 */
	protected static final int COLUMN_STATE = 8;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 8;

	/** 
	 * Index of primary-key column userId
	 */
	protected static final int PK_COLUMN_USER_ID = 1;

	/** 
	 * Inserts a new row in the users table.
	 */
	public UsersPk insert(UsersDto dto) throws UsersDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );
			int index = 1;
			stmt.setInt( index++, dto.getUserId() );
			stmt.setString( index++, dto.getUserName() );
			stmt.setString( index++, dto.getUserPass() );
			stmt.setString( index++, dto.getIdentification() );
			stmt.setString( index++, dto.getRealName() );
			stmt.setString( index++, dto.getSurname() );
			stmt.setShort( index++, dto.getUserProfile() );
			stmt.setShort( index++, dto.getState() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setUserId( rs.getInt( 1 ) );
			}
		
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new UsersDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the users table.
	 */
	public void update(UsersPk pk, UsersDto dto) throws UsersDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + dto );
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			stmt.setInt( index++, dto.getUserId() );
			stmt.setString( index++, dto.getUserName() );
			stmt.setString( index++, dto.getUserPass() );
			stmt.setString( index++, dto.getIdentification() );
			stmt.setString( index++, dto.getRealName() );
			stmt.setString( index++, dto.getSurname() );
			stmt.setShort( index++, dto.getUserProfile() );
			stmt.setShort( index++, dto.getState() );
			stmt.setInt( 9, pk.getUserId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new UsersDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the users table.
	 */
	public void delete(UsersPk pk) throws UsersDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_DELETE + " with PK: " + pk );
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setInt( 1, pk.getUserId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new UsersDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the users table that matches the specified primary-key value.
	 */
	public UsersDto findByPrimaryKey(UsersPk pk) throws UsersDaoException
	{
		return findByPrimaryKey( pk.getUserId() );
	}

	/** 
	 * Returns all rows from the users table that match the criteria 'userId = :userId'.
	 */
	public UsersDto findByPrimaryKey(int userId) throws UsersDaoException
	{
		UsersDto ret[] = findByDynamicSelect( SQL_SELECT + " WHERE userId = ?", new Object[] {  new Integer(userId) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the users table that match the criteria ''.
	 */
	public UsersDto[] findAll() throws UsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY userId", null );
	}

	/** 
	 * Returns all rows from the users table that match the criteria 'userId = :userId'.
	 */
	public UsersDto[] findWhereUserIdEquals(int userId) throws UsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE userId = ? ORDER BY userId", new Object[] {  new Integer(userId) } );
	}

	/** 
	 * Returns all rows from the users table that match the criteria 'userName = :userName'.
	 */
	public UsersDto[] findWhereUserNameEquals(String userName) throws UsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE userName = ? ORDER BY userName", new Object[] { userName } );
	}

	/** 
	 * Returns all rows from the users table that match the criteria 'userPass = :userPass'.
	 */
	public UsersDto[] findWhereUserPassEquals(String userPass) throws UsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE userPass = MD5(?) ORDER BY userPass", new Object[] { userPass } );
	}

	/** 
	 * Returns all rows from the users table that match the criteria 'identification = :identification'.
	 */
	public UsersDto[] findWhereIdentificationEquals(String identification) throws UsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE identification = ? ORDER BY identification", new Object[] { identification } );
	}

	/** 
	 * Returns all rows from the users table that match the criteria 'realName = :realName'.
	 */
	public UsersDto[] findWhereRealNameEquals(String realName) throws UsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE realName = ? ORDER BY realName", new Object[] { realName } );
	}

	/** 
	 * Returns all rows from the users table that match the criteria 'surname = :surname'.
	 */
	public UsersDto[] findWhereSurnameEquals(String surname) throws UsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE surname = ? ORDER BY surname", new Object[] { surname } );
	}

	/** 
	 * Returns all rows from the users table that match the criteria 'userProfile = :userProfile'.
	 */
	public UsersDto[] findWhereUserProfileEquals(short userProfile) throws UsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE userProfile = ? ORDER BY userProfile", new Object[] {  new Short(userProfile) } );
	}

	/** 
	 * Returns all rows from the users table that match the criteria 'state = :state'.
	 */
	public UsersDto[] findWhereStateEquals(short state) throws UsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE state = ? ORDER BY state", new Object[] {  new Short(state) } );
	}

	/**
	 * Method 'UsersDaoImpl'
	 * 
	 */
	public UsersDaoImpl()
	{
	}

	/**
	 * Method 'UsersDaoImpl'
	 * 
	 * @param userConn
	 */
	public UsersDaoImpl(final java.sql.Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "bd_hulkstore.users";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected UsersDto fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			UsersDto dto = new UsersDto();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected UsersDto[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			UsersDto dto = new UsersDto();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		UsersDto ret[] = new UsersDto[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(UsersDto dto, ResultSet rs) throws SQLException
	{
		dto.setUserId( rs.getInt( COLUMN_USER_ID ) );
		dto.setUserName( rs.getString( COLUMN_USER_NAME ) );
		dto.setUserPass( rs.getString( COLUMN_USER_PASS ) );
		dto.setIdentification( rs.getString( COLUMN_IDENTIFICATION ) );
		dto.setRealName( rs.getString( COLUMN_REAL_NAME ) );
		dto.setSurname( rs.getString( COLUMN_SURNAME ) );
		dto.setUserProfile( rs.getShort( COLUMN_USER_PROFILE ) );
		dto.setState( rs.getShort( COLUMN_STATE ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(UsersDto dto)
	{
	}

	/** 
	 * Returns all rows from the users table that match the specified arbitrary SQL statement
	 */
	public UsersDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws UsersDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new UsersDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the users table that match the specified arbitrary SQL statement
	 */
	public UsersDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws UsersDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new UsersDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}
    
    // Se conservan estos metodos
    @Override
    public UsersDto validateUser(String userName, String userPass) throws UsersDaoException {
        UsersDto rsp[] = findByDynamicWhere( "userName = ? and userPass = MD5(?) ORDER BY userPass", new Object[] { userName, userPass } );  
        
        if (rsp.length != 0){
            return rsp[0];
            
        } else {
            return null;
        }
    }

}
