package com.example.demo.service.serviceImpl;

import com.example.demo.entity.ChucVu;
import com.example.demo.repository.ChucVuRepo;
import com.example.demo.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    ChucVuRepo chucVuRepo;

    @Override
    public List<ChucVu> getAll() {
        return this.chucVuRepo.findAll();
    }

    @Override
    public ChucVu getById(UUID idChucVu) {
        return this.chucVuRepo.findById(idChucVu).get();
    }

    @Override
    public ChucVu create(ChucVu chucVu) {
        return this.chucVuRepo.save(chucVu);
    }

    @Override
    public ChucVu update(UUID id, String ma, String ten) {
        ChucVu chucVu1 = this.getById(id);
        chucVu1.setMa(ma);
        chucVu1.setTen(ten);
        return this.chucVuRepo.save(chucVu1);
    }

    @Override
    public ChucVu deleteById(UUID idChucVu) {
        return null;
    }
}
