-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: testspring
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `admin` (
  `adminid` int(11) NOT NULL AUTO_INCREMENT,
  `adminname` varchar(20) NOT NULL,
  `adminpassword` varchar(20) NOT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'yan','123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `olduser`
--

DROP TABLE IF EXISTS `olduser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `olduser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `olduser`
--

LOCK TABLES `olduser` WRITE;
/*!40000 ALTER TABLE `olduser` DISABLE KEYS */;
INSERT INTO `olduser` VALUES (1,'aaa','123','beijing'),(2,'a','123456','guangzhou');
/*!40000 ALTER TABLE `olduser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `vote_uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'a','123',1),(2,'b','123456',2),(3,'yan','123456',3),(4,'aaa','123',4);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vote` (
  `vote_id` int(11) NOT NULL AUTO_INCREMENT,
  `vote_title` varchar(100) NOT NULL,
  `vote_stime` varchar(20) NOT NULL,
  `vote_etime` varchar(20) NOT NULL,
  `vote_firstitem` varchar(100) NOT NULL,
  `vote_seconditem` varchar(100) NOT NULL,
  `vote_thirditem` varchar(100) NOT NULL,
  `vote_uid` int(11) NOT NULL,
  `firstnum` int(11) DEFAULT NULL,
  `voterid` int(11) DEFAULT NULL,
  `secondnum` int(11) DEFAULT NULL,
  `thirdnum` int(11) DEFAULT NULL,
  PRIMARY KEY (`vote_id`),
  KEY `FK_ID` (`vote_uid`),
  CONSTRAINT `FK_ID` FOREIGN KEY (`vote_uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote`
--

LOCK TABLES `vote` WRITE;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
INSERT INTO `vote` VALUES (46,'a','2019-05-01','2019-05-02','a','aa','aaa',1,0,0,0,0),(48,'c','2019-06-20','2019-06-21','c','cccc','cc',1,0,0,0,0),(50,'测试创建投票','2019-07-02','2019-07-03','a','b','c',1,0,0,0,0);
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `votedata`
--

DROP TABLE IF EXISTS `votedata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `votedata` (
  `data_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_num` int(11) DEFAULT NULL,
  `second_num` int(11) DEFAULT NULL,
  `third_num` int(11) DEFAULT NULL,
  `four_num` int(11) DEFAULT NULL,
  `five_num` int(11) DEFAULT NULL,
  `six_num` int(11) DEFAULT NULL,
  `voteid` int(11) NOT NULL,
  PRIMARY KEY (`data_id`),
  KEY `voteid` (`voteid`),
  CONSTRAINT `votedata_ibfk_1` FOREIGN KEY (`voteid`) REFERENCES `vote` (`vote_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `votedata`
--

LOCK TABLES `votedata` WRITE;
/*!40000 ALTER TABLE `votedata` DISABLE KEYS */;
INSERT INTO `votedata` VALUES (1,2,0,1,0,0,0,46),(3,0,1,0,0,0,0,48),(5,0,0,0,0,0,0,50);
/*!40000 ALTER TABLE `votedata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voter`
--

DROP TABLE IF EXISTS `voter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `voter` (
  `voter_id` int(11) NOT NULL AUTO_INCREMENT,
  `voter_name` varchar(20) NOT NULL,
  `voter_password` varchar(20) NOT NULL,
  `voteid` int(11) DEFAULT NULL,
  PRIMARY KEY (`voter_id`),
  KEY `voteid` (`voteid`),
  CONSTRAINT `voteid` FOREIGN KEY (`voteid`) REFERENCES `vote` (`vote_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voter`
--

LOCK TABLES `voter` WRITE;
/*!40000 ALTER TABLE `voter` DISABLE KEYS */;
INSERT INTO `voter` VALUES (1,'a','123',NULL),(3,'yan','123456',NULL),(4,'c','123456',NULL),(5,'d','1234567',NULL),(6,'e','123',NULL),(7,'g','123',NULL);
/*!40000 ALTER TABLE `voter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voterhasvote`
--

DROP TABLE IF EXISTS `voterhasvote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `voterhasvote` (
  `voterid` int(11) NOT NULL,
  `voteid` int(11) NOT NULL,
  PRIMARY KEY (`voterid`,`voteid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voterhasvote`
--

LOCK TABLES `voterhasvote` WRITE;
/*!40000 ALTER TABLE `voterhasvote` DISABLE KEYS */;
INSERT INTO `voterhasvote` VALUES (1,46),(3,46),(3,47),(4,46),(4,48),(5,47);
/*!40000 ALTER TABLE `voterhasvote` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-03  1:14:25
