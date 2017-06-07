CREATE TABLE `loopholedata` (
  `CNNVD_ID` varchar(255) NOT NULL,
  `loopholeName` varchar(255) DEFAULT NULL,
  `publishTime` varchar(255) DEFAULT NULL,
  `updateTime` varchar(255) DEFAULT NULL,
  `dangerGrade` varchar(255) DEFAULT NULL,
  `loopholeType` varchar(255) DEFAULT NULL,
  `dangerType` varchar(255) DEFAULT NULL,
  `CVE_ID` varchar(255) DEFAULT NULL,
  `loopholeIntroduce` varchar(2550) DEFAULT NULL,
  `loopholeAnnounce` varchar(2550) DEFAULT NULL,
  `loopholePatch` varchar(255) DEFAULT NULL,
  `effectEntity` varchar(2550) DEFAULT NULL,
  `relevantLoophole` varchar(2550) DEFAULT NULL,
  `loopholeURL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CNNVD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
