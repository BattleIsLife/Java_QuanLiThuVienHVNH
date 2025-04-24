package service;

import dao.NhanVienDAO;
import model.Nhanvien;

import java.util.List;

public class NhanVienService {

    private NhanVienDAO nhanvienDao = new NhanVienDAO();

//    // Phương thức thêm nhân viên
//    public int themNhanVien(Nhanvien nhanvien) {
//        return nhanvienDao.them(nhanvien);
//    }
//
//    // Phương thức cập nhật thông tin nhân viên
//    public int suaNhanVien(Nhanvien nhanvien) {
//        return nhanvienDao.(nhanvien);
//    }
//
//    // Phương thức xóa nhân viên theo mã nhân viên
//    public int xoaNhanVien(String maNhanVien) {
//        return nhanvienDao.delete(maNhanVien);
//    }

    // Phương thức lấy tất cả nhân viên
    public List<Nhanvien> layTatCaNhanVien() {
        return nhanvienDao.getAll();
    }

    // Phương thức lấy nhân viên theo mã nhân viên
    public Nhanvien layNhanVienTheoId(String maNhanVien) {
        return nhanvienDao.selectById(maNhanVien);
    }
    public Nhanvien findByCredentials(String u,String pass) {
    	return nhanvienDao.findByCredentials(u, pass);
    }
}
