/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2019-06-30 22:39:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_customer`
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `jobs` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('1', 'joy', 'doctor', '13745874578');
INSERT INTO `t_customer` VALUES ('2', 'jack', 'teacher', '13521210112');
INSERT INTO `t_customer` VALUES ('3', 'tom', 'worker', '15179405961');
INSERT INTO `t_customer` VALUES ('5', 'zhangsan', 'manager', '13233334444');
