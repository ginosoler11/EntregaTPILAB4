-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: recibos
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `legajo` int NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `fecha_ingreso` datetime(6) DEFAULT NULL,
  `fecha_nacimiento` datetime(6) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `sueldo_bruto` float DEFAULT NULL,
  PRIMARY KEY (`legajo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'gino','soler','1999-11-04 00:00:00.000000','2021-10-10 00:00:00.000000','cajero',200000),(2,'moyano','Contador','2022-11-10 21:00:00.000000','2007-02-13 21:00:00.000000','naku',400000),(3,'Pollioto','Deposito','2020-12-26 21:00:00.000000','1999-01-04 21:00:00.000000','Martin',1000000),(4,'Serrano','Gerente','2009-12-26 21:00:00.000000','2007-01-10 21:00:00.000000','Diego',1500000),(5,'mac','burger','2022-11-10 21:00:00.000000','2022-08-23 21:00:00.000000','macdonal',10),(6,'4','facultad','2021-11-10 21:00:00.000000','2019-01-10 21:00:00.000000','lab',9000),(7,'online','Juegos','2022-11-09 21:00:00.000000','1996-09-24 21:00:00.000000','mu',10000000);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-11 20:49:44
