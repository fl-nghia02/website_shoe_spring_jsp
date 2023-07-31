package com.example.demo.service.serviceImpl;

import com.example.demo.entity.DongSP;
import com.example.demo.repository.DongSPRepo;
import com.example.demo.service.DongSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSPImpl implements DongSPService {
    @Autowired
    DongSPRepo dongSPRepo;
    @Override
    public List<DongSP> getAll() {
        return this.dongSPRepo.findAll();
    }

    @Override
    public DongSP getById(UUID id) {
        return this.dongSPRepo.findById(id).get();
    }

    @Override
    public DongSP create(DongSP dongSP) {
        return this.dongSPRepo.save(dongSP);
    }

    @Override
    public DongSP update(UUID id, String ma, String ten) {
        DongSP dongSp = this.getById(id);
        dongSp.setMa(ma);
        dongSp.setTen(ten);
        return this.dongSPRepo.save(dongSp);
    }

    @Override
    public DongSP deleteById(UUID id) {
        return null;
    }
}
