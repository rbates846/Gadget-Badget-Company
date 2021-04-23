-- MySQL dump 10.13  Distrib 8.0.14, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gadgetbadgetdb
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `buyers`
--

DROP TABLE IF EXISTS `buyers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `buyers` (
  `bno` int NOT NULL AUTO_INCREMENT,
  `buyerID` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` int DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `projectName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`bno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyers`
--

LOCK TABLES `buyers` WRITE;
/*!40000 ALTER TABLE `buyers` DISABLE KEYS */;
INSERT INTO `buyers` VALUES (1,'B001','Rupasinghe','Matara',771234567,'rup@gmail.com','Robo Arm'),(2,'B002','Perera','Colombo',712345677,'perera@gmail.com','water engine');
/*!40000 ALTER TABLE `buyers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fund`
--

DROP TABLE IF EXISTS `fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fund` (
  `fundID` int NOT NULL AUTO_INCREMENT,
  `funderName` varchar(45) NOT NULL,
  `fundResearch` varchar(45) NOT NULL,
  `paymentType` varchar(45) NOT NULL,
  `fundAmount` varchar(45) NOT NULL,
  `fundDesc` varchar(300) NOT NULL,
  `fundDate` varchar(45) NOT NULL,
  PRIMARY KEY (`fundID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fund`
--

LOCK TABLES `fund` WRITE;
/*!40000 ALTER TABLE `fund` DISABLE KEYS */;
INSERT INTO `fund` VALUES (4,'WeHelpYou Company','Robo arm','Cash','60000.0','Paid as three installment','2021-04-22'),(6,'WithYou Company','Electric cart','Cash','150000.0','Second payment finished','2021-04-23'),(7,'ABC Company','Water Engine','Cash','50000.0','Paid as three installments','2021-04-22'),(8,'WithYou Company','Electric cart','Cash','150000.0','Second payment finished','2021-04-23');
/*!40000 ALTER TABLE `fund` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `project` (
  `projectId` int NOT NULL AUTO_INCREMENT,
  `projectCode` varchar(45) NOT NULL,
  `projectName` varchar(45) NOT NULL,
  `projectPrice` varchar(45) NOT NULL,
  `projectDescription` varchar(300) NOT NULL,
  PRIMARY KEY (`projectId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'P001','Water Melon','20000.0','Lower Inflammation and Oxidative Stress'),(2,'P002','Robo cart','200000.0','best robo in sri lanka');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `researchmanagement`
--

DROP TABLE IF EXISTS `researchmanagement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `researchmanagement` (
  `researchId` int NOT NULL AUTO_INCREMENT,
  `researcheName` varchar(45) NOT NULL,
  `researchInstitute` varchar(45) NOT NULL,
  `researchDuration` varchar(45) NOT NULL,
  `researchDescription` varchar(300) NOT NULL,
  PRIMARY KEY (`researchId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `researchmanagement`
--

LOCK TABLES `researchmanagement` WRITE;
/*!40000 ALTER TABLE `researchmanagement` DISABLE KEYS */;
INSERT INTO `researchmanagement` VALUES (1,'Water Engine','SLIIT','4 years','The water engine is a positive-displacement engine, often closely resembling a steam engine with similar pistons and valves, that is driven by water pressure.'),(2,'Robo Arm','abc institute','3 years','A HYSTERESIS BLACK-BOX MODEL OF A SOFT ROBOTIC ARM FEATURING PNEUMATIC ARTIFICIAL MUSCLE'),(3,'ABC','abc institute','2 years','I have a dream');
/*!40000 ALTER TABLE `researchmanagement` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-24  3:06:26
