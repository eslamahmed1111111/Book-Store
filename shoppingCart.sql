CREATE DATABASE  IF NOT EXISTS bookstore ;
USE bookstore;

DROP TABLE IF EXISTS shopping_cart;
CREATE TABLE shopping_cart (
  ID int(11) NOT NULL,
  ISBN int(11) NOT NULL,
  quantity int(11) default 1,
  PRIMARY KEY (ID,ISBN),
<<<<<<< HEAD
  CONSTRAINT shopping_cart_fk FOREIGN KEY (ID) REFERENCES book (ISBN);
)
=======
  CONSTRAINT shopping_cart_fk FOREIGN KEY (ID) REFERENCES book (ISBN)
);
>>>>>>> cdfe7c8d92dd2063eeeced169da10ff5c3be47fc


