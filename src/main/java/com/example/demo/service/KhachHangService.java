package com.example.demo.service;

import com.example.demo.entity.KhachHang;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHang> getAll();
    KhachHang getById(UUID idKhachHang);
    KhachHang getByMa(String maKhacHang);
    KhachHang create(KhachHang khachHang);
    KhachHang update(UUID id, String ma, String ten, String tenDem, String ho, Date ngaySinh,
                     String sdt, String diaChi, String thanhPho, String quocGia, String matKhau
                     );
    KhachHang deleteById(UUID idKhachHang);
}
