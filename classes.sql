DROP DATABASE IF EXISTS `class`;
CREATE DATABASE `class`;
USE `class`;
CREATE TABLE `class` (
`Class_Id` int(11) NOT NULL AUTO_INCREMENT,
`Teacher` varchar(50) NOT NULL,
`Classroom` varchar(50) NOT NULL,
`Status` varchar(50) NOT NULL,
PRIMARY KEY(`Class_Id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;
INSERT INTO `class` VALUES(1,'Hana','H902','READY');
INSERT INTO `class` VALUES(2,'Popa','H421','IN_PROCESS');
INSERT INTO `class` VALUES(3,'Dennis','H711','IN_PROCESS');
INSERT INTO `class` VALUES(4,'Shiri','H505','CLOSED');

