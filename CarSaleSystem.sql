/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL80_localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : carsalesystem

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 28/02/2020 23:16:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car_info
-- ----------------------------
DROP TABLE IF EXISTS `car_info`;
CREATE TABLE `car_info`  (
  `car_id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '轿车编号',
  `model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '轿车型号',
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '轿车颜色',
  `manufactory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生产厂家',
  `factory_date` datetime(0) NOT NULL COMMENT '出厂日期',
  `price` decimal(12, 2) NOT NULL COMMENT '价格',
  PRIMARY KEY (`car_id`, `model`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_info
-- ----------------------------
INSERT INTO `car_info` VALUES (1, 'Aventador-LP700', 'Gloden', 'Lamborghini', '2019-06-06 00:00:00', 7559200.00);
INSERT INTO `car_info` VALUES (2, 'Huracan', 'Blue', 'Lamborghini', '2019-06-06 00:00:00', 2782000.00);
INSERT INTO `car_info` VALUES (3, 'Urus', 'Yellow', 'Lamborghini', '2019-06-06 00:00:00', 2900000.00);
INSERT INTO `car_info` VALUES (4, 'Centenario', 'Black Yellow', 'Lamborghini', '2019-06-06 00:00:00', 50000000.00);
INSERT INTO `car_info` VALUES (5, 'Aventador', 'Yellow', 'Lamborghini', '2019-06-06 00:00:00', 6137000.00);
INSERT INTO `car_info` VALUES (6, 'Terzo Millennio', 'Black', 'Lamborghini', '2019-06-06 00:00:00', 30000000.00);
INSERT INTO `car_info` VALUES (7, 'F12berlinetta', 'Ferrari-Red', '\r\nFerrari ', '2019-06-07 00:00:00', 5308000.00);
INSERT INTO `car_info` VALUES (8, '812 Superfast', 'Ferrari-Red', 'Ferrari', '2019-06-07 00:00:00', 4988000.00);
INSERT INTO `car_info` VALUES (9, '488 Pista', 'Azure', 'Ferrari', '2019-06-07 01:00:00', 4188000.00);
INSERT INTO `car_info` VALUES (10, 'F8 Tributo', 'Purple', 'Ferrari', '2019-06-07 01:00:00', 2980000.00);
INSERT INTO `car_info` VALUES (11, 'Audi Sport-R8', 'Jewelry Blue', 'Audi', '2019-06-08 02:00:00', 2354800.00);
INSERT INTO `car_info` VALUES (12, 'Audi TT RS', 'White', 'Audi', '2019-06-08 02:00:00', 453800.00);
INSERT INTO `car_info` VALUES (13, 'Audi TTS', 'Red', 'Audi', '2019-06-08 02:00:00', 507800.00);
INSERT INTO `car_info` VALUES (15, 'V8 Vantage', 'Silver', 'Aston Martin', '2019-06-08 00:00:00', 1868000.00);
INSERT INTO `car_info` VALUES (16, 'DBS', 'Red', 'Aston Martin', '2019-06-09 00:00:00', 3768000.00);
INSERT INTO `car_info` VALUES (17, 'Vanquish ', 'Jewelry Blue', 'Aston Martin', '2019-06-10 00:00:00', 3998000.00);
INSERT INTO `car_info` VALUES (18, 'Rapide', 'Black', 'Aston Martin', '2019-06-11 00:00:00', 2868000.00);
INSERT INTO `car_info` VALUES (19, 'Rapide AMR', 'Black', 'Aston Martin', '2019-06-11 00:00:00', 3600000.00);
INSERT INTO `car_info` VALUES (20, 'Vanquish ', 'Jewelry Blue', 'Aston Martin', '2019-06-11 00:00:00', 3980000.00);
INSERT INTO `car_info` VALUES (22, 'M2', 'Green', 'BMW', '2019-05-25 00:00:00', 633800.00);
INSERT INTO `car_info` VALUES (23, 'M3', 'White', 'BMW', '2019-05-25 00:00:00', 876800.00);
INSERT INTO `car_info` VALUES (24, 'M4', 'Orange', 'BMW', '2019-05-25 00:00:00', 906800.00);
INSERT INTO `car_info` VALUES (25, 'X6 M', 'Green', 'BMW', '2019-05-25 00:00:00', 1759900.00);
INSERT INTO `car_info` VALUES (26, 'Panamera', 'Red', 'Porsche', '2019-06-10 00:00:00', 973000.00);
INSERT INTO `car_info` VALUES (28, 'Cayenne', 'White', 'Porsche', '2019-06-10 00:00:00', 895000.00);
INSERT INTO `car_info` VALUES (29, '718', 'Red', 'Porsche', '2019-06-10 00:00:00', 5455000.00);
INSERT INTO `car_info` VALUES (30, '911', 'Black', 'Porsche', '2019-06-10 00:00:00', 1197000.00);
INSERT INTO `car_info` VALUES (31, 'Cayenne Coupe', 'Black', 'Porsche', '2019-06-11 00:00:00', 998000.00);
INSERT INTO `car_info` VALUES (32, 'Cayman', 'White', 'Porsche', '2019-06-11 00:00:00', 2000000.00);
INSERT INTO `car_info` VALUES (33, '添越', 'Black', 'Bentley', '2019-05-05 00:00:00', 2690000.00);
INSERT INTO `car_info` VALUES (34, '飞驰', 'Blue', 'Bentley', '2019-05-05 00:00:00', 2780000.00);
INSERT INTO `car_info` VALUES (35, '慕尚', 'Silver', 'Bentley', '2019-05-05 00:00:00', 4950000.00);
INSERT INTO `car_info` VALUES (36, 'Chiron', 'Black', 'BUGATTI', '2018-08-08 00:00:00', 25000000.00);
INSERT INTO `car_info` VALUES (37, 'Divo', 'Black', 'BUGATTI', '2018-08-08 00:00:00', 50000000.00);
INSERT INTO `car_info` VALUES (38, 'Vision Gran Turismo', 'Wine Red', 'BUGATTI', '2018-08-08 00:00:00', 100000000.00);
INSERT INTO `car_info` VALUES (39, 'Toyota 86', 'Blue', 'TOYOTA', '2019-06-18 00:00:00', 340000.00);
INSERT INTO `car_info` VALUES (40, '卡罗拉', 'White', 'TOYOTA', '2019-06-18 00:00:00', 141800.00);
INSERT INTO `car_info` VALUES (41, 'F-TYPE', 'Silver', 'JAGUAR', '2019-07-01 00:00:00', 582000.00);
INSERT INTO `car_info` VALUES (42, 'Jesko', 'Wine Red', 'Koenigsegg', '2016-06-06 00:00:00', 20000000.00);
INSERT INTO `car_info` VALUES (43, 'Agera', 'Black', 'Koenigsegg', '2017-06-06 00:00:00', 35000000.00);
INSERT INTO `car_info` VALUES (44, 'Agera RS', 'Grey', 'Koenigsegg', '2017-08-12 00:00:00', 40000000.00);
INSERT INTO `car_info` VALUES (45, 'ONE.1', 'Black White', 'Koenigsegg', '2017-08-08 00:00:00', 60000000.00);
INSERT INTO `car_info` VALUES (46, 'X-BOW', 'Blue', 'KTM', '2018-09-10 00:00:00', 1390000.00);
INSERT INTO `car_info` VALUES (47, '幻影', 'Silver', 'Rolls-Royce', '2019-01-01 00:00:00', 7900000.00);
INSERT INTO `car_info` VALUES (48, '古思特', 'Blue', 'Rolls-Royce', '2019-02-25 00:00:00', 4500000.00);
INSERT INTO `car_info` VALUES (49, '魅影', 'Black', 'Rolls-Royce', '2018-05-06 00:00:00', 5050000.00);
INSERT INTO `car_info` VALUES (50, '库里南', 'Black', 'Rolls-Royce', '2019-03-21 00:00:00', 6100000.00);
INSERT INTO `car_info` VALUES (51, 'Evora', 'Blue', 'Lotus', '2018-04-02 00:00:00', 972000.00);
INSERT INTO `car_info` VALUES (52, 'Elise', 'Red', 'Lotus', '2017-06-16 00:00:00', 1200000.00);
INSERT INTO `car_info` VALUES (53, 'Huayra', 'Red', 'Pagani', '2018-09-01 00:00:00', 29000000.00);
INSERT INTO `car_info` VALUES (54, 'Zonda', 'Black Red', 'Pagani', '2016-10-22 00:00:00', 43000000.00);
INSERT INTO `car_info` VALUES (55, 'GTR', 'Orange', 'NISSAN', '2019-02-28 00:00:00', 1890000.00);
INSERT INTO `car_info` VALUES (57, 'BRZ', 'Jewelry Blue', 'Subaru', '2019-06-06 00:00:00', 380000.00);

-- ----------------------------
-- Table structure for guest_info
-- ----------------------------
DROP TABLE IF EXISTS `guest_info`;
CREATE TABLE `guest_info`  (
  `guest_name` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `contact_inf` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `business_re` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`guest_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of guest_info
-- ----------------------------
INSERT INTO `guest_info` VALUES ('Alexander', '12546845', 'changsha', 'day3');
INSERT INTO `guest_info` VALUES ('Anna', '51465455', 'chongqing', 'day1');
INSERT INTO `guest_info` VALUES ('Brant', '98456215', 'anhui', 'day4');
INSERT INTO `guest_info` VALUES ('Cheney', '84586854', 'guilin', 'day5');
INSERT INTO `guest_info` VALUES ('Lucy', '1111111', 'Shanghai', '12');
INSERT INTO `guest_info` VALUES ('任虹宇', '12121212', 'chongqing', '23');

-- ----------------------------
-- Table structure for sales_info
-- ----------------------------
DROP TABLE IF EXISTS `sales_info`;
CREATE TABLE `sales_info`  (
  `sale_date` datetime(0) NOT NULL COMMENT '销售日期',
  `Car_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '轿车类型',
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '颜色',
  `number` int(255) NOT NULL COMMENT '数量',
  `handler` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '经手人',
  PRIMARY KEY (`handler`, `sale_date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sales_info
-- ----------------------------
INSERT INTO `sales_info` VALUES ('2018-07-12 00:00:00', 'ONE.1', 'black white', 1, '	Alice');
INSERT INTO `sales_info` VALUES ('2018-11-07 00:00:00', 'Huayra', 'Red', 1, '	Anna');
INSERT INTO `sales_info` VALUES ('2018-06-20 00:00:00', 'Elise', 'Red', 5, '	Anne');
INSERT INTO `sales_info` VALUES ('2018-04-10 00:00:00', '	Elise', 'Red', 2, '	Blank');
INSERT INTO `sales_info` VALUES ('2018-01-18 00:00:00', 'Elise	', 'Red', 4, '	Bob');
INSERT INTO `sales_info` VALUES ('2018-07-10 00:00:00', 'Zonda', 'black red', 4, '	Bob');
INSERT INTO `sales_info` VALUES ('2017-12-13 00:00:00', '	Agera RS', 'Grey', 3, '	Lucy');
INSERT INTO `sales_info` VALUES ('2019-05-30 00:00:00', 'M3', 'White', 3, '	Lucy');
INSERT INTO `sales_info` VALUES ('2019-06-15 00:00:00', 'X6 M', 'Green', 2, '	Mike');
INSERT INTO `sales_info` VALUES ('2019-06-12 00:00:00', '卡罗拉', 'White', 5, 'Anne');
INSERT INTO `sales_info` VALUES ('2019-03-21 00:00:00', 'Agera', 'Black', 2, 'Blank');
INSERT INTO `sales_info` VALUES ('2019-02-02 00:00:00', '911', 'Yellow', 4, '任宏宇');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(6) UNSIGNED ZEROFILL NOT NULL COMMENT '用户ID',
  `user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`, `user`, `password`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (000001, 'root', 'toor');

-- ----------------------------
-- Table structure for worker_info
-- ----------------------------
DROP TABLE IF EXISTS `worker_info`;
CREATE TABLE `worker_info`  (
  `worker_id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` enum('男','女') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `age` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年龄',
  `origin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '籍贯',
  `education` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL COMMENT '学历',
  PRIMARY KEY (`worker_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11111111 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of worker_info
-- ----------------------------
INSERT INTO `worker_info` VALUES (123456, '黄鹏程', '女', '23', 'china', 'unkonw');
INSERT INTO `worker_info` VALUES (1234567, 'renhongyu', '男', '21', 'china', 'hight');
INSERT INTO `worker_info` VALUES (3465148, 'Mike', '男', '22', 'England', 'college');
INSERT INTO `worker_info` VALUES (4698542, 'Alice', '男', '21', 'France', 'college');
INSERT INTO `worker_info` VALUES (5421510, 'Anne', '女', '28', 'England', 'college');
INSERT INTO `worker_info` VALUES (5468451, 'Blank', '男', '24', 'American', 'high school student');
INSERT INTO `worker_info` VALUES (5945132, 'Anna', '女', '24', 'American', 'college');
INSERT INTO `worker_info` VALUES (8465125, 'Bob', '男', '19', 'England', 'Junior high school students');
INSERT INTO `worker_info` VALUES (8465135, 'kaka', '男', '18', 'China', 'college');

SET FOREIGN_KEY_CHECKS = 1;
