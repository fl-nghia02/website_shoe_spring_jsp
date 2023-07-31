package com.example.demo.service;

import com.example.demo.entity.HoaDon;

import java.util.List;
import java.util.UUID;

public interface HoaDonService {
    List<HoaDon> getAll();

    List<HoaDon> getAllWithTrangThai(Integer tt);

    HoaDon getHoaDon(UUID idKhachHang);

    HoaDon create(HoaDon hoaDon);

    HoaDon updateTrangThai(UUID id, Integer trangThai);
}
