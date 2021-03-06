CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(20) DEFAULT NULL,
  `LAST_NAME` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`)
);

CREATE TABLE `flight` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FLIGHT_NUMBER` varchar(20) NOT NULL,
  `OPERATING_AIRLINE` varchar(20) NOT NULL,
  `DEPARTURE_CITY` varchar(20) NOT NULL,
  `ARRIVAL_CITY` varchar(20) NOT NULL,
  `DATE_OF_DEPARTURE` date NOT NULL,
  `ESTIMATED_DEPARTURE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `passenger` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(256) DEFAULT NULL,
  `MIDDLE_NAME` varchar(256) DEFAULT NULL,
  `LAST_NAME` varchar(256) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `PHONE` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `reservation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CHECKED_IN` tinyint(1) DEFAULT NULL,
  `NUMBER_OF_BAGS` int(11) DEFAULT NULL,
  `PASSENGER_ID` int(11) DEFAULT NULL,
  `FLIGHT_ID` int(11) DEFAULT NULL,
  `CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `PASSENGER_ID` (`PASSENGER_ID`),
  KEY `FLIGHT_ID` (`FLIGHT_ID`),
  CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`PASSENGER_ID`) REFERENCES `passenger` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`FLIGHT_ID`) REFERENCES `flight` (`ID`)
);

CREATE TABLE role
(
ID INT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(20),
PRIMARY KEY (id)
);

CREATE TABLE user_role
(
user_id int,
role_id int,
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE TABLE document (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  NAME varchar(100) NOT NULL,
  DATA longblob NOT NULL,
  PRIMARY KEY (`ID`)
);