package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "hoa_don_chi_tiet")
public class HoaDonChiTiet {
    @EmbeddedId
    private IdHoaDonChiTiet id;
    @Column(name="so_luong")
    private Integer soLuong;
    @Column(name="don_gia")
    private Double donGia;

    public HoaDonChiTiet(IdHoaDonChiTiet id, Integer soLuong, Double donGia) {
        this.id = id;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
}
