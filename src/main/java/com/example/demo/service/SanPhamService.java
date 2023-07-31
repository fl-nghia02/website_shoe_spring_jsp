package com.example.demo.service;

import com.example.demo.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    List<SanPham> getAll();
    SanPham getById(UUID idSanPham);
    SanPham create(SanPham sanPham);
    SanPham update(UUID id, String ma, String ten);
    SanPham deleteById(UUID idSanPham);
}
