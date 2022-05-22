-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 23, 2021 at 11:04 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `auto`
--
CREATE DATABASE IF NOT EXISTS `auto` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `auto`;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id_c` int(8) NOT NULL,
  `name` varchar(45) NOT NULL,
  `phone` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `invoce_sales`
--

CREATE TABLE `invoce_sales` (
  `id_invoice` int(8) NOT NULL,
  `total` float NOT NULL,
  `discount` float NOT NULL DEFAULT 0,
  `net` float NOT NULL DEFAULT 0,
  `id_customer` int(8) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `invp`
--

CREATE TABLE `invp` (
  `idp` int(8) NOT NULL,
  `total` float NOT NULL,
  `discount` float NOT NULL DEFAULT 0,
  `net` float NOT NULL DEFAULT 0,
  `id_sapplair` int(8) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `invp`
--

INSERT INTO `invp` (`idp`, `total`, `discount`, `net`, `id_sapplair`, `date`) VALUES
(3, 25000, 0, 0, 5, '2021-07-30 21:58:56'),
(4, 25000, 5000, 20000, 2, '2021-07-30 22:01:03'),
(5, 5000, 0, 0, 1, '2021-07-30 22:48:35'),
(6, 5009, 0, 0, 2, '2021-07-30 22:51:37'),
(7, 5009, 0, 0, 2, '2021-07-30 22:51:51'),
(8, 5009, 0, 0, 2, '2021-07-30 22:52:11');

-- --------------------------------------------------------

--
-- Table structure for table `mixp`
--

CREATE TABLE `mixp` (
  `id_p` int(8) NOT NULL,
  `id_inv` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mixp`
--

INSERT INTO `mixp` (`id_p`, `id_inv`) VALUES
(4, 3),
(4, 4),
(5, 3),
(9, 5);

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `pid` int(8) NOT NULL,
  `code` varchar(8) NOT NULL,
  `title` varchar(45) NOT NULL,
  `unit` int(8) NOT NULL,
  `qty` int(8) NOT NULL,
  `price` float NOT NULL,
  `Total` float NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`pid`, `code`, `title`, `unit`, `qty`, `price`, `Total`) VALUES
(4, '1402', 'طقم دشلي تمساح ', 1, 3, 4250, 0),
(5, '4155', 'اصابع  بترول ', 1, 20, 300, 0),
(6, '7145', 'طاوة خلفيه ', 1, 2, 13000, 26000),
(8, '1020', 'book', 1, 20, 500, 0),
(9, '1021', 'book2', 1, 20, 600, 0),
(10, '121', 'book3', 2, 40, 100, 0),
(11, '121', 'book3', 2, 40, 100, 0),
(12, '121', 'book3', 2, 40, 100, 0);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `idsales` int(8) NOT NULL,
  `qty_sales` int(8) NOT NULL,
  `price_sales` float NOT NULL DEFAULT 0,
  `store_id` int(8) NOT NULL,
  `invoice_sales` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `storage`
--

CREATE TABLE `storage` (
  `id_s` int(8) NOT NULL,
  `idp` int(8) NOT NULL,
  `Av_qty` int(8) NOT NULL DEFAULT 0,
  `price` float NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `supplair`
--

CREATE TABLE `supplair` (
  `idsp` int(8) NOT NULL,
  `fullname` varchar(20) NOT NULL,
  `address` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplair`
--

INSERT INTO `supplair` (`idsp`, `fullname`, `address`, `phone`, `date`) VALUES
(1, 'ابن هادي ', 'نقم', NULL, '2021-07-30 17:18:19'),
(2, 'الصاروخ', 'شارع خولان', NULL, '2021-07-30 17:18:19'),
(3, 'جي دبليو', 'شارع خولان ', NULL, '2021-07-30 17:19:48'),
(4, 'اطلس ', 'بيت معياد', NULL, '2021-07-30 17:19:48'),
(5, 'البصمه ', 'شارع خولان ', NULL, '2021-07-30 17:21:50'),
(6, 'باج - الافاق ', 'هايل ', NULL, '2021-07-30 17:21:50');

-- --------------------------------------------------------

--
-- Table structure for table `unit`
--

CREATE TABLE `unit` (
  `idunit` int(8) NOT NULL,
  `unit` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `unit`
--

INSERT INTO `unit` (`idunit`, `unit`) VALUES
(1, 'فردي'),
(2, 'زوجي'),
(3, 'بالمتر'),
(4, 'بالكيلو');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_c`);

--
-- Indexes for table `invoce_sales`
--
ALTER TABLE `invoce_sales`
  ADD PRIMARY KEY (`id_invoice`);

--
-- Indexes for table `invp`
--
ALTER TABLE `invp`
  ADD PRIMARY KEY (`idp`),
  ADD KEY `id_sapplair` (`id_sapplair`);

--
-- Indexes for table `mixp`
--
ALTER TABLE `mixp`
  ADD UNIQUE KEY `id_p` (`id_p`,`id_inv`),
  ADD KEY `mixp_ibfk_1` (`id_inv`);

--
-- Indexes for table `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`pid`),
  ADD KEY `unit` (`unit`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`idsales`),
  ADD KEY `invoice_sales` (`invoice_sales`),
  ADD KEY `store_id` (`store_id`);

--
-- Indexes for table `storage`
--
ALTER TABLE `storage`
  ADD PRIMARY KEY (`id_s`),
  ADD KEY `storage_ibfk_1` (`idp`);

--
-- Indexes for table `supplair`
--
ALTER TABLE `supplair`
  ADD PRIMARY KEY (`idsp`);

--
-- Indexes for table `unit`
--
ALTER TABLE `unit`
  ADD PRIMARY KEY (`idunit`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id_c` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `invoce_sales`
--
ALTER TABLE `invoce_sales`
  MODIFY `id_invoice` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `invp`
--
ALTER TABLE `invp`
  MODIFY `idp` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `purchase`
--
ALTER TABLE `purchase`
  MODIFY `pid` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `idsales` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `storage`
--
ALTER TABLE `storage`
  MODIFY `id_s` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `supplair`
--
ALTER TABLE `supplair`
  MODIFY `idsp` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `unit`
--
ALTER TABLE `unit`
  MODIFY `idunit` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `invp`
--
ALTER TABLE `invp`
  ADD CONSTRAINT `invp_ibfk_1` FOREIGN KEY (`id_sapplair`) REFERENCES `supplair` (`idsp`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `mixp`
--
ALTER TABLE `mixp`
  ADD CONSTRAINT `mixp_ibfk_1` FOREIGN KEY (`id_inv`) REFERENCES `invp` (`idp`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mixp_ibfk_2` FOREIGN KEY (`id_p`) REFERENCES `purchase` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`unit`) REFERENCES `unit` (`idunit`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `storage` (`id_s`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `storage`
--
ALTER TABLE `storage`
  ADD CONSTRAINT `storage_ibfk_1` FOREIGN KEY (`idp`) REFERENCES `purchase` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Database: `autofix`
--
CREATE DATABASE IF NOT EXISTS `autofix` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `autofix`;

-- --------------------------------------------------------

--
-- Stand-in structure for view `allofsales`
-- (See below for the actual view)
--
CREATE TABLE `allofsales` (
`SIo` int(10)
,`Code` int(10)
,`Title` varchar(45)
,`unit` varchar(25)
,`QtySales` int(10)
,`PriceSales` float
,`Total` float
,`TotalOfAll` float
,`clintname` text
,`ID_Stock` int(10)
,`GnS` int(10)
);

-- --------------------------------------------------------

--
-- Table structure for table `detailspurchase`
--

CREATE TABLE `detailspurchase` (
  `ID_Dp` int(10) NOT NULL,
  `Code` int(10) NOT NULL,
  `Title` varchar(45) NOT NULL,
  `ID_Unit` int(10) NOT NULL,
  `Qty` int(10) NOT NULL,
  `PriceP` float NOT NULL,
  `Total` float NOT NULL,
  `GnP` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detailspurchase`
--

INSERT INTO `detailspurchase` (`ID_Dp`, `Code`, `Title`, `ID_Unit`, `Qty`, `PriceP`, `Total`, `GnP`) VALUES
(1, 1001, 'صدام تيوتا ', 1, 10, 10000, 100000, 238),
(2, 1002, 'هندل سوزوكي ', 1, 20, 2000, 40000, 238),
(3, 1003, 'سكان حديد', 1, 1, 15000, 15000, 238),
(18, 14, 'تلفون', 1, 14, 70000, 980000, 95677075),
(20, 11124, 'هههه', 2, 25, 255, 6375, 85616160),
(21, 55, '54', 5, 55, 55, 3025, 85616160),
(22, 12, '12', 1, 12, 12, 144, 79553333),
(23, 13, '13', 3, 13, 13, 169, 79553333),
(24, 14, '15', 5, 15, 15, 225, 79553333),
(25, 254, 'طقم الجيرات 125 جي دبيلو', 3, 1, 9850, 9850, 11415916),
(26, 105, 'ريموت ', 1, 10, 205, 2050, 99203069),
(27, 106, 'سله مهملات', 1, 12, 333, 3996, 99203069),
(28, 107, 'وسادة', 1, 1, 500, 500, 99203069),
(29, 1008, 'تلفون نوكيا', 1, 3, 32500, 97500, 99203069);

--
-- Triggers `detailspurchase`
--
DELIMITER $$
CREATE TRIGGER `DeleteEle` AFTER DELETE ON `detailspurchase` FOR EACH ROW UPDATE purchase SET TotalOfAll = TotalOfAll-old.Total
WHERE GnP=old.gnp
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `TotalInvoiceTrigger` AFTER INSERT ON `detailspurchase` FOR EACH ROW UPDATE purchase SET TotalOfAll =(SELECT SUM(Total)FROM detailspurchase WHERE GnP=new.gnp)
WHERE GnP=new.gnp
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `UP8` AFTER UPDATE ON `detailspurchase` FOR EACH ROW UPDATE purchase SET TotalOfAll =(SELECT SUM(Total)FROM detailspurchase WHERE GnP=new.gnp)
WHERE GnP=new.gnp
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `currentPurchase` AFTER INSERT ON `detailspurchase` FOR EACH ROW BEGIN INSERT INTO stockmain  SET  DP= new.ID_Dp  ; 
UPDATE `stockmain` SET `QtyStock`=(SELECT Qty  FROM detailspurchase WHERE ID_Dp=new.ID_Dp ),`PriceP`=(SELECT PriceP  FROM detailspurchase WHERE ID_Dp=new.ID_Dp ) WHERE DP=NEW.ID_DP ;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `detials`
-- (See below for the actual view)
--
CREATE TABLE `detials` (
`Code` int(10)
,`Title` varchar(45)
,`Unit` varchar(25)
,`Qty` int(10)
,`PriceP` float
,`Total` float
,`GnP` int(10)
);

-- --------------------------------------------------------

--
-- Table structure for table `genp`
--

CREATE TABLE `genp` (
  `GenP` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `genp`
--

INSERT INTO `genp` (`GenP`) VALUES
(238),
(11415916),
(79553333),
(85616160),
(95677075),
(99203069);

--
-- Triggers `genp`
--
DELIMITER $$
CREATE TRIGGER `as` AFTER INSERT ON `genp` FOR EACH ROW INSERT INTO purchase SET 
GnP=new.GenP
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `gens`
--

CREATE TABLE `gens` (
  `GnS` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gens`
--

INSERT INTO `gens` (`GnS`) VALUES
(111),
(333),
(10101),
(109909545),
(244259629),
(534085526),
(631033599),
(636465876),
(733524150),
(779528136),
(789367964);

--
-- Triggers `gens`
--
DELIMITER $$
CREATE TRIGGER `autosale` AFTER INSERT ON `gens` FOR EACH ROW INSERT INTO sales SET 
GnS=new.Gns
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `infosale`
-- (See below for the actual view)
--
CREATE TABLE `infosale` (
`ID_Stock` int(10)
,`Title` varchar(45)
,`unit` varchar(25)
,`QtySales` int(10)
,`PriceSales` float
,`Total` float
,`GnS` int(10)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `invoiceofpur`
-- (See below for the actual view)
--
CREATE TABLE `invoiceofpur` (
`ID_Dp` int(10)
,`Code` int(10)
,`Title` varchar(45)
,`Unit` varchar(25)
,`Qty` int(10)
,`PriceP` float
,`Total` float
,`TotalOfAll` float
,`FN` varchar(45)
,`GnP` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `ordersales`
--

CREATE TABLE `ordersales` (
  `SIo` int(10) NOT NULL,
  `QtySales` int(10) NOT NULL,
  `PriceSales` float NOT NULL,
  `Total` float NOT NULL,
  `ID_Stock` int(10) NOT NULL,
  `GnS` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ordersales`
--

INSERT INTO `ordersales` (`SIo`, `QtySales`, `PriceSales`, `Total`, `ID_Stock`, `GnS`) VALUES
(3, 1, 20000, 20000, 3, 333),
(4, 1, 80000, 80000, 10, 631033599),
(5, 2, 2500, 5000, 2, 631033599),
(6, 2, 12000, 24000, 1, 631033599),
(7, 10, 20, 200, 13, 244259629),
(8, 1, 80000, 80000, 10, 779528136),
(9, 2, 7900080000, 15800200000, 10, 789367964),
(10, 1, 12000, 12000, 1, 636465876),
(11, 18, 2500, 45000, 2, 636465876),
(12, 1, 12000, 12000, 1, 534085526),
(14, 1, 110, 105, 2, 111);

--
-- Triggers `ordersales`
--
DELIMITER $$
CREATE TRIGGER `AvaM4A` AFTER INSERT ON `ordersales` FOR EACH ROW UPDATE sales SET TotalOfAll =(SELECT SUM(Total)FROM ordersales WHERE GnS=new.GnS)
WHERE GnS=new.GnS
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `AvaM4A1` AFTER DELETE ON `ordersales` FOR EACH ROW UPDATE sales SET TotalOfAll = TotalOfAll-old.Total
WHERE GnS=old.GnS
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `AvaM4A2` AFTER UPDATE ON `ordersales` FOR EACH ROW UPDATE sales SET TotalOfAll =(SELECT SUM(Total)FROM ordersales WHERE GnS=new.GnS)
WHERE GnS=new.GnS
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `AvaMove` BEFORE INSERT ON `ordersales` FOR EACH ROW BEGIN 
UPDATE stockmain SET QtyStock=QtyStock-new.QtySales
where ID_Stock=new.ID_Stock;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `AvaMove2` BEFORE DELETE ON `ordersales` FOR EACH ROW BEGIN 
UPDATE stockmain SET QtyStock=QtyStock+old.QtySales
where ID_Stock=old.ID_Stock;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `AvaMove3` BEFORE UPDATE ON `ordersales` FOR EACH ROW BEGIN 
UPDATE stockmain SET QtyStock=QtyStock-new.QtySales+old.QtySales
where ID_Stock=new.ID_Stock;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `PI` int(11) NOT NULL,
  `TotalOfAll` float NOT NULL DEFAULT 0,
  `ID_Sppleir` int(11) DEFAULT NULL,
  `GnP` int(11) NOT NULL,
  `Cdate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`PI`, `TotalOfAll`, `ID_Sppleir`, `GnP`, `Cdate`) VALUES
(1, 155000, NULL, 238, '2021-08-27 01:58:04'),
(7, 980000, NULL, 95677075, '2021-08-30 17:27:45'),
(8, 9400, 1, 85616160, '2021-08-30 17:29:50'),
(9, 538, 2, 79553333, '2021-08-31 01:56:24'),
(10, 9850, 1, 11415916, '2021-09-13 20:46:22'),
(11, 104046, 1, 99203069, '2021-09-21 22:00:19');

-- --------------------------------------------------------

--
-- Stand-in structure for view `pur_spp`
-- (See below for the actual view)
--
CREATE TABLE `pur_spp` (
`PI` int(11)
,`TotalOfAll` float
,`FN` varchar(45)
,`GnP` int(11)
,`Cdate` timestamp
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `salebydate`
-- (See below for the actual view)
--
CREATE TABLE `salebydate` (
`GnS` int(10)
,`clintname` text
,`TotalOfAll` float
,`Discount` float
,`Cdate` timestamp
);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `SI` int(10) NOT NULL,
  `clintname` text DEFAULT NULL,
  `TotalOfAll` float NOT NULL DEFAULT 0,
  `Discount` float NOT NULL DEFAULT 0,
  `afterDiscount` float NOT NULL DEFAULT 0,
  `GnS` int(10) NOT NULL,
  `Cdate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`SI`, `clintname`, `TotalOfAll`, `Discount`, `afterDiscount`, `GnS`, `Cdate`) VALUES
(5, '', 109000, 0, 0, 631033599, '2021-09-19 23:58:11'),
(6, '', 200, 0, 0, 244259629, '2021-09-20 00:03:38'),
(7, '', 80000, 0, 0, 779528136, '2021-09-20 00:03:52'),
(8, 'زبون عام', 15800, 800, 0, 789367964, '2021-09-22 23:00:02'),
(9, 'صالح', 57000, 0, 0, 636465876, '2021-09-21 22:02:38'),
(10, 'زبون عام', 12000, 0, 0, 534085526, '2021-09-21 22:04:58'),
(11, NULL, 105, 5, 0, 111, '2021-09-22 23:31:39');

-- --------------------------------------------------------

--
-- Stand-in structure for view `sla1`
-- (See below for the actual view)
--
CREATE TABLE `sla1` (
`SIo` int(10)
,`QtySales` int(10)
,`PriceSales` float
,`Total` float
,`ID_Stock` int(10)
,`GnS` int(10)
,`TotalOfAll` float
,`clintname` text
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `sokcet`
-- (See below for the actual view)
--
CREATE TABLE `sokcet` (
`ID_Stock` int(10)
,`Code` int(10)
,`Title` varchar(45)
,`unit` varchar(25)
,`QtyStock` int(10)
,`PriceP` float
,`PriceST` float
);

-- --------------------------------------------------------

--
-- Table structure for table `sppleir`
--

CREATE TABLE `sppleir` (
  `ID_Suppleir` int(10) NOT NULL,
  `FN` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `phone` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sppleir`
--

INSERT INTO `sppleir` (`ID_Suppleir`, `FN`, `Address`, `phone`) VALUES
(1, 'الصاروخ لقطع الغيار', '', ''),
(2, 'البصمة', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `stockmain`
--

CREATE TABLE `stockmain` (
  `ID_Stock` int(10) NOT NULL,
  `QtyStock` int(10) NOT NULL,
  `PriceP` float NOT NULL,
  `PriceST` float NOT NULL DEFAULT 0,
  `DP` int(10) DEFAULT NULL,
  `Avaliable_Items` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stockmain`
--

INSERT INTO `stockmain` (`ID_Stock`, `QtyStock`, `PriceP`, `PriceST`, `DP`, `Avaliable_Items`) VALUES
(1, 6, 10000, 12000, 1, 0),
(2, -1, 2000, 2500, 2, 0),
(3, 0, 15000, 0, 3, 0),
(4, 5, 2500, 0, 6, 0),
(5, 5, 5, 0, 7, 0),
(6, 5, 5, 0, 9, 0),
(7, 15, 15, 0, 14, 0),
(8, 44, 44, 0, 16, 0),
(9, 33, 33, 0, 17, 0),
(10, 10, 70000, 80000, 18, 0),
(11, 25, 255, 300, 20, 0),
(12, 55, 55, 0, 21, 0),
(13, 2, 12, 20, 22, 0),
(14, 13, 13, 0, 23, 0),
(15, 15, 15, 22.5, 24, 0),
(16, 1, 9850, 0, 25, 0),
(17, 10, 205, 0, 26, 0),
(18, 12, 333, 400, 27, 0),
(19, 1, 500, 0, 28, 0),
(20, 3, 32500, 0, 29, 0);

-- --------------------------------------------------------

--
-- Stand-in structure for view `stq`
-- (See below for the actual view)
--
CREATE TABLE `stq` (
`ID_Stock` int(10)
,`Code` int(10)
,`Title` varchar(45)
,`unit` varchar(25)
,`QtyStock` int(10)
,`PriceP` float
,`PriceST` float
,`Avaliable_Items` tinyint(1)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `stqe`
-- (See below for the actual view)
--
CREATE TABLE `stqe` (
`ID_Stock` int(10)
,`Code` int(10)
,`Title` varchar(45)
,`unit` varchar(25)
,`QtyStock` int(10)
,`PriceP` float
,`PriceST` float
,`Avaliable_Items` tinyint(1)
);

-- --------------------------------------------------------

--
-- Table structure for table `unit`
--

CREATE TABLE `unit` (
  `ID_Unit` int(10) NOT NULL,
  `Unit` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `unit`
--

INSERT INTO `unit` (`ID_Unit`, `Unit`) VALUES
(1, 'فردة'),
(2, 'زوج'),
(3, 'طقم'),
(4, 'شدة'),
(5, 'بالكيلو ');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'abdulrhman', '773886998'),
(2, 'Mohammed ', '123456789');

-- --------------------------------------------------------

--
-- Structure for view `allofsales`
--
DROP TABLE IF EXISTS `allofsales`;

CREATE ALGORITHM=TEMPTABLE DEFINER=`` SQL SECURITY DEFINER VIEW `allofsales`  AS SELECT `s`.`SIo` AS `SIo`, `so`.`Code` AS `Code`, `so`.`Title` AS `Title`, `so`.`unit` AS `unit`, `s`.`QtySales` AS `QtySales`, `s`.`PriceSales` AS `PriceSales`, `s`.`Total` AS `Total`, `s`.`TotalOfAll` AS `TotalOfAll`, `s`.`clintname` AS `clintname`, `s`.`ID_Stock` AS `ID_Stock`, `s`.`GnS` AS `GnS` FROM (`sla1` `s` join `sokcet` `so` on(`so`.`ID_Stock` = `s`.`ID_Stock`)) ORDER BY `s`.`SIo` DESC ;

-- --------------------------------------------------------

--
-- Structure for view `detials`
--
DROP TABLE IF EXISTS `detials`;

CREATE ALGORITHM=UNDEFINED DEFINER=`` SQL SECURITY DEFINER VIEW `detials`  AS SELECT `dp`.`Code` AS `Code`, `dp`.`Title` AS `Title`, `u`.`Unit` AS `Unit`, `dp`.`Qty` AS `Qty`, `dp`.`PriceP` AS `PriceP`, `dp`.`Total` AS `Total`, `dp`.`GnP` AS `GnP` FROM (`detailspurchase` `dp` join `unit` `u` on(`u`.`ID_Unit` = `dp`.`ID_Unit`)) ;

-- --------------------------------------------------------

--
-- Structure for view `infosale`
--
DROP TABLE IF EXISTS `infosale`;

CREATE ALGORITHM=TEMPTABLE DEFINER=`` SQL SECURITY DEFINER VIEW `infosale`  AS SELECT `allofsales`.`ID_Stock` AS `ID_Stock`, `allofsales`.`Title` AS `Title`, `allofsales`.`unit` AS `unit`, `allofsales`.`QtySales` AS `QtySales`, `allofsales`.`PriceSales` AS `PriceSales`, `allofsales`.`Total` AS `Total`, `allofsales`.`GnS` AS `GnS` FROM `allofsales` ;

-- --------------------------------------------------------

--
-- Structure for view `invoiceofpur`
--
DROP TABLE IF EXISTS `invoiceofpur`;

CREATE ALGORITHM=UNDEFINED DEFINER=`` SQL SECURITY DEFINER VIEW `invoiceofpur`  AS SELECT `dp`.`ID_Dp` AS `ID_Dp`, `dp`.`Code` AS `Code`, `dp`.`Title` AS `Title`, `uu`.`Unit` AS `Unit`, `dp`.`Qty` AS `Qty`, `dp`.`PriceP` AS `PriceP`, `dp`.`Total` AS `Total`, `p`.`TotalOfAll` AS `TotalOfAll`, `s`.`FN` AS `FN`, `p`.`GnP` AS `GnP` FROM ((((`detailspurchase` `dp` join `unit` `uu` on(`uu`.`ID_Unit` = `dp`.`ID_Unit`)) join `genp` `g` on(`g`.`GenP` = `dp`.`GnP`)) join `purchase` `p` on(`p`.`GnP` = `g`.`GenP`)) join `sppleir` `s` on(`s`.`ID_Suppleir` = `p`.`ID_Sppleir`)) ;

-- --------------------------------------------------------

--
-- Structure for view `pur_spp`
--
DROP TABLE IF EXISTS `pur_spp`;

CREATE ALGORITHM=UNDEFINED DEFINER=`` SQL SECURITY DEFINER VIEW `pur_spp`  AS SELECT `p`.`PI` AS `PI`, `p`.`TotalOfAll` AS `TotalOfAll`, `o`.`FN` AS `FN`, `p`.`GnP` AS `GnP`, `p`.`Cdate` AS `Cdate` FROM (`purchase` `p` join `sppleir` `o` on(`o`.`ID_Suppleir` = `p`.`ID_Sppleir`)) ;

-- --------------------------------------------------------

--
-- Structure for view `salebydate`
--
DROP TABLE IF EXISTS `salebydate`;

CREATE ALGORITHM=TEMPTABLE DEFINER=`` SQL SECURITY DEFINER VIEW `salebydate`  AS SELECT `sales`.`GnS` AS `GnS`, `sales`.`clintname` AS `clintname`, `sales`.`TotalOfAll` AS `TotalOfAll`, `sales`.`Discount` AS `Discount`, `sales`.`Cdate` AS `Cdate` FROM `sales` ORDER BY `sales`.`Cdate` DESC ;

-- --------------------------------------------------------

--
-- Structure for view `sla1`
--
DROP TABLE IF EXISTS `sla1`;

CREATE ALGORITHM=TEMPTABLE DEFINER=`` SQL SECURITY DEFINER VIEW `sla1`  AS SELECT `o`.`SIo` AS `SIo`, `o`.`QtySales` AS `QtySales`, `o`.`PriceSales` AS `PriceSales`, `o`.`Total` AS `Total`, `o`.`ID_Stock` AS `ID_Stock`, `gens`.`GnS` AS `GnS`, `s`.`TotalOfAll` AS `TotalOfAll`, `s`.`clintname` AS `clintname` FROM ((`ordersales` `o` left join `gens` on(`o`.`GnS` = `gens`.`GnS`)) left join `sales` `s` on(`s`.`GnS` = `gens`.`GnS`)) ;

-- --------------------------------------------------------

--
-- Structure for view `sokcet`
--
DROP TABLE IF EXISTS `sokcet`;

CREATE ALGORITHM=TEMPTABLE DEFINER=`` SQL SECURITY DEFINER VIEW `sokcet`  AS SELECT `sm`.`ID_Stock` AS `ID_Stock`, `dsp`.`Code` AS `Code`, `dsp`.`Title` AS `Title`, `u`.`Unit` AS `unit`, `sm`.`QtyStock` AS `QtyStock`, `sm`.`PriceP` AS `PriceP`, `sm`.`PriceST` AS `PriceST` FROM ((`detailspurchase` `dsp` join `stockmain` `sm` on(`dsp`.`ID_Dp` = `sm`.`DP`)) join `unit` `u` on(`dsp`.`ID_Unit` = `u`.`ID_Unit`)) ;

-- --------------------------------------------------------

--
-- Structure for view `stq`
--
DROP TABLE IF EXISTS `stq`;

CREATE ALGORITHM=UNDEFINED DEFINER=`` SQL SECURITY DEFINER VIEW `stq`  AS SELECT `sm`.`ID_Stock` AS `ID_Stock`, `dsp`.`Code` AS `Code`, `dsp`.`Title` AS `Title`, `u`.`Unit` AS `unit`, `sm`.`QtyStock` AS `QtyStock`, `sm`.`PriceP` AS `PriceP`, `sm`.`PriceST` AS `PriceST`, `sm`.`Avaliable_Items` AS `Avaliable_Items` FROM ((`detailspurchase` `dsp` join `stockmain` `sm` on(`dsp`.`ID_Dp` = `sm`.`DP`)) join `unit` `u` on(`dsp`.`ID_Unit` = `u`.`ID_Unit`)) WHERE `sm`.`QtyStock` > 0 ;

-- --------------------------------------------------------

--
-- Structure for view `stqe`
--
DROP TABLE IF EXISTS `stqe`;

CREATE ALGORITHM=TEMPTABLE DEFINER=`` SQL SECURITY DEFINER VIEW `stqe`  AS SELECT `sm`.`ID_Stock` AS `ID_Stock`, `dsp`.`Code` AS `Code`, `dsp`.`Title` AS `Title`, `u`.`Unit` AS `unit`, `sm`.`QtyStock` AS `QtyStock`, `sm`.`PriceP` AS `PriceP`, `sm`.`PriceST` AS `PriceST`, `sm`.`Avaliable_Items` AS `Avaliable_Items` FROM ((`detailspurchase` `dsp` join `stockmain` `sm` on(`dsp`.`ID_Dp` = `sm`.`DP`)) join `unit` `u` on(`dsp`.`ID_Unit` = `u`.`ID_Unit`)) WHERE `sm`.`QtyStock` <= 0 ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detailspurchase`
--
ALTER TABLE `detailspurchase`
  ADD PRIMARY KEY (`ID_Dp`),
  ADD KEY `GnP` (`GnP`),
  ADD KEY `ID_Unit` (`ID_Unit`);

--
-- Indexes for table `genp`
--
ALTER TABLE `genp`
  ADD PRIMARY KEY (`GenP`),
  ADD UNIQUE KEY `GenP` (`GenP`);

--
-- Indexes for table `gens`
--
ALTER TABLE `gens`
  ADD PRIMARY KEY (`GnS`),
  ADD UNIQUE KEY `GnS` (`GnS`);

--
-- Indexes for table `ordersales`
--
ALTER TABLE `ordersales`
  ADD PRIMARY KEY (`SIo`),
  ADD KEY `ID_Stock` (`ID_Stock`),
  ADD KEY `GnS` (`GnS`);

--
-- Indexes for table `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`PI`),
  ADD KEY `GnP` (`GnP`),
  ADD KEY `ID_Sppleir` (`ID_Sppleir`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`SI`),
  ADD KEY `GnS` (`GnS`);

--
-- Indexes for table `sppleir`
--
ALTER TABLE `sppleir`
  ADD PRIMARY KEY (`ID_Suppleir`);

--
-- Indexes for table `stockmain`
--
ALTER TABLE `stockmain`
  ADD PRIMARY KEY (`ID_Stock`),
  ADD KEY `stockmain_ibfk_1` (`DP`);

--
-- Indexes for table `unit`
--
ALTER TABLE `unit`
  ADD PRIMARY KEY (`ID_Unit`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detailspurchase`
--
ALTER TABLE `detailspurchase`
  MODIFY `ID_Dp` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `ordersales`
--
ALTER TABLE `ordersales`
  MODIFY `SIo` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `purchase`
--
ALTER TABLE `purchase`
  MODIFY `PI` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `SI` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `sppleir`
--
ALTER TABLE `sppleir`
  MODIFY `ID_Suppleir` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `stockmain`
--
ALTER TABLE `stockmain`
  MODIFY `ID_Stock` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `unit`
--
ALTER TABLE `unit`
  MODIFY `ID_Unit` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detailspurchase`
--
ALTER TABLE `detailspurchase`
  ADD CONSTRAINT `detailspurchase_ibfk_1` FOREIGN KEY (`GnP`) REFERENCES `genp` (`GenP`),
  ADD CONSTRAINT `detailspurchase_ibfk_2` FOREIGN KEY (`ID_Unit`) REFERENCES `unit` (`ID_Unit`);

--
-- Constraints for table `ordersales`
--
ALTER TABLE `ordersales`
  ADD CONSTRAINT `ordersales_ibfk_1` FOREIGN KEY (`ID_Stock`) REFERENCES `stockmain` (`ID_Stock`),
  ADD CONSTRAINT `ordersales_ibfk_2` FOREIGN KEY (`GnS`) REFERENCES `gens` (`GnS`);

--
-- Constraints for table `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`GnP`) REFERENCES `genp` (`GenP`),
  ADD CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`ID_Sppleir`) REFERENCES `sppleir` (`ID_Suppleir`);

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`GnS`) REFERENCES `gens` (`GnS`);

--
-- Constraints for table `stockmain`
--
ALTER TABLE `stockmain`
  ADD CONSTRAINT `stockmain_ibfk_1` FOREIGN KEY (`DP`) REFERENCES `detailspurchase` (`ID_Dp`) ON DELETE NO ACTION ON UPDATE NO ACTION;
--
-- Database: `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Table structure for table `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(10) UNSIGNED NOT NULL,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

--
-- Dumping data for table `pma__bookmark`
--

INSERT INTO `pma__bookmark` (`id`, `dbase`, `user`, `label`, `query`) VALUES
(1, 'auto', 'root', 'in', 'SELECT * FROM `mixp`');

-- --------------------------------------------------------

--
-- Table structure for table `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_length` text COLLATE utf8_bin DEFAULT NULL,
  `col_collation` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) COLLATE utf8_bin DEFAULT '',
  `col_default` text COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Central list of columns';

-- --------------------------------------------------------

--
-- Table structure for table `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `settings_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Settings related to Designer';

--
-- Dumping data for table `pma__designer_settings`
--

INSERT INTO `pma__designer_settings` (`username`, `settings_data`) VALUES
('root', '{\"snap_to_grid\":\"off\",\"relation_lines\":\"true\",\"angular_direct\":\"direct\"}');

-- --------------------------------------------------------

--
-- Table structure for table `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `export_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `template_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `template_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved export templates';

--
-- Dumping data for table `pma__export_templates`
--

INSERT INTO `pma__export_templates` (`id`, `username`, `export_type`, `template_name`, `template_data`) VALUES
(1, 'root', 'server', 'Autofixapp', '{\"quick_or_custom\":\"quick\",\"what\":\"sql\",\"db_select[]\":[\"auto\",\"autofix\",\"phpmyadmin\",\"triggers\"],\"aliases_new\":\"\",\"output_format\":\"sendit\",\"filename_template\":\"@SERVER@\",\"remember_template\":\"on\",\"charset\":\"utf-8\",\"compression\":\"none\",\"maxsize\":\"\",\"codegen_structure_or_data\":\"data\",\"codegen_format\":\"0\",\"csv_separator\":\",\",\"csv_enclosed\":\"\\\"\",\"csv_escaped\":\"\\\"\",\"csv_terminated\":\"AUTO\",\"csv_null\":\"NULL\",\"csv_structure_or_data\":\"data\",\"excel_null\":\"NULL\",\"excel_columns\":\"something\",\"excel_edition\":\"win\",\"excel_structure_or_data\":\"data\",\"json_structure_or_data\":\"data\",\"json_unicode\":\"something\",\"latex_caption\":\"something\",\"latex_structure_or_data\":\"structure_and_data\",\"latex_structure_caption\":\"Structure of table @TABLE@\",\"latex_structure_continued_caption\":\"Structure of table @TABLE@ (continued)\",\"latex_structure_label\":\"tab:@TABLE@-structure\",\"latex_relation\":\"something\",\"latex_comments\":\"something\",\"latex_mime\":\"something\",\"latex_columns\":\"something\",\"latex_data_caption\":\"Content of table @TABLE@\",\"latex_data_continued_caption\":\"Content of table @TABLE@ (continued)\",\"latex_data_label\":\"tab:@TABLE@-data\",\"latex_null\":\"\\\\textit{NULL}\",\"mediawiki_structure_or_data\":\"data\",\"mediawiki_caption\":\"something\",\"mediawiki_headers\":\"something\",\"htmlword_structure_or_data\":\"structure_and_data\",\"htmlword_null\":\"NULL\",\"ods_null\":\"NULL\",\"ods_structure_or_data\":\"data\",\"odt_structure_or_data\":\"structure_and_data\",\"odt_relation\":\"something\",\"odt_comments\":\"something\",\"odt_mime\":\"something\",\"odt_columns\":\"something\",\"odt_null\":\"NULL\",\"pdf_report_title\":\"\",\"pdf_structure_or_data\":\"data\",\"phparray_structure_or_data\":\"data\",\"sql_include_comments\":\"something\",\"sql_header_comment\":\"\",\"sql_use_transaction\":\"something\",\"sql_compatibility\":\"NONE\",\"sql_structure_or_data\":\"structure_and_data\",\"sql_create_table\":\"something\",\"sql_auto_increment\":\"something\",\"sql_create_view\":\"something\",\"sql_create_trigger\":\"something\",\"sql_backquotes\":\"something\",\"sql_type\":\"INSERT\",\"sql_insert_syntax\":\"both\",\"sql_max_query_size\":\"50000\",\"sql_hex_for_binary\":\"something\",\"sql_utc_time\":\"something\",\"texytext_structure_or_data\":\"structure_and_data\",\"texytext_null\":\"NULL\",\"yaml_structure_or_data\":\"data\",\"\":null,\"as_separate_files\":null,\"csv_removeCRLF\":null,\"csv_columns\":null,\"excel_removeCRLF\":null,\"json_pretty_print\":null,\"htmlword_columns\":null,\"ods_columns\":null,\"sql_dates\":null,\"sql_relation\":null,\"sql_mime\":null,\"sql_disable_fk\":null,\"sql_views_as_tables\":null,\"sql_metadata\":null,\"sql_drop_database\":null,\"sql_drop_table\":null,\"sql_if_not_exists\":null,\"sql_simple_view_export\":null,\"sql_view_current_user\":null,\"sql_or_replace_view\":null,\"sql_procedure_function\":null,\"sql_truncate\":null,\"sql_delayed\":null,\"sql_ignore\":null,\"texytext_columns\":null}');

-- --------------------------------------------------------

--
-- Table structure for table `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- Table structure for table `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp(),
  `sqlquery` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hidden items of navigation tree';

-- --------------------------------------------------------

--
-- Table structure for table `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Dumping data for table `pma__recent`
--

INSERT INTO `pma__recent` (`username`, `tables`) VALUES
('root', '[{\"db\":\"autofix\",\"table\":\"infosale\"},{\"db\":\"autofix\",\"table\":\"allofsales\"},{\"db\":\"autofix\",\"table\":\"salebydate\"},{\"db\":\"autofix\",\"table\":\"sales\"},{\"db\":\"autofix\",\"table\":\"sla1\"},{\"db\":\"autofix\",\"table\":\"sokcet\"},{\"db\":\"autofix\",\"table\":\"ordersales\"},{\"db\":\"autofix\",\"table\":\"koo\"},{\"db\":\"phpmyadmin\",\"table\":\"pma__bookmark\"},{\"db\":\"information_schema\",\"table\":\"VIEWS\"}]');

-- --------------------------------------------------------

--
-- Table structure for table `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

--
-- Dumping data for table `pma__relation`
--

INSERT INTO `pma__relation` (`master_db`, `master_table`, `master_field`, `foreign_db`, `foreign_table`, `foreign_field`) VALUES
('auto', 'mixp', 'id_inv', 'auto', 'invp', 'idp'),
('auto', 'mixp', 'id_p', 'auto', 'purchase', 'pid'),
('autofix', 'stockmain', 'DP', 'autofix', 'detailspurchase', 'ID_Dp');

-- --------------------------------------------------------

--
-- Table structure for table `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved searches';

--
-- Dumping data for table `pma__savedsearches`
--

INSERT INTO `pma__savedsearches` (`id`, `username`, `db_name`, `search_name`, `search_data`) VALUES
(1, 'root', 'auto', 'invoicep', '{\"criteriaColumnCount\":3,\"criteriaColumn\":[\"\",\"\",\"\"],\"criteriaSort\":[\"\",\"\",\"\"],\"criteria\":[\"\",\"\",\"\"],\"criteriaAndOrRow\":[\"or\"],\"criteriaAndOrColumn\":[\"and\",\"and\"],\"rows\":0,\"TableList\":[\"customer\",\"invoce_sales\",\"invp\",\"mixp\",\"purchase\",\"sales\",\"storage\",\"supplair\",\"unit\"],\"Or0\":[\"\",\"\",\"\"]}'),
(2, 'root', 'autofix', 'sales', '{\"criteriaColumnCount\":3,\"criteriaColumn\":[\"\",\"\",\"\"],\"criteriaSort\":[\"\",\"\",\"\"],\"criteria\":[\"\",\"\",\"\"],\"criteriaAndOrRow\":[\"or\"],\"criteriaAndOrColumn\":[\"and\",\"and\"],\"rows\":0,\"TableList\":[\"detailspurchase\",\"detials\",\"genp\",\"gens\",\"invoiceofpur\",\"ordersales\",\"pur_spp\",\"purchase\",\"sales\",\"sppleir\",\"stockmain\",\"stq\",\"unit\",\"users\"],\"Or0\":[\"\",\"\",\"\"]}');

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT 0,
  `x` float UNSIGNED NOT NULL DEFAULT 0,
  `y` float UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

--
-- Dumping data for table `pma__table_info`
--

INSERT INTO `pma__table_info` (`db_name`, `table_name`, `display_field`) VALUES
('auto', 'purchase', 'code'),
('auto', 'unit', 'unit'),
('autofix', 'detailspurchase', 'Title');

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `prefs` text COLLATE utf8_bin NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

--
-- Dumping data for table `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'autofix', 'detailspurchase', '{\"sorted_col\":\"`detailspurchase`.`GnP` ASC\"}', '2021-09-16 20:25:30'),
('root', 'autofix', 'purchase', '{\"sorted_col\":\"`purchase`.`ID_Sppleir` ASC\"}', '2021-09-16 20:29:20');

-- --------------------------------------------------------

--
-- Table structure for table `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_bin NOT NULL,
  `schema_sql` text COLLATE utf8_bin DEFAULT NULL,
  `data_sql` longtext COLLATE utf8_bin DEFAULT NULL,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_bin DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Database changes tracking for phpMyAdmin';

--
-- Dumping data for table `pma__tracking`
--

INSERT INTO `pma__tracking` (`db_name`, `table_name`, `version`, `date_created`, `date_updated`, `schema_snapshot`, `schema_sql`, `data_sql`, `tracking`, `tracking_active`) VALUES
('autofix', 'detailspurchase', 1, '2021-08-20 05:23:55', '2021-08-20 05:23:55', 'a:2:{s:7:\"COLUMNS\";a:8:{i:0;a:8:{s:5:\"Field\";s:5:\"ID_Dp\";s:4:\"Type\";s:7:\"int(10)\";s:9:\"Collation\";N;s:4:\"Null\";s:2:\"NO\";s:3:\"Key\";s:3:\"PRI\";s:7:\"Default\";N;s:5:\"Extra\";s:14:\"auto_increment\";s:7:\"Comment\";s:0:\"\";}i:1;a:8:{s:5:\"Field\";s:4:\"Code\";s:4:\"Type\";s:7:\"int(10)\";s:9:\"Collation\";N;s:4:\"Null\";s:2:\"NO\";s:3:\"Key\";s:0:\"\";s:7:\"Default\";N;s:5:\"Extra\";s:0:\"\";s:7:\"Comment\";s:0:\"\";}i:2;a:8:{s:5:\"Field\";s:5:\"Title\";s:4:\"Type\";s:11:\"varchar(45)\";s:9:\"Collation\";s:18:\"utf8mb4_general_ci\";s:4:\"Null\";s:2:\"NO\";s:3:\"Key\";s:0:\"\";s:7:\"Default\";N;s:5:\"Extra\";s:0:\"\";s:7:\"Comment\";s:0:\"\";}i:3;a:8:{s:5:\"Field\";s:7:\"ID_Unit\";s:4:\"Type\";s:7:\"int(10)\";s:9:\"Collation\";N;s:4:\"Null\";s:2:\"NO\";s:3:\"Key\";s:3:\"MUL\";s:7:\"Default\";N;s:5:\"Extra\";s:0:\"\";s:7:\"Comment\";s:0:\"\";}i:4;a:8:{s:5:\"Field\";s:3:\"Qty\";s:4:\"Type\";s:7:\"int(10)\";s:9:\"Collation\";N;s:4:\"Null\";s:2:\"NO\";s:3:\"Key\";s:0:\"\";s:7:\"Default\";N;s:5:\"Extra\";s:0:\"\";s:7:\"Comment\";s:0:\"\";}i:5;a:8:{s:5:\"Field\";s:6:\"PriceP\";s:4:\"Type\";s:5:\"float\";s:9:\"Collation\";N;s:4:\"Null\";s:2:\"NO\";s:3:\"Key\";s:0:\"\";s:7:\"Default\";N;s:5:\"Extra\";s:0:\"\";s:7:\"Comment\";s:0:\"\";}i:6;a:8:{s:5:\"Field\";s:5:\"Total\";s:4:\"Type\";s:5:\"float\";s:9:\"Collation\";N;s:4:\"Null\";s:2:\"NO\";s:3:\"Key\";s:0:\"\";s:7:\"Default\";N;s:5:\"Extra\";s:0:\"\";s:7:\"Comment\";s:0:\"\";}i:7;a:8:{s:5:\"Field\";s:3:\"GnP\";s:4:\"Type\";s:7:\"int(10)\";s:9:\"Collation\";N;s:4:\"Null\";s:2:\"NO\";s:3:\"Key\";s:3:\"MUL\";s:7:\"Default\";N;s:5:\"Extra\";s:0:\"\";s:7:\"Comment\";s:0:\"\";}}s:7:\"INDEXES\";a:3:{i:0;a:13:{s:5:\"Table\";s:15:\"detailspurchase\";s:10:\"Non_unique\";s:1:\"0\";s:8:\"Key_name\";s:7:\"PRIMARY\";s:12:\"Seq_in_index\";s:1:\"1\";s:11:\"Column_name\";s:5:\"ID_Dp\";s:9:\"Collation\";s:1:\"A\";s:11:\"Cardinality\";s:1:\"7\";s:8:\"Sub_part\";N;s:6:\"Packed\";N;s:4:\"Null\";s:0:\"\";s:10:\"Index_type\";s:5:\"BTREE\";s:7:\"Comment\";s:0:\"\";s:13:\"Index_comment\";s:0:\"\";}i:1;a:13:{s:5:\"Table\";s:15:\"detailspurchase\";s:10:\"Non_unique\";s:1:\"1\";s:8:\"Key_name\";s:3:\"GnP\";s:12:\"Seq_in_index\";s:1:\"1\";s:11:\"Column_name\";s:3:\"GnP\";s:9:\"Collation\";s:1:\"A\";s:11:\"Cardinality\";s:1:\"2\";s:8:\"Sub_part\";N;s:6:\"Packed\";N;s:4:\"Null\";s:0:\"\";s:10:\"Index_type\";s:5:\"BTREE\";s:7:\"Comment\";s:0:\"\";s:13:\"Index_comment\";s:0:\"\";}i:2;a:13:{s:5:\"Table\";s:15:\"detailspurchase\";s:10:\"Non_unique\";s:1:\"1\";s:8:\"Key_name\";s:7:\"ID_Unit\";s:12:\"Seq_in_index\";s:1:\"1\";s:11:\"Column_name\";s:7:\"ID_Unit\";s:9:\"Collation\";s:1:\"A\";s:11:\"Cardinality\";s:1:\"7\";s:8:\"Sub_part\";N;s:6:\"Packed\";N;s:4:\"Null\";s:0:\"\";s:10:\"Index_type\";s:5:\"BTREE\";s:7:\"Comment\";s:0:\"\";s:13:\"Index_comment\";s:0:\"\";}}}', '# log 2021-08-20 05:23:55 root\nDROP TABLE IF EXISTS `detailspurchase`;\n# log 2021-08-20 05:23:55 root\n\nCREATE TABLE `detailspurchase` (\n  `ID_Dp` int(10) NOT NULL,\n  `Code` int(10) NOT NULL,\n  `Title` varchar(45) NOT NULL,\n  `ID_Unit` int(10) NOT NULL,\n  `Qty` int(10) NOT NULL,\n  `PriceP` float NOT NULL,\n  `Total` float NOT NULL,\n  `GnP` int(10) NOT NULL\n) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;\n', '\n', 'UPDATE,INSERT,DELETE,TRUNCATE,CREATE TABLE,ALTER TABLE,RENAME TABLE,DROP TABLE,CREATE INDEX,DROP INDEX', 0);

-- --------------------------------------------------------

--
-- Table structure for table `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `config_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Dumping data for table `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2021-09-23 21:04:17', '{\"Console\\/Mode\":\"collapse\",\"DefaultTransformations\\/Substring\":[\"0\",\"all\",\"\\u2026\"],\"DefaultTransformations\\/External\":[\"0\",\"-f \\/dev\\/null -i -wrap -q\",\"1\",\"1\"],\"DefaultTransformations\\/DateFormat\":[\"0\",\"local\"],\"DefaultTransformations\\/Inline\":[\"100\",\"100\"],\"DefaultTransformations\\/TextImageLink\":[\"100\",\"50\"],\"InsertRows\":4,\"Server\\/hide_db\":\"\",\"Server\\/only_db\":\"\",\"2fa\":{\"type\":\"db\",\"backend\":\"\",\"settings\":[]},\"NavigationWidth\":275}');

-- --------------------------------------------------------

--
-- Table structure for table `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL,
  `tab` varchar(64) COLLATE utf8_bin NOT NULL,
  `allowed` enum('Y','N') COLLATE utf8_bin NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- Table structure for table `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and their assignments to user groups';

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Indexes for table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Indexes for table `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Indexes for table `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Indexes for table `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Indexes for table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Indexes for table `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Indexes for table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Indexes for table `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Indexes for table `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Indexes for table `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Indexes for table `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Indexes for table `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Indexes for table `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Database: `triggers`
--
CREATE DATABASE IF NOT EXISTS `triggers` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `triggers`;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
