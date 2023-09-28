/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80100
 Source Host           : localhost:3306
 Source Schema         : mypj

 Target Server Type    : MySQL
 Target Server Version : 80100
 File Encoding         : 65001

 Date: 28/09/2023 22:43:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hrecord
-- ----------------------------
DROP TABLE IF EXISTS `hrecord`;
CREATE TABLE `hrecord`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `hid` int(0) NOT NULL,
  `uid` int(0) NOT NULL,
  `file_path` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` date NULL DEFAULT NULL,
  `update_time` date NULL DEFAULT NULL,
  `context` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hrecord
-- ----------------------------
INSERT INTO `hrecord` VALUES (1, 2, 1, 'c://', '2023-09-28', NULL, 'honor');
INSERT INTO `hrecord` VALUES (2, 1, 1, 'c://', '2023-09-28', NULL, 'honor');

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `series` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `token` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `last_used` timestamp(0) NOT NULL,
  PRIMARY KEY (`series`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 264 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (1, '${val1} + ${val2}');
INSERT INTO `record` VALUES (2, '${val1} + ${val2}');
INSERT INTO `record` VALUES (3, '${val1} + ${val2}');
INSERT INTO `record` VALUES (4, '${val1} + ${val2}');
INSERT INTO `record` VALUES (5, '${val1} + ${val2}');
INSERT INTO `record` VALUES (6, '${val1} + ${val2}');
INSERT INTO `record` VALUES (7, '${val1} + ${val2}');
INSERT INTO `record` VALUES (8, '${val1} + ${val2}');
INSERT INTO `record` VALUES (9, '${val1} + ${val2}');
INSERT INTO `record` VALUES (10, '${val1} + ${val2}');
INSERT INTO `record` VALUES (11, '${val1} + ${val2}');
INSERT INTO `record` VALUES (12, '${val1} + ${val2}');
INSERT INTO `record` VALUES (13, '${val1} + ${val2}');
INSERT INTO `record` VALUES (14, '${val1} + ${val2}');
INSERT INTO `record` VALUES (15, '${val1} + ${val2}');
INSERT INTO `record` VALUES (16, '${val1} + ${val2}');
INSERT INTO `record` VALUES (17, '${val1} + ${val2}');
INSERT INTO `record` VALUES (18, '${val1} + ${val2}');
INSERT INTO `record` VALUES (19, '${val1} + ${val2}');
INSERT INTO `record` VALUES (20, '${val1} + ${val2}');
INSERT INTO `record` VALUES (21, '${val1} + ${val2}');
INSERT INTO `record` VALUES (22, '${val1} + ${val2}');
INSERT INTO `record` VALUES (23, '${val1} + ${val2}');
INSERT INTO `record` VALUES (24, '${val1} + ${val2}');
INSERT INTO `record` VALUES (25, '${val1} + ${val2}');
INSERT INTO `record` VALUES (26, '${val1} + ${val2}');
INSERT INTO `record` VALUES (27, '${val1} + ${val2}');
INSERT INTO `record` VALUES (28, '${val1} + ${val2}');
INSERT INTO `record` VALUES (29, '${val1} + ${val2}');
INSERT INTO `record` VALUES (30, '${val1} + ${val2}');
INSERT INTO `record` VALUES (31, '${val1} + ${val2}');
INSERT INTO `record` VALUES (32, '${val1} + ${val2}');
INSERT INTO `record` VALUES (33, '${val1} + ${val2}');
INSERT INTO `record` VALUES (34, '${val1} + ${val2}');
INSERT INTO `record` VALUES (35, '${val1} + ${val2}');
INSERT INTO `record` VALUES (36, '${val1} + ${val2}');
INSERT INTO `record` VALUES (37, '${val1} + ${val2}');
INSERT INTO `record` VALUES (38, '${val1} + ${val2}');
INSERT INTO `record` VALUES (39, '${val1} + ${val2}');
INSERT INTO `record` VALUES (40, '${val1} + ${val2}');
INSERT INTO `record` VALUES (41, '${val1} + ${val2}');
INSERT INTO `record` VALUES (42, '${val1} + ${val2}');
INSERT INTO `record` VALUES (43, '${val1} + ${val2}');
INSERT INTO `record` VALUES (44, '${val1} + ${val2}');
INSERT INTO `record` VALUES (45, '${val1} + ${val2}');
INSERT INTO `record` VALUES (46, '${val1} + ${val2}');
INSERT INTO `record` VALUES (47, '${val1} + ${val2}');
INSERT INTO `record` VALUES (48, '${val1} + ${val2}');
INSERT INTO `record` VALUES (49, '${val1} + ${val2}');
INSERT INTO `record` VALUES (50, '${val1} + ${val2}');
INSERT INTO `record` VALUES (51, '${val1} + ${val2}');
INSERT INTO `record` VALUES (52, '${val1} + ${val2}');
INSERT INTO `record` VALUES (53, '${val1} + ${val2}');
INSERT INTO `record` VALUES (54, '${val1} + ${val2}');
INSERT INTO `record` VALUES (55, '${val1} + ${val2}');
INSERT INTO `record` VALUES (56, '${val1} + ${val2}');
INSERT INTO `record` VALUES (57, '${val1} + ${val2}');
INSERT INTO `record` VALUES (58, '${val1} + ${val2}');
INSERT INTO `record` VALUES (59, '${val1} + ${val2}');
INSERT INTO `record` VALUES (60, '${val1} + ${val2}');
INSERT INTO `record` VALUES (61, '${val1} + ${val2}');
INSERT INTO `record` VALUES (62, '${val1} + ${val2}');
INSERT INTO `record` VALUES (63, '${val1} + ${val2}');
INSERT INTO `record` VALUES (64, '${val1} + ${val2}');
INSERT INTO `record` VALUES (65, '${val1} + ${val2}');
INSERT INTO `record` VALUES (66, '${val1} + ${val2}');
INSERT INTO `record` VALUES (67, '${val1} + ${val2}');
INSERT INTO `record` VALUES (68, '${val1} + ${val2}');
INSERT INTO `record` VALUES (69, '${val1} + ${val2}');
INSERT INTO `record` VALUES (70, '${val1} + ${val2}');
INSERT INTO `record` VALUES (71, '${val1} + ${val2}');
INSERT INTO `record` VALUES (72, '${val1} + ${val2}');
INSERT INTO `record` VALUES (73, '${val1} + ${val2}');
INSERT INTO `record` VALUES (74, '${val1} + ${val2}');
INSERT INTO `record` VALUES (75, '${val1} + ${val2}');
INSERT INTO `record` VALUES (76, '${val1} + ${val2}');
INSERT INTO `record` VALUES (77, '${val1} + ${val2}');
INSERT INTO `record` VALUES (78, '${val1} + ${val2}');
INSERT INTO `record` VALUES (79, '${val1} + ${val2}');
INSERT INTO `record` VALUES (80, '${val1} + ${val2}');
INSERT INTO `record` VALUES (81, '${val1} + ${val2}');
INSERT INTO `record` VALUES (82, '${val1} + ${val2}');
INSERT INTO `record` VALUES (83, '${val1} + ${val2}');
INSERT INTO `record` VALUES (84, '${val1} + ${val2}');
INSERT INTO `record` VALUES (85, '${val1} + ${val2}');
INSERT INTO `record` VALUES (86, '${val1} + ${val2}');
INSERT INTO `record` VALUES (87, '${val1} + ${val2}');
INSERT INTO `record` VALUES (88, '${val1} + ${val2}');
INSERT INTO `record` VALUES (89, '${val1} + ${val2}');
INSERT INTO `record` VALUES (90, '${val1} + ${val2}');
INSERT INTO `record` VALUES (91, '${val1} + ${val2}');
INSERT INTO `record` VALUES (92, '${val1} + ${val2}');
INSERT INTO `record` VALUES (93, '${val1} + ${val2}');
INSERT INTO `record` VALUES (94, '${val1} + ${val2}');
INSERT INTO `record` VALUES (95, '${val1} + ${val2}');
INSERT INTO `record` VALUES (96, '${val1} + ${val2}');
INSERT INTO `record` VALUES (97, '${val1} + ${val2}');
INSERT INTO `record` VALUES (98, '${val1} + ${val2}');
INSERT INTO `record` VALUES (99, '${val1} + ${val2}');
INSERT INTO `record` VALUES (100, '${val1} + ${val2}');
INSERT INTO `record` VALUES (101, '${val1} + ${val2}');
INSERT INTO `record` VALUES (102, '${val1} + ${val2}');
INSERT INTO `record` VALUES (103, '${val1} + ${val2}');
INSERT INTO `record` VALUES (104, '${val1} + ${val2}');
INSERT INTO `record` VALUES (105, '${val1} + ${val2}');
INSERT INTO `record` VALUES (106, '${val1} + ${val2}');
INSERT INTO `record` VALUES (107, '${val1} + ${val2}');
INSERT INTO `record` VALUES (108, '${val1} + ${val2}');
INSERT INTO `record` VALUES (109, '${val1} + ${val2}');
INSERT INTO `record` VALUES (110, '${val1} + ${val2}');
INSERT INTO `record` VALUES (111, '${val1} + ${val2}');
INSERT INTO `record` VALUES (112, '${val1} + ${val2}');
INSERT INTO `record` VALUES (113, '${val1} + ${val2}');
INSERT INTO `record` VALUES (114, '${val1} + ${val2}');
INSERT INTO `record` VALUES (115, '${val1} + ${val2}');
INSERT INTO `record` VALUES (116, '${val1} + ${val2}');
INSERT INTO `record` VALUES (117, '${val1} + ${val2}');
INSERT INTO `record` VALUES (118, '${val1} + ${val2}');
INSERT INTO `record` VALUES (119, '${val1} + ${val2}');
INSERT INTO `record` VALUES (120, '${val1} + ${val2}');
INSERT INTO `record` VALUES (121, '${val1} + ${val2}');
INSERT INTO `record` VALUES (122, '${val1} + ${val2}');
INSERT INTO `record` VALUES (123, '${val1} + ${val2}');
INSERT INTO `record` VALUES (124, '${val1} + ${val2}');
INSERT INTO `record` VALUES (125, '${val1} + ${val2}');
INSERT INTO `record` VALUES (126, '${val1} + ${val2}');
INSERT INTO `record` VALUES (127, '${val1} + ${val2}');
INSERT INTO `record` VALUES (128, '${val1} + ${val2}');
INSERT INTO `record` VALUES (129, '${val1} + ${val2}');
INSERT INTO `record` VALUES (130, '${val1} + ${val2}');
INSERT INTO `record` VALUES (131, '${val1} + ${val2}');
INSERT INTO `record` VALUES (132, '${val1} + ${val2}');
INSERT INTO `record` VALUES (133, '${val1} + ${val2}');
INSERT INTO `record` VALUES (134, '${val1} + ${val2}');
INSERT INTO `record` VALUES (135, '${val1} + ${val2}');
INSERT INTO `record` VALUES (136, '${val1} + ${val2}');
INSERT INTO `record` VALUES (137, '${val1} + ${val2}');
INSERT INTO `record` VALUES (138, '${val1} + ${val2}');
INSERT INTO `record` VALUES (139, '${val1} + ${val2}');
INSERT INTO `record` VALUES (140, '${val1} + ${val2}');
INSERT INTO `record` VALUES (141, '${val1} + ${val2}');
INSERT INTO `record` VALUES (142, '${val1} + ${val2}');
INSERT INTO `record` VALUES (143, '${val1} + ${val2}');
INSERT INTO `record` VALUES (144, '${val1} + ${val2}');
INSERT INTO `record` VALUES (145, '${val1} + ${val2}');
INSERT INTO `record` VALUES (146, '${val1} + ${val2}');
INSERT INTO `record` VALUES (147, '${val1} + ${val2}');
INSERT INTO `record` VALUES (148, '${val1} + ${val2}');
INSERT INTO `record` VALUES (149, '${val1} + ${val2}');
INSERT INTO `record` VALUES (150, '${val1} + ${val2}');
INSERT INTO `record` VALUES (151, '${val1} + ${val2}');
INSERT INTO `record` VALUES (152, '${val1} + ${val2}');
INSERT INTO `record` VALUES (153, '${val1} + ${val2}');
INSERT INTO `record` VALUES (154, '${val1} + ${val2}');
INSERT INTO `record` VALUES (155, '${val1} + ${val2}');
INSERT INTO `record` VALUES (156, '${val1} + ${val2}');
INSERT INTO `record` VALUES (157, '${val1} + ${val2}');
INSERT INTO `record` VALUES (158, '${val1} + ${val2}');
INSERT INTO `record` VALUES (159, '${val1} + ${val2}');
INSERT INTO `record` VALUES (160, '${val1} + ${val2}');
INSERT INTO `record` VALUES (161, '${val1} + ${val2}');
INSERT INTO `record` VALUES (162, '${val1} + ${val2}');
INSERT INTO `record` VALUES (163, '${val1} + ${val2}');
INSERT INTO `record` VALUES (164, '${val1} + ${val2}');
INSERT INTO `record` VALUES (165, '${val1} + ${val2}');
INSERT INTO `record` VALUES (166, '${val1} + ${val2}');
INSERT INTO `record` VALUES (167, '${val1} + ${val2}');
INSERT INTO `record` VALUES (168, '${val1} + ${val2}');
INSERT INTO `record` VALUES (169, '${val1} + ${val2}');
INSERT INTO `record` VALUES (170, '${val1} + ${val2}');
INSERT INTO `record` VALUES (171, '${val1} + ${val2}');
INSERT INTO `record` VALUES (172, '${val1} + ${val2}');
INSERT INTO `record` VALUES (173, '${val1} + ${val2}');
INSERT INTO `record` VALUES (174, '${val1} + ${val2}');
INSERT INTO `record` VALUES (175, '${val1} + ${val2}');
INSERT INTO `record` VALUES (176, '${val1} + ${val2}');
INSERT INTO `record` VALUES (177, '${val1} + ${val2}');
INSERT INTO `record` VALUES (178, '${val1} + ${val2}');
INSERT INTO `record` VALUES (179, '${val1} + ${val2}');
INSERT INTO `record` VALUES (180, '${val1} + ${val2}');
INSERT INTO `record` VALUES (181, '${val1} + ${val2}');
INSERT INTO `record` VALUES (182, '${val1} + ${val2}');
INSERT INTO `record` VALUES (183, '${val1} + ${val2}');
INSERT INTO `record` VALUES (184, '${val1} + ${val2}');
INSERT INTO `record` VALUES (185, '${val1} + ${val2}');
INSERT INTO `record` VALUES (186, '${val1} + ${val2}');
INSERT INTO `record` VALUES (187, '${val1} + ${val2}');
INSERT INTO `record` VALUES (188, '${val1} + ${val2}');
INSERT INTO `record` VALUES (189, '${val1} + ${val2}');
INSERT INTO `record` VALUES (190, '${val1} + ${val2}');
INSERT INTO `record` VALUES (191, '${val1} + ${val2}');
INSERT INTO `record` VALUES (192, '${val1} + ${val2}');
INSERT INTO `record` VALUES (193, '${val1} + ${val2}');
INSERT INTO `record` VALUES (194, '${val1} + ${val2}');
INSERT INTO `record` VALUES (195, '${val1} + ${val2}');
INSERT INTO `record` VALUES (196, '${val1} + ${val2}');
INSERT INTO `record` VALUES (197, '${val1} + ${val2}');
INSERT INTO `record` VALUES (198, '${val1} + ${val2}');
INSERT INTO `record` VALUES (199, '${val1} + ${val2}');
INSERT INTO `record` VALUES (200, '${val1} + ${val2}');
INSERT INTO `record` VALUES (201, '${val1} + ${val2}');
INSERT INTO `record` VALUES (202, '${val1} + ${val2}');
INSERT INTO `record` VALUES (203, '${val1} + ${val2}');
INSERT INTO `record` VALUES (204, '${val1} + ${val2}');
INSERT INTO `record` VALUES (205, '${val1} + ${val2}');
INSERT INTO `record` VALUES (206, '${val1} + ${val2}');
INSERT INTO `record` VALUES (207, '${val1} + ${val2}');
INSERT INTO `record` VALUES (208, '${val1} + ${val2}');
INSERT INTO `record` VALUES (209, '${val1} + ${val2}');
INSERT INTO `record` VALUES (210, '${val1} + ${val2}');
INSERT INTO `record` VALUES (211, '${val1} + ${val2}');
INSERT INTO `record` VALUES (212, '${val1} + ${val2}');
INSERT INTO `record` VALUES (213, '${val1} + ${val2}');
INSERT INTO `record` VALUES (214, '${val1} + ${val2}');
INSERT INTO `record` VALUES (215, '${val1} + ${val2}');
INSERT INTO `record` VALUES (216, '${val1} + ${val2}');
INSERT INTO `record` VALUES (217, '${val1} + ${val2}');
INSERT INTO `record` VALUES (218, '${val1} + ${val2}');
INSERT INTO `record` VALUES (219, '${val1} + ${val2}');
INSERT INTO `record` VALUES (220, '${val1} + ${val2}');
INSERT INTO `record` VALUES (221, '${val1} + ${val2}');
INSERT INTO `record` VALUES (222, '${val1} + ${val2}');
INSERT INTO `record` VALUES (223, '${val1} + ${val2}');
INSERT INTO `record` VALUES (224, '${val1} + ${val2}');
INSERT INTO `record` VALUES (225, '${val1} + ${val2}');
INSERT INTO `record` VALUES (226, '${val1} + ${val2}');
INSERT INTO `record` VALUES (227, '${val1} + ${val2}');
INSERT INTO `record` VALUES (228, '${val1} + ${val2}');
INSERT INTO `record` VALUES (229, '${val1} + ${val2}');
INSERT INTO `record` VALUES (230, '${val1} + ${val2}');
INSERT INTO `record` VALUES (231, '${val1} + ${val2}');
INSERT INTO `record` VALUES (232, '${val1} + ${val2}');
INSERT INTO `record` VALUES (233, '${val1} + ${val2}');
INSERT INTO `record` VALUES (234, '${val1} + ${val2}');
INSERT INTO `record` VALUES (235, '${val1} + ${val2} + ${val3}');
INSERT INTO `record` VALUES (236, '${val1} + ${val2}');
INSERT INTO `record` VALUES (237, '${val1} + ${val2} + ${val3}');
INSERT INTO `record` VALUES (238, '${val1} + ${val2}');
INSERT INTO `record` VALUES (239, '${val1} + ${val2} + ${val3}');
INSERT INTO `record` VALUES (240, '${val1} + ${val2}');
INSERT INTO `record` VALUES (241, '${val1} + ${val2} + ${val3}');
INSERT INTO `record` VALUES (242, '${val1} + ${val2}');
INSERT INTO `record` VALUES (243, '${val1} + ${val2} + ${val3}');
INSERT INTO `record` VALUES (244, '${val1} + ${val2}');
INSERT INTO `record` VALUES (245, '${val1} + ${val2} + ${val3}');
INSERT INTO `record` VALUES (246, '${val1} + ${val2}');
INSERT INTO `record` VALUES (247, '${val1} + ${val2} + ${val3}');
INSERT INTO `record` VALUES (248, '${val1} + ${val2}');
INSERT INTO `record` VALUES (249, '${val1} + ${val2} + ${val3}');
INSERT INTO `record` VALUES (250, '${val1} + ${val2}');
INSERT INTO `record` VALUES (251, '${val1} + ${val2} + ${val3}');
INSERT INTO `record` VALUES (252, '${val1} + ${val2}');
INSERT INTO `record` VALUES (253, '${val1} + ${val2} + ${val3}');
INSERT INTO `record` VALUES (254, '${val1} + ${val2}');
INSERT INTO `record` VALUES (255, '${val1} + ${val2} + ${val3}');
INSERT INTO `record` VALUES (256, '${val1} + ${val2}');
INSERT INTO `record` VALUES (257, '${val1} + ${val2} + ${val3}');
INSERT INTO `record` VALUES (258, '${val1} + ${val2}');
INSERT INTO `record` VALUES (259, '${val1} + ${val2} + ${val3}');
INSERT INTO `record` VALUES (260, '${val1} + ${val2}');
INSERT INTO `record` VALUES (261, '${val1} + ${val2} + ${val3}');
INSERT INTO `record` VALUES (262, '${val1} + ${val2} + ${val3}');
INSERT INTO `record` VALUES (263, '${val1} + ${val2} + ${val3}');
INSERT INTO `record` VALUES (264, '${val1} + ${val2} + ${val3}');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tel` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'carry', '$2a$10$hdVLUj3k.mtPdLgsVU/s/.D0wpR0z5DtIG08sKfkzMs8ibb6teXom', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (6, 'tt', '$2a$10$A5dwGKVogUtoMgX/h3LOMuEHJ12mrah9TpQfmeotQcBexW84h6B.K', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
