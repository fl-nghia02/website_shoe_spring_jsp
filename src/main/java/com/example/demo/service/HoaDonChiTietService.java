package com.example.demo.service;

import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.entity.IdHoaDonChiTiet;

import java.util.List;
import java.util.UUID;

public interface HoaDonChiTietService {
    List<HoaDonChiTiet> getAllInHoaDon(UUID idHoaDon);
    List<HoaDonChiTiet> getAll();
    HoaDonChiTiet getHoaDonChiTiet(IdHoaDonChiTiet id);
    HoaDonChiTiet create(HoaDonChiTiet hoaDonChiTiet);
}
