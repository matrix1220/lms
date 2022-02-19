DROP TABLE users;
DROP TABLE books;
DROP TABLE students;
DROP TABLE borrowed_books;
CREATE TABLE users (
	id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	role INT NOT NULL,
	username VARCHAR(30),
	password VARCHAR(30),
	PRIMARY KEY (id)
);
CREATE TABLE students (
	user_id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	fine INT NOT NULL,
	PRIMARY KEY (user_id)
);
CREATE TABLE books (
	id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	title VARCHAR(30) NOT NULL,
	subject VARCHAR(50) NOT NULL,
	author VARCHAR(30) NOT NULL,
	ISBN VARCHAR(30) NOT NULL,
	publish_date VARCHAR(30) NOT NULL,
	PRIMARY KEY (id)
);
CREATE TABLE borrowed_books (
	book_id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	user_id INT NOT NULL,
	start_date INT NOT NULL,
	finish_date INT NOT NULL,
	PRIMARY KEY(book_id,user_id)
	);
INSERT INTO books(title, subject, author, ISBN , publish_date)
VALUES ('Java' , 'CSE' , 'Alan' , '12' , '2012'),
       ('C++' , 'CSE' , 'Robert' , '1231' , '2012'),
       ('C#' , 'Computer' , 'Micheal' , '11232' , '2012');
INSERT INTO borrowed_books(user_id, start_date , finish_date)
VALUES(123,12,232);

INSERT INTO users(role,username, password)
VALUES(1,'username','password'),
      (2 ,'2' ,'2'),
      (3, '3' , '3');



