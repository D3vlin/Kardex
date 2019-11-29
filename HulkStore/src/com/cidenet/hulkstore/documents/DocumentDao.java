package com.cidenet.hulkstore.documents;

import com.cidenet.hulkstore.jdbc.AbstractDAO;
import com.cidenet.hulkstore.jdbc.ResourceManager;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DocumentDao extends AbstractDAO
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT documentId, documentDescription, state FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( documentId, documentDescription, state ) VALUES ( ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET documentId = ?, documentDescription = ?, state = ? WHERE documentId = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE documentId = ?";

	/** 
	 * Index of column documentId
	 */
	protected static final int COLUMN_DOCUMENT_ID = 1;

	/** 
	 * Index of column documentDescription
	 */
	protected static final int COLUMN_DOCUMENT_DESCRIPTION = 2;

	/** 
	 * Index of column state
	 */
	protected static final int COLUMN_STATE = 3;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 3;

	/** 
	 * Index of primary-key column documentId
	 */
	protected static final int PK_COLUMN_DOCUMENT_ID = 1;

	/** 
	 * Inserts a new row in the document table.
	 */
	public DocumentPk insert(DocumentDto dto) throws DocumentDaoException
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
			stmt.setInt( index++, dto.getDocumentId() );
			stmt.setString( index++, dto.getDocumentDescription() );
			stmt.setShort( index++, dto.getState() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setDocumentId( rs.getInt( 1 ) );
			}
		
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new DocumentDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the document table.
	 */
	public boolean update(DocumentPk pk, DocumentDto dto) throws DocumentDaoException
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
			stmt.setInt( index++, dto.getDocumentId() );
			stmt.setString( index++, dto.getDocumentDescription() );
			stmt.setShort( index++, dto.getState() );
			stmt.setInt( 4, pk.getDocumentId() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
                        return true;
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new DocumentDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the document table.
	 */
	public void delete(DocumentPk pk) throws DocumentDaoException
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
			stmt.setInt( 1, pk.getDocumentId() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new DocumentDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the document table that matches the specified primary-key value.
	 */
	public DocumentDto findByPrimaryKey(DocumentPk pk) throws DocumentDaoException
	{
		return findByPrimaryKey( pk.getDocumentId() );
	}

	/** 
	 * Returns all rows from the document table that match the criteria 'documentId = :documentId'.
	 */
	public DocumentDto findByPrimaryKey(int documentId) throws DocumentDaoException
	{
		DocumentDto ret[] = findByDynamicSelect( SQL_SELECT + " WHERE documentId = ?", new Object[] {  new Integer(documentId) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the document table that match the criteria ''.
	 */
	public DocumentDto[] findAll() throws DocumentDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY documentId", null );
	}

	/** 
	 * Returns all rows from the document table that match the criteria 'documentId = :documentId'.
	 */
	public DocumentDto[] findWhereDocumentIdEquals(int documentId) throws DocumentDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE documentId = ? ORDER BY documentId", new Object[] {  new Integer(documentId) } );
	}

	/** 
	 * Returns all rows from the document table that match the criteria 'documentDescription = :documentDescription'.
	 */
	public DocumentDto[] findWhereDocumentDescriptionEquals(String documentDescription) throws DocumentDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE documentDescription = ? ORDER BY documentDescription", new Object[] { documentDescription } );
	}

	/** 
	 * Returns all rows from the document table that match the criteria 'state = :state'.
	 */
	public DocumentDto[] findWhereStateEquals(short state) throws DocumentDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE state = ? ORDER BY state", new Object[] {  new Short(state) } );
	}

	/**
	 * Method 'DocumentDaoImpl'
	 * 
	 */
	public DocumentDao()
	{
	}

	/**
	 * Method 'DocumentDaoImpl'
	 * 
	 * @param userConn
	 */
	public DocumentDao(final java.sql.Connection userConn)
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
		return "bd_hulkstore.document";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected DocumentDto fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			DocumentDto dto = new DocumentDto();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected DocumentDto[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			DocumentDto dto = new DocumentDto();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		DocumentDto ret[] = new DocumentDto[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(DocumentDto dto, ResultSet rs) throws SQLException
	{
		dto.setDocumentId( rs.getInt( COLUMN_DOCUMENT_ID ) );
		dto.setDocumentDescription( rs.getString( COLUMN_DOCUMENT_DESCRIPTION ) );
		dto.setState( rs.getShort( COLUMN_STATE ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(DocumentDto dto)
	{
	}

	/** 
	 * Returns all rows from the document table that match the specified arbitrary SQL statement
	 */
	public DocumentDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws DocumentDaoException
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
			throw new DocumentDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the document table that match the specified arbitrary SQL statement
	 */
	public DocumentDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws DocumentDaoException
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
			throw new DocumentDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

    public String findNextDocumentId() throws DocumentDaoException {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            conn = isConnSupplied ? userConn : ResourceManager.getConnection();
            
            // construct the SQL statement
            final String SQL = "SELECT LPAD((SELECT COUNT(*) + 1 FROM " + getTableName() + "), 6, '0') AS nextDocumentId";
            
            System.out.println( "Executing " + SQL);
            stmt = conn.prepareStatement( SQL );

            rs = stmt.executeQuery();
            rs.next();
            
            return rs.getString(1);
        }
        catch (Exception _e) {
            throw new DocumentDaoException( "Exception: " + _e.getMessage(), _e );
        }
        finally {
            ResourceManager.close(rs);
            ResourceManager.close(stmt);
            if (!isConnSupplied) {
                ResourceManager.close(conn);
            }

        }
    }

}
