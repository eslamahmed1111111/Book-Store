CREATE DATABASE  IF NOT EXISTS bookstore;
USE bookstore;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  user_name varchar(10) NOT NULL,
  password varchar(45) NOT NULL,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  phone_number varchar(15) DEFAULT NULL,
  shipping_address varchar(45) DEFAULT NULL,
  privilege varchar(10) DEFAULT 'customer',
  PRIMARY KEY (user_name)
) ;
LOCK TABLES users WRITE;
INSERT INTO users VALUES ('eslam','eslam','eslam','ahmed','eslamahmed@gmail.com','122554','NY','1111');
UNLOCK TABLES;

