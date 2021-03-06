CREATE DATABASE `Beatsaver` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `Metadata` (
  `songId` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bpm` double DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `songName` varchar(100) DEFAULT NULL,
  `songSubName` varchar(100) DEFAULT NULL,
  `songAuthorName` varchar(100) DEFAULT NULL,
  `levelAuthorName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`songId`),
  CONSTRAINT `Metadata_FK` FOREIGN KEY (`songId`) REFERENCES `Song` (`songId`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `Song` (
  `songId` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `uploaderId` int NOT NULL,
  `uploaded` varchar(100) DEFAULT NULL,
  `automapper` tinyint(1) DEFAULT NULL,
  `ranked` tinyint(1) DEFAULT NULL,
  `qualified` tinyint(1) DEFAULT NULL,
  `createdAt` varchar(100) DEFAULT NULL,
  `updatedAt` varchar(100) DEFAULT NULL,
  `lastPublishedAt` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`songId`),
  KEY `Song_FK` (`uploaderId`),
  CONSTRAINT `Song_FK` FOREIGN KEY (`uploaderId`) REFERENCES `Uploader` (`uploaderId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `Stats` (
  `songId` varchar(100) NOT NULL,
  `plays` int DEFAULT NULL,
  `downloads` int DEFAULT NULL,
  `upvotes` int DEFAULT NULL,
  `downvotes` int DEFAULT NULL,
  `score` double DEFAULT NULL,
  PRIMARY KEY (`songId`),
  CONSTRAINT `Stats_FK` FOREIGN KEY (`songId`) REFERENCES `Song` (`songId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `Uploader` (
  `uploaderId` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `hash` varchar(100) DEFAULT NULL,
  `avatar` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uploaderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `Version` (
  `hash` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `songId` varchar(100) NOT NULL,
  `state` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createdAt` varchar(100) DEFAULT NULL,
  `sageScore` varchar(100) DEFAULT NULL,
  `downloadURL` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `coverURL` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `previewURL` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`hash`),
  KEY `Version_FK` (`songId`),
  CONSTRAINT `Version_FK` FOREIGN KEY (`songId`) REFERENCES `Song` (`songId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;