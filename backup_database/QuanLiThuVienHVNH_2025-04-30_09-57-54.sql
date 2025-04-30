# ************************************************************
# Antares - SQL Client
# Version 0.7.34
# 
# https://antares-sql.app/
# https://github.com/antares-sql/antares
# 
# Host: localhost (MySQL Community Server - GPL 8.4.5)
# Database: QuanLiThuVienHVNH
# Generation time: 2025-04-30T09:58:14+07:00
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS QuanLiThuVienHVNH;

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

LOCK TABLES `tblNXB` WRITE;
/*!40000 ALTER TABLE `tblNXB` DISABLE KEYS */;

INSERT INTO `tblNXB` (`MaNXB`, `TenNXB`, `Diachi`, `SDT`, `Email`) VALUES
	("nxb0000001", "NXB Chính trị Quốc gia Sự thật", "Hà Nội", "0123456789", "test@mail.com"),
	("nxb0000002", "NXB Kim Đồng", "Hà Nội", "0123456789", "test@mail.com");

/*!40000 ALTER TABLE `tblNXB` ENABLE KEYS */;
UNLOCK TABLES;



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
  `Matkhau` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Quyenhan` enum('NONE','NHANVIEN','ADMIN') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`Manhanvien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `tblNhanVien` WRITE;
/*!40000 ALTER TABLE `tblNhanVien` DISABLE KEYS */;

INSERT INTO `tblNhanVien` (`Manhanvien`, `Tennhanvien`, `Ngaysinh`, `Gioitinh`, `Diachi`, `Email`, `SDT`, `Chucvu`, `Matkhau`, `Quyenhan`) VALUES
	("admin", "Trần Tuấn Đạt", "2004-09-27", "Nam", "Hà Nội", "test@mail.com", "01234567890", "Quản lí", "1234", "ADMIN"),
	("low_level0", "Đáy xã hội", "2004-09-27", "Nam", "Hà Nội", "test@mail.com", "01234567890", "Quản lí", "1234", "NONE");

/*!40000 ALTER TABLE `tblNhanVien` ENABLE KEYS */;
UNLOCK TABLES;



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

LOCK TABLES `tblSach` WRITE;
/*!40000 ALTER TABLE `tblSach` DISABLE KEYS */;

INSERT INTO `tblSach` (`Masach`, `Tensach`, `Matheloai`, `Matacgia`, `MaNXB`, `Giasach`, `Soluong`, `Anh`, `Ghichu`) VALUES
	("sach000000", "Sách thử nghiệm", "test000000", "tacgia0001", "nxb0000002", 25000, 100, "/home/datcd/Downloads/ryo cat.jpeg", "something"),
	("sach000001", "Bocchi The Rock - Tập 1", "test000001", "tacgia0000", "nxb0000002", 40000, 5, "/home/datcd/Downloads/bocchi.jpeg", "Truyện siêu hay"),
	("sach000002", "Đường Cách Mệnh", "test000003", "tacgia9999", "nxb0000001", 250000, 2, "/home/datcd/Downloads/duong-cach-menh.jpg", "Tác phẩm tập hợp các bài giảng của đồng chí Nguyễn Ái Quốc tại các lớp huấn luyện cán bộ của Hội Việt Nam Cách mạng Thanh niên tại Quảng Châu (Trung Quốc) trong những năm 1925-1927."),
	("sach000004", "Cuộc phiêu lưu kì bí của JoJo: Steel Ball Run", "test000001", "tacgia0001", "nxb0000002", 100000, 1, "/home/datcd/Downloads/Steel_Ball_Run_1.jpg", "Phần 7 của bộ truyện JJBA");

/*!40000 ALTER TABLE `tblSach` ENABLE KEYS */;
UNLOCK TABLES;



# Dump of table tblTacGia
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tblTacGia`;

CREATE TABLE `tblTacGia` (
  `Matacgia` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Tentacgia` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `Ngaysinh` date NOT NULL,
  `Gioitinh` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `Diachi` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`Matacgia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `tblTacGia` WRITE;
/*!40000 ALTER TABLE `tblTacGia` DISABLE KEYS */;

INSERT INTO `tblTacGia` (`Matacgia`, `Tentacgia`, `Ngaysinh`, `Gioitinh`, `Diachi`) VALUES
	("tacgia0000", "Hamazi Aki", "1975-11-17", "Nữ", "Nhật Bản"),
	("tacgia0001", "Hirohiko Araki", "1960-06-07", "Nam", "Nhật Bản"),
	("tacgia9999", "Hồ Chí Minh", "1890-05-19", "Nam", "Nghệ An"),
	("test000000", "test", "1975-04-30", "Nữ", "test"),
	("test000001", "test1", "1945-09-02", "Nam", "test1");

/*!40000 ALTER TABLE `tblTacGia` ENABLE KEYS */;
UNLOCK TABLES;



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
	("test000000", "Sách tham khảo"),
	("test000001", "Truyện tranh"),
	("test000002", "Sách giáo trình"),
	("test000003", "Sách giáo dục"),
	("test000004", "Sách tâm lí học");

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

# Dump completed on 2025-04-30T09:58:14+07:00
