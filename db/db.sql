-- MySQL dump 10.13  Distrib 5.7.15, for osx10.11 (x86_64)
--
-- Host: localhost    Database: NEGOCMERC
-- ------------------------------------------------------
-- Server version	5.7.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `NEGOCMERC`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `NEGOCMERC` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `NEGOCMERC`;

--
-- Table structure for table `MERCADORIA`
--

DROP TABLE IF EXISTS `MERCADORIA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MERCADORIA` (
  `cd_mercadoria` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nm_mercadoria` varchar(200) NOT NULL,
  `tp_mercadoria` varchar(120) NOT NULL,
  PRIMARY KEY (`cd_mercadoria`),
  UNIQUE KEY `cd_mercadoria_UNIQUE` (`cd_mercadoria`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MERCADORIA`
--

LOCK TABLES `MERCADORIA` WRITE;
/*!40000 ALTER TABLE `MERCADORIA` DISABLE KEYS */;
INSERT INTO `MERCADORIA` VALUES (12,'Arroz','Alimento'),(13,'Feijão','Alimento'),(14,'Salada','Alimento'),(15,'Macarrão','Alimento');
/*!40000 ALTER TABLE `MERCADORIA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OPERACAO`
--

DROP TABLE IF EXISTS `OPERACAO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OPERACAO` (
  `cd_operacao` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `vl_preco` double NOT NULL,
  `vl_quantidade` int(10) NOT NULL,
  `tp_operacao` varchar(45) NOT NULL,
  `cd_mercadoria` int(10) unsigned NOT NULL,
  PRIMARY KEY (`cd_operacao`),
  UNIQUE KEY `cd_operacao_UNIQUE` (`cd_operacao`),
  KEY `cd_mercadoria_idx` (`cd_mercadoria`),
  CONSTRAINT `cd_mercadoria` FOREIGN KEY (`cd_mercadoria`) REFERENCES `MERCADORIA` (`cd_mercadoria`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OPERACAO`
--

LOCK TABLES `OPERACAO` WRITE;
/*!40000 ALTER TABLE `OPERACAO` DISABLE KEYS */;
INSERT INTO `OPERACAO` VALUES (8,4.6,4,'VENDA',12);
/*!40000 ALTER TABLE `OPERACAO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-03 18:38:56
