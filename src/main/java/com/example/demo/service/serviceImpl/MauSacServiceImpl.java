package com.example.demo.service.serviceImpl;

import com.example.demo.entity.MauSac;
import com.example.demo.repository.MauSacRepo;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    MauSacRepo mauSacRepo;

    @Override
    public List<MauSac> getAll() {
        return this.mauSacRepo.findAll();
    }

    @Override
    public MauSac getById(UUID idMauSac) {
        return this.mauSacRepo.findById(idMauSac).get();
    }

    @Override
    public MauSac create(MauSac mauSac) {
        return this.mauSacRepo.save(mauSac);
    }

    @Override
    public MauSac update(UUID id, String ma, String ten) {
        MauSac mauSac =  this.getById(id);
        mauSac.setMa(ma);
        mauSac.setTen(ten);
        return this.mauSacRepo.save(mauSac);
    }

    @Override
    public MauSac deleteById(UUID idMauSac) {
        return null;
    }
}
