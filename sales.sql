CREATE DATABASE  IF NOT EXISTS bookstore ;
USE bookstore;

DROP TABLE IF EXISTS sales;
CREATE TABLE sales (
  purchase_date datetime NOT NULL,
  user_name varchar(10) NOT NULL,
  ISBN int(11) NOT NULL,
  quantity int(11) DEFAULT NULL,
  PRIMARY KEY (purchase_date,user_name,ISBN),
  KEY sales_username_fk_idx (user_name),
  KEY sales_isbn_fk_idx (ISBN),
  CONSTRAINT sales_isbn_fk FOREIGN KEY (ISBN) REFERENCES book (ISBN),
  CONSTRAINT sales_username_fk FOREIGN KEY (user_name) REFERENCES users (user_name)
) ;
