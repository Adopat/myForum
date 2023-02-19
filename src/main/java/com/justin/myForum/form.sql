-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: forum
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'前端',10,'2021-12-04 16:00:00'),(2,'后端',20,'2021-12-03 16:00:00'),(3,'测试',30,'2021-12-02 16:00:00'),(4,'大数据',40,'2021-12-01 16:00:00'),(5,'运维',50,'2021-11-30 16:00:00');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) DEFAULT NULL,
  `floor` int(11) DEFAULT NULL COMMENT '楼层编号，回复是不能删除的',
  `content` varchar(524) DEFAULT NULL COMMENT '回复内容',
  `user_id` int(11) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL COMMENT '回复人名称',
  `user_img` varchar(128) DEFAULT NULL COMMENT '回复人头像',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete` int(11) DEFAULT NULL COMMENT '0是正常，1是禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (1,1,1,'哈哈哈我有',111,'Justin','justin','2021-11-30 16:00:00','2021-11-30 16:00:00',0),(2,1,2,'uzi最强',111,'Justin1','justin1','2021-12-01 16:00:00','2021-12-01 16:00:00',0),(3,1,3,'gogoing 最强',111,'Justin2','justin2','2021-12-02 16:00:00','2021-12-02 16:00:00',0),(4,1,4,'lope最垃圾',111,'Justin3','justin3','2021-12-03 16:00:00','2021-12-03 16:00:00',0),(5,2,1,'上单提莫',111,'Justin4','justin4','2021-12-04 16:00:00','2021-12-04 16:00:00',0),(6,2,2,'LOL',111,'Justin5','justin5','2021-12-05 16:00:00','2021-12-05 16:00:00',0),(7,2,3,'222',111,'Justin6','justin6','2021-12-06 16:00:00','2021-12-06 16:00:00',0),(8,9,1,'Go语言最棒',8,'juliadfd','https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg','2022-04-03 10:39:52','2022-04-03 10:39:52',0),(9,9,2,'Go语言最棒1',8,'juliadfd','https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg','2022-04-03 10:40:29','2022-04-03 10:40:29',0),(10,12,1,'Linus教程YYDS',8,'juliadfd','https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg','2022-04-03 10:41:10','2022-04-03 10:41:10',0),(11,12,2,'Linus教程YYDS!!!!!',8,'juliadfd','https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg','2022-04-03 10:41:25','2022-04-03 10:41:25',0),(12,9,3,'Linus教程YYDS!!!!!',8,'juliadfd','https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg','2022-04-03 10:41:43','2022-04-03 10:41:43',0),(13,15,1,'我有资料啊',16,'朱茵','https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg','2022-04-05 11:36:02','2022-04-05 11:36:02',0),(14,15,2,'我也有资料',16,'朱茵','https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg','2022-04-05 11:36:13','2022-04-05 11:36:13',0),(15,15,3,'我也想学测试,有资料吗',15,'周星驰','https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg','2022-04-05 11:37:05','2022-04-05 11:37:05',0);
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `c_id` int(11) DEFAULT NULL COMMENT '分类',
  `title` varchar(128) DEFAULT NULL COMMENT '标题',
  `content` varchar(1024) DEFAULT NULL COMMENT '内容',
  `pv` int(11) DEFAULT NULL COMMENT '浏览量',
  `user_id` int(11) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `user_img` varchar(128) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `hot` int(2) DEFAULT '0' COMMENT '是否热门 1是热门',
  `delete` int(11) DEFAULT '0' COMMENT '0是未删除，1是一件删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,2,'Java教程','Java教程',11,110,'jack110','baidu.com','2021-12-06 16:00:00','2021-12-06 16:00:00',0,0),(2,1,'HTML教程','HTML教程',10,111,'jack111','baidu.com','2021-12-07 16:00:00','2021-12-07 16:00:00',0,0),(3,1,'CSS教程','CSS教程',8,112,'jack112','baidu.com','2021-12-08 16:00:00','2021-12-08 16:00:00',0,0),(4,1,'JavaScript教程','JavaScript教程',7,113,'jack113','baidu.com','2021-12-09 16:00:00','2021-12-09 16:00:00',0,0),(5,2,'Node教程','Node教程',5,114,'jack114','baidu.com','2021-12-10 16:00:00','2021-12-10 16:00:00',0,0),(6,2,'Go语言教程','Go语言教程',5,115,'jack115','baidu.com','2021-12-11 16:00:00','2021-12-11 16:00:00',0,0),(7,2,'C语言教程','C语言教程',3,116,'jack116','baidu.com','2021-12-12 16:00:00','2021-12-12 16:00:00',0,0),(8,1,'前端教程','前端教程',3,117,'jack117','baidu.com','2021-12-13 16:00:00','2021-12-13 16:00:00',0,0),(9,3,'测试教程','测试教程',6,118,'jack118','baidu.com','2021-12-14 16:00:00','2021-12-14 16:00:00',0,0),(10,4,'大数据教程','大数据教程',14,119,'jack119','baidu.com','2021-12-15 16:00:00','2021-12-15 16:00:00',0,0),(11,5,'Linus教程','Linus教程',12,120,'jack120','baidu.com','2021-12-16 16:00:00','2021-12-16 16:00:00',0,0),(12,2,'React教程','React是最棒的',3,8,'juliadfd','https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg','2022-04-03 10:03:04','2022-04-03 10:03:04',0,0),(13,2,'React教程','React是最棒的',4,8,'juliadfd','https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg','2022-04-03 10:03:37','2022-04-03 10:03:37',0,0),(14,2,'我想学Java','dfdjkhdfkghdjka;dskl',2,16,'朱茵','https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg','2022-04-05 11:18:50','2022-04-05 11:18:50',0,0),(15,3,'我想学Pytest','我想学Pytest我想学Pytest我想学Pytest我想学Pytest我想学Pytest我想学Pytest',3,16,'朱茵','https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg','2022-04-05 11:35:46','2022-04-05 11:35:46',0,0);
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(32) DEFAULT NULL,
  `pwd` varchar(128) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `img` varchar(128) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `role` int(11) DEFAULT NULL COMMENT '1是普通用户，2是管理员',
  `username` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_un` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'20211201','E9510081AC30FFA83F10B68CDE1CAC07',1,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg','2022-01-09 12:51:48',1,'tom111'),(2,'20211202','E9510081AC30FFA83F10B68CDE1CAC07',1,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg','2022-01-09 12:51:56',1,'tom222'),(3,'20211203','E9510081AC30FFA83F10B68CDE1CAC07',1,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg','2022-01-09 12:52:03',1,'tom333'),(4,'45678','CE9E8DC8A961356D7624F1F463EDAFB5',1,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg','2022-04-03 07:02:31',1,NULL),(6,'456789','CE9E8DC8A961356D7624F1F463EDAFB5',1,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg','2022-04-03 07:04:39',1,NULL),(7,'45678910','CE9E8DC8A961356D7624F1F463EDAFB5',1,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg','2022-04-03 07:09:34',1,NULL),(8,'45678911','CE9E8DC8A961356D7624F1F463EDAFB5',1,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg','2022-04-03 07:09:48',1,'juliadfd'),(10,'18912345678','81DC9BDB52D04DC20036DBD8313ED055',2,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg','2022-04-05 10:30:29',1,'Lucy PAP'),(11,'18956789123','202CB962AC59075B964B07152D234B70',2,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg','2022-04-05 10:32:18',1,'Lucy POP'),(12,'13912345678','202CB962AC59075B964B07152D234B70',1,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg','2022-04-05 10:36:04',1,'Rion JI'),(13,'1391111111','202CB962AC59075B964B07152D234B70',1,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg','2022-04-05 10:38:50',1,'老汪'),(14,'1392222222','202CB962AC59075B964B07152D234B70',1,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg','2022-04-05 10:39:43',1,'老楼'),(15,'139333333','E10ADC3949BA59ABBE56E057F20F883E',1,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg','2022-04-05 10:59:23',1,'周星驰'),(16,'1394444444','202CB962AC59075B964B07152D234B70',2,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg','2022-04-05 11:03:39',1,'朱茵'),(17,'1234','202CB962AC59075B964B07152D234B70',2,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg','2022-04-06 13:40:16',1,'1234'),(18,'12345','827CCB0EEA8A706C4C34A16891F84E7B',2,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg','2022-04-06 13:41:58',1,'12345'),(19,'6666','E9510081AC30FFA83F10B68CDE1CAC07',2,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg','2022-09-20 13:01:22',1,'6666'),(21,'1111111','25D55AD283AA400AF464C76D713C07AD',2,'https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg','2023-02-19 12:47:49',1,'1111111');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'forum'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-19 21:26:13
