package com.example.demo.service.serviceImpl;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.repository.ChiTietSanPhamRepo;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    @Autowired
    ChiTietSanPhamRepo chiTietSanPhamRepo;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    NsxService nsxService;
    @Autowired
    MauSacService mauSacService;
    @Autowired
    DongSPService dongSPService;

    @Override
    public List<ChiTietSanPham> getAll() {
        return this.chiTietSanPhamRepo.findAll();
    }

    @Override
    public ChiTietSanPham getById(UUID id) {
        return this.chiTietSanPhamRepo.findById(id).get();
    }

    @Override
    public ChiTietSanPham create(ChiTietSanPham chiTietSanPham) {
        return this.chiTietSanPhamRepo.save(chiTietSanPham);
    }

    @Override
    public ChiTietSanPham update(UUID id, UUID idSp, UUID idNsx, UUID idMauSac,
                                 UUID dongSp, Integer namBh, String moTa,
                                 Integer soLuongTon, Double giaNhap, Double giaBan) {
        ChiTietSanPham ctsp = this.getById(id);
        ctsp.setSanPham(this.sanPhamService.getById(idSp));
        ctsp.setNsx(this.nsxService.getById(idNsx));
        ctsp.setMauSac(this.mauSacService.getById(idMauSac));
        ctsp.setDongSP(this.dongSPService.getById(dongSp));
        ctsp.setNamBH(namBh);
        ctsp.setMoTa(moTa);
        ctsp.setSoLuongTon(soLuongTon);
        ctsp.setGiaNhap(giaNhap);
        ctsp.setGiaBan(giaBan);
        return this.chiTietSanPhamRepo.save(ctsp);
    }

    @Override
    public ChiTietSanPham deleteById(UUID id) {
        return null;
    }
}
