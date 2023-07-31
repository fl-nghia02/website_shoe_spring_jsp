package com.example.demo.service;

import com.example.demo.entity.Nsx;

import java.util.List;
import java.util.UUID;

public interface NsxService {
    List<Nsx> getAll();
    Nsx getById(UUID idNsx);
    Nsx create(Nsx nsx);
    Nsx update(UUID nsx, String ma, String ten);
    Nsx deleteById(UUID idNsx);
}
