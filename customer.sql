CREATE DATABASE  IF NOT EXISTS bookstore;
USE bookstore;
DROP TABLE IF EXISTS users;

CREATE TABLE customer (
  user_name varchar(10) NOT NULL,
  customer_id varchar(10) NOT NULL UNIQUE,
  PRIMARY KEY (user_name,customer_id),
  CONSTRAINT user_nameisforeignkey FOREIGN KEY (user_name) REFERENCES users (user_name)
) ;

