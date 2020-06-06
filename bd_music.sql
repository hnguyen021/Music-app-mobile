-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2020 at 06:28 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bd_music`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `idAdmin` int(255) NOT NULL,
  `adminname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`idAdmin`, `adminname`, `password`) VALUES
(1, 'hung1', '123');

-- --------------------------------------------------------

--
-- Table structure for table `album`
--

CREATE TABLE `album` (
  `idAlbum` int(255) NOT NULL,
  `TenAlbum` varchar(255) NOT NULL,
  `TenCaSiAlbum` varchar(255) NOT NULL,
  `HinhAlbum` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `album`
--

INSERT INTO `album` (`idAlbum`, `TenAlbum`, `TenCaSiAlbum`, `HinhAlbum`) VALUES
(1, 'Lá Xa Lìa Cành (Single)\r\n', 'Lê Bảo Bình', 'http://192.168.1.116:8888/upload/xalaliacanh.jpg'),
(2, 'Cõi Nhớ', 'Ngọc Hân', 'http://192.168.1.116:8888/upload/coinho.jpg'),
(3, 'Hồng Nhan Bạc Phận', 'Jack', 'http://192.168.1.116:8888/upload/hongnhanbacphan.jpg'),
(4, 'Em Ơi Lên Phố', 'Minh Vương M4U', 'http://192.168.1.116:8888/upload/emoilenpho.jpg'),
(5, 'Phía Sau Một Cô Gái', 'Sobin Hoàng Sơn', 'http://192.168.1.116:8888/upload/phiasau1cogai.jpg '),
(6, 'Tướng Quân', 'Nhật Phong', 'http://192.168.1.116:8888/upload/tuongquan.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `baihat`
--

CREATE TABLE `baihat` (
  `idBaiHat` int(255) NOT NULL,
  `idAlbum` int(255) NOT NULL,
  `idTheLoai` int(255) NOT NULL,
  `idPlayList` int(255) NOT NULL,
  `TenBaiHat` varchar(255) NOT NULL,
  `HinhBaiHat` varchar(255) NOT NULL,
  `CaSi` varchar(255) NOT NULL,
  `LinkBaiHat` varchar(255) NOT NULL,
  `LuotThich` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `baihat`
--

INSERT INTO `baihat` (`idBaiHat`, `idAlbum`, `idTheLoai`, `idPlayList`, `TenBaiHat`, `HinhBaiHat`, `CaSi`, `LinkBaiHat`, `LuotThich`) VALUES
(1, 1, 1, 1, 'Lá Xa Lìa Cành', 'http://192.168.1.116:8888/upload/xalaliacanh.jpg\r\n', 'Lê Bảo Bình', 'http://192.168.1.116:8888/upload/lebaobinh_xalaliacanh.mp3\r\n', 12),
(2, 1, 1, 1, 'Sóng Gió', 'http://192.168.1.116:8888/upload/songgio.jpg', 'Jack', 'http://192.168.1.116:8888/upload/jack_songgio.mp3', 9),
(3, 1, 1, 1, 'Hơn Cả Yêu', 'http://192.168.1.116:8888/upload/honcayeu.jpg', 'Đức Phúc', 'http://192.168.1.116:8888/upload/ducphuc_honcayeu.mp3', 3),
(4, 1, 1, 1, 'Hạt Bụi Nhỏ', 'http://192.168.1.116:8888/upload/hatbuinho.jpg', 'Khởi My', 'http://192.168.1.116:8888/upload/khoimy_hatbuinho.mp3', 4),
(5, 2, 1, 1, 'Test Tên1', 'upload/background_top100vpop.jpg', 'abc', 'upload/Jack_songgio.mp3', 2);

-- --------------------------------------------------------

--
-- Table structure for table `chude`
--

CREATE TABLE `chude` (
  `idChuDe` int(255) NOT NULL,
  `TenChuDe` varchar(255) NOT NULL,
  `HinhChuDe` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chude`
--

INSERT INTO `chude` (`idChuDe`, `TenChuDe`, `HinhChuDe`) VALUES
(1, 'Nhạc Việt', 'http://192.168.1.116:8888/upload/nhacviet.jpg'),
(2, 'Nhạc Hot', 'http://192.168.1.116:8888/upload/nhachot.jpg'),
(3, 'Nhạc Nước Ngoài', 'http://192.168.1.116:8888/upload/nhacnuocngoai.jpg'),
(4, 'K-POP HIT', 'upload/kopophit.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `playlist`
--

CREATE TABLE `playlist` (
  `idPlayList` int(255) NOT NULL,
  `TenPlayList` varchar(255) NOT NULL,
  `HinhNen` text NOT NULL,
  `IconPlayList` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `playlist`
--

INSERT INTO `playlist` (`idPlayList`, `TenPlayList`, `HinhNen`, `IconPlayList`) VALUES
(1, 'Top 100 Việt Nam', 'http://192.168.1.116:8888/upload/background_top100nhactrevn.jpg', 'http://192.168.1.116:8888/upload/top100nhactre.jpg'),
(2, 'Top 100 Nhạc V-Pop Hay Nhất', 'http://192.168.1.116:8888/upload/background_top100vpop.jpg', 'http://192.168.1.116:8888/upload/top100vpop.jpg'),
(3, 'Top 100 Nhạc Rock Âu Mỹ Hay Nhất', 'http://192.168.1.116:8888/upload/top100rock.jpg', 'http://192.168.1.116:8888/upload/background_top100rockjpg'),
(4, 'Top 100 Nhạc Trữ Tình Hay Nhất', 'http://192.168.1.116:8888/upload/background_top100nhactrutinh.jpg', 'https://bbvnmedia.files.wordpress.com/2017/06/zingmp3.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `quangcao`
--

CREATE TABLE `quangcao` (
  `idQuangCao` int(255) NOT NULL,
  `HinhAnhQC` varchar(255) NOT NULL,
  `NoiDungQC` varchar(255) NOT NULL,
  `idBaiHat` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `quangcao`
--

INSERT INTO `quangcao` (`idQuangCao`, `HinhAnhQC`, `NoiDungQC`, `idBaiHat`) VALUES
(1, 'http://192.168.1.116:8888/upload/qckhoimi.jpg', 'Hạt Bụi Nhỏ,Khởi My\r\n', 4),
(2, 'http://192.168.1.116:8888/upload/qckhoimi.jpg', 'abxjdkas', 3),
(3, 'http://192.168.1.116:8888/upload/qckhoimi.jpg', 'sssssssssssssssss', 1),
(4, 'https://i.pinimg.com/236x/db/a4/8d/dba48da9e8b3638ccf49023090c8a246.jpg', 'lalanashjkdhask', 1);

-- --------------------------------------------------------

--
-- Table structure for table `theloai`
--

CREATE TABLE `theloai` (
  `idTheLoai` int(255) NOT NULL,
  `idChuDe` int(255) NOT NULL,
  `TenTheLoai` varchar(255) NOT NULL,
  `HinhTheLoai` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `theloai`
--

INSERT INTO `theloai` (`idTheLoai`, `idChuDe`, `TenTheLoai`, `HinhTheLoai`) VALUES
(1, 1, 'V-POP: Những Bản Hits Quốc Dân', 'http://192.168.1.116:8888/upload/vpopnhungbanhitquocdan.jpg'),
(2, 3, 'EDM', 'http://192.168.1.116:8888/upload/EDM.jpg'),
(3, 4, 'Acoustic Hàn Quốc', 'http://192.168.1.116:8888/upload/acoustickpop.jpg'),
(4, 3, 'Acoustic Nước Ngoài', 'http://192.168.1.116:8888/upload/acousticus.jpg'),
(5, 1, 'Acoustic Việt Nam', 'http://192.168.1.116:8888/upload/acousticvn.jpg'),
(6, 3, 'Nhạc Không Lời EDM', 'http://192.168.1.116:8888/upload/nhackloiedm.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `TenUser` text NOT NULL,
  `PassWord` varchar(255) NOT NULL,
  `idBaiHat` int(255) NOT NULL,
  `idComMent` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`idUser`, `TenUser`, `PassWord`, `idBaiHat`, `idComMent`) VALUES
(1, 'Hung', '123', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idAdmin`);

--
-- Indexes for table `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`idAlbum`);

--
-- Indexes for table `baihat`
--
ALTER TABLE `baihat`
  ADD PRIMARY KEY (`idBaiHat`),
  ADD KEY `fk_idthloai` (`idTheLoai`),
  ADD KEY `fk_idplaylist` (`idPlayList`),
  ADD KEY `idAlbum` (`idAlbum`);

--
-- Indexes for table `chude`
--
ALTER TABLE `chude`
  ADD PRIMARY KEY (`idChuDe`);

--
-- Indexes for table `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`idPlayList`);

--
-- Indexes for table `quangcao`
--
ALTER TABLE `quangcao`
  ADD PRIMARY KEY (`idQuangCao`),
  ADD KEY `fk_idbaihat` (`idBaiHat`);

--
-- Indexes for table `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`idTheLoai`),
  ADD KEY `fk_idchude` (`idChuDe`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `idAdmin` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `album`
--
ALTER TABLE `album`
  MODIFY `idAlbum` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `baihat`
--
ALTER TABLE `baihat`
  MODIFY `idBaiHat` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `chude`
--
ALTER TABLE `chude`
  MODIFY `idChuDe` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `playlist`
--
ALTER TABLE `playlist`
  MODIFY `idPlayList` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `quangcao`
--
ALTER TABLE `quangcao`
  MODIFY `idQuangCao` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `theloai`
--
ALTER TABLE `theloai`
  MODIFY `idTheLoai` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `baihat`
--
ALTER TABLE `baihat`
  ADD CONSTRAINT `fk_idplaylist` FOREIGN KEY (`idPlayList`) REFERENCES `playlist` (`idPlayList`);

--
-- Constraints for table `quangcao`
--
ALTER TABLE `quangcao`
  ADD CONSTRAINT `fk_idbaihat` FOREIGN KEY (`idBaiHat`) REFERENCES `baihat` (`idBaiHat`);

--
-- Constraints for table `theloai`
--
ALTER TABLE `theloai`
  ADD CONSTRAINT `fk_idchude` FOREIGN KEY (`idChuDe`) REFERENCES `chude` (`idChuDe`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
