package com.example.demo.service;

import com.example.demo.entity.MauSac;

import java.util.List;
import java.util.UUID;

public interface MauSacService {
    List<MauSac> getAll();
    MauSac getById(UUID idMauSac);
    MauSac create(MauSac mauSac);
    MauSac update(UUID id, String ma, String ten);
    MauSac deleteById(UUID idMauSac);
}
