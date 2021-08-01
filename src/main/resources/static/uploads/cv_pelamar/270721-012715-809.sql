-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 18, 2021 at 07:24 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `doize`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  `creadate` datetime NOT NULL,
  `modidate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `name`, `birth_date`, `phone`, `email`, `password`, `status`, `creadate`, `modidate`) VALUES
(1, 'Samodra', '2000-12-08', '081234331541', 'samodra.me@gmail.com', '$2y$12$rBmJzRClAl6LevV0kz1i4etvcU/JO.VxLoMeVrywQzEg3IbpA8sde', 1, '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(3, 'Meita', '2002-05-23', '087788664575', 'meita.s@gmail.com', '$2y$10$nbjxbTVmKlj4rPG9AgspKu36cNPkfng/fQIIz2OVGxuyst/FASb5u', 1, '2021-07-17 13:56:04', '2021-07-17 13:56:04'),
(4, 'Andrias', '2002-05-23', '087788664575', 'andrias@gmail.com', '$2y$10$Pc6tyUJOPmDDVsF1.5dh4O6W8GATahXTCnSWAb4Qg5PfepEtTtAAe', 1, '2021-07-19 00:10:29', '2021-07-19 00:10:29'),
(5, 'Pras', NULL, NULL, 'pras@gmail.com', '$2y$10$t58v7znecisIKq7TmBmyiOTDNSPvZhgmmQDysYZ1gsNkcWGz88L.u', 1, '2021-07-19 00:21:38', '2021-07-19 00:21:38');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
