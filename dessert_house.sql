-- MySQL dump 10.13  Distrib 5.5.25, for Win64 (x86)
--
-- Host: localhost    Database: dessert_house
-- ------------------------------------------------------
-- Server version	5.5.25

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`aid`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'1','1');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL,
  `price` double NOT NULL,
  `time` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,1,435,'2012-12-12','预订',1),(2,2,1111,'2000','销售',2),(3,3,12,'2011','预订',3),(4,4,322,'2012','销售',4),(5,5,112,'2010','销售',5),(6,1,275,'2013-03-08','预订',2),(7,1,275,'2013-03-08','预订',2),(8,1,275,'2013-03-08','预订',2),(9,1,275,'2013-03-08','预订',2),(10,1,120,'2013-03-08','预订',2),(11,1,120,'2013-03-08','预订',2),(12,1,120,'2013-03-08','预订',2),(13,1,120,'2013-03-08','预订',2),(14,1,120,'2013-03-08','预订',2),(15,1,120,'2013-03-08','预订',2),(16,1,120,'2013-03-08','预订',2),(17,1,120,'2013-03-08','预订',2),(18,1,120,'2013-03-08','预订',2),(19,1,120,'2013-03-08','预订',1),(20,1,120,'2013-03-08','预订',1),(21,1,120,'2013-03-08','预订',1),(22,1,120,'2013-03-08','预订',1),(23,1,120,'2013-03-08','预订',1),(24,1,780,'2013-03-08','预订',1),(25,1,150,'2013-03-09','预订',1),(26,1,184,'2013-03-09','预订',1),(27,1,184,'2013-03-09','预订',1),(28,1,210,'2013-03-09','预订',1),(29,1,96,'2013-03-09','预订',1),(30,1,144,'2013-03-09','预订',1),(31,1,576,'2013-03-09','销售',1),(32,1,5760,'2013-03-09','销售',1),(33,1,96,'2013-03-09','销售',1),(34,1,96,'2013-03-09','销售',1),(35,1,432,'2013-03-09','预订',1),(36,1,155,'2013-03-09','预订',8),(37,1,150,'2013-03-09','预订',8);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clerk`
--

DROP TABLE IF EXISTS `clerk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clerk` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `hid` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clerk`
--

LOCK TABLES `clerk` WRITE;
/*!40000 ALTER TABLE `clerk` DISABLE KEYS */;
INSERT INTO `clerk` VALUES (1,'1','1','王狗蛋',12,'苏州','2222','男',6),(2,'2','2','李狗蛋',13,'南京','1212','女',2),(3,'3','3','杨狗蛋',14,'北京','212','男',2),(4,'4','4','汪汪汪',15,'河北','2323','未知',4),(5,'5','5','热',65,'热','45435','女',5),(6,'身份','第三方','地方',44,'但纷纷','地方','女',3);
/*!40000 ALTER TABLE `clerk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `card` int(11) DEFAULT NULL,
  `state` varchar(45) NOT NULL,
  `account` double NOT NULL,
  `level` int(11) NOT NULL,
  `time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'1','1','莫其凡','南京','女','15996285252',22,1,'激活',2895,5,'2013-03-09'),(8,'2','2','顾客','ds ','4','df',65,NULL,'停止',250,1,'2013-03-09');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dessert`
--

DROP TABLE IF EXISTS `dessert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dessert` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `price` double NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`did`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dessert`
--

LOCK TABLES `dessert` WRITE;
/*!40000 ALTER TABLE `dessert` DISABLE KEYS */;
INSERT INTO `dessert` VALUES (1,'恋爱季活动 蔷薇之城 上海市外环内免费配送',180,'蛋糕'),(2,'美团网团购 经典巧克力慕斯',120,'蛋糕'),(3,'甜蜜恋人旗舰店特供 炫彩华章',150,'蛋糕'),(4,'甜蜜恋人旗舰店专供 经典布朗尼',155,'蛋糕'),(5,'甜蜜恋人旗舰店专供 卷心巧克力',55,'蛋糕'),(6,'GABA披萨法包（蒜香培根）',30,'面包'),(7,'GABA调理杂粮法包（香辣）',123,'面包'),(8,'100%精选果汁组合',34,'饮品'),(9,'调制GABA胚芽乳(红豆口味)',67,'饮品'),(10,'小蝴蝶结礼盒B',89,'伴手礼'),(11,'蟹派大礼盒',43,'伴手礼'),(12,'蜜加沙旺福来大礼盒',344,'伴手礼'),(13,'甜蜜旗舰店专供蛋糕 皇冠',188,'蛋糕'),(14,'甜蜜恋人旗舰店提货 心相映',222,'蛋糕'),(15,'婚礼蛋糕蓝色梦幻',1400,'蛋糕');
/*!40000 ALTER TABLE `dessert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discount` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `discount` double NOT NULL,
  `level` int(11) NOT NULL,
  `money` double NOT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES (1,1,1,0),(2,0.95,2,666),(3,0.9,3,1000),(4,0.85,4,1500),(5,0.8,5,2000);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `house`
--

DROP TABLE IF EXISTS `house`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `house` (
  `hid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  PRIMARY KEY (`hid`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `house`
--

LOCK TABLES `house` WRITE;
/*!40000 ALTER TABLE `house` DISABLE KEYS */;
INSERT INTO `house` VALUES (1,'南京鼓楼店','南京','4324234'),(2,'苏州园区店','苏州','324234'),(3,'上海虹桥店','上海','23432423'),(4,'台湾新竹店','台湾','4543'),(5,'香港九龙店','香港','34242'),(6,'女汉子XX店','汉子街','56546546');
/*!40000 ALTER TABLE `house` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `address` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  PRIMARY KEY (`mid`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'1','1','大娃',1,'房顶上','男','35435'),(2,'2','2','二娃',2,'葫芦棚','男','4354'),(3,'3','3','三娃',3,'山洞','男','45342'),(4,'4','4','大王',4,'鞍山','女','233'),(5,'5','5','覆盖',54,'风光好','男','3423432');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recharge`
--

DROP TABLE IF EXISTS `recharge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recharge` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `number` double NOT NULL,
  `time` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recharge`
--

LOCK TABLES `recharge` WRITE;
/*!40000 ALTER TABLE `recharge` DISABLE KEYS */;
INSERT INTO `recharge` VALUES (1,111,'2012-12','充值',1),(2,100,'2011-11','激活',1),(3,100,'2013-03-08','激活',1),(4,100,'2013-03-08','激活',1),(5,100,'2013-03-08','激活',1),(6,100,'2013-03-08','激活',1),(7,5,'2013-03-08','充值',1),(8,5,'2013-03-08','充值',1),(9,100,'2013-03-08','激活',1),(10,66,'2013-03-08','充值',1),(11,88888,'2013-03-09','充值',1),(12,100,'2013-03-09','激活',8);
/*!40000 ALTER TABLE `recharge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `oid` int(11) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (1,1,11,1),(2,2,12,1),(3,3,13,1),(4,4,14,1),(5,1,12,1),(6,1,32,2),(7,2,1,2),(8,3,3,3),(9,8,4,4),(10,7,5,5),(11,2,1,1),(12,4,1,1),(13,2,1,9),(14,4,1,9),(15,2,1,10),(16,2,1,11),(17,2,1,12),(18,2,1,13),(19,2,1,14),(20,2,1,15),(21,2,1,16),(22,2,1,17),(23,2,1,18),(24,2,1,19),(25,2,1,20),(26,2,1,21),(27,2,1,22),(28,2,1,23),(29,2,4,24),(30,3,2,24),(31,3,1,25),(32,3,1,26),(33,8,1,26),(34,3,1,27),(35,8,1,27),(36,1,1,28),(37,6,1,28),(38,2,1,29),(39,1,1,30),(40,1,4,31),(41,1,40,32),(42,2,1,33),(43,2,1,34),(44,1,3,35),(45,4,1,36),(46,3,1,37);
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL,
  `did` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,1,1,99),(2,1,2,42),(3,1,3,44),(4,1,4,44),(5,1,5,44),(6,1,6,55),(7,1,7,22),(8,1,8,33),(9,1,9,44),(10,1,10,55),(11,1,11,66),(12,1,12,77),(13,2,1,44),(14,2,2,42),(15,2,3,33),(16,2,4,44),(17,2,5,55),(18,2,6,6),(19,2,7,7),(20,2,8,3),(21,2,9,2),(22,2,10,5),(23,2,11,7),(24,2,12,34),(25,3,1,-41),(26,3,2,32),(27,3,3,2),(28,3,4,12),(29,3,5,34),(30,3,6,5),(31,3,7,64),(32,3,8,32),(33,3,9,3),(34,3,10,12),(35,3,11,23),(36,3,12,4),(37,4,1,-39),(38,4,2,4),(39,4,3,32),(40,4,4,45),(41,4,5,65),(42,4,6,32),(43,4,7,1),(44,4,8,43),(45,4,9,5),(46,4,10,4),(47,4,11,4),(48,4,12,4),(49,5,1,-38),(50,5,2,5),(51,5,3,3),(52,5,4,1),(53,5,5,43),(54,5,6,5),(55,5,7,6),(56,5,8,6),(57,5,9,1),(58,5,10,4),(59,5,11,2),(60,5,12,1),(61,6,1,0),(62,6,2,0),(63,6,3,0),(64,6,4,0),(65,6,5,0),(66,6,6,0),(67,6,7,0),(68,6,8,0),(69,6,9,0),(70,6,10,0),(71,6,11,0),(72,6,12,0),(73,1,13,0),(74,2,13,0),(75,3,13,0),(76,4,13,0),(77,5,13,0),(78,6,13,0),(79,1,14,0),(80,2,14,0),(81,3,14,0),(82,4,14,0),(83,5,14,0),(84,6,14,0),(85,1,15,0),(86,2,15,0),(87,3,15,0),(88,4,15,0),(89,5,15,0),(90,6,15,0);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-03-14 20:44:50
