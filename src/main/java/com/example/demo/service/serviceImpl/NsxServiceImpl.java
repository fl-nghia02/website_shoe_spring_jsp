package com.example.demo.service.serviceImpl;

import com.example.demo.entity.Nsx;
import com.example.demo.repository.NsxRepo;
import com.example.demo.service.NsxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class NsxServiceImpl implements NsxService {
    @Autowired
    NsxRepo nsxRepo;

    @Override
    public List<Nsx> getAll() {
        return this.nsxRepo.findAll();
    }

    @Override
    public Nsx getById(UUID idNsx) {
        return this.nsxRepo.findById(idNsx).get();
    }

    @Override
    public Nsx create(Nsx nsx) {
        return this.nsxRepo.save(nsx);
    }

    @Override
    public Nsx update(UUID nsx, String ma, String ten) {
        Nsx nsx1 = this.getById(nsx);
        nsx1.setMa(ma);
        nsx1.setTen(ten);
        return this.nsxRepo.save(nsx1);
    }

    @Override
    public Nsx deleteById(UUID idNsx) {
        return null;
    }
}
