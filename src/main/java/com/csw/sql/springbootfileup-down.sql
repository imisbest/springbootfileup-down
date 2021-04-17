/*
 Navicat Premium Data Transfer

 Source Server         : 106.13.236.137_3306
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : 106.13.236.137:3306
 Source Schema         : springbootfileup-down

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 15/01/2020 17:26:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ffile
-- ----------------------------
DROP TABLE IF EXISTS `ffile`;
CREATE TABLE `ffile`  (
  `id` varchar(99) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `oname` varchar(99) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nname` varchar(99) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `z_file` varchar(99) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(99) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sizes` varchar(99) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(99) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `istrue` varchar(99) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` varchar(999) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ffile
-- ----------------------------
INSERT INTO `ffile` VALUES ('11111', '张三.txt', 'uuid.txt', '.txt', '/files/..', '1024', 'text/pain', '是', '0');

-- ----------------------------
-- Table structure for fuser
-- ----------------------------
DROP TABLE IF EXISTS `fuser`;
CREATE TABLE `fuser`  (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of fuser
-- ----------------------------
INSERT INTO `fuser` VALUES ('qqq', 'qqq');

SET FOREIGN_KEY_CHECKS = 1;
