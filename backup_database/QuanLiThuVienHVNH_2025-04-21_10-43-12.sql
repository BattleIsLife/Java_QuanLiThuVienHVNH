# ************************************************************
# Antares - SQL Client
# Version 0.7.34
# 
# https://antares-sql.app/
# https://github.com/antares-sql/antares
# 
# Host: localhost (MySQL Community Server - GPL 8.4.5)
# Database: QuanLiThuVienHVNH
# Generation time: 2025-04-21T10:43:34+07:00
# ************************************************************

CREATE Database QuanLiThuVienHVNH;
USE QuanLiThuVienHVNH;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table tblCaLam
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tblCaLam`;

CREATE TABLE `tblCaLam` (
  `Macalam` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Manhanvien` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Thoigian` date NOT NULL,
  PRIMARY KEY (`Macalam`),
  KEY `FK_Calam_Nhanvien` (`Manhanvien`),
  CONSTRAINT `FK_Calam_Nhanvien` FOREIGN KEY (`Manhanvien`) REFERENCES `tblNhanVien` (`Manhanvien`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





# Dump of table tblChiTietPhieuMuon
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tblChiTietPhieuMuon`;

CREATE TABLE `tblChiTietPhieuMuon` (
  `Maphieumuon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Masach` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Soluongmuon` int NOT NULL,
  PRIMARY KEY (`Maphieumuon`,`Masach`),
  KEY `FK_Phieumuon_Masach` (`Masach`),
  CONSTRAINT `FK_Phieumuon_Maphieumuon` FOREIGN KEY (`Maphieumuon`) REFERENCES `tblPhieuMuon` (`Maphieumuon`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Phieumuon_Masach` FOREIGN KEY (`Masach`) REFERENCES `tblSach` (`Masach`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





# Dump of table tblNXB
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tblNXB`;

CREATE TABLE `tblNXB` (
  `MaNXB` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `TenNXB` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `Diachi` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `SDT` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`MaNXB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





# Dump of table tblNguoiMuon
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tblNguoiMuon`;

CREATE TABLE `tblNguoiMuon` (
  `Manguoimuon` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Tennguoimuon` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `Gioitinh` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `SDT` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Diachi` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `Email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`Manguoimuon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





# Dump of table tblNhanVien
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tblNhanVien`;

CREATE TABLE `tblNhanVien` (
  `Manhanvien` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Tennhanvien` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `Ngaysinh` date NOT NULL,
  `Gioitinh` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `Diachi` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `Email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `SDT` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Chucvu` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`Manhanvien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





# Dump of table tblPhieuMuon
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tblPhieuMuon`;

CREATE TABLE `tblPhieuMuon` (
  `Maphieumuon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Ngaymuon` datetime NOT NULL,
  `Hantrasach` date NOT NULL,
  `Manguoimuon` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Manhanvien` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`Maphieumuon`),
  KEY `FK_Phieumuon_Nguoimuon` (`Manguoimuon`),
  KEY `FK_Phieumuon_Nhanvien` (`Manhanvien`),
  CONSTRAINT `FK_Phieumuon_Nguoimuon` FOREIGN KEY (`Manguoimuon`) REFERENCES `tblNguoiMuon` (`Manguoimuon`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Phieumuon_Nhanvien` FOREIGN KEY (`Manhanvien`) REFERENCES `tblNhanVien` (`Manhanvien`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





# Dump of table tblPhieuPhat
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tblPhieuPhat`;

CREATE TABLE `tblPhieuPhat` (
  `Maphieuphat` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Tienphat` decimal(10,0) NOT NULL,
  `Manguoimuon` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Manhanvien` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Thoigianphat` datetime NOT NULL,
  `Ghichu` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`Maphieuphat`),
  KEY `FK_Phieuphat_Nguoimuon` (`Manguoimuon`),
  KEY `FK_Phieuphat_Nhanvien` (`Manhanvien`),
  CONSTRAINT `FK_Phieuphat_Nguoimuon` FOREIGN KEY (`Manguoimuon`) REFERENCES `tblNguoiMuon` (`Manguoimuon`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Phieuphat_Nhanvien` FOREIGN KEY (`Manhanvien`) REFERENCES `tblNhanVien` (`Manhanvien`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





# Dump of table tblSach
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tblSach`;

CREATE TABLE `tblSach` (
  `Masach` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Tensach` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `Matheloai` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Matacgia` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `MaNXB` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Giasach` decimal(10,0) NOT NULL,
  `Soluong` int NOT NULL,
  `Anh` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Ghichu` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`Masach`),
  KEY `FK_Sach_Theloai` (`Matheloai`),
  KEY `FK_Sach_Tacgia` (`Matacgia`),
  KEY `FK_Sach_NXB` (`MaNXB`),
  CONSTRAINT `FK_Sach_NXB` FOREIGN KEY (`MaNXB`) REFERENCES `tblNXB` (`MaNXB`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Sach_Tacgia` FOREIGN KEY (`Matacgia`) REFERENCES `tblTacGia` (`Matacgia`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Sach_Theloai` FOREIGN KEY (`Matheloai`) REFERENCES `tblTheLoai` (`Matheloai`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





# Dump of table tblTacGia
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tblTacGia`;

CREATE TABLE `tblTacGia` (
  `Matacgia` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Tentacgia` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `Ngaysinh` datetime NOT NULL,
  `Gioitinh` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `Diachi` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`Matacgia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





# Dump of table tblTheLoai
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tblTheLoai`;

CREATE TABLE `tblTheLoai` (
  `Matheloai` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Tentheloai` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`Matheloai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `tblTheLoai` WRITE;
/*!40000 ALTER TABLE `tblTheLoai` DISABLE KEYS */;

INSERT INTO `tblTheLoai` (`Matheloai`, `Tentheloai`) VALUES
	("test000000", "test");

/*!40000 ALTER TABLE `tblTheLoai` ENABLE KEYS */;
UNLOCK TABLES;



# Dump of views
# ------------------------------------------------------------

# Creating temporary tables to overcome VIEW dependency errors


/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

# Dump completed on 2025-04-21T10:43:34+07:00
