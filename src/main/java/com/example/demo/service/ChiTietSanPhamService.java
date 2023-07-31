package com.example.demo.service;

import com.example.demo.entity.ChiTietSanPham;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {
    List<ChiTietSanPham> getAll();
    ChiTietSanPham getById(UUID id);
    ChiTietSanPham create(ChiTietSanPham chiTietSanPham);
    ChiTietSanPham update(UUID id, UUID idSp, UUID idNsx, UUID idMauSac, UUID dongSp, Integer namBh,
                          String moTa, Integer soLuongTon, Double giaNhap, Double giaBan
                          );
    ChiTietSanPham deleteById(UUID id);
}
