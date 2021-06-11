CREATE DATABASE  IF NOT EXISTS bookstore ;
USE bookstore;

DROP TABLE IF EXISTS books_categories;

CREATE TABLE books_categories (
  category varchar(45) NOT NULL,
  PRIMARY KEY (category)
) ;