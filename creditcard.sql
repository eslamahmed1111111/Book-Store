CREATE DATABASE  IF NOT EXISTS bookstore ;
USE bookstore;

DROP TABLE IF EXISTS creditcard;

CREATE TABLE creditcard (

 card_no  VARCHAR (45) NOT NULL,
 expiry_date  DATE NOT NULL,

 PRIMARY KEY(card_no)
);

INSERT INTO creditcard VALUES('1111' , '2030-01-01');
INSERT INTO creditcard VALUES('0000' , '2030-01-01');
INSERT INTO creditcard VALUES('1234' , '2030-01-01');

