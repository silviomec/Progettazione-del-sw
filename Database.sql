-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: db_pds
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `canoni`
--

DROP TABLE IF EXISTS `canoni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `canoni` (
  `idcanone` int NOT NULL AUTO_INCREMENT,
  `importoAnnuale` decimal(6,2) NOT NULL,
  `scadenza` date NOT NULL,
  `saldato` tinyint(1) NOT NULL,
  `INSERZIONISTA` varchar(16) DEFAULT NULL,
  `STRUTTURATURISTICA` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`idcanone`),
  UNIQUE KEY `idcanone_UNIQUE` (`idcanone`),
  KEY `INSERZIONISTA_idx` (`INSERZIONISTA`),
  KEY `STRUTTURATURISTICA_idx` (`STRUTTURATURISTICA`),
  CONSTRAINT `canoni_INSERZIONISTA` FOREIGN KEY (`INSERZIONISTA`) REFERENCES `inserzionisti` (`codiceFiscale`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `canoni_STRUTTURATURISTICA` FOREIGN KEY (`STRUTTURATURISTICA`) REFERENCES `struttureturistiche` (`PartitaIva`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canoni`
--

LOCK TABLES `canoni` WRITE;
/*!40000 ALTER TABLE `canoni` DISABLE KEYS */;
INSERT INTO `canoni` VALUES (1,125.00,'2021-09-13',0,'LMPRTI99B65A783J','47654387986'),(2,125.00,'2022-05-01',1,'MCCSLV98M11A783F','12345678911'),(3,125.00,'2022-07-02',1,'LMPRTI99B65A783J','69745223097'),(4,125.00,'2022-11-16',1,'DTMKNL98L02A783Z','77777777777'),(5,125.00,'2022-11-17',1,'DTMKNL98L02A783Z','12345678901');
/*!40000 ALTER TABLE `canoni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clienti`
--

DROP TABLE IF EXISTS `clienti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clienti` (
  `codiceFiscale` char(16) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codiceFiscale`),
  UNIQUE KEY `telefono_UNIQUE` (`telefono`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clienti`
--

LOCK TABLES `clienti` WRITE;
/*!40000 ALTER TABLE `clienti` DISABLE KEYS */;
INSERT INTO `clienti` VALUES ('DTMKNL98L02A783Z','Kevin Luca','De Toma','388777','k.detoma@studenti.unisannio.it'),('LMPRTI99B65A783J','Rita','Lamparelli','7776724231','r.l@email.it'),('LPOPNE98R03A784R','Pene','Lope','329y678909','PENElope@outlook.it'),('RSSMRC98E01A783A','Marco','Rossi','7770491329','m.rossi@email.it');
/*!40000 ALTER TABLE `clienti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dipendenti`
--

DROP TABLE IF EXISTS `dipendenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dipendenti` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `codiceFiscale` char(16) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `codiceFiscale_UNIQUE` (`codiceFiscale`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `telefono_UNIQUE` (`telefono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dipendenti`
--

LOCK TABLES `dipendenti` WRITE;
/*!40000 ALTER TABLE `dipendenti` DISABLE KEYS */;
INSERT INTO `dipendenti` VALUES ('ricchan','buba','LMPRTI99B65A783J','Rita','Lampa','777347','ritalamp@email.it');
/*!40000 ALTER TABLE `dipendenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inserzioni`
--

DROP TABLE IF EXISTS `inserzioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inserzioni` (
  `idInserzione` int NOT NULL AUTO_INCREMENT,
  `titolo` varchar(45) NOT NULL,
  `descrizione` varchar(200) NOT NULL,
  `prezzoPerNotte` decimal(6,2) unsigned zerofill NOT NULL,
  `numeroPersone` int NOT NULL,
  `dataInizio` date NOT NULL,
  `dataFine` date NOT NULL,
  `STRUTTURATURISTICA` varchar(11) DEFAULT NULL,
  `INSERZIONISTA` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`idInserzione`),
  UNIQUE KEY `idInserzioni_UNIQUE` (`idInserzione`),
  KEY `STRUTTURATURISTICA_` (`STRUTTURATURISTICA`),
  KEY `INSERZIONISTA_idx` (`INSERZIONISTA`),
  CONSTRAINT `inserzioni_INSERZIONISTA` FOREIGN KEY (`INSERZIONISTA`) REFERENCES `inserzionisti` (`codiceFiscale`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `inserzioni_STRUTTURATURISTICA` FOREIGN KEY (`STRUTTURATURISTICA`) REFERENCES `struttureturistiche` (`PartitaIva`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `numeroPersone` CHECK ((`numeroPersone` >= 0)),
  CONSTRAINT `prezzoPerNotte` CHECK ((`prezzoPerNotte` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inserzioni`
--

LOCK TABLES `inserzioni` WRITE;
/*!40000 ALTER TABLE `inserzioni` DISABLE KEYS */;
INSERT INTO `inserzioni` VALUES (1,'Hotel Rabona','Camera Matrimoniale',0070.00,2,'2021-08-08','2021-08-20','69745223097','LMPRTI99B65A783J'),(2,'marta','ampia camera',0060.00,3,'2021-10-19','2021-10-26','12345678901','DTMKNL98L02A783Z');
/*!40000 ALTER TABLE `inserzioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inserzionisti`
--

DROP TABLE IF EXISTS `inserzionisti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inserzionisti` (
  `codiceFiscale` char(16) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codiceFiscale`),
  UNIQUE KEY `telefono_UNIQUE` (`telefono`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inserzionisti`
--

LOCK TABLES `inserzionisti` WRITE;
/*!40000 ALTER TABLE `inserzionisti` DISABLE KEYS */;
INSERT INTO `inserzionisti` VALUES ('DTMKNL98L02A783Z','Kevin Luca','De Toma','388777','k.detoma@studenti.unisannio.it'),('LMPRTI99B65A783J','Rita','Lamp','777','rita@hot.it'),('MCCSLV98M11A783F','Silvio','Mecchella','456','ok@okok.it');
/*!40000 ALTER TABLE `inserzionisti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazioni`
--

DROP TABLE IF EXISTS `prenotazioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazioni` (
  `idprenotazione` int NOT NULL AUTO_INCREMENT,
  `dataArrivo` date NOT NULL,
  `dataPartenza` date NOT NULL,
  `prezzoTotale` decimal(7,2) NOT NULL,
  `CLIENTE` varchar(16) DEFAULT NULL,
  `INSERZIONE` int DEFAULT NULL,
  `STRUTTURATURISTICA` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`idprenotazione`),
  UNIQUE KEY `idprenotazioni_UNIQUE` (`idprenotazione`),
  KEY `prenotazioni_CLIENTE_idx` (`CLIENTE`),
  KEY `prenotazioni_INSERZIONE_idx` (`INSERZIONE`),
  KEY `prenotazioni_STRUTTURATURISTICA_idx` (`STRUTTURATURISTICA`),
  CONSTRAINT `prenotazioni_CLIENTE` FOREIGN KEY (`CLIENTE`) REFERENCES `clienti` (`codiceFiscale`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `prenotazioni_INSERZIONE` FOREIGN KEY (`INSERZIONE`) REFERENCES `inserzioni` (`idInserzione`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `prenotazioni_STRUTTURATURISTICA` FOREIGN KEY (`STRUTTURATURISTICA`) REFERENCES `struttureturistiche` (`PartitaIva`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `prenotazioni_chk_1` CHECK ((`dataPartenza` > `dataArrivo`)),
  CONSTRAINT `prenotazioni_chk_2` CHECK ((`prezzoTotale` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazioni`
--

LOCK TABLES `prenotazioni` WRITE;
/*!40000 ALTER TABLE `prenotazioni` DISABLE KEYS */;
INSERT INTO `prenotazioni` VALUES (1,'2020-01-01','2020-01-10',600.00,'LMPRTI99B65A783J',1,'69745223097'),(2,'2021-11-23','2021-11-30',300.00,'DTMKNL98L02A783Z',2,'12345678901');
/*!40000 ALTER TABLE `prenotazioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ricevutepagamentocanoni`
--

DROP TABLE IF EXISTS `ricevutepagamentocanoni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ricevutepagamentocanoni` (
  `idPagamentoCanone` int NOT NULL AUTO_INCREMENT,
  `importo` decimal(6,2) NOT NULL,
  `dataPagamento` date NOT NULL,
  `CANONE` int DEFAULT NULL,
  `INSERZIONISTA` char(16) DEFAULT NULL,
  `STRUTTURATURISTICA` char(11) DEFAULT NULL,
  PRIMARY KEY (`idPagamentoCanone`),
  UNIQUE KEY `idPagamentoCanone_UNIQUE` (`idPagamentoCanone`),
  KEY `CANONE_idx` (`CANONE`),
  KEY `pagamento_INSERZIONISTA_idx` (`INSERZIONISTA`),
  KEY `pagamento_STRUTTURATURISTICA_idx` (`STRUTTURATURISTICA`),
  CONSTRAINT `pagamento_CANONE` FOREIGN KEY (`CANONE`) REFERENCES `canoni` (`idcanone`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `pagamento_INSERZIONISTA` FOREIGN KEY (`INSERZIONISTA`) REFERENCES `inserzionisti` (`codiceFiscale`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `pagamento_STRUTTURATURISTICA1` FOREIGN KEY (`STRUTTURATURISTICA`) REFERENCES `struttureturistiche` (`PartitaIva`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `ricevutepagamentocanoni_chk_1` CHECK ((`importo` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ricevutepagamentocanoni`
--

LOCK TABLES `ricevutepagamentocanoni` WRITE;
/*!40000 ALTER TABLE `ricevutepagamentocanoni` DISABLE KEYS */;
INSERT INTO `ricevutepagamentocanoni` VALUES (1,125.00,'2020-09-13',1,'LMPRTI99B65A783J','47654387986'),(2,125.00,'2021-05-01',2,'MCCSLV98M11A783F','12345678911'),(3,125.00,'2021-07-02',3,'LMPRTI99B65A783J','69745223097');
/*!40000 ALTER TABLE `ricevutepagamentocanoni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ricevutepagamentoprenotazioni`
--

DROP TABLE IF EXISTS `ricevutepagamentoprenotazioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ricevutepagamentoprenotazioni` (
  `idpagamentoPrenotazione` int NOT NULL AUTO_INCREMENT,
  `importo` decimal(6,2) NOT NULL,
  `dataPagamento` date NOT NULL,
  `PRENOTAZIONE` int DEFAULT NULL,
  `CLIENTE` char(16) DEFAULT NULL,
  `STRUTTURATURISTICA` char(11) DEFAULT NULL,
  PRIMARY KEY (`idpagamentoPrenotazione`),
  UNIQUE KEY `idpagamentoPrenotazione_UNIQUE` (`idpagamentoPrenotazione`),
  KEY `PRENOTAZIONE_idx` (`PRENOTAZIONE`),
  KEY `pagamento_CLIENTE_idx` (`CLIENTE`),
  KEY `pagamento_STRUTTURATURISTICA2` (`STRUTTURATURISTICA`),
  CONSTRAINT `pagamento_CLIENTE` FOREIGN KEY (`CLIENTE`) REFERENCES `clienti` (`codiceFiscale`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `pagamento_PRENOTAZIONE` FOREIGN KEY (`PRENOTAZIONE`) REFERENCES `prenotazioni` (`idprenotazione`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `pagamento_STRUTTURATURISTICA2` FOREIGN KEY (`STRUTTURATURISTICA`) REFERENCES `struttureturistiche` (`PartitaIva`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `ricevutepagamentoprenotazioni_chk_1` CHECK ((`importo` > 0))
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ricevutepagamentoprenotazioni`
--

LOCK TABLES `ricevutepagamentoprenotazioni` WRITE;
/*!40000 ALTER TABLE `ricevutepagamentoprenotazioni` DISABLE KEYS */;
INSERT INTO `ricevutepagamentoprenotazioni` VALUES (1,600.00,'2020-01-01',1,'LMPRTI99B65A783J','69745223097'),(2,300.00,'2021-11-23',2,'DTMKNL98L02A783Z','12345678901');
/*!40000 ALTER TABLE `ricevutepagamentoprenotazioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `struttureturistiche`
--

DROP TABLE IF EXISTS `struttureturistiche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `struttureturistiche` (
  `PartitaIva` varchar(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `stelle` enum('1','2','3','4','5') NOT NULL,
  `tipologia` enum('Hotel','B&B','Residence','Ostello') NOT NULL,
  `indirizzo` varchar(100) NOT NULL,
  `INSERZIONISTA` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`PartitaIva`),
  KEY `struttureturistiche_INSERZIONISTA_idx` (`INSERZIONISTA`),
  CONSTRAINT `struttureturistiche_INSERZIONISTA` FOREIGN KEY (`INSERZIONISTA`) REFERENCES `inserzionisti` (`codiceFiscale`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `struttureturistiche`
--

LOCK TABLES `struttureturistiche` WRITE;
/*!40000 ALTER TABLE `struttureturistiche` DISABLE KEYS */;
INSERT INTO `struttureturistiche` VALUES ('12345678901','KINKY university','3','Ostello','dove sta il campetto Mellusi','DTMKNL98L02A783Z'),('12345678911','Cremlino','5','Hotel','Moscow , Putin Plaza 1','MCCSLV98M11A783F'),('47654387986','Rituccia','5','B&B','Benevento','LMPRTI99B65A783J'),('69745223097','Hotel Rabona','4','Hotel','Via dei mariuoli 5 bn','LMPRTI99B65A783J'),('77777777777','Korenji','4','Residence','Via delle Arance, 7','DTMKNL98L02A783Z');
/*!40000 ALTER TABLE `struttureturistiche` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-23 19:14:46
