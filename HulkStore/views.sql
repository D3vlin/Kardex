/*
Created: 06/11/2019
Modified: 02/12/2019
Model: MySQL 8.0
Database: MySQL 8.0
*/

/* REPORTS */

CREATE VIEW
VI_Store AS
SELECT S.storeId, S.storeName, S.address, S.state
FROM STORE S
WHERE S.state = 1;

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