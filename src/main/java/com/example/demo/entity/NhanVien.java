package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @Column(length = 32)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String ma;
    private String ten;
    @Column(name = "ten_dem")
    private String tenDem;
    private String ho;
    @Column(name = "gioi_tinh")
    private boolean gioiTinh;
    @Column(name = "ngay_sinh")
    private Date ngaySinh;
    @Column(name = "dia_chi")
    private String diaChi;
    private String sdt;
    @Column(name = "mat_khau")
    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "id_ch")
    private CuaHang cuaHang;

    @ManyToOne
    @JoinColumn(name = "id_cv")
    private ChucVu chucVu;

    @Column(name = "trang_thai")
    private boolean trangThai;

    public NhanVien(String ma, String ten, String tenDem, String ho, boolean gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, CuaHang cuaHang, ChucVu chucVu) {
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.cuaHang = cuaHang;
        this.chucVu = chucVu;
    }

}
