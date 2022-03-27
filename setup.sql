CREATE DATABASE platformadb;
USE platformadb;

CREATE TABLE Platform(
	IDPlatform INT PRIMARY KEY,
    NamePlatform VARCHAR(255),
    PricePerMonth DOUBLE
);

CREATE TABLE Category(
	IDCategory INT PRIMARY KEY,
    NameCategory VARCHAR(255)
);

CREATE TABLE Series(
	IDSeries INT PRIMARY KEY,
    NameSeries VARCHAR(255),
    NumberOfSeasons INT,
    IDCategory INT,
    IDPlatform INT,
    FOREIGN KEY (IDCategory) REFERENCES Category(IDCategory),
    FOREIGN KEY (IDPlatform) REFERENCES Platform(IDPlatform)
);

INSERT INTO Platform (IDPlatform, NamePlatform, PricePerMonth)
	VALUES (1, 'Netflix', 7.99);
    
INSERT INTO Platform (IDPlatform, NamePlatform, PricePerMonth)
	VALUES (2, 'HBO GO', 4.99);
    
INSERT INTO Platform (IDPlatform, NamePlatform, PricePerMonth)
	VALUES (3, 'Disney Plus', 8.99);
    
INSERT INTO Category (IDCategory, NameCategory)
	VALUES (1, 'Comedy');
    
INSERT INTO Category (IDCategory, NameCategory)
	VALUES (2, 'Drama');
    
INSERT INTO Category (IDCategory, NameCategory)
	VALUES (3, 'Sci-Fi');
    
SELECT * FROM Platform;
SELECT * FROM Category;
SELECT * FROM Series;

SELECT * FROM Series s INNER JOIN Category c ON s.IDCategory = c.IDCategory WHERE NameCategory = 'Drama';