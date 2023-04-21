use esmile;
DROP TABLE IF EXISTS SYS_USER;

CREATE TABLE `SYS_USER` (
    `USER_ID` int NOT NULL AUTO_INCREMENT,
    `USER_NAME` varchar(30) DEFAULT NULL,
    `PASSWORD` varchar(50) DEFAULT NULL,
    `DELETED` int DEFAULT NULL,
    `CREATE_BY` varchar(30) DEFAULT NULL,
    `update_by` varchar(30) DEFAULT NULL,
    `CREATE_DATE` date DEFAULT NULL,
    `UPDATE_DATE` date DEFAULT NULL,
    PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
