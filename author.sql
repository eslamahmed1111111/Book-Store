CREATE DATABASE  IF NOT EXISTS bookstore ;
USE bookstore;

DROP TABLE IF EXISTS book_author;
CREATE TABLE book_author (
  ISBN int(11) NOT NULL,
  author_name varchar(45) NOT NULL,
  PRIMARY KEY (ISBN,author_name),
  CONSTRAINT bookauthors_isbn_fk FOREIGN KEY (ISBN) REFERENCES book (ISBN)
) ;
