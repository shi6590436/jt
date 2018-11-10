/*
 Navicat Premium Data Transfer

 Source Server         : o2o
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : o2o

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 06/18/2018 10:04:15 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tb_area`
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area` (
  `area_id` int(5) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(200) NOT NULL,
  `area_desc` varchar(1000) DEFAULT NULL,
  `priority` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`area_id`),
  UNIQUE KEY `UK_AREA` (`area_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tb_area`
-- ----------------------------
BEGIN;
INSERT INTO `tb_area` VALUES ('1', '海珠区', null, '1', null, null), ('2', '天河区', null, '2', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `tb_head_line`
-- ----------------------------
DROP TABLE IF EXISTS `tb_head_line`;
CREATE TABLE `tb_head_line` (
  `line_id` int(100) NOT NULL AUTO_INCREMENT,
  `line_name` varchar(1000) DEFAULT NULL,
  `line_link` varchar(1000) NOT NULL,
  `line_img` varchar(2000) NOT NULL,
  `priority` int(2) DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`line_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tb_local_auth`
-- ----------------------------
DROP TABLE IF EXISTS `tb_local_auth`;
CREATE TABLE `tb_local_auth` (
  `local_auth_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `user_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`local_auth_id`),
  UNIQUE KEY `uk_local_profile` (`user_name`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `fk_local_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tb_person_info`
-- ----------------------------
DROP TABLE IF EXISTS `tb_person_info`;
CREATE TABLE `tb_person_info` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `profile_img` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_flag` int(2) NOT NULL DEFAULT '0',
  `shop_ower_flag` int(2) NOT NULL DEFAULT '0',
  `admin_flag` int(2) NOT NULL,
  `enable_status` int(2) NOT NULL DEFAULT '0',
  `crate_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tb_person_info`
-- ----------------------------
BEGIN;
INSERT INTO `tb_person_info` VALUES ('1', '张飞', '2018-06-12 14:43:37', '1', '13711114122', null, null, '0', '0', '55', '0', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `tb_product`
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `product_id` int(100) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) NOT NULL,
  `product_desc` varchar(2000) DEFAULT NULL,
  `img_addr` varchar(255) DEFAULT '',
  `normal_price` decimal(20,2) DEFAULT NULL,
  `promotion_price` decimal(20,2) DEFAULT NULL,
  `enable_status` int(2) DEFAULT '0',
  `point` int(10) DEFAULT NULL,
  `product_category_id` int(11) DEFAULT NULL,
  `shop_id` int(11) DEFAULT '0',
  `priority` int(2) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `fk_product_shop` (`shop_id`),
  KEY `fk_product_procate` (`product_category_id`),
  CONSTRAINT `fk_product_procate` FOREIGN KEY (`product_category_id`) REFERENCES `tb_product_category` (`product_category_id`),
  CONSTRAINT `fk_product_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tb_product_category`
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_category`;
CREATE TABLE `tb_product_category` (
  `product_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_category_name` varchar(128) NOT NULL,
  `product_category_desc` varchar(500) DEFAULT NULL,
  `priorty` int(2) DEFAULT '0',
  `shop_id` int(11) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`product_category_id`),
  KEY `fk_procate_shop` (`shop_id`),
  CONSTRAINT `fk_procate_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tb_product_img`
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_img`;
CREATE TABLE `tb_product_img` (
  `product_img_id` int(20) NOT NULL AUTO_INCREMENT,
  `img_addr` varchar(2000) NOT NULL,
  `img_desc` varchar(2000) DEFAULT NULL,
  `priority` int(2) DEFAULT '0',
  `product_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`product_img_id`),
  KEY `fk_proimg_product` (`product_id`) USING BTREE,
  CONSTRAINT `fk_proimg_product` FOREIGN KEY (`product_id`) REFERENCES `tb_product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tb_shop`
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop`;
CREATE TABLE `tb_shop` (
  `shop_id` int(10) NOT NULL AUTO_INCREMENT,
  `ower_id` int(10) NOT NULL COMMENT '店铺创建人',
  `area_id` int(5) DEFAULT NULL,
  `shop_category_id` int(11) DEFAULT NULL,
  `parent_category_id` int(11) DEFAULT NULL,
  `shop_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `shop_desc` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `shop_addr` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `longitude` double(16,12) DEFAULT NULL,
  `latitude` double(16,12) DEFAULT NULL,
  `priority` int(3) DEFAULT '0',
  `advice` varchar(255) CHARACTER SET utf32 COLLATE utf32_unicode_ci DEFAULT NULL,
  `enable_status` int(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `shop_img` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`shop_id`),
  KEY `fk_shop_profile` (`ower_id`),
  KEY `fk_shop_area` (`area_id`),
  KEY `fk_shop_shopcate` (`shop_category_id`),
  KEY `fk_shop_parentcate` (`parent_category_id`),
  CONSTRAINT `fk_shop_area` FOREIGN KEY (`area_id`) REFERENCES `tb_area` (`area_id`),
  CONSTRAINT `fk_shop_parentcate` FOREIGN KEY (`parent_category_id`) REFERENCES `tb_shop_category` (`parent_id`),
  CONSTRAINT `fk_shop_profile` FOREIGN KEY (`ower_id`) REFERENCES `tb_person_info` (`user_id`),
  CONSTRAINT `fk_shop_shopcate` FOREIGN KEY (`shop_category_id`) REFERENCES `tb_shop_category` (`shop_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tb_shop`
-- ----------------------------
BEGIN;
INSERT INTO `tb_shop` VALUES ('3', '1', '1', '1', null, '王子拉茶', '泡妞好去处', 'TiT创意园', '123456789', null, null, '1', '不通过', '1', '2018-06-11 18:23:21', '2018-06-11 18:58:21', null), ('10', '1', '1', '1', null, '贡茶', '贡茶1', 'TiT创意园', '123456789', null, null, null, '审核中', '0', '2018-06-13 13:55:34', '2018-06-13 13:55:34', null), ('11', '1', '1', '1', null, '贡茶', '贡茶1', 'TiT创意园', '123456789', null, null, null, '审核中', '0', '2018-06-13 13:58:00', '2018-06-13 13:58:00', null), ('12', '1', '1', '1', null, '贡茶', '贡茶1', 'TiT创意园', '123456789', null, null, null, '审核中', '0', '2018-06-13 13:59:35', '2018-06-13 13:59:35', null), ('13', '1', '1', '1', null, '贡茶', '贡茶1', 'TiT创意园', '123456789', null, null, null, '审核中', '0', '2018-06-13 14:04:24', '2018-06-13 14:04:24', null), ('14', '1', '1', '1', null, '贡茶', '贡茶1', 'TiT创意园', '123456789', null, null, null, '审核中', '0', '2018-06-13 14:11:56', '2018-06-13 14:11:56', null), ('15', '1', '1', '1', null, '贡茶', '贡茶1', 'TiT创意园', '123456789', null, null, null, '审核中', '0', '2018-06-14 10:41:21', '2018-06-14 10:41:21', null), ('16', '1', '1', '1', null, '贡茶', '贡茶1', 'TiT创意园', '123456789', null, null, null, '审核中', '0', '2018-06-14 10:43:19', '2018-06-14 10:43:19', null), ('17', '1', '1', '1', null, '贡茶', '贡茶1', 'TiT创意园', '123456789', null, null, null, '审核中', '0', '2018-06-14 10:44:51', '2018-06-14 10:44:51', null), ('28', '1', '1', '2', null, '粤兴来', '快餐', '横一街', '15230677540', null, null, null, null, '0', '2018-06-16 19:41:21', '2018-06-16 19:41:21', '/upload/item/shop/28/2018061619412153128.jpg'), ('29', '1', '2', '2', null, '有一家', 'ttet', '广州', '12366645646', null, null, null, null, '0', '2018-06-16 20:00:22', '2018-06-16 20:00:22', '/upload/item/shop/29/2018061620002284869.jpg'), ('30', '1', '2', '2', null, '昌盛', '九点', '横一街', '12456632363', null, null, null, null, '0', '2018-06-16 20:11:38', '2018-06-16 20:11:38', '/upload/item/shop/30/2018061620113763540.jpg'), ('31', '1', '2', '2', null, '金源', '所属、 ', '客村', '52466778879', null, null, null, null, '0', '2018-06-16 20:28:41', '2018-06-16 20:28:41', '/upload/item/shop/31/2018061620284032706.jpg'), ('32', '1', '2', '2', null, '巨大', 'rey', '解放路； ', '214556524', null, null, null, null, '0', '2018-06-16 20:32:55', '2018-06-16 20:32:55', '/upload/item/shop/32/2018061620325569536.jpg'), ('33', '1', '2', '2', null, '图书', '天文台', '风飒风', '4312526547', null, null, null, null, '0', '2018-06-16 20:39:08', '2018-06-16 20:39:08', '/upload/item/shop/33/2018061620390739092.jpg');
COMMIT;

-- ----------------------------
--  Table structure for `tb_shop_category`
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop_category`;
CREATE TABLE `tb_shop_category` (
  `shop_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_category_name` varchar(100) NOT NULL DEFAULT '',
  `shop_category_desc` varchar(1000) DEFAULT '',
  `shop_category_img` varchar(2000) DEFAULT NULL,
  `priority` int(2) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`shop_category_id`),
  KEY `fk_shop_category_self` (`parent_id`),
  CONSTRAINT `tb_shop_category` FOREIGN KEY (`parent_id`) REFERENCES `tb_shop_category` (`shop_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tb_shop_category`
-- ----------------------------
BEGIN;
INSERT INTO `tb_shop_category` VALUES ('1', '咖啡奶茶', '咖啡牛奶', 'test', '1', null, null, null), ('2', '咖啡', '星巴克', 'test', '0', null, null, '1');
COMMIT;

-- ----------------------------
--  Table structure for `tb_wechat_auth`
-- ----------------------------
DROP TABLE IF EXISTS `tb_wechat_auth`;
CREATE TABLE `tb_wechat_auth` (
  `wechat_auth_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `open_id` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`wechat_auth_id`),
  UNIQUE KEY `uk_oauth` (`open_id`),
  KEY `fk_oauth_profile` (`user_id`),
  CONSTRAINT `fk_oauth_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Procedure structure for `tb_area`
-- ----------------------------
DROP PROCEDURE IF EXISTS `tb_area`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `tb_area`()
DROP TABLE IF EXISTS `tb_area`;
 ;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
