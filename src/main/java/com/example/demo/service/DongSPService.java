package com.example.demo.service;


import com.example.demo.entity.DongSP;

import java.util.List;
import java.util.UUID;

public interface DongSPService {
    List<DongSP> getAll();
    DongSP getById(UUID id);
    DongSP create(DongSP dongSP);
    DongSP update(UUID id, String ma, String ten);
    DongSP deleteById(UUID id);
}
