CREATE DATABASE  IF NOT EXISTS bookstore;
USE bookstore;

DROP TABLE IF EXISTS book;

CREATE TABLE book (
  ISBN int(11) NOT NULL,
  title varchar(45) DEFAULT NULL,
  publisher varchar(45) DEFAULT NULL,
  author varchar(45) DEFAULT NULL,
  publication_year year(4) DEFAULT NULL,
  price integer DEFAULT NULL,
  category varchar(45) DEFAULT NULL,
  no_copies int(5) DEFAULT NULL,
  threshold_quantity int(5) DEFAULT NULL,
  PRIMARY KEY (ISBN),
  KEY books_pub_fk_idx (publisher),
  KEY books_cat_fk_idx (category),
  CONSTRAINT books_cat_fk FOREIGN KEY (category) REFERENCES books_categories (category),
  CONSTRAINT books_pub_fk FOREIGN KEY (publisher) REFERENCES publisher (publisher_name)
);

DELIMITER ;;
 CREATE TRIGGER books_BEFORE_INSERT BEFORE INSERT ON book
 FOR EACH ROW BEGIN
 IF ( NEW.no_copies < NEW.threshold_quantity) THEN
   SIGNAL SQLSTATE '45000'
   SET MESSAGE_TEXT = 'NO OF COPIES INSERTED CANNOT BE LESS THAN THE THRESHOLD';
END IF;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE TRIGGER books_BEFORE_UPDATE BEFORE UPDATE ON book
FOR EACH ROW BEGIN
IF (NEW.no_copies < 0) THEN
   SIGNAL SQLSTATE '45000'
   SET MESSAGE_TEXT = 'NO OF COPIES CANNOT BE NEGATIVE';
END IF;
END ;;
DELIMITER ;
 
 DELIMITER ;;
 CREATE TRIGGER books_AFTER_UPDATE AFTER UPDATE ON book
 FOR EACH ROW BEGIN
 DECLARE i INT DEFAULT 0;
  IF (OLD.no_copies >= NEW.threshold_quantity && NEW.no_copies < NEW.threshold_quantity) THEN
    IF (NEW.no_copies < 4) THEN
       SET i = 4;
    END IF;
    insert into book_orders (ISBN,order_date,quantity,price) values
    (NEW.ISBN,NOW(),NEW.threshold_quantity + i, NEW.price * (NEW.threshold_quantity + i));
END IF;
END ;;
DELIMITER ;




