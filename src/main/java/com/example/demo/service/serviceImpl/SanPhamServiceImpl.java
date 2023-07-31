package com.example.demo.service.serviceImpl;

import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepo;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepo sanPhamRepo;
    @Override
    public List<SanPham> getAll() {
        return this.sanPhamRepo.findAll();
    }

    @Override
    public SanPham getById(UUID idSanPham) {
        return this.sanPhamRepo.findById(idSanPham).get();
    }

    @Override
    public SanPham create(SanPham sanPham) {
        return this.sanPhamRepo.save(sanPham);
    }

    @Override
    public SanPham update(UUID id, String ma, String ten) {
        SanPham sanPham = this.sanPhamRepo.findById(id).get();
        sanPham.setMa(ma);
        sanPham.setTen(ten);
        return this.sanPhamRepo.save(sanPham);
    }

    @Override
    public SanPham deleteById(UUID idSanPham) {
        return null;
    }
}
