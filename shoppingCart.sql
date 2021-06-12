CREATE DATABASE  IF NOT EXISTS bookstore ;
USE bookstore;

DROP TABLE IF EXISTS shopping_cart;
CREATE TABLE shopping_cart (
  user_name VARCHAR(10) NOT NULL,
  ISBN int(11) NOT NULL,
  quantity int(11) default 1,
  PRIMARY KEY (user_name,ISBN),
  CONSTRAINT shopping_cart_fk FOREIGN KEY (user_name) REFERENCES users (user_name),
  CONSTRAINT shopping_cart_fk1 FOREIGN KEY (ISBN) REFERENCES book(ISBN)
);

