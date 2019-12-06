package com.cidenet.hulkstore.kardex;

import com.cidenet.hulkstore.jdbc.AbstractDAO;
import com.cidenet.hulkstore.jdbc.ResourceManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** 
 * This class handles queries to the kardex detail table.
 *  
 * @author Alexis Duque
 * @version 1.0
 * @since 2019-11-24
 */
public final class KardexDetailDao extends AbstractDAO
{
    /** 
     * The factory class for this DAO has two versions of the create() method - one that
     * takes no arguments and one that takes a Connection argument. If the Connection version
     * is chosen then the connection will be stored in this attribute and will be used by all
     * calls to this DAO, otherwise a new Connection will be allocated for each operation.
     */
    protected java.sql.Connection userConn;

    /** 
     * All finder methods in this class use this SELECT constant to build their queries.
     */
    protected final String SQL_SELECT = "SELECT detailId, productId, storeId, kardexDetailYear, kardexDetailMonth, kardexDetailday, userId, documentId, documentNumber, operation, quantity, unityValue, totalValue, observations, state FROM " + getTableName() + "";

    /** 
     * Finder methods will pass this value to the JDBC setMaxRows method.
     */
    protected int maxRows;

    /** 
     * SQL INSERT statement for this table.
     */
    protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( detailId, productId, storeId, kardexDetailYear, kardexDetailMonth, kardexDetailday, userId, documentId, documentNumber, operation, quantity, unityValue, totalValue, observations, state ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

    /** 
     * SQL UPDATE statement for this table.
     */
    protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET detailId = ?, productId = ?, storeId = ?, kardexDetailYear = ?, kardexDetailMonth = ?, kardexDetailday = ?, userId = ?, documentId = ?, documentNumber = ?, operation = ?, quantity = ?, unityValue = ?, totalValue = ?, observations = ?, state = ? WHERE detailId = ? AND productId = ? AND storeId = ?";

    /** 
     * Indexes of the columns in the kardex_detail table.
     */
    protected static final int COLUMN_DETAIL_ID = 1;
    protected static final int COLUMN_PRODUCT_ID = 2;
    protected static final int COLUMN_STORE_ID = 3;
    protected static final int COLUMN_KARDEX_DETAIL_YEAR = 4;
    protected static final int COLUMN_KARDEX_DETAIL_MONTH = 5;
    protected static final int COLUMN_KARDEX_DETAILDAY = 6;
    protected static final int COLUMN_USER_ID = 7;
    protected static final int COLUMN_DOCUMENT_ID = 8;
    protected static final int COLUMN_DOCUMENT_NUMBER = 9;
    protected static final int COLUMN_OPERATION = 10;
    protected static final int COLUMN_QUANTITY = 11;
    protected static final int COLUMN_UNITY_VALUE = 12;
    protected static final int COLUMN_TOTAL_VALUE = 13;
    protected static final int COLUMN_OBSERVATIONS = 14;
    protected static final int COLUMN_STATE = 15;

    /** 
     * Number of columns in the kardex_detail table
     */
    protected static final int KARDEX_DETAIL_COLUMNS = 15;

    /** 
     * Index of primary-key column detailId in the kardex_detail table
     */
    protected static final int PK_COLUMN_DETAIL_ID = 1;

    /** 
     * Index of primary-key column productId in the kardex_detail table
     */
    protected static final int PK_COLUMN_PRODUCT_ID = 2;

    /** 
     * Index of primary-key column storeId in the kardex_detail table
     */
    protected static final int PK_COLUMN_STORE_ID = 3;

    /** 
     * Indexes of the columns in the vi_kardexdetail view.
     */
    protected static final int COLUMN_VIEW_DETAIL_ID = 1;
    protected static final int COLUMN_VIEW_KARDEX_DETAIL_YEAR = 2;
    protected static final int COLUMN_VIEW_KARDEX_DETAIL_MONTH = 3;
    protected static final int COLUMN_VIEW_KARDEX_DETAILDAY = 4;
    protected static final int COLUMN_VIEW_DOCUMENT_ID = 5;
    protected static final int COLUMN_VIEW_DOCUMENT_DESCRIPTION = 6;
    protected static final int COLUMN_VIEW_DOCUMENT_NUMBER = 7;
    protected static final int COLUMN_VIEW_OPERATION = 8;
    protected static final int COLUMN_VIEW_QUANTITY = 9;
    protected static final int COLUMN_VIEW_UNITY_VALUE = 10;
    protected static final int COLUMN_VIEW_TOTAL_VALUE = 11;
    protected static final int COLUMN_VIEW_OBSERVATIONS = 12;
    protected static final int COLUMN_VIEW_PRODUCT_ID = 13;
    protected static final int COLUMN_VIEW_STORE_ID = 14;

    /** 
     * Number of columns in the vi_kardexdetail view.
     */
    protected static final int KARDEX_DETAIL_VIEW_COLUMNS = 14;

    /** 
     * Inserts a new row in the kardex_detail table.
     * 
     * @param kardexDetailDto
     * @return KardexDetailPk
     * @throws com.cidenet.hulkstore.kardex.KardexDetailDaoException
     */
    public KardexDetailPk insert(KardexDetailDto kardexDetailDto) throws KardexDetailDaoException
    {
        // declare variables
        long t1 = System.currentTimeMillis();
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            statement = connection.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );
            int index = 1;
            statement.setInt( index++, kardexDetailDto.getDetailId() );
            statement.setInt( index++, kardexDetailDto.getProductId() );
            statement.setInt( index++, kardexDetailDto.getStoreId() );
            statement.setInt( index++, kardexDetailDto.getKardexDetailYear() );
            statement.setInt( index++, kardexDetailDto.getKardexDetailMonth() );
            statement.setInt( index++, kardexDetailDto.getKardexDetailday() );
            
            if (kardexDetailDto.isUserIdNull()) { statement.setNull( index++, java.sql.Types.INTEGER ); }
            else { statement.setInt( index++, kardexDetailDto.getUserId() ); }

            statement.setInt( index++, kardexDetailDto.getDocumentId() );
            statement.setInt( index++, kardexDetailDto.getDocumentNumber() );
            statement.setShort( index++, kardexDetailDto.getOperation() );
            statement.setDouble( index++, kardexDetailDto.getQuantity() );
            statement.setDouble( index++, kardexDetailDto.getUnityValue() );
            statement.setDouble( index++, kardexDetailDto.getTotalValue() );
            statement.setString( index++, kardexDetailDto.getObservations() );
            statement.setShort( index++, kardexDetailDto.getState() );
            System.out.println( "Executing " + SQL_INSERT + " with DTO: " + kardexDetailDto );
            int rows = statement.executeUpdate();
            long t2 = System.currentTimeMillis();
            System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );

            // retrieve values from auto-increment columns
            resultSet = statement.getGeneratedKeys();
            if (resultSet != null && resultSet.next()) { kardexDetailDto.setDetailId( resultSet.getInt( 1 ) ); }

            reset(kardexDetailDto);
            return kardexDetailDto.createPk();
            
        } catch (Exception exception) { throw new KardexDetailDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }

    /** 
     * Updates a single row in the kardex_detail table.
     * 
     * @param kardexDetailPk
     * @param kardexDetailDto
     * @return boolean
     * @throws com.cidenet.hulkstore.kardex.KardexDetailDaoException 
     */
    public boolean update(KardexDetailPk kardexDetailPk, KardexDetailDto kardexDetailDto) throws KardexDetailDaoException
    {
        long t1 = System.currentTimeMillis();
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + kardexDetailDto );
            statement = connection.prepareStatement( SQL_UPDATE );
            int index=1;
            statement.setInt( index++, kardexDetailDto.getDetailId() );
            statement.setInt( index++, kardexDetailDto.getProductId() );
            statement.setInt( index++, kardexDetailDto.getStoreId() );
            statement.setInt( index++, kardexDetailDto.getKardexDetailYear() );
            statement.setInt( index++, kardexDetailDto.getKardexDetailMonth() );
            statement.setInt( index++, kardexDetailDto.getKardexDetailday() );

            if (kardexDetailDto.isUserIdNull()) { statement.setNull( index++, java.sql.Types.INTEGER ); }
            else { statement.setInt( index++, kardexDetailDto.getUserId() ); }

            statement.setInt( index++, kardexDetailDto.getDocumentId() );
            statement.setInt( index++, kardexDetailDto.getDocumentNumber() );
            statement.setShort( index++, kardexDetailDto.getOperation() );
            statement.setDouble( index++, kardexDetailDto.getQuantity() );
            statement.setDouble( index++, kardexDetailDto.getUnityValue() );
            statement.setDouble( index++, kardexDetailDto.getTotalValue() );
            statement.setString( index++, kardexDetailDto.getObservations() );
            statement.setShort( index++, kardexDetailDto.getState() );
            statement.setInt( index++, kardexDetailPk.getDetailId() );
            statement.setInt( index++, kardexDetailPk.getProductId() );
            statement.setInt( index++, kardexDetailPk.getStoreId() );
            int rows = statement.executeUpdate();
            reset(kardexDetailDto);
            long t2 = System.currentTimeMillis();
            System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
            return true;
                    
        } catch (Exception exception) { throw new KardexDetailDaoException( "Exception: " + exception.getMessage(), exception );

        } finally {
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }

    /** 
     * Returns a single row from the kardex_detail table that match the criteria 'productId = :productId and storeId = :storeId'.
     * 
     * @param productId
     * @param storeId
     * @return KardexDetailDto[]
     * @throws com.cidenet.hulkstore.kardex.KardexDetailDaoException
     */
    public KardexDetailDto[] findWhereProductIdAndStoreIdEquals(int productId, int storeId) throws KardexDetailDaoException
    {
        return findByDynamicSelect( SQL_SELECT + " WHERE productId = ? and storeId = ?", new Object[] {productId, storeId} );
    }

    /** 
     * Returns the last record of the kardex_detail table that match the criteria 'productId =: productId and storeId =: storeId'.
     * 
     * @param productId
     * @param storeId
     * @return KardexDetailDto
     * @throws com.cidenet.hulkstore.kardex.KardexDetailDaoException 
     */
    public KardexDetailDto findLastKardexDetail(int productId, int storeId) throws KardexDetailDaoException
    {
        KardexDetailDto ret[] = findByDynamicSelect( SQL_SELECT + " WHERE productId = ? and storeId = ?", new Object[] {productId, storeId} );
        return ret[ret.length - 1];
    }

    /**
     * Empty Constructor.
     */
    public KardexDetailDao() {}

    /**
     * Constructor.
     * 
     * @param userConn
     */
    public KardexDetailDao(final java.sql.Connection userConn) { this.userConn = userConn; }

    /** 
     * Sets the value of maxRows.
     * 
     * @param maxRows
     */
    public void setMaxRows(int maxRows) { this.maxRows = maxRows; }

    /** 
     * Gets the value of maxRows.
     * 
     * @return int 
     */
    public int getMaxRows() { return maxRows; }

    /**
     * Returns the name of the table.
     * 
     * @return String
     */
    public String getTableName() { return "bd_hulkstore.kardex_detail"; }

    /** 
     * Fetches a single row from the result set.
     * 
     * @param resultSet
     * @return KardexDetailDto
     * @throws java.sql.SQLException
     */
    protected KardexDetailDto fetchSingleResult(ResultSet resultSet) throws SQLException
    {
        if (resultSet.next()) {
            KardexDetailDto dto = new KardexDetailDto();
            populateDto( dto, resultSet);
            return dto;

        } else { return null; }		
    }

    /** 
     * Fetches multiple rows from the result set.
     * 
     * @param resultSet
     * @return KardexDetailView[]
     * @throws java.sql.SQLException
     */
    protected KardexDetailView[] fetchKardexDetailView(ResultSet resultSet) throws SQLException
    {
        ArrayList resultList = fetchMultiResults(resultSet, true);   
        KardexDetailView kardexDetailView[] = new KardexDetailView[ resultList.size() ];
        resultList.toArray( kardexDetailView );
        return kardexDetailView;
    }

    /** 
     * Fetches multiple rows from the result set.
     * 
     * @param resultSet
     * @return KardexDetailDto
     * @throws java.sql.SQLException
     */
    protected KardexDetailDto[] fetchKardexDetailDto(ResultSet resultSet) throws SQLException
    {
        ArrayList resultList = fetchMultiResults(resultSet, false);   
        KardexDetailDto kardexDetailDto[] = new KardexDetailDto[ resultList.size() ];
        resultList.toArray( kardexDetailDto );
        return kardexDetailDto;
    }

    /** 
     * Fetches multiple rows from the result set.
     * 
     * @param resultSet
     * @param view
     * @return ArrayList
     * @throws java.sql.SQLException 
     */
    protected ArrayList fetchMultiResults(ResultSet resultSet, boolean view) throws SQLException
    {
        ArrayList resultList = new ArrayList();

        while (resultSet.next()) {
            if(view) {
                KardexDetailView kardexDetailView = new KardexDetailView();
                populateKardexDetailView( kardexDetailView, resultSet);
                resultList.add( kardexDetailView );
            } else {
                KardexDetailDto kardexDetailDto = new KardexDetailDto();
                populateDto( kardexDetailDto, resultSet);
                resultList.add( kardexDetailDto );
            }                    
        }            
        return resultList;
    }

    /** 
     * Populates a DTO with data from a ResultSet.
     * 
     * @param kardexDetailDto
     * @param resultSet
     * @throws java.sql.SQLException
     */
    protected void populateDto(KardexDetailDto kardexDetailDto, ResultSet resultSet) throws SQLException
    {
        kardexDetailDto.setDetailId( resultSet.getInt( COLUMN_DETAIL_ID ) );
        kardexDetailDto.setProductId( resultSet.getInt( COLUMN_PRODUCT_ID ) );
        kardexDetailDto.setStoreId( resultSet.getInt( COLUMN_STORE_ID ) );
        kardexDetailDto.setKardexDetailYear( resultSet.getInt( COLUMN_KARDEX_DETAIL_YEAR ) );
        kardexDetailDto.setKardexDetailMonth( resultSet.getInt( COLUMN_KARDEX_DETAIL_MONTH ) );
        kardexDetailDto.setKardexDetailday( resultSet.getInt( COLUMN_KARDEX_DETAILDAY ) );
        kardexDetailDto.setUserId( resultSet.getInt( COLUMN_USER_ID ) );
        if (resultSet.wasNull()) { kardexDetailDto.setUserIdNull( true ); }		
        kardexDetailDto.setDocumentId( resultSet.getInt( COLUMN_DOCUMENT_ID ) );
        kardexDetailDto.setDocumentNumber( resultSet.getInt( COLUMN_DOCUMENT_NUMBER ) );
        kardexDetailDto.setOperation( resultSet.getShort( COLUMN_OPERATION ) );
        kardexDetailDto.setQuantity( resultSet.getDouble( COLUMN_QUANTITY ) );
        kardexDetailDto.setUnityValue( resultSet.getDouble( COLUMN_UNITY_VALUE ) );
        kardexDetailDto.setTotalValue( resultSet.getDouble( COLUMN_TOTAL_VALUE ) );
        kardexDetailDto.setObservations( resultSet.getString( COLUMN_OBSERVATIONS ) );
        kardexDetailDto.setState( resultSet.getShort( COLUMN_STATE ) );
    }

    /** 
     * Populates a DTO with data from a ResultSet.
     * 
     * @param kardexDetailView
     * @param resultSet
     * @throws java.sql.SQLException
     */
    protected void populateKardexDetailView(KardexDetailView kardexDetailView, ResultSet resultSet) throws SQLException
    {
        kardexDetailView.setDetailId( resultSet.getInt( COLUMN_VIEW_DETAIL_ID ) );
        kardexDetailView.setKardexDetailYear( resultSet.getInt( COLUMN_VIEW_KARDEX_DETAIL_YEAR ) );
        kardexDetailView.setKardexDetailMonth( resultSet.getInt( COLUMN_VIEW_KARDEX_DETAIL_MONTH ) );
        kardexDetailView.setKardexDetailday( resultSet.getInt( COLUMN_VIEW_KARDEX_DETAILDAY ) );
        kardexDetailView.setDocumentId( resultSet.getInt( COLUMN_VIEW_DOCUMENT_ID ) );
        kardexDetailView.setDocumentDescription(resultSet.getString( COLUMN_VIEW_DOCUMENT_DESCRIPTION ) );
        kardexDetailView.setDocumentNumber( resultSet.getInt( COLUMN_VIEW_DOCUMENT_NUMBER ) );
        kardexDetailView.setOperation( resultSet.getShort( COLUMN_VIEW_OPERATION ) );
        kardexDetailView.setQuantity( resultSet.getDouble( COLUMN_VIEW_QUANTITY ) );
        kardexDetailView.setUnityValue( resultSet.getDouble( COLUMN_VIEW_UNITY_VALUE ) );
        kardexDetailView.setTotalValue( resultSet.getDouble( COLUMN_VIEW_TOTAL_VALUE ) );
        kardexDetailView.setObservations( resultSet.getString( COLUMN_VIEW_OBSERVATIONS ) );                
        kardexDetailView.setProductId( resultSet.getInt( COLUMN_VIEW_PRODUCT_ID ) );
        kardexDetailView.setStoreId( resultSet.getInt( COLUMN_VIEW_STORE_ID ) );
    }

    /** 
     * Resets the modified attributes in the DTO.
     * 
     * @param kardexDetailDto
     */
    protected void reset(KardexDetailDto kardexDetailDto) {}

    /** 
     * Returns all rows from the kardex_detail table that match the specified arbitrary SQL statement.
     * 
     * @param sql
     * @param sqlParams
     * @return KardexDetailDto[]
     * @throws com.cidenet.hulkstore.kardex.KardexDetailDaoException 
     */
    public KardexDetailDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws KardexDetailDaoException
    {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            // construct the SQL statement
            final String SQL = sql;

            System.out.println( "Executing " + SQL );
            // prepare statement
            statement = connection.prepareStatement( SQL );
            statement.setMaxRows( maxRows );

            // bind parameters
            for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
                statement.setObject( i+1, sqlParams[i] );
            }

            resultSet = statement.executeQuery();

            // fetch the results
            return fetchKardexDetailDto(resultSet);
            
        } catch (Exception exception) { throw new KardexDetailDaoException( "Exception: " + exception.getMessage(), exception );
            
        } finally {
            ResourceManager.close(resultSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }

    /** 
     * Returns all rows from the kardex_detail table that match the specified arbitrary SQL statement.
     * 
     * @param sql
     * @param sqlParams
     * @return KardexDetailDto[]
     * @throws com.cidenet.hulkstore.kardex.KardexDetailDaoException
     */
    public KardexDetailDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws KardexDetailDaoException
    {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            // construct the SQL statement
            final String SQL = SQL_SELECT + " WHERE " + sql;

            System.out.println( "Executing " + SQL );
            // prepare statement
            statement = connection.prepareStatement( SQL );
            statement.setMaxRows( maxRows );

            // bind parameters
            for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
                statement.setObject( i+1, sqlParams[i] );
            }

            resultSet = statement.executeQuery();

            // fetch the results
            return fetchKardexDetailDto(resultSet);
            
        } catch (Exception exception) { throw new KardexDetailDaoException( "Exception: " + exception.getMessage(), exception );
            
        } finally {
            ResourceManager.close(resultSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }
        
    /** 
     * Returns the next available id for the next record.
     * 
     * @return String
     * @throws com.cidenet.hulkstore.kardex.KardexDetailDaoException
     */
    public String findNextDetailId() throws KardexDetailDaoException
    {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            // construct the SQL statement
            final String SQL = "SELECT LPAD((SELECT COUNT(*) + 1 FROM " + getTableName() + "), 6, '0') AS nextDetailId";

            System.out.println( "Executing " + SQL);
            statement = connection.prepareStatement( SQL );

            resultSet = statement.executeQuery();
            resultSet.next();

            return resultSet.getString(1);
        
        } catch (Exception exception) { throw new KardexDetailDaoException( "Exception: " + exception.getMessage(), exception );
        
        } finally {
            ResourceManager.close(resultSet);
            ResourceManager.close(statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }
        
    /**
     * Returns all rows from the kardex detail view.
     * 
     * @param productId
     * @param storeId
     * @return KardexDetailView[]
     * @throws KardexDaoException 
     */
    public KardexDetailView[] getKardexDetailView(int productId, int storeId) throws KardexDaoException
    {
        // declare variables
        final boolean isConnSupplied = (userConn != null);
        Connection connection = null;
        PreparedStatement Statement = null;
        ResultSet resultSet = null;

        try {
            // get the user-specified connection or get a connection from the ResourceManager
            connection = isConnSupplied ? userConn : ResourceManager.getConnection();

            // construct the SQL statement
            final String SQL = "SELECT * FROM bd_hulkstore.vi_kardexdetail WHERE productId = " + productId + " and storeId = " + storeId;


            System.out.println( "Executing " + SQL );
            // prepare statement
            Statement = connection.prepareStatement( SQL );
            Statement.setMaxRows( maxRows );

            resultSet = Statement.executeQuery();

            // fetch the results
            return fetchKardexDetailView(resultSet);

        } catch (Exception exception) { throw new KardexDaoException( "Exception: " + exception.getMessage(), exception );

        } finally {
            ResourceManager.close(resultSet);
            ResourceManager.close(Statement);
            if (!isConnSupplied) { ResourceManager.close(connection); }
        }
    }
}