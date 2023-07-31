package com.example.demo.service;

import com.example.demo.entity.CuaHang;
import com.example.demo.entity.NhanVien;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface NhanVienService {
    List<NhanVien> getAll();
    NhanVien getById(UUID idNhanVien);
    NhanVien getByMa(String idNhanVien);
    NhanVien create(NhanVien nhanVien);
    NhanVien update(UUID id, String ma, String ten, String tenDem, String ho, boolean gioiTinh,
                    Date ngaySinh, String diaChi, String sdt, String matKhau, UUID idCuaHang, UUID idChucVu, Boolean trangThai);
    NhanVien changeTrangThai(UUID idNhanVien);
    NhanVien deleteById(UUID idNhanVien);
}
