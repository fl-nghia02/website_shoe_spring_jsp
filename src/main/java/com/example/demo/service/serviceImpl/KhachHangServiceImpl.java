package com.example.demo.service.serviceImpl;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepo;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    KhachHangRepo khachHangRepo;

    @Override
    public List<KhachHang> getAll() {
        return this.khachHangRepo.findAll();
    }

    @Override
    public KhachHang getById(UUID idKhachHang) {
        return this.khachHangRepo.findById(idKhachHang).get();
    }

    @Override
    public KhachHang getByMa(String sdt) {
        return this.khachHangRepo.getByMa(sdt).get(0);
    }

    @Override
    public KhachHang create(KhachHang khachHang) {
        return this.khachHangRepo.save(khachHang);
    }

    @Override
    public KhachHang update(UUID id, String ma, String ten, String tenDem, String ho, Date ngaySinh,
                            String sdt, String diaChi, String thanhPho, String quocGia, String matKhau) {
        KhachHang khachHang = this.getById(id);
        khachHang.setHo(ho);
        khachHang.setMa(ma);
        khachHang.setTen(ten);
        khachHang.setTenDem(tenDem);
        khachHang.setNgaySinh(ngaySinh);
        khachHang.setSdt(sdt);
        khachHang.setDiaChi(diaChi);
        khachHang.setThanhPho(thanhPho);
        khachHang.setQuocGia(quocGia);
        khachHang.setMatKhau(matKhau);
        return this.khachHangRepo.save(khachHang);
    }

    @Override
    public KhachHang deleteById(UUID idKhachHang) {
        return null;
    }
}
