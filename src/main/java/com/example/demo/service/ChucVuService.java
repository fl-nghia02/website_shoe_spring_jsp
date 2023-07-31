package com.example.demo.service;

import com.example.demo.entity.ChucVu;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {
    List<ChucVu> getAll();
    ChucVu getById(UUID idChucVu);
    ChucVu create(ChucVu chucVu);
    ChucVu update(UUID id, String ma, String ten);
    ChucVu deleteById(UUID idChucVu);
}
