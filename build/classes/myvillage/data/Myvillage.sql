


USE MyVillage;

CREATE TABLE Villagers(
    Id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Name VARCHAR(255),
    ImagePath VARCHAR(255),
    DOB DATE,
    Mincome INT,
    Occupation VARCHAR(255),
    Edustat VARCHAR(255),
    Gender VARCHAR(255),
    Bloodgroup VARCHAR(255),
    Email VARCHAR(58) UNIQUE,
    Cell VARCHAR(29) UNIQUE,
    MaritalStat VARCHAR(255),
    HealthStat VARCHAR(255)
    HouseId INT FOREIGN KEY REFERENCES Houses(Id)

);


CREATE TABLE Houses(
    Id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Name VARCHAR(255),
    DOC DATE,
    Fitstat VARCHAR(255),
    Dwellers INT
);




 