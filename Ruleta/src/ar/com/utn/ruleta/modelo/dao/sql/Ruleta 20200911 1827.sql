-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.13-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema ruleta
--

CREATE DATABASE IF NOT EXISTS ruleta;
USE ruleta;

--
-- Definition of table `apuestas`
--

DROP TABLE IF EXISTS `apuestas`;
CREATE TABLE `apuestas` (
  `APU_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `JUG_ID` int(10) unsigned NOT NULL,
  `APU_RONDA` int(11) NOT NULL,
  PRIMARY KEY (`APU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `apuestas`
--

/*!40000 ALTER TABLE `apuestas` DISABLE KEYS */;
INSERT INTO `apuestas` (`APU_ID`,`JUG_ID`,`APU_RONDA`) VALUES 
 (3,10,2),
 (4,12,1),
 (6,16,1),
 (8,20,1),
 (10,29,1),
 (11,32,1),
 (13,37,1),
 (15,42,1),
 (17,47,1);
/*!40000 ALTER TABLE `apuestas` ENABLE KEYS */;


--
-- Definition of table `combinaciones2numeros`
--

DROP TABLE IF EXISTS `combinaciones2numeros`;
CREATE TABLE `combinaciones2numeros` (
  `COMB2_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `COMB2_VALOR1` int(10) unsigned NOT NULL,
  `COMB2_VALOR2` int(10) unsigned NOT NULL,
  PRIMARY KEY (`COMB2_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `combinaciones2numeros`
--

/*!40000 ALTER TABLE `combinaciones2numeros` DISABLE KEYS */;
INSERT INTO `combinaciones2numeros` (`COMB2_ID`,`COMB2_VALOR1`,`COMB2_VALOR2`) VALUES 
 (1,1,2),
 (2,2,3),
 (3,4,5),
 (4,5,6),
 (5,7,8),
 (6,8,9),
 (7,10,11),
 (8,11,12),
 (9,13,14),
 (10,14,15),
 (11,16,17),
 (12,17,18),
 (13,19,20),
 (14,20,21),
 (15,22,23),
 (16,23,24),
 (17,25,26),
 (18,26,27),
 (19,28,29),
 (20,29,30),
 (21,31,32),
 (22,32,33),
 (23,34,35),
 (24,35,36),
 (25,1,4),
 (26,2,5),
 (27,3,6),
 (28,4,7),
 (29,5,8),
 (30,6,9),
 (31,7,10),
 (32,8,11),
 (33,9,12),
 (34,10,13),
 (35,11,14),
 (36,12,15),
 (37,13,16),
 (38,14,17),
 (39,15,18),
 (40,16,19),
 (41,17,20),
 (42,18,21),
 (43,19,22),
 (44,20,23),
 (45,21,24),
 (46,22,25),
 (47,23,26),
 (48,24,27),
 (49,25,28),
 (50,26,29),
 (51,27,30),
 (52,28,31),
 (53,29,32),
 (54,30,33),
 (55,31,34),
 (56,32,35),
 (57,33,36);
/*!40000 ALTER TABLE `combinaciones2numeros` ENABLE KEYS */;


--
-- Definition of table `combinaciones4numeros`
--

DROP TABLE IF EXISTS `combinaciones4numeros`;
CREATE TABLE `combinaciones4numeros` (
  `COMB4_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `COMB4_VALOR1` int(10) unsigned NOT NULL,
  `COMB4_VALOR2` int(10) unsigned NOT NULL,
  `COMB4_VALOR3` int(10) unsigned NOT NULL,
  `COMB4_VALOR4` int(10) unsigned NOT NULL,
  PRIMARY KEY (`COMB4_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `combinaciones4numeros`
--

/*!40000 ALTER TABLE `combinaciones4numeros` DISABLE KEYS */;
INSERT INTO `combinaciones4numeros` (`COMB4_ID`,`COMB4_VALOR1`,`COMB4_VALOR2`,`COMB4_VALOR3`,`COMB4_VALOR4`) VALUES 
 (1,1,2,4,5),
 (2,2,3,5,6),
 (3,4,5,7,8),
 (4,5,6,8,9),
 (5,7,8,10,11),
 (6,8,9,11,12),
 (7,10,11,13,14),
 (8,11,12,14,15),
 (9,13,14,16,17),
 (10,14,15,17,18),
 (11,16,17,19,20),
 (12,17,18,20,21),
 (13,19,20,22,23),
 (14,20,21,23,24),
 (15,22,23,25,26),
 (16,23,24,26,27),
 (17,25,26,28,29),
 (18,26,27,29,30),
 (19,28,29,31,32),
 (20,29,30,32,33),
 (21,31,32,34,35),
 (22,32,33,35,36);
/*!40000 ALTER TABLE `combinaciones4numeros` ENABLE KEYS */;


--
-- Definition of table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
CREATE TABLE `jugadores` (
  `JUG_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `JUG_NOMBRE` varchar(45) NOT NULL,
  `JUG_APELLIDO` varchar(45) NOT NULL,
  `JUG_ALIAS` varchar(45) NOT NULL,
  PRIMARY KEY (`JUG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `jugadores`
--

/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` (`JUG_ID`,`JUG_NOMBRE`,`JUG_APELLIDO`,`JUG_ALIAS`) VALUES 
 (1,'Gabriel','Casas','gcasas'),
 (14,'Matias','Nahuel','orei'),
 (16,'fer_test','diaz_test','ferdi otro'),
 (18,'Matias','Nahuel','matias'),
 (20,'fer_test','diaz_test','ferdi'),
 (22,'Matias_test','Nahuel','asd'),
 (31,'Matias_test','Nahuel','asd'),
 (34,'Matias_test','Nahuel','asd'),
 (37,'fer_test','diaz_test','ferdi'),
 (39,'Matias_test','Nahuel','asd'),
 (42,'fer_test','diaz_test','ferdi'),
 (44,'Matias_test','Nahuel','asd'),
 (47,'fer_test','diaz_test','ferdi'),
 (49,'Matias_test','Nahuel','asd');
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;


--
-- Definition of table `opcion_grupo`
--

DROP TABLE IF EXISTS `opcion_grupo`;
CREATE TABLE `opcion_grupo` (
  `OPG_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `APU_ID` int(10) unsigned NOT NULL,
  `OPG_GRUPO` int(10) unsigned NOT NULL,
  `OPG_SALDO` int(10) unsigned NOT NULL,
  PRIMARY KEY (`OPG_ID`),
  KEY `FK_opcion_grupo_apuesta` (`APU_ID`),
  CONSTRAINT `FK_opcion_grupo_apuesta` FOREIGN KEY (`APU_ID`) REFERENCES `apuestas` (`APU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `opcion_grupo`
--

/*!40000 ALTER TABLE `opcion_grupo` DISABLE KEYS */;
/*!40000 ALTER TABLE `opcion_grupo` ENABLE KEYS */;


--
-- Definition of table `opciones_cuatro_numeros`
--

DROP TABLE IF EXISTS `opciones_cuatro_numeros`;
CREATE TABLE `opciones_cuatro_numeros` (
  `OPCUA_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `COMB4_ID` int(10) unsigned NOT NULL,
  `APU_ID` int(10) unsigned NOT NULL,
  `OPCUA_SALDO` int(11) NOT NULL,
  PRIMARY KEY (`OPCUA_ID`),
  KEY `FK_opciones_cuatro_numeros_apuesta` (`APU_ID`),
  KEY `FK_opciones_cuatro_numeros_comb4n` (`COMB4_ID`),
  CONSTRAINT `FK_opciones_cuatro_numeros_apuesta` FOREIGN KEY (`APU_ID`) REFERENCES `apuestas` (`APU_ID`),
  CONSTRAINT `FK_opciones_cuatro_numeros_comb4n` FOREIGN KEY (`COMB4_ID`) REFERENCES `combinaciones4numeros` (`COMB4_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `opciones_cuatro_numeros`
--

/*!40000 ALTER TABLE `opciones_cuatro_numeros` DISABLE KEYS */;
/*!40000 ALTER TABLE `opciones_cuatro_numeros` ENABLE KEYS */;


--
-- Definition of table `opciones_dos_numeros`
--

DROP TABLE IF EXISTS `opciones_dos_numeros`;
CREATE TABLE `opciones_dos_numeros` (
  `OPD_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `COMB2_ID` int(10) unsigned NOT NULL,
  `APU_ID` int(10) unsigned NOT NULL,
  `OPD_SALDO` int(11) NOT NULL,
  PRIMARY KEY (`OPD_ID`),
  KEY `FK_opciones_dos_numeros_apuesta` (`APU_ID`),
  KEY `FK_opciones_dos_numeros_comb2n` (`COMB2_ID`),
  CONSTRAINT `FK_opciones_dos_numeros_apuesta` FOREIGN KEY (`APU_ID`) REFERENCES `apuestas` (`APU_ID`),
  CONSTRAINT `FK_opciones_dos_numeros_comb2n` FOREIGN KEY (`COMB2_ID`) REFERENCES `combinaciones2numeros` (`COMB2_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `opciones_dos_numeros`
--

/*!40000 ALTER TABLE `opciones_dos_numeros` DISABLE KEYS */;
/*!40000 ALTER TABLE `opciones_dos_numeros` ENABLE KEYS */;


--
-- Definition of table `opciones_un_numero`
--

DROP TABLE IF EXISTS `opciones_un_numero`;
CREATE TABLE `opciones_un_numero` (
  `OPUN_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `OPUN_VALOR` varchar(45) NOT NULL,
  `APU_ID` int(10) unsigned NOT NULL,
  `OPUN_SALDO` int(11) NOT NULL,
  PRIMARY KEY (`OPUN_ID`),
  KEY `FK_opciones_un_numero_apuesta` (`APU_ID`),
  CONSTRAINT `FK_opciones_un_numero_apuesta` FOREIGN KEY (`APU_ID`) REFERENCES `apuestas` (`APU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `opciones_un_numero`
--

/*!40000 ALTER TABLE `opciones_un_numero` DISABLE KEYS */;
INSERT INTO `opciones_un_numero` (`OPUN_ID`,`OPUN_VALOR`,`APU_ID`,`OPUN_SALDO`) VALUES 
 (4,'1',4,100),
 (6,'36',4,100),
 (7,'1',6,100),
 (9,'36',4,100),
 (10,'1',8,100),
 (12,'36',4,100),
 (13,'1',10,100),
 (14,'2',10,50),
 (15,'36',4,100),
 (16,'1',11,100),
 (17,'2',11,50),
 (18,'36',6,100),
 (19,'1',13,100),
 (20,'2',13,50),
 (21,'36',8,100),
 (22,'1',15,100),
 (23,'2',15,50),
 (24,'36',8,100),
 (25,'1',17,100),
 (26,'2',17,50),
 (27,'36',8,100);
/*!40000 ALTER TABLE `opciones_un_numero` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
