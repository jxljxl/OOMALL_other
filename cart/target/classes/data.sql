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
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES(1,1,111,'111','111','111',1,'2020-12-06 19:21:16',NULL),(2,1,222,'222','222','222',0,'2020-12-06 19:21:27',NULL),(3,1,333,'333','333','333',0,'2020-12-06 19:21:44',NULL);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `region` WRITE;
INSERT INTO `region`(`id`, `pid`, `name`, `postal_code`, `state`, `gmt_create`, `gmt_modified`) VALUES (1, 2, '111', 11, 1, '2020-12-08 15:24:02', NULL);
INSERT INTO `region`(`id`, `pid`, `name`, `postal_code`, `state`, `gmt_create`, `gmt_modified`) VALUES (2, 3, '222', 22, 1, '2020-12-08 15:24:12', NULL);
INSERT INTO `region`(`id`, `pid`, `name`, `postal_code`, `state`, `gmt_create`, `gmt_modified`) VALUES (3, 4, '333', 33, 0, '2020-12-08 15:24:14', NULL);

UNLOCK TABLES;

LOCK TABLES `shopping_cart` WRITE;
INSERT INTO `shopping_cart`(`id`, `customer_id`, `goods_sku_id`, `quantity`, `price`, `gmt_create`, `gmt_modified`) VALUES (1, 1, 1, 1, 11, '2020-12-11 17:25:27', NULL);
INSERT INTO `shopping_cart`(`id`, `customer_id`, `goods_sku_id`, `quantity`, `price`, `gmt_create`, `gmt_modified`) VALUES (2, 1, 2, 1, 22, '2020-12-11 17:25:35', NULL);
INSERT INTO `shopping_cart`(`id`, `customer_id`, `goods_sku_id`, `quantity`, `price`, `gmt_create`, `gmt_modified`) VALUES (3, 5, 3, 1, 33, '2020-12-11 17:25:47', NULL);
UNLOCK TABLES;

