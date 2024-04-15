CREATE TABLE IF NOT EXISTS customer (customerId INT NOT NULL, firstName VARCHAR(255), lastName VARCHAR(255), gender VARCHAR(255), PRIMARY KEY(customerId));
INSERT INTO customer (customerId, firstName, lastName, gender) VALUES ('1', 'Alexis', 'Peralta', 'M');
INSERT INTO customer (customerId, firstName, lastName, gender) VALUES ('2', 'Pedro', 'Camargo', 'M');
INSERT INTO customer (customerId, firstName, lastName, gender) VALUES ('3', 'Xiomara', 'Benites', 'F');
INSERT INTO customer (customerId, firstName, lastName, gender) VALUES ('4', 'Chaparron', 'Bonaparte', 'M');
INSERT INTO customer (customerId, firstName, lastName, gender) VALUES ('5', 'Ramon', 'Castilla', null);