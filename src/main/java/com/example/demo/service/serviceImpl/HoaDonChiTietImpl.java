package com.example.demo.service.serviceImpl;

import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.entity.IdHoaDonChiTiet;
import com.example.demo.repository.HoaDonChiTietRepo;
import com.example.demo.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HoaDonChiTietImpl implements HoaDonChiTietService {
    @Autowired
    HoaDonChiTietRepo hoaDonChiTietRepo;
    @Override
    public List<HoaDonChiTiet> getAllInHoaDon(UUID id) {
        return this.hoaDonChiTietRepo.findAll();
    }

    @Override
    public List<HoaDonChiTiet> getAll() {
        return this.hoaDonChiTietRepo.findAll();
    }

    @Override
    public HoaDonChiTiet getHoaDonChiTiet(IdHoaDonChiTiet id) {
        return null;
    }

    @Override
    public HoaDonChiTiet create(HoaDonChiTiet hoaDonChiTiet) {
        return this.hoaDonChiTietRepo.save(hoaDonChiTiet);
    }
}
