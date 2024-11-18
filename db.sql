drop database if exists se4458midterm;
create database se4458midterm;
use se4458midterm;

drop table if exists Flight;
create table Flight (
	`id` int primary key not null auto_increment,
    `from` varchar(128) not null,
    `to` varchar(128) not null,
    `seat` int not null
);

drop table if exists FlightDates;
create table FlightDates (
	`id` int primary key not null auto_increment,
    `flightID` int not null,
    `date` date not null,
    `bseat` int not null
);

drop table if exists Passenger;
create table Passenger (
	`id` int primary key not null auto_increment,
    `username` varchar(128) not null
);

drop table if exists Ticket;
create table Ticket (
	`id` int primary key not null auto_increment,
    `passengerID` int not null,
    `flightID` int not null,
    `checkedin` tinyint not null
);

-- Flight
DELIMITER $$
CREATE PROCEDURE GenerateFlightData()
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE fromCities VARCHAR(128);
    DECLARE toCities VARCHAR(128);
    DECLARE seat INT;

    WHILE i <= 350 DO
        SET fromCities = CONCAT('City_', FLOOR(1 + (RAND() * 100)));
        SET toCities = CONCAT('City_', FLOOR(101 + (RAND() * 100)));
        SET seat = FLOOR(100 + (RAND() * 101));
        INSERT INTO Flight (id, `from`, `to`, seat)
        VALUES (i, fromCities, toCities, seat);
        SET i = i + 1;
    END WHILE;
END$$
DELIMITER ;

-- FlightDates
DELIMITER $$
CREATE PROCEDURE GenerateFlightDatesData()
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE aFlightID INT;
    DECLARE aDate date;
    DECLARE randomBookedSeat INT;

    WHILE i <= 350 DO
        SET aFlightID = FLOOR(5 + (RAND() * 51));
        SET aDate = DATE_ADD('2023-01-01', INTERVAL FLOOR(RAND() * 365) DAY); -- Random date in 2023
        SET randomBookedSeat = FLOOR(50 + (RAND() * 101));
        INSERT INTO FlightDates (id, `flightID`, `date`, `bseat`)
        VALUES (i, aFlightID, aDate, randomBookedSeat);
        SET i = i + 1;
    END WHILE;
END$$
DELIMITER ;

-- Passenger
DELIMITER $$
CREATE PROCEDURE GeneratePassengerData()
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE aUsername VARCHAR(128);
    WHILE i <= 50 DO
        SET aUsername = CONCAT('Passenger_', FLOOR(101 + (RAND() * 100)));
        INSERT INTO Passenger (id, `username`)
        VALUES (i, aUsername);
        SET i = i + 1;
    END WHILE;
END$$
DELIMITER ;


-- Ticket
DELIMITER $$
CREATE PROCEDURE GenerateTicketData()
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE aPassengerID INT;
    DECLARE aFlightID INT;
    DECLARE aCheckedIn BOOLEAN;
    WHILE i <= 50 DO
        SET aPassengerID = FLOOR(0 + (RAND() * 51));
		SET aFlightID = FLOOR(0 + (RAND() * 151));
		SET aCheckedIn = FLOOR(0 + (RAND() * 2));
        INSERT INTO Ticket (id, `passengerID`, `flightID`, `checkedin`)
        VALUES (i, aPassengerID, aFlightID, aCheckedIn);
        SET i = i + 1;
    END WHILE;
END$$
DELIMITER ;

-- call functions to create datas;
CALL GenerateFlightData();
CALL GenerateFlightDatesData();
CALL GeneratePassengerData();
CALL GenerateTicketData();