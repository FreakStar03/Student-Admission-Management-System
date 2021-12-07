-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 07, 2021 at 03:08 PM
-- Server version: 8.0.26-0ubuntu0.20.04.3
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `email`, `password`) VALUES
(1, 'admin', 'admin@apsit', '123');

-- --------------------------------------------------------

--
-- Table structure for table `BranchData`
--

CREATE TABLE `BranchData` (
  `Bid` int NOT NULL,
  `id` int NOT NULL,
  `Course` varchar(10) NOT NULL,
  `PaymentID` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Branch` varchar(30) NOT NULL,
  `Year` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `BranchData`
--

INSERT INTO `BranchData` (`Bid`, `id`, `Course`, `PaymentID`, `Branch`, `Year`) VALUES
(4, 2, 'BTech', '4546dawd', 'Mechanical', 'TE'),
(5, 3, 'BTech', '48654865', 'IT', 'FE'),
(6, 3, 'BTech', 'awer', 'Civil', 'FE'),
(7, 4, 'BTech', 'wadawd', 'IT', 'FE'),
(9, 8, 'BTech', 'awdawedfa', 'IT', 'FE'),
(10, 10, 'BTech', 'dwad5515', 'Computer Science', 'SE'),
(11, 10, 'BTech', 'raesdf', 'IT', 'FE'),
(15, 12, 'BTech', '/Storage/12/12-receipt.png', 'Computer Science', 'TE'),
(16, 12, 'BTech', '/Storage/12/12-receipt.png', 'IT', 'FE');

-- --------------------------------------------------------

--
-- Table structure for table `PersonalData`
--

CREATE TABLE `PersonalData` (
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

--
-- Dumping data for table `PersonalData`
--

INSERT INTO `PersonalData` (`PdID`, `id`, `firstname`, `middlename`, `lastname`, `phoneno1`, `phoneno2`, `address`, `email`, `dob`, `city`, `state`, `pincode`, `photoAddress`, `IdAddress`) VALUES
(1, 1, 'Chirag', 'Padyal', 'Sanjay', 9999999, 9999999, 'somewhere on planet Earth.', 'chirag@gmail.com', '2021-11-09', 'Thane', 'Maharashtra', 594645, '/Storage/1/1-ID.png', '/Storage/1/1-Photo.png'),
(2, 2, 'Rakesh', 'Patil', 'Suresh', 65666656, 65666656, 'aseugfaeu auufae awihhfea aiwhf iahwfiae aiwhf', 'Rakesh@mail.com', '2021-11-23', 'Thane', 'Maharashtra', 8754564, '/Storage/2/2-ID.png', '/Storage/2/2-Photo.png'),
(3, 3, 'Jaykumar', 'Nayi', 'A', 54666466, 54666466, 'dyawgdy duawgidfgaw gdauwgdoaw dhdoiaw dawhd', 'Jaykumar@mail.com', '2021-11-14', 'Thane', 'Maharashtra', 65466, '/Storage/3/3-ID.png', '/Storage/3/3-Photo.png'),
(4, 4, 'Harish', 'Jain', 'Rakesh', 999999999, 999999999, 'awd adrw aw rfewafsa afef awfawef waf', 'harish@mail.com', '2021-11-14', 'Thane', 'Maharashtra', 475535, '/Storage/4/4-ID.png', '/Storage/4/4-Photo.png'),
(5, 6, 'joker', 'karen', 'haren', 4545242, 4545254, 'asdfef asfdaes awfd a a', 'joker@MAIL.COM', '2021-11-18', 'Thane', 'Maharashtra', 458452, '/Storage/6/6-ID.png', '/Storage/6/6-Photo.png'),
(6, 8, 'ganesh', 'tarun', 'harin', 5454545, 6566566, 'dawjyfdajey aiugdiuawgd uyiagdiuag ugaduasg augdu', 'ganesh@mail.com', '2021-11-22', 'Noida', 'Chennai', 546464, '/Storage/8/8-ID.png', '/Storage/8/8-Photo.png'),
(7, 9, 'neon', 'sage', 'king', 463454135, 569555636, 'dhawed aiwhdo haodihea hdoieahf  haiephdpead eihf aeifhea faeiohf', 'neon@mail.com', '2021-11-04', 'Thane', 'Maharashtra', 4000403, '/Storage/9/9-ID.png', '/Storage/9/9-Photo.png'),
(8, 10, 'adaw', 'awdaw', 'waddwad', 414556651, 423564624, 'fdsf saefdase faedf  degdsgdsdgsdgs ', 'dawedf@mail.com', '2021-04-15', 'Noida', 'Chennai', 58554, '/Storage/10/10-ID.png', '/Storage/10/10-Photo.png'),
(9, 12, 'sfsdfae', 'fdaed', 'eadawed', 486846868, 846486846, 'efawfad aawdawedf awdawda wdawdawd WDWAD', 'WADAWD@AWF', '2021-12-15', 'Thane', 'Maharashtra', 84687, '/Storage/12/12-ID.png', '/Storage/12/12-Photo.png');

-- --------------------------------------------------------

--
-- Table structure for table `RegistrationData`
--

CREATE TABLE `RegistrationData` (
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

--
-- Dumping data for table `RegistrationData`
--

INSERT INTO `RegistrationData` (`Rid`, `id`, `SSC`, `HSC`, `MHCET`, `JEE`, `sscCert`, `hscCert`, `mhCert`, `jeeCert`, `eligible`) VALUES
(1, 1, 88, 80, 70, 30, '/Storage/1/1-scc_certificate.png', '/Storage/1/1-hcc_certificate.png', '/Storage/1/1-mhcet_certificate.png', '/Storage/1/1-jee_certificate.png', 'yes'),
(2, 2, 70, 60, 70, 45, '/Storage/2/2-scc_certificate.png', '/Storage/2/2-hcc_certificate.png', '/Storage/2/2-mhcet_certificate.png', '/Storage/2/2-jee_certificate.png', 'no'),
(3, 3, 80, 70, 70, 70, '/Storage/3/3-scc_certificate.png', '/Storage/3/3-hcc_certificate.png', '/Storage/3/3-mhcet_certificate.png', '/Storage/3/3-jee_certificate.png', 'yes'),
(4, 4, 45, 45, 30, 45, '/Storage/4/4-scc_certificate.png', '/Storage/4/4-hcc_certificate.png', '/Storage/4/4-mhcet_certificate.png', '/Storage/4/4-jee_certificate.png', 'no'),
(5, 8, 50, 45, 70, 30, '/Storage/8/8-scc_certificate.png', '/Storage/8/8-hcc_certificate.png', '/Storage/8/8-mhcet_certificate.png', '/Storage/8/8-jee_certificate.png', 'no'),
(6, 10, 89, 89, 30, 30, '/Storage/10/10-scc_certificate.png', '/Storage/10/10-hcc_certificate.png', '/Storage/10/10-mhcet_certificate.png', '/Storage/10/10-jee_certificate.png', 'no'),
(7, 12, 56, 45, 45, 42, '/Storage/12/12-scc_certificate.png', '/Storage/12/12-hcc_certificate.png', '/Storage/12/12-mhcet_certificate.png', '/Storage/12/12-jee_certificate.png', 'no');

-- --------------------------------------------------------

--
-- Table structure for table `studentReg`
--

CREATE TABLE `studentReg` (
  `id` int NOT NULL,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `studentReg`
--

INSERT INTO `studentReg` (`id`, `name`, `email`, `password`) VALUES
(1, 'chirag', 'chirag@mail.com', 'pass'),
(2, 'Rakesh', 'Rakesh@mail.com', 'pass'),
(3, 'Jaykumar', 'Jaykumar@mail.com', 'pass'),
(4, 'harish', 'harish@mail.com', 'pass'),
(5, 'kiran', 'kiran@mail.com', 'pass'),
(6, 'Joker', 'joke@mail.com', 'pass'),
(7, 'nitin', 'nitin@mail.com', 'pass'),
(8, 'ganesh', 'ganesh@mail.com', 'pass'),
(9, 'neon', 'neon@mail.com', 'pass'),
(10, 'prakash', 'prakash@mail.com', 'pass'),
(11, 'goat', 'goat@mail.com', 'pass'),
(12, 'krish', 'krish@mail.com', 'pass'),
(13, 'dinesh', 'dinesh@gmail.com', 'pass');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `BranchData`
--
ALTER TABLE `BranchData`
  ADD PRIMARY KEY (`Bid`),
  ADD KEY `Fk_BranchData` (`id`);

--
-- Indexes for table `PersonalData`
--
ALTER TABLE `PersonalData`
  ADD PRIMARY KEY (`PdID`),
  ADD KEY `FK_PersonOrder` (`id`);

--
-- Indexes for table `RegistrationData`
--
ALTER TABLE `RegistrationData`
  ADD PRIMARY KEY (`Rid`),
  ADD KEY `fk_foreign_key_name` (`id`);

--
-- Indexes for table `studentReg`
--
ALTER TABLE `studentReg`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `BranchData`
--
ALTER TABLE `BranchData`
  MODIFY `Bid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `PersonalData`
--
ALTER TABLE `PersonalData`
  MODIFY `PdID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `RegistrationData`
--
ALTER TABLE `RegistrationData`
  MODIFY `Rid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `studentReg`
--
ALTER TABLE `studentReg`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `BranchData`
--
ALTER TABLE `BranchData`
  ADD CONSTRAINT `Fk_BranchData` FOREIGN KEY (`id`) REFERENCES `studentReg` (`id`);

--
-- Constraints for table `PersonalData`
--
ALTER TABLE `PersonalData`
  ADD CONSTRAINT `FK_PersonOrder` FOREIGN KEY (`id`) REFERENCES `studentReg` (`id`),
  ADD CONSTRAINT `PersonalData_ibfk_1` FOREIGN KEY (`id`) REFERENCES `studentReg` (`id`);

--
-- Constraints for table `RegistrationData`
--
ALTER TABLE `RegistrationData`
  ADD CONSTRAINT `fk_foreign_key_name` FOREIGN KEY (`id`) REFERENCES `studentReg` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
