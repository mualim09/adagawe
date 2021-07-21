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
-- Table structure for table `assignment`
--

CREATE TABLE `assignment` (
  `id_assignment` int(11) NOT NULL,
  `name_assignment` varchar(50) NOT NULL,
  `description_assignment` varchar(255) DEFAULT NULL,
  `course` varchar(50) NOT NULL,
  `duedate_assignment` datetime DEFAULT NULL,
  `reminder_at` datetime DEFAULT NULL,
  `priority` int(11) NOT NULL DEFAULT 0,
  `working_status` int(11) NOT NULL DEFAULT 0,
  `status` int(11) NOT NULL DEFAULT 1,
  `id_user` int(11) NOT NULL,
  `creadate` datetime NOT NULL DEFAULT current_timestamp(),
  `modidate` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `assignment`
--

INSERT INTO `assignment` (`id_assignment`, `name_assignment`, `description_assignment`, `course`, `duedate_assignment`, `reminder_at`, `priority`, `working_status`, `status`, `id_user`, `creadate`, `modidate`) VALUES
(1, 'Latihan_P5_2', 'Latihan activity', 'Pemrograman 6', '2021-07-14 23:46:57', '2021-07-13 23:46:57', 0, 0, 1, 1, '2021-07-12 23:47:48', '2021-07-12 23:47:48'),
(2, 'Latihan spring', 'latihan prg7 spring', 'Pemrograman 7', '2021-07-13 21:20:26', '2021-07-13 21:20:26', 0, 0, 1, 1, '2021-07-13 21:20:26', '2021-07-13 21:20:26'),
(3, 'Latihan jpa ku prg7', 'latihan prg7 gais', 'Pemrograman 7', '2021-07-13 21:20:26', '2021-07-13 21:20:26', 0, 0, 1, 1, '2021-07-13 21:20:26', '2021-07-13 21:20:26'),
(4, 'Latihan P6', 'latihan prg6', 'Pemrograman 6', '2021-07-13 21:20:30', '2021-07-13 21:20:30', 0, 0, 1, 1, '2021-07-12 17:41:59', '2021-07-12 17:41:59');

-- --------------------------------------------------------

--
-- Table structure for table `daily_activity`
--

CREATE TABLE `daily_activity` (
  `id_daily_activity` int(11) NOT NULL,
  `name_daily_activity` varchar(50) NOT NULL,
  `description_daily_activity` varchar(255) DEFAULT NULL,
  `duedate_daily_activity` datetime DEFAULT NULL,
  `reminder_at` datetime DEFAULT NULL,
  `priority` int(11) NOT NULL DEFAULT 0,
  `working_status` int(11) NOT NULL DEFAULT 0,
  `status` int(11) NOT NULL DEFAULT 1,
  `id_user` int(11) NOT NULL,
  `creadate` datetime NOT NULL DEFAULT current_timestamp(),
  `modidate` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `daily_activity`
--

INSERT INTO `daily_activity` (`id_daily_activity`, `name_daily_activity`, `description_daily_activity`, `duedate_daily_activity`, `reminder_at`, `priority`, `working_status`, `status`, `id_user`, `creadate`, `modidate`) VALUES
(1, 'Nyuci Baju', 'Mencuci Baju', '2021-07-13 21:20:26', '2021-07-12 21:20:26', 1, 0, 0, 1, '2021-07-12 21:21:04', '2021-07-12 21:21:04'),
(2, 'Membeli Sarapan', 'Ini kita beli sarapan ges', '2021-07-13 21:20:26', '2021-07-13 21:20:26', 0, 1, 0, 1, '2021-07-12 21:21:04', '2021-07-12 21:21:04'),
(3, 'Tidur', 'Ini kita beli sarapan ges', '2021-07-13 21:20:26', '2021-07-13 21:20:26', 0, 1, 0, 1, '2021-07-12 21:21:04', '2021-07-12 21:21:04'),
(4, 'Tidur 4', 'Ini kita beli sarapan ges', '2021-07-13 21:20:26', '2021-07-13 21:20:26', 0, 1, 1, 1, '2021-07-13 09:13:26', '2021-07-13 10:04:50');

-- --------------------------------------------------------

--
-- Table structure for table `detail_schedule`
--

CREATE TABLE `detail_schedule` (
  `id_detail_schedule` int(11) NOT NULL,
  `name_detail_schedule` varchar(255) NOT NULL,
  `day_schedule` varchar(20) NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `id_schedule` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 1,
  `creadate` datetime NOT NULL DEFAULT current_timestamp(),
  `modidate` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_schedule`
--

INSERT INTO `detail_schedule` (`id_detail_schedule`, `name_detail_schedule`, `day_schedule`, `start_time`, `end_time`, `id_schedule`, `status`, `creadate`, `modidate`) VALUES
(1, 'Pemrograman 8', 'Selasa', '07:00:00', '12:00:00', 1, 1, '2021-07-13 01:18:32', '2021-07-13 07:54:00'),
(2, 'Pemrograman 7', 'Rabu', '13:00:00', '16:00:00', 1, 0, '2021-07-13 01:28:24', '2021-07-13 01:28:24'),
(3, 'Pemrograman 7', 'Rabu', '13:00:00', '16:00:00', 1, 1, '2021-07-13 07:51:21', '2021-07-13 07:51:21');

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `id_schedule` int(11) NOT NULL,
  `name_schedule` varchar(50) NOT NULL,
  `description_schedule` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 1,
  `id_user` int(11) NOT NULL,
  `creadate` datetime NOT NULL DEFAULT current_timestamp(),
  `modidate` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
-- Indexes for table `assignment`
--
ALTER TABLE `assignment`
  ADD PRIMARY KEY (`id_assignment`);

--
-- Indexes for table `daily_activity`
--
ALTER TABLE `daily_activity`
  ADD PRIMARY KEY (`id_daily_activity`);

--
-- Indexes for table `detail_schedule`
--
ALTER TABLE `detail_schedule`
  ADD PRIMARY KEY (`id_detail_schedule`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id_schedule`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assignment`
--
ALTER TABLE `assignment`
  MODIFY `id_assignment` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `daily_activity`
--
ALTER TABLE `daily_activity`
  MODIFY `id_daily_activity` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `detail_schedule`
--
ALTER TABLE `detail_schedule`
  MODIFY `id_detail_schedule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `id_schedule` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
