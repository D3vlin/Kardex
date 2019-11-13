/* DATA DUMP */

-- Stores
INSERT INTO store VALUES(DEFAULT, 'MaxPower', 'Carrera 20', 1);
INSERT INTO store VALUES(DEFAULT, 'IronShop', 'Avenida 3', 1);

-- Unities
INSERT INTO UNITY VALUES(DEFAULT, 'unidades', 1);
INSERT INTO UNITY VALUES(DEFAULT, 'cajas', 1);
INSERT INTO UNITY VALUES(DEFAULT, 'camisetas', 1);
INSERT INTO UNITY VALUES(DEFAULT, 'vasos', 1);
INSERT INTO UNITY VALUES(DEFAULT, 'comics', 1);

-- Documents
INSERT INTO DOCUMENT VALUES(DEFAULT, 'Factura', 1);

-- Creation of users
INSERT INTO USERS VALUES(DEFAULT, 'admin', MD5('admin'), '00000000', 'Admin', 'Master', 1, 1);
INSERT INTO USERS VALUES(DEFAULT, 'user', MD5('user'), '11111111', 'User', 'Standar', 0, 1);