CREATE TABLE Movies (
  id bigserial NOT NULL PRIMARY KEY,
  Type character(10),
  Name character(250),
  Genre character (250),
  Date character (10),
  Wdate character(10),
  Duration character(50),
  StoryLine character (10000),
  Actors character (1000),
  Producers character(500),
  Seasons int,
  Episodes int,
  Reviews int,
  Favorite boolean
);

INSERT INTO Movies (Type, Name, Genre, Date, Wdate, Duration, StoryLine, Actors, Producers, Seasons, Episodes, Reviews, Favorite)
 VALUES ('Movie', 'Avatar', 'Action, Adventure, Fantasy', '18-12-2009', '19-06-2017', '2h 42min',
  'A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.',
  'Sam Worthington, Zoe Saldana, Sigourney Weaver', 'James Cameron', 0, 1, 10, TRUE );

INSERT INTO Movies (Type, Name, Genre, Date, Wdate, Duration, StoryLine, Actors, Producers, Seasons, Episodes, Reviews, Favorite)
 VALUES ('Movie', 'Titanic', 'Drama, Romance', '19-12-1997', '28-04-2017', '3h 14min',
  'A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.',
  'Leonardo DiCaprio, Kate Winslet, Billy Zane', 'James Cameron', 0, 1, 10, FALSE );

INSERT INTO Movies (Type, Name, Genre, Date, Wdate, Duration, StoryLine, Actors, Producers, Seasons, Episodes, Reviews, Favorite)
 VALUES ('Series', 'Harry Potter and the Deathly Hallows: Part 2', 'Adventure, Drama, Fantasy', '15-07-2011', '28-04-2017', '2h 10min',
  'Harry, Ron and Hermione search for Voldemort''s remaining Horcruxes in their effort to destroy the Dark Lord as the final battle rages on at Hogwarts.',
  'Daniel Radcliffe, Emma Watson, Rupert Grint', 'David Yates', 0, 8, 10, TRUE );

INSERT INTO Movies (Type, Name, Genre, Date, Wdate, Duration, StoryLine, Actors, Producers, Seasons, Episodes, Reviews, Favorite)
 VALUES ('TV-Series', 'How i met your mother', 'Comedy', '20-06-2005', '28-04-2017', '21 minutes',
  'A father recounts to his children, through a series of flashbacks, the journey he and his four best friends took leading up to him meeting their mother.',
  'Josh Radnor, Jason Segel, Cobie Smulders', 'Carter Bays, Craig Thomas', 9, 210, 10, FALSE );


INSERT INTO Movies (Type, Name, Genre, Date, Wdate, Duration, StoryLine, Actors, Producers, Seasons, Episodes, Reviews, Favorite)
 VALUES ('TV-Series', 'Game of Thrones', 'Adventure, Drama, Fantasy', '17-04-2011', '28-04-2017', '50 minutes',
 'Nine noble families fight for control over the mythical lands of Westeros, while a forgotten race returns after being dormant for thousands of years.',
  'Emilia Clarke, Peter Dinklage, Kit Harington', 'David Benioff, D. B. Weiss', 7, 60, 10, TRUE );

INSERT INTO Movies (Type, Name, Genre, Date, Wdate, Duration, StoryLine, Actors, Producers, Seasons, Episodes, Reviews, Favorite)
 VALUES ('Series', 'Star Wars: The Last Jedi', 'Action, Adventure, Fantasy', '15-12-2017', '-', '-',
  'Having taken her first steps into a larger world in Star Wars: The Force Awakens (2015), Rey continues her epic journey with Finn, Poe and Luke Skywalker in the next chapter of the saga.',
  'Daisy Ridley, John Boyega, Mark Hamill', 'Rian Johnson, George Lucas', 0, 8, 10, FALSE );

INSERT INTO Movies (Type, Name, Genre, Date, Wdate, Duration, StoryLine, Actors, Producers, Seasons, Episodes, Reviews, Favorite)
 VALUES ('TV-Series', 'The Big Bang Theory', 'Comedy, Romance', '01-05-2006', '28-04-2017', '22min',
  'A woman who moves into an apartment across the hall from two brilliant but socially awkward physicists shows them how little they know about life outside of the laboratory.',
  'Johnny Galecki, Jim Parsons, Kaley Cuoco', 'Chuck Lorre, Bill Prady', 12, 280, 10, TRUE );





--
-- CREATE TABLE Persons (
--   id bigserial NOT NULL PRIMARY KEY,
--   FirstName character (50),
--   LastName character(50),
--   Gender character(100),
--   DateofBirth character(100) ,
--   Phone character (100),
--   Email character (100)
-- );

INSERT INTO Persons (FirstName, LastName, Gender, DateofBirth, Phone, Email) VALUES ('Cristian', 'Pintea', 'Male', '1994-10-22', '0756608975', 'pintea.cristi94@gmail.com');



CREATE TABLE Persons (
  id bigserial NOT NULL PRIMARY KEY,
  FirstName character (100),
  LastName character(100),
  Gender character(10),
  DateofBirth character(10),
  Phone character (10),
  Email character (100),
  Password character (100)
);

INSERT INTO Persons (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin1@mail.com', 'pass1');
INSERT INTO Persons (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin2@mail.com', 'pass2');
INSERT INTO Persons (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin3@mail.com', 'pass3');
INSERT INTO Persons (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin4@mail.com', 'pass4');
INSERT INTO Persons (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin5@mail.com', 'pass5');
INSERT INTO Persons (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin6@mail.com', 'pass6');
INSERT INTO Persons (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin7@mail.com', 'pass7');
INSERT INTO Persons (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin8@mail.com', 'pass8');
INSERT INTO Persons (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin9@mail.com', 'pass9');
INSERT INTO Persons (FirstName, LastName, Gender, DateofBirth, Phone, Email, Password) VALUES
 ('Andreas', 'Caro', 'Male', '1992-12-20', '0722391912', 'admin10@mail.com', 'pass10');