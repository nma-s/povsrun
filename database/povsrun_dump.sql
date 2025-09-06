-- MySQL dump 10.13  Distrib 8.0.35, for macos13 (x86_64)
--
-- Host: localhost    Database: povsrun
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `povsrun`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `povsrun` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `povsrun`;

--
-- Table structure for table `event_participants`
--

DROP TABLE IF EXISTS `event_participants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_participants` (
  `event_id` bigint NOT NULL,
  `runner_id` bigint NOT NULL,
  PRIMARY KEY (`event_id`,`runner_id`),
  KEY `FK36vd8kow7sging59yfryoedkb` (`runner_id`),
  CONSTRAINT `FK36vd8kow7sging59yfryoedkb` FOREIGN KEY (`runner_id`) REFERENCES `runners` (`id`),
  CONSTRAINT `FKkehvthjrh10heovf15wdn11u9` FOREIGN KEY (`event_id`) REFERENCES `run_event` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_participants`
--

LOCK TABLES `event_participants` WRITE;
/*!40000 ALTER TABLE `event_participants` DISABLE KEYS */;
INSERT INTO `event_participants` VALUES (1,1),(2,1),(3,1),(4,1),(7,1),(1,2),(3,2),(4,2),(7,2),(1,3),(2,3),(5,3),(6,3),(7,3),(2,4),(3,4),(7,4),(1,5),(2,5),(5,5),(3,6),(7,6),(1,7),(3,7),(4,7),(3,8),(4,8),(5,8),(3,9),(4,9),(1,10),(3,10),(4,10),(5,10),(6,10);
/*!40000 ALTER TABLE `event_participants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_routes`
--

DROP TABLE IF EXISTS `event_routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_routes` (
  `event_id` bigint NOT NULL,
  `route_id` bigint NOT NULL,
  PRIMARY KEY (`event_id`,`route_id`),
  KEY `FKlpwmwbsioe4nwn5qampgdwqw1` (`route_id`),
  CONSTRAINT `FKlpwmwbsioe4nwn5qampgdwqw1` FOREIGN KEY (`route_id`) REFERENCES `routes` (`route_id`),
  CONSTRAINT `FKp2hl26700rg9vta6brnrfxa98` FOREIGN KEY (`event_id`) REFERENCES `run_event` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_routes`
--

LOCK TABLES `event_routes` WRITE;
/*!40000 ALTER TABLE `event_routes` DISABLE KEYS */;
INSERT INTO `event_routes` VALUES (1,100),(2,101),(2,102),(3,103),(3,104),(4,105),(7,106),(5,107),(6,108);
/*!40000 ALTER TABLE `event_routes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route-sequence`
--

DROP TABLE IF EXISTS `route-sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route-sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route-sequence`
--

LOCK TABLES `route-sequence` WRITE;
/*!40000 ALTER TABLE `route-sequence` DISABLE KEYS */;
INSERT INTO `route-sequence` VALUES (109);
/*!40000 ALTER TABLE `route-sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route_via`
--

DROP TABLE IF EXISTS `route_via`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route_via` (
  `route_id` bigint NOT NULL,
  `via_route` varchar(255) DEFAULT NULL,
  KEY `FK1vaxs4ythgmwtp75lymw6tq86` (`route_id`),
  CONSTRAINT `FK1vaxs4ythgmwtp75lymw6tq86` FOREIGN KEY (`route_id`) REFERENCES `routes` (`route_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_via`
--

LOCK TABLES `route_via` WRITE;
/*!40000 ALTER TABLE `route_via` DISABLE KEYS */;
INSERT INTO `route_via` VALUES (100,'Victoria'),(100,'Lambeth Bridge'),(101,'Blackfriars Bridge'),(102,'Vauxhall Bridge'),(102,'Battersea Park'),(103,'Waterloo Bridge'),(103,'Blackfriars Bridge'),(104,'Buckingham Palace'),(104,'Strand'),(105,'Embankment'),(105,'Westminister Bridge'),(106,'Victoria'),(106,'Vauxhall Bridge'),(107,'Battersea Park'),(108,'Hyde Park');
/*!40000 ALTER TABLE `route_via` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routes`
--

DROP TABLE IF EXISTS `routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routes` (
  `route_id` bigint NOT NULL,
  `distance_in_km` float DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `starting_point` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`route_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routes`
--

LOCK TABLES `routes` WRITE;
/*!40000 ALTER TABLE `routes` DISABLE KEYS */;
INSERT INTO `routes` VALUES (100,8,'8K Social Run','Elephant & Castle Square'),(101,7,'7km Social Run','Elephant & Castle Square'),(102,10.5,'10.5km Social Run','Elephant & Castle Square'),(103,8,'8km Social Run','Elephant & Castle Square'),(104,11.5,'11.5km Social Run','Elephant & Castle Square'),(105,7.5,'7.5km Social Run','Elephant & Castle Square'),(106,8,'8km Social Run','Elephant & Castle Square'),(107,5,'Weekend Short Run','Elephant & Castle Square'),(108,16,'Weekend Long Run','Elephant & Castle Square');
/*!40000 ALTER TABLE `routes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `run_event`
--

DROP TABLE IF EXISTS `run_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `run_event` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `day` varchar(255) DEFAULT NULL,
  `month` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `run_event`
--

LOCK TABLES `run_event` WRITE;
/*!40000 ALTER TABLE `run_event` DISABLE KEYS */;
INSERT INTO `run_event` VALUES (1,'2025-06-16','Monday','June','Summer Run June 2025 Week 3'),(2,'2025-06-23','Monday','June','Summer Run June 2025 Week 4'),(3,'2025-06-30','Monday','June','Summer Run June 2025 Week 5'),(4,'2025-07-14','Monday','July','Summer Run July 2025 Week 2'),(5,'2025-07-26','Saturday','July','Summer Run July 2025 Week 3'),(6,'2025-08-16','Saturday','August','Summer Run August 2025 Week 2'),(7,'2025-07-21','Monday','July','Summer Run July 2025 Week 3');
/*!40000 ALTER TABLE `run_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `runners`
--

DROP TABLE IF EXISTS `runners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `runners` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` enum('FEMALE','MALE','OTHER','PREFER_NOT_TO_SAY') DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `runners`
--

LOCK TABLES `runners` WRITE;
/*!40000 ALTER TABLE `runners` DISABLE KEYS */;
INSERT INTO `runners` VALUES (1,'Nicole','FEMALE','Samuels'),(2,'Jerome','MALE','Peters'),(3,'Andrea','FEMALE','Flynn'),(4,'Denzel','MALE','Smith'),(5,'Lauren','FEMALE','Cruz'),(6,'Alex','OTHER','Ponds'),(7,'Martin','MALE','Green'),(8,'Talha','MALE','Ali'),(9,'Caroline','FEMALE','Mendez'),(10,'Raye','OTHER','Charles');
/*!40000 ALTER TABLE `runners` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-06 18:26:59
