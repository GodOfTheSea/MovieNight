CREATE TABLE Movies (
  id bigserial NOT NULL PRIMARY KEY,
  Type character(10),
  Name character(50),
  Genre character (100),
  Date character (10),
  Wdate character(10),
  Duration character(50),
  StoryLine character (1000),
  Stars character (500),
  Director character(100),
  Episodes int,
  Seasons int,
  Note int,
  Favorit boolean
);

INSERT INTO Filme (Type, Name, Genre, Date, Wdate, Duration, StoryLine, Stars, Director, Seasons, Episodes, Note, Favorit) VALUES ('Series', 'How i met your mother', 'comedy', '20-06-2005', '28-04-2017', '21 minutes', 'how i met ur mother', 'some actors', 'some director', 9, 210, 10, 1);


CREATE TABLE Persons (
  id bigserial NOT NULL PRIMARY KEY,
  FirstName character (50),
  LastName character(50),
  Gender character(100),
  DateofBirth character(100) ,
  Phone character (100),
  Email character (100)
);

INSERT INTO Persons (FirstName, LastName, Gender, DateofBirth, Phone, Email) VALUES ('Cristian', 'Pintea', 'Male', '1994-10-22', '0756608975', 'pintea.cristi94@gmail.com');



CREATE TABLE Persoane (
  id bigserial NOT NULL PRIMARY KEY,
  FirstName character (100),
  LastName character(100),
  Gender character(10),
  DateofBirth character(10),
  Phone character (10),
  Email character (100),
  Password character (100)
);

INSERT INTO Persoane (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin@mail.com', 'pass');
INSERT INTO Persoane (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin@mail.com', 'pass');
INSERT INTO Persoane (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin@mail.com', 'pass');
INSERT INTO Persoane (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin@mail.com', 'pass');
INSERT INTO Persoane (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin@mail.com', 'pass');
INSERT INTO Persoane (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin@mail.com', 'pass');
INSERT INTO Persoane (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin@mail.com', 'pass');
INSERT INTO Persoane (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin@mail.com', 'pass');
INSERT INTO Persoane (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin@mail.com', 'pass');
INSERT INTO Persoane (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin@mail.com', 'pass');