/* TRIGGERS OF DATA VALIDATION */

/*
Created: 05/11/2019
Modified: 05/11/2019
Model: MySQL 8.0
Database: MySQL 8.0
*/

/* USERS userName, identification, realName, surname */
DELIMITER $$
CREATE TRIGGER TR_RegisterNewUser
	BEFORE INSERT ON USERS FOR EACH ROW
	BEGIN
		IF LENGTH(NEW.userName) = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para identificador';
		ELSEIF LENGTH(NEW.identification) <> 8 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para numero de identificacion';
		ELSEIF LENGTH(NEW.realName) = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para nombres';
		ELSEIF LENGTH(NEW.surname) = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para apellidos';
		END IF;
	END;
$$

/* USERS userName, identification, realName, surname, state, userProfile */
DELIMITER $$
CREATE TRIGGER TR_ModifyUser
	BEFORE UPDATE ON USERS FOR EACH ROW
	BEGIN
		IF LENGTH(NEW.userName) = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para identificador';
		ELSEIF LENGTH(NEW.identification) <> 8 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para numero de identificacion';
		ELSEIF LENGTH(NEW.realName) = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para nombres';
		ELSEIF LENGTH(NEW.surname) = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para apellidos';
		ELSEIF (SELECT COUNT(*) FROM USERS WHERE state = 1 AND userProfile = 1) = 1 AND OLD.userProfile = 1 AND NEW.userProfile = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Debe haber al menos un administrador';
		END IF;
	END;
$$

/* UNITY unityDescription */
DELIMITER $$
CREATE TRIGGER TR_RegisterNewUnity
	BEFORE INSERT ON UNITY FOR EACH ROW
	BEGIN
		IF LENGTH(NEW.unityDescription) = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para descripcion de unidad';       
		END IF;
	END;
$$

/* UNITY unityDescription */
DELIMITER $$
CREATE TRIGGER TR_ModifyUnity
	BEFORE UPDATE ON UNITY FOR EACH ROW
	BEGIN
		IF LENGTH(NEW.unityDescription) = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para descripcion de unidad';
		END IF;
	END;
$$

/* STORE storeName, address */
DELIMITER $$
CREATE TRIGGER TR_RegisterNewStore
	BEFORE INSERT ON STORE FOR EACH ROW
	BEGIN
		IF LENGTH(NEW.storeName) = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para nombre de almacen';
		ELSEIF LENGTH(NEW.address) = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para direccion de almacen';
		END IF;
  END;
$$

/* STORE storeName, address */
DELIMITER $$
CREATE TRIGGER TR_ModifyStore
	BEFORE UPDATE ON STORE FOR EACH ROW
	BEGIN
		IF LENGTH(NEW.storeName) = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para nombre de almacen';
		ELSEIF LENGTH(NEW.address) = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para direccion de almacen';
		END IF;
  END;
$$

/* DOCUMENT documentDescription */
DELIMITER $$  
CREATE TRIGGER TR_RegisterNewDocument
	BEFORE INSERT ON DOCUMENT FOR EACH ROW
	BEGIN
		IF LENGTH(NEW.documentDescription) = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para descripcion de documento';
		END IF;
  END;
$$

/* DOCUMENT documentDescription */
DELIMITER $$
CREATE TRIGGER TR_ModifyDocument
	BEFORE UPDATE ON DOCUMENT FOR EACH ROW
	BEGIN
		IF LENGTH(NEW.documentDescription) = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para descripcion de documento';
		END IF;
	END;
$$

/*PRODUCT productName */
DELIMITER $$  
CREATE TRIGGER TR_RegisterNewProduct
	BEFORE INSERT ON PRODUCT FOR EACH ROW
	BEGIN
		IF LENGTH(NEW.productName) = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para nombre de producto';
		END IF;
  END;
$$

/*PRODUCT productName */
DELIMITER $$
CREATE TRIGGER TR_ModifyProduct
	BEFORE UPDATE ON PRODUCT FOR EACH ROW
	BEGIN
		IF LENGTH(NEW.productName) = 0 THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dato invalido para nombre de producto';
		END IF;
  END;
$$

/*KARDEX_DETAIL kardexDetailYear, kardexDetailMonth, kardexDetailDay, quantity, totalValue */
DELIMITER $$
CREATE TRIGGER TR_RegisterNewKardexDetail
	BEFORE INSERT ON KARDEX_DETAIL FOR EACH ROW
	BEGIN
		SET @numKarDet = (SELECT COUNT(*) FROM KARDEX_DETAIL WHERE (storeId = NEW.storeId AND productId = NEW.productId));
		IF (NEW.kardexDetailYear < 1990) THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Año invalido'; 
		ELSEIF (NEW.kardexDetailMonth > 12 OR NEW.kardexDetailMonth < 1) THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Mes invalido'; 
		ELSEIF (NEW.kardexDetailDay > 31 OR NEW.kardexDetailDay < 1) THEN
				SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dia invalido'; 
		ELSEIF (@numKarDet >= 1)	THEN
			SET @detailYear =(SELECT kardexDetailYear FROM KARDEX_DETAIL WHERE (storeId = NEW.storeId AND productId = NEW.productId) ORDER BY kardexDetailYear DESC, kardexDetailMonth DESC,kardexDetailDay DESC LIMIT 1);
			SET @detailMonth = (SELECT kardexDetailMonth FROM KARDEX_DETAIL WHERE (storeId = NEW.storeId AND productId = NEW.productId) ORDER BY kardexDetailYear DESC, kardexDetailMonth DESC,kardexDetailDay DESC LIMIT 1);
			SET @detailDay = (SELECT kardexDetailDay FROM KARDEX_DETAIL WHERE (storeId = NEW.storeId AND productId = NEW.productId) ORDER BY kardexDetailYear DESC, kardexDetailMonth DESC,kardexDetailDay DESC LIMIT 1);
			
			IF (NEW.kardexDetailYear < @detailYear) THEN
				SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'El año debe de ser mayor al anterior detalle';
			ELSEIF (@detailYear = NEW.kardexDetailYear AND  NEW.kardexDetailMonth < @detailMonth ) THEN
				SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'El mes debe de ser mayor al anterior detalle';
			ELSEIF (@detailYear = NEW.kardexDetailYear AND @detailMonth = NEW.kardexDetailMonth AND  NEW.kardexDetailDay < @detailDay) THEN
				SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'El día debe de ser mayor al anterior detalle';
			END IF;					
		END IF;
        
		IF NEW.operation = 1 THEN
			SET @quantity = (SELECT quantity FROM KARDEX WHERE productId = NEW.productId AND storeId = NEW.storeId) + NEW.quantity ;
            SET @totalValue = (SELECT totalValue FROM KARDEX WHERE productId = NEW.productId AND storeId = NEW.storeId) + NEW.totalValue;            
        ELSE
			SET @quantity = (SELECT quantity FROM KARDEX WHERE productId = NEW.productId AND storeId = NEW.storeId) - NEW.quantity;
            SET @totalValue = (SELECT totalValue FROM KARDEX WHERE productId = NEW.productId AND storeId = NEW.storeId) - NEW.totalValue;
        END IF;
        
        SET @unityValue = @totalValue / @quantity;
		IF (@unityValue IS null) THEN
			SET @unityValue = 0;
		END IF;
		
		IF(@quantity < 0 OR @totalValue < 0 OR @unityValue < 0) THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Cantidad excedida';
    END IF;
	END;
$$

/*KARDEX_DETAIL kardexDetailYear, kardexDetailMonth, kardexDetailDay, quantity, totalValue */
DELIMITER $$
CREATE TRIGGER TR_ModifyKardexDetail
	BEFORE UPDATE ON KARDEX_DETAIL FOR EACH ROW
	BEGIN
		IF (NEW.kardexDetailYear < 1990) THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Año invalido'; 
		ELSEIF (NEW.kardexDetailMonth > 12 OR NEW.kardexDetailMonth < 1) THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Mes invalido'; 
		ELSEIF (NEW.kardexDetailDay > 31 OR NEW.kardexDetailDay < 1) THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Dia invalido'; 
		ELSEIF (OLD.kardexDetailYear > NEW.kardexDetailYear) THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'El año debe de ser mayor al detalle anterior';
		ELSEIF (OLD.kardexDetailYear = NEW.kardexDetailYear AND OLD.kardexDetailMonth > NEW.kardexDetailMonth) THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'El mes debe de ser mayor al detalle anterior';
		ELSEIF (OLD.kardexDetailYear = NEW.kardexDetailYear AND OLD.kardexDetailMonth = NEW.kardexDetailMonth AND OLD.kardexDetailDay > NEW.kardexDetailDay) THEN
			SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'El día debe de ser mayor al detalle anterior';
		END IF;	
		
		IF NEW.state = 1 THEN
			IF OLD.operation = 1 THEN
				SET @quantity = (SELECT quantity FROM KARDEX WHERE productId = NEW.productId AND storeId = NEW.storeId) - OLD.quantity;
				SET @totalValue = (SELECT totalValue FROM KARDEX WHERE productId = NEW.productId AND storeId = NEW.storeId) - OLD.totalValue;
			ELSE
				SET @quantity = (SELECT quantity FROM KARDEX WHERE productId = NEW.productId AND storeId = NEW.storeId) + OLD.quantity ;
				SET @totalValue = (SELECT totalValue FROM KARDEX WHERE productId = NEW.productId AND storeId = NEW.storeId) + OLD.totalValue; 
			END IF;
            
            IF NEW.operation = 1 THEN
				SET @quantity = @quantity + NEW.quantity;
                SET @totalValue = @totalValue + NEW.totalValue;
			ELSE
				SET @quantity = @quantity - NEW.quantity;
                SET @totalValue = @totalValue - NEW.totalValue;
            END IF;
			
            SET @unityValue = @totalValue / @quantity;
			IF (@unityValue IS null) THEN
				SET @unityValue = 0;
			END IF;
            
			IF(@quantity < 0 OR @totalValue < 0 OR @unityValue < 0) THEN
				SIGNAL SQLSTATE '45000' set  MESSAGE_TEXT = 'Cantidad excedida';
			END IF;
    END IF;
	END;
$$