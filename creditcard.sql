CREATE DATABASE  IF NOT EXISTS bookstore ;
USE bookstore;

DROP TABLE IF EXISTS creditcard;

CREATE TABLE creditcard (

 card_no  VARCHAR (45) NOT NULL,
 expiry_date  DATE NOT NULL,

 PRIMARY KEY(card_no)
);


