-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: Enade
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `Prova`
--

DROP TABLE IF EXISTS `Prova`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Prova` (
  `idProva` int NOT NULL AUTO_INCREMENT,
  `dataProva` date NOT NULL,
  PRIMARY KEY (`idProva`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prova`
--

LOCK TABLES `Prova` WRITE;
/*!40000 ALTER TABLE `Prova` DISABLE KEYS */;
INSERT INTO `Prova` VALUES (24,'2021-06-30');
/*!40000 ALTER TABLE `Prova` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prova_has_Questao`
--

DROP TABLE IF EXISTS `Prova_has_Questao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Prova_has_Questao` (
  `Prova_idProva` int NOT NULL,
  `Questao_idQuestao` int NOT NULL,
  PRIMARY KEY (`Prova_idProva`,`Questao_idQuestao`),
  KEY `fk_Prova_has_Questao_Questao1_idx` (`Questao_idQuestao`),
  KEY `fk_Prova_has_Questao_Prova1_idx` (`Prova_idProva`),
  CONSTRAINT `fk_Prova_has_Questao_Prova1` FOREIGN KEY (`Prova_idProva`) REFERENCES `Prova` (`idProva`),
  CONSTRAINT `fk_Prova_has_Questao_Questao1` FOREIGN KEY (`Questao_idQuestao`) REFERENCES `Questao` (`idQuestao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prova_has_Questao`
--

LOCK TABLES `Prova_has_Questao` WRITE;
/*!40000 ALTER TABLE `Prova_has_Questao` DISABLE KEYS */;
INSERT INTO `Prova_has_Questao` VALUES (24,12),(24,13),(24,14);
/*!40000 ALTER TABLE `Prova_has_Questao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Questao`
--

DROP TABLE IF EXISTS `Questao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Questao` (
  `idQuestao` int NOT NULL AUTO_INCREMENT,
  `descricaoQuestao` varchar(45) COLLATE utf8_bin NOT NULL,
  `alternativaA` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `alternativaB` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `alternativaC` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `alternativaD` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `alternativaE` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `questaoCorreta` char(1) COLLATE utf8_bin DEFAULT NULL,
  `estadoQuestao` tinyint NOT NULL,
  `TipoQuestao_idTipoQuestao` int NOT NULL,
  PRIMARY KEY (`idQuestao`),
  KEY `fk_Questao_TipoQuestao1_idx` (`TipoQuestao_idTipoQuestao`),
  CONSTRAINT `fk_Questao_TipoQuestao1` FOREIGN KEY (`TipoQuestao_idTipoQuestao`) REFERENCES `TipoQuestao` (`idTipoQuestao`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Questao`
--

LOCK TABLES `Questao` WRITE;
/*!40000 ALTER TABLE `Questao` DISABLE KEYS */;
INSERT INTO `Questao` VALUES (11,'XXXXXXXXX','B','C','D','E','F','E',1,15),(12,'D','A','B','C','D','E','D',1,16),(13,'E','A','B','C','D','E','E',1,16),(14,'A','A','B','C','D','E','A',1,16);
/*!40000 ALTER TABLE `Questao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Resultado`
--

DROP TABLE IF EXISTS `Resultado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Resultado` (
  `idResultado` int NOT NULL AUTO_INCREMENT,
  `valorObtido` double NOT NULL,
  `Usuario_idUsuario` int NOT NULL,
  `Prova_idProva` int NOT NULL,
  PRIMARY KEY (`idResultado`),
  KEY `fk_Resultado_Usuario1_idx` (`Usuario_idUsuario`),
  KEY `fk_Resultado_Prova1_idx` (`Prova_idProva`),
  CONSTRAINT `fk_Resultado_Prova1` FOREIGN KEY (`Prova_idProva`) REFERENCES `Prova` (`idProva`),
  CONSTRAINT `fk_Resultado_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `Usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Resultado`
--

LOCK TABLES `Resultado` WRITE;
/*!40000 ALTER TABLE `Resultado` DISABLE KEYS */;
INSERT INTO `Resultado` VALUES (26,0,28,24),(27,0,28,24),(28,10,30,24);
/*!40000 ALTER TABLE `Resultado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoQuestao`
--

DROP TABLE IF EXISTS `TipoQuestao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TipoQuestao` (
  `idTipoQuestao` int NOT NULL AUTO_INCREMENT,
  `nomeTipoQuestao` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idTipoQuestao`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoQuestao`
--

LOCK TABLES `TipoQuestao` WRITE;
/*!40000 ALTER TABLE `TipoQuestao` DISABLE KEYS */;
INSERT INTO `TipoQuestao` VALUES (15,'Discursiva'),(16,'Múltipla escolha');
/*!40000 ALTER TABLE `TipoQuestao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoUsuario`
--

DROP TABLE IF EXISTS `TipoUsuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TipoUsuario` (
  `idTipoUsuario` int NOT NULL AUTO_INCREMENT,
  `nomeTipoUsuario` varchar(9) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoUsuario`
--

LOCK TABLES `TipoUsuario` WRITE;
/*!40000 ALTER TABLE `TipoUsuario` DISABLE KEYS */;
INSERT INTO `TipoUsuario` VALUES (1,'Professor'),(2,'Aluno');
/*!40000 ALTER TABLE `TipoUsuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) COLLATE utf8_bin NOT NULL,
  `email` varchar(45) COLLATE utf8_bin NOT NULL,
  `senha` varchar(255) COLLATE utf8_bin NOT NULL,
  `TipoUsuario_idTipoUsuario` int NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_Usuario_TipoUsuario_idx` (`TipoUsuario_idTipoUsuario`),
  CONSTRAINT `fk_Usuario_TipoUsuario` FOREIGN KEY (`TipoUsuario_idTipoUsuario`) REFERENCES `TipoUsuario` (`idTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (23,'rtetreter','othon.bruck@hotmail.com','a6fde72c9f644917fa51be5c462083c949e7daf18d384a533ebfd6d288d816c5',1),(24,'dasdasd','xxxx@hotmail.com','2ed46d7bedc17aba18343eac71e21648b1af50fff732af7e338075cd0ed1567a',1),(25,'gfdgfdgfd','xxxx@gmail.com','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',1),(26,'adsadasd','xD@g.com','42b94e1b28f71182c0db4b914b121b27372ea18fd7626aff767a4439efb2dbdd',1),(27,'fdsfdsf','fdsfsd@g.com','a6fde72c9f644917fa51be5c462083c949e7daf18d384a533ebfd6d288d816c5',1),(28,'othon','o@g.com','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',2),(29,'dsds','d@gm.com','a6fde72c9f644917fa51be5c462083c949e7daf18d384a533ebfd6d288d816c5',1),(30,'da','da@gm.com','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',2),(31,'dddd','dd@gmail.com','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',1),(32,'CFDSDFS','a@g.com','91a73fd806ab2c005c13b4dc19130a884e909dea3f72d46e30266fe1a1f588d8',2);
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-28 20:20:08
