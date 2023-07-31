package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "chi_tiet_sp")
public class ChiTietSanPham {
    @Id
    @Column(length = 32)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public ChiTietSanPham(SanPham sanPham, Nsx nsx, MauSac mauSac, DongSP dongSP,
                          Integer namBH, String moTa, Integer soLuongTon, Double giaNhap, Double giaBan) {
        this.sanPham = sanPham;
        this.nsx = nsx;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    @ManyToOne
    @JoinColumn(name = "id_sp")
    private SanPham sanPham;
    @ManyToOne
    @JoinColumn(name = "id_nsx")
    private Nsx nsx;
    @ManyToOne
    @JoinColumn(name = "id_mau_sac")
    private MauSac mauSac;
    @ManyToOne
    @JoinColumn(name = "id_dong_sp")
    private DongSP dongSP;
    @Column(name = "nam_bh")
    private Integer namBH;
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name="so_luong_ton")
    private Integer soLuongTon;
    @Column(name="gia_nhap")
    private Double giaNhap;
    @Column(name="gia_ban")
    private Double giaBan;
}
