package com.example.demo.service.serviceImpl;

import com.example.demo.entity.CuaHang;
import com.example.demo.repository.CuaHangRepo;
import com.example.demo.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {
    @Autowired
    CuaHangRepo cuaHangRepo;
    @Override
    public List<CuaHang> getAll() {
        return this.cuaHangRepo.findAll();
    }

    @Override
    public CuaHang getById(UUID id) {
        return this.cuaHangRepo.findById(id).get();
    }

    @Override
    public CuaHang create(CuaHang cuaHang) {
        return this.cuaHangRepo.save(cuaHang);
    }

    @Override
    public CuaHang update(UUID id, String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        CuaHang cuaHang = this.getById(id);
        cuaHang.setMa(ma);
        cuaHang.setTen(ten);
        cuaHang.setDiaChi(diaChi);
        cuaHang.setThanhPho(thanhPho);
        cuaHang.setQuocGia(quocGia);
        return this.cuaHangRepo.save(cuaHang);
    }

    @Override
    public CuaHang deleteById(UUID id) {
        return null;
    }
}
