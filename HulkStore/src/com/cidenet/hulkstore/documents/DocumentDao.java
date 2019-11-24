package com.cidenet.hulkstore.documents;

public interface DocumentDao
{
	/** 
	 * Inserts a new row in the document table.
	 */
	public DocumentPk insert(DocumentDto dto) throws DocumentDaoException;

	/** 
	 * Updates a single row in the document table.
	 */
	public boolean update(DocumentPk pk, DocumentDto dto) throws DocumentDaoException;

	/** 
	 * Deletes a single row in the document table.
	 */
	public void delete(DocumentPk pk) throws DocumentDaoException;

	/** 
	 * Returns the rows from the document table that matches the specified primary-key value.
	 */
	public DocumentDto findByPrimaryKey(DocumentPk pk) throws DocumentDaoException;

	/** 
	 * Returns all rows from the document table that match the criteria 'documentId = :documentId'.
	 */
	public DocumentDto findByPrimaryKey(int documentId) throws DocumentDaoException;

	/** 
	 * Returns all rows from the document table that match the criteria ''.
	 */
	public DocumentDto[] findAll() throws DocumentDaoException;

	/** 
	 * Returns all rows from the document table that match the criteria 'documentId = :documentId'.
	 */
	public DocumentDto[] findWhereDocumentIdEquals(int documentId) throws DocumentDaoException;

	/** 
	 * Returns all rows from the document table that match the criteria 'documentDescription = :documentDescription'.
	 */
	public DocumentDto[] findWhereDocumentDescriptionEquals(String documentDescription) throws DocumentDaoException;

	/** 
	 * Returns all rows from the document table that match the criteria 'state = :state'.
	 */
	public DocumentDto[] findWhereStateEquals(short state) throws DocumentDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the document table that match the specified arbitrary SQL statement
	 */
	public DocumentDto[] findByDynamicSelect(String sql, Object[] sqlParams) throws DocumentDaoException;

	/** 
	 * Returns all rows from the document table that match the specified arbitrary SQL statement
	 */
	public DocumentDto[] findByDynamicWhere(String sql, Object[] sqlParams) throws DocumentDaoException;
        
        /** 
	 * Returns the next available id for the next record
	 */
        public String findNextDocumentId() throws DocumentDaoException;

}
