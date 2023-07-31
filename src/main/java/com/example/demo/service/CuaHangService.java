package com.example.demo.service;

import com.example.demo.entity.CuaHang;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {
    List<CuaHang> getAll();

    CuaHang getById(UUID id);

    CuaHang create(CuaHang cuaHang);

    CuaHang update(UUID id, String ma, String ten, String diaChi,String thanhPho, String quocGia);

    CuaHang deleteById(UUID id);
}
