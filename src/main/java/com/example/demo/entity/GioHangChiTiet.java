package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "gio_hang_chi_tiet")
public class GioHangChiTiet {
    @EmbeddedId
    private IdGioHangChiTiet id;

    public GioHangChiTiet(IdGioHangChiTiet id, Integer soLuong, Double donGia, Double donGiaKhiGiam) {
        this.id = id;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    @Column(name = "so_luong")
    private Integer soLuong;
    @Column(name = "don_gia")
    private Double donGia;
    @Column(name = "don_gia_khi_giam")
    private Double donGiaKhiGiam;
}
