
CREATE DATABASE IF NOT EXISTS `student` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `student`;


CREATE TABLE IF NOT EXISTS `admin` (
  `id` int NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `admin` (`id`, `name`, `email`, `password`) VALUES
(1, 'admin', 'admin@apsit', '123');


CREATE TABLE IF NOT EXISTS `BranchData` (
  `Bid` int NOT NULL,
  `id` int NOT NULL,
  `Course` varchar(10) NOT NULL,
  `PaymentID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Branch` varchar(30) NOT NULL,
  `Year` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `BranchData` (`Bid`, `id`, `Course`, `PaymentID`, `Branch`, `Year`) VALUES
(1, 1, 'BTech', 'awjd654', 'Computer Science', 'FE'),
(2, 1, 'BTech', 'gdaw552', 'IT', 'FE'),
(3, 1, 'BTech', 'agwd926', 'Civil', 'FE'),
(4, 2, 'BTech', '4546dawd', 'Mechanical', 'TE'),
(5, 3, 'BTech', '48654865', 'IT', 'FE'),
(6, 3, 'BTech', 'awer', 'Civil', 'FE');


CREATE TABLE IF NOT EXISTS `PersonalData` (
  `PdID` int NOT NULL,
  `id` int NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `middlename` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `phoneno1` int NOT NULL,
  `phoneno2` int DEFAULT NULL,
  `address` varchar(100) NOT NULL,
  `email` varchar(30) NOT NULL,
  `dob` date NOT NULL,
  `city` varchar(30) NOT NULL,
  `state` varchar(30) NOT NULL,
  `pincode` int NOT NULL,
  `photoAddress` varchar(100) NOT NULL,
  `IdAddress` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `PersonalData` (`PdID`, `id`, `firstname`, `middlename`, `lastname`, `phoneno1`, `phoneno2`, `address`, `email`, `dob`, `city`, `state`, `pincode`, `photoAddress`, `IdAddress`) VALUES
(1, 1, 'Chirag', 'Padyal', 'Sanjay', 9999999, 9999999, 'somewhere on planet Earth.', 'chirag@gmail.com', '2021-11-09', 'Thane', 'Maharashtra', 594645, '/Storage/1/1-ID.png', '/Storage/1/1-Photo.png'),
(2, 2, 'Rakesh', 'Patil', 'Suresh', 65666656, 65666656, 'aseugfaeu auufae awihhfea aiwhf iahwfiae aiwhf', 'Rakesh@mail.com', '2021-11-23', 'Thane', 'Maharashtra', 8754564, '/Storage/2/2-ID.png', '/Storage/2/2-Photo.png'),
(3, 3, 'Jaykumar', 'Nayi', 'A', 54666466, 54666466, 'dyawgdy duawgidfgaw gdauwgdoaw dhdoiaw dawhd', 'Jaykumar@mail.com', '2021-11-14', 'Thane', 'Maharashtra', 65466, '/Storage/3/3-ID.png', '/Storage/3/3-Photo.png');

CREATE TABLE IF NOT EXISTS `RegistrationData` (
  `Rid` int NOT NULL,
  `id` int NOT NULL,
  `SSC` int NOT NULL,
  `HSC` int NOT NULL,
  `MHCET` int DEFAULT NULL,
  `JEE` int DEFAULT NULL,
  `sscCert` varchar(50) NOT NULL,
  `hscCert` varchar(50) NOT NULL,
  `mhCert` varchar(50) NOT NULL,
  `jeeCert` varchar(50) NOT NULL,
  `eligible` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `RegistrationData` (`Rid`, `id`, `SSC`, `HSC`, `MHCET`, `JEE`, `sscCert`, `hscCert`, `mhCert`, `jeeCert`, `eligible`) VALUES
(1, 1, 88, 80, 70, 30, '/Storage/1/1-scc_certificate.png', '/Storage/1/1-hcc_certificate.png', '/Storage/1/1-mhcet_certificate.png', '/Storage/1/1-jee_certificate.png', 'yes'),
(2, 2, 70, 60, 70, 45, '/Storage/2/2-scc_certificate.png', '/Storage/2/2-hcc_certificate.png', '/Storage/2/2-mhcet_certificate.png', '/Storage/2/2-jee_certificate.png', 'no'),
(3, 3, 80, 70, 70, 70, '/Storage/3/3-scc_certificate.png', '/Storage/3/3-hcc_certificate.png', '/Storage/3/3-mhcet_certificate.png', '/Storage/3/3-jee_certificate.png', 'yes');

CREATE TABLE IF NOT EXISTS `studentReg` (
  `id` int NOT NULL,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `studentReg` (`id`, `name`, `email`, `password`) VALUES
(1, 'chirag', 'chirag@mail.com', 'pass'),
(2, 'Rakesh', 'Rakesh@mail.com', 'pass'),
(3, 'Jaykumar', 'Jaykumar@mail.com', 'pass');


ALTER TABLE `BranchData`
  ADD PRIMARY KEY (`Bid`),
  ADD KEY `Fk_BranchData` (`id`);


ALTER TABLE `PersonalData`
  ADD PRIMARY KEY (`PdID`),
  ADD KEY `FK_PersonOrder` (`id`);


ALTER TABLE `RegistrationData`
  ADD PRIMARY KEY (`Rid`),
  ADD KEY `fk_foreign_key_name` (`id`);


ALTER TABLE `studentReg`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `BranchData`
  MODIFY `Bid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE `PersonalData`
  MODIFY `PdID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `RegistrationData`
  MODIFY `Rid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `studentReg`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `BranchData`
  ADD CONSTRAINT `Fk_BranchData` FOREIGN KEY (`id`) REFERENCES `studentReg` (`id`);

ALTER TABLE `PersonalData`
  ADD CONSTRAINT `FK_PersonOrder` FOREIGN KEY (`id`) REFERENCES `studentReg` (`id`),
  ADD CONSTRAINT `PersonalData_ibfk_1` FOREIGN KEY (`id`) REFERENCES `studentReg` (`id`);

ALTER TABLE `RegistrationData`
  ADD CONSTRAINT `fk_foreign_key_name` FOREIGN KEY (`id`) REFERENCES `studentReg` (`id`);
COMMIT;
