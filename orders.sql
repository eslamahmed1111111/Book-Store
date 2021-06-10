CREATE DATABASE  IF NOT EXISTS bookstore ;
USE bookstore;

DROP TABLE IF EXISTS book_orders;
CREATE TABLE book_orders (
  user_name varchar(10) NOT NULL DEFAULT 'eslam',
  ISBN int(11) NOT NULL,
  order_date datetime DEFAULT NULL,
  quantity int(11) DEFAULT '0',
  price integer DEFAULT '0',
  PRIMARY KEY (user_name,ISBN),
  KEY bookorders_isbn_fk_idx (ISBN),
  KEY bookorders_username_fk_idx (user_name),
  CONSTRAINT bookorders_isbn_fk FOREIGN KEY (ISBN) REFERENCES book (ISBN),
  CONSTRAINT bookorders_username_fk FOREIGN KEY (user_name) REFERENCES users (user_name)
)

DELIMITER ;;
CREATE TRIGGER book_orders_BEFORE_DELETE BEFORE DELETE ON book_orders 
FOR EACH ROW BEGIN
UPDATE book SET book.no_copies = (book.no_copies + OLD.quantity) 
where book.ISBN = OLD.ISBN;
END ;;
DELIMITER ;