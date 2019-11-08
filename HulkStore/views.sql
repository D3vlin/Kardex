/*
Created: 06/11/2019
Modified: 06/11/2019
Model: MySQL 8.0
Database: MySQL 8.0
*/

/* CONSULTS */

CREATE VIEW
VI_ProductStoreQuantity AS
SELECT K.productId, K.storeId, S.storeName, K.quantity
FROM KARDEX AS K
INNER JOIN PRODUCT AS P
ON P.productId = K.productId
INNER JOIN STORE AS S
ON S.storeId = K.storeId;

CREATE VIEW
VI_ProductEntry AS
SELECT KD.productId, KD.storeId, S.storeName, KD.quantity, KD.kardexDetailYear, KD.kardexDetailMonth, KD.kardexDetailday
FROM KARDEX_DETAIL AS KD
INNER JOIN PRODUCT AS P
ON P.productId = KD.productId
INNER JOIN STORE AS S
ON S.storeId = KD.storeId
WHERE KD.operation = 1 AND KD.state = 1;

CREATE VIEW
VI_ProductOutput AS
SELECT KD.productId, KD.storeId, S.storeName, KD.quantity, KD.kardexDetailYear, KD.kardexDetailMonth, KD.kardexDetailday
FROM KARDEX_DETAIL AS KD
INNER JOIN PRODUCT AS P
ON P.productId = KD.productId
INNER JOIN STORE AS S
ON S.storeId = KD.storeId
WHERE KD.operation = 0 AND KD.state = 1;

/* REPORTS */

CREATE VIEW
VI_Store AS
SELECT storeId, storeName, address
FROM STORE
WHERE state = 1;

CREATE VIEW
VI_Product AS
SELECT P.productId, P.productName, U.unityDescription
FROM PRODUCT AS P
INNER JOIN UNITY AS U
ON P.unityId = U.unityId
WHERE P.state = 1;

CREATE VIEW
VI_Kardex AS
SELECT K.productId, P.productName, U.unityDescription, K.storeId, S.storeName, K.quantity, K.unityValue
FROM KARDEX AS K
INNER JOIN PRODUCT AS P
ON P.productId = K.productId
INNER JOIN STORE AS S
ON S.storeId = K.storeId
INNER JOIN UNITY AS U
ON U.unityId = P.unityId
WHERE K.state = 1;

CREATE VIEW
VI_KardexDetail AS
SELECT KD.detailId, KD.productId, KD.storeId, KD.kardexDetailYear, KD.kardexDetailMonth, KD.kardexDetailday, D.documentId, KD.documentNumber, KD.operation, KD.quantity, KD.unityValue, KD.totalValue, KD.observations
FROM KARDEX_DETAIL AS KD
INNER JOIN DOCUMENT AS D
ON KD.documentId = D.documentId
WHERE KD.state = 1;