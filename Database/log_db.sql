-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 10, 2023 at 09:34 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `log_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `db_mobil`
--

CREATE TABLE `db_mobil` (
  `id_mobil` int(11) NOT NULL,
  `brand` varchar(20) DEFAULT NULL,
  `model` varchar(20) DEFAULT NULL,
  `tahun` varchar(10) DEFAULT NULL,
  `warna` varchar(20) DEFAULT NULL,
  `nopol` varchar(10) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `db_mobil`
--

INSERT INTO `db_mobil` (`id_mobil`, `brand`, `model`, `tahun`, `warna`, `nopol`, `harga`, `status`) VALUES
(6, 'Toyota', 'Rush', '2017', 'hitam', 'B 4729 T', 660000, 'NOT READY'),
(7, 'Mitsubishi', 'Xpander', '2015', 'putih', 'D 7839 UI', 550000, 'READY'),
(8, 'Suzuki', 'Ertiga', '2018', 'silver', 'T 4382 J', 540000, 'READY'),
(9, 'Suzuki', 'Baleno', '2017', 'merah', 'B 7351 IO', 525000, 'NOT READY'),
(10, 'Honda', 'Brio', '2017', 'biru', 'B 9165 Q', 565000, 'READY'),
(11, 'Honda', 'HR-V', '2019', 'hitam', 'K 2371 TR', 800000, 'READY'),
(12, 'Toyota', 'Rush', '2015', 'putih', 'D 6512 P', 500000, 'READY');

-- --------------------------------------------------------

--
-- Table structure for table `menyewa`
--

CREATE TABLE `menyewa` (
  `id` int(11) NOT NULL,
  `tgl_mulai` date DEFAULT NULL,
  `tgl_akhir` date DEFAULT NULL,
  `lama` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `mobil_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menyewa`
--

INSERT INTO `menyewa` (`id`, `tgl_mulai`, `tgl_akhir`, `lama`, `total`, `user_id`, `mobil_id`) VALUES
(7, '2023-01-10', '2023-01-12', 2, 1320000, 6, 6);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `nama` varchar(20) DEFAULT NULL,
  `username` varchar(16) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `nik` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `telp` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `nama`, `username`, `password`, `nik`, `alamat`, `telp`) VALUES
(4, '', 'admin', 'admin123', '', '', ''),
(5, 'Muhammad Adam', 'madam', 'notfound', '', '', ''),
(6, 'Muhammad Salah', 'salah', 'benar', '', '', ''),
(7, 'Ahmad Pogba', 'pogba', 'pogboom', '', '', ''),
(8, 'Sadio Mane', 'mane', 'enam', '', '', ''),
(9, 'bhjv', '', 'jbui', '', '', ''),
(10, 'harits', 'ritss', 'rahmannnoi', '9178327512', 'Tangerang', '0876125126'),
(11, 'nuel', 'welll', 'weelloii', '982717621', 'Bengkulu', '082615631');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `db_mobil`
--
ALTER TABLE `db_mobil`
  ADD PRIMARY KEY (`id_mobil`);

--
-- Indexes for table `menyewa`
--
ALTER TABLE `menyewa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `menyewa_FK` (`user_id`),
  ADD KEY `menyewa_FK_mobil` (`mobil_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `db_mobil`
--
ALTER TABLE `db_mobil`
  MODIFY `id_mobil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `menyewa`
--
ALTER TABLE `menyewa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `menyewa`
--
ALTER TABLE `menyewa`
  ADD CONSTRAINT `menyewa_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `menyewa_FK_mobil` FOREIGN KEY (`mobil_id`) REFERENCES `db_mobil` (`id_mobil`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
