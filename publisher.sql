CREATE DATABASE  IF NOT EXISTS bookstore;
USE bookstore;
DROP TABLE IF EXISTS publisher;

CREATE TABLE publisher (
  publisher_name varchar(45) NOT NULL,
  address varchar(100) DEFAULT NULL,
  phone varchar(15) DEFAULT NULL,
  PRIMARY KEY (publisher_name)
);
