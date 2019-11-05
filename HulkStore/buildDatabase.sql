DROP DATABASE IF EXISTS BD_HULKSTORE;
CREATE DATABASE BD_HULKSTORE;
USE BD_HULKSTORE;
/*
Created: 05/11/2019
Modified: 05/11/2019
Model: MySQL 8.0
Database: MySQL 8.0
*/

-- Create tables section -------------------------------------------------

-- Table PRODUCTO

CREATE TABLE PRODUCT
(
  productId Int(6) ZEROFILL NOT NULL AUTO_INCREMENT,
  productName Varchar(50) NOT NULL,
  unityId Int(3) ZEROFILL,
  state Tinyint(1) NOT NULL DEFAULT 1,
 PRIMARY KEY (productId)
)
;

CREATE INDEX idx_unityId ON PRODUCT (unityId)
;

-- Table KARDEX

CREATE TABLE KARDEX
(
  productId Int(6) ZEROFILL NOT NULL,
  storeId Int(6) ZEROFILL NOT NULL,
  quantity Double(9,2) NOT NULL,
  unityValue Double(9,2) NOT NULL,
  totalValue Double(9,2),
  state Tinyint(1) NOT NULL DEFAULT 1
)
;

ALTER TABLE KARDEX ADD PRIMARY KEY (productId,storeId)
;

-- Table KARDEX_DETAIL

CREATE TABLE KARDEX_DETAIL
(
  detailId Int(6) ZEROFILL NOT NULL AUTO_INCREMENT,
  productId Int(6) ZEROFILL NOT NULL,
  storeId Int(6) ZEROFILL NOT NULL,
  kardexDetailYear Int(2) ZEROFILL NOT NULL,
  kardexDetailMonth Int(2) ZEROFILL NOT NULL,
  kardexDetailday Int(2) ZEROFILL NOT NULL,
  userId Int(6) ZEROFILL,
  documentId Int(6) ZEROFILL NOT NULL,
  documentNumber Int(11) NOT NULL,
  operation Bool NOT NULL,
  quantity Double(9,2) NOT NULL,
  unityValue Double(9,2) NOT NULL,
  totalValue Double(9,2) NOT NULL,
  observations Varchar(100),
  state Tinyint(1) NOT NULL DEFAULT 1,
 PRIMARY KEY (detailId,productId,storeId)
)
;

CREATE INDEX idx_userId ON KARDEX_DETAIL (userId)
;

CREATE INDEX idx_documentId ON KARDEX_DETAIL (documentId)
;

-- Table STORE

CREATE TABLE STORE
(
  storeId Int(6) ZEROFILL NOT NULL AUTO_INCREMENT,
  storeName Varchar(20) NOT NULL,
  address Varchar(40) NOT NULL,
  state Tinyint(1) NOT NULL DEFAULT 1,
 PRIMARY KEY (storeId)
)
;

-- Table UNITY

CREATE TABLE UNITY
(
  unityId Int(3) ZEROFILL NOT NULL AUTO_INCREMENT,
  unityDescription Varchar(20) NOT NULL,
  state Tinyint(1) NOT NULL DEFAULT 1,
 PRIMARY KEY (unityId)
)
;

-- Table DOCUMENT

CREATE TABLE DOCUMENT
(
  documentId Int(6) ZEROFILL NOT NULL AUTO_INCREMENT,
  documentDescription Text NOT NULL,
  state Tinyint(1) NOT NULL DEFAULT 1,
 PRIMARY KEY (documentId)
)
;

-- Table USER

CREATE TABLE USERS
(
  userId Int(6) ZEROFILL NOT NULL AUTO_INCREMENT,
  userName Varchar(32) NOT NULL,
  userPass Char(32) NOT NULL,
  identification Char(8) NOT NULL,
  realName Varchar(40) NOT NULL,
  surname Varchar(40) NOT NULL,
  userProfile Bool NOT NULL DEFAULT 0,
  state Tinyint(1) NOT NULL,
 PRIMARY KEY (userId)
)
;

ALTER TABLE USERS ADD UNIQUE userName (userName)
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE PRODUCT ADD CONSTRAINT fk_product_unity FOREIGN KEY (unityId) REFERENCES UNITY (unityId) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE KARDEX ADD CONSTRAINT fk_kardex_product FOREIGN KEY (productId) REFERENCES PRODUCT (productId) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE KARDEX ADD CONSTRAINT fk_kardex_store FOREIGN KEY (storeId) REFERENCES STORE (storeId) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE KARDEX_DETAIL ADD CONSTRAINT fk_kardexDetail_kardex FOREIGN KEY (productId, storeId) REFERENCES KARDEX (productId, storeId) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE KARDEX_DETAIL ADD CONSTRAINT fk_kardexDetail_document FOREIGN KEY (documentId) REFERENCES DOCUMENT (documentId) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE KARDEX_DETAIL ADD CONSTRAINT fk_kardexDetail_users FOREIGN KEY (userId) REFERENCES USERS (userId) ON DELETE NO ACTION ON UPDATE NO ACTION
;