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
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    @Column(length = 32)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public HoaDon(KhachHang khachHang, NhanVien nhanVien, String ma, Date ngayTao,
                  Date ngayThanhToan, Date ngayShip, Date ngayNhan, Integer tinhTrang) {
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tinhTrang = tinhTrang;
        this.tenNguoiNhan = khachHang.getTen()+khachHang.getHo();
        this.diaChi = khachHang.getDiaChi();
        this.sdt = khachHang.getSdt();
    }

    @ManyToOne
    @JoinColumn(name = "id_kh")
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "id_nv")
    private NhanVien nhanVien;
    private String ma;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_thanh_toan")
    private Date ngayThanhToan;
    @Column(name = "ngay_ship")
    private Date ngayShip;
    @Column(name = "ngay_nhan")
    private Date ngayNhan;
    @Column(name = "tinh_trang")
    private Integer tinhTrang;
    @Column(name = "ten_nguoi_nhan")
    private String tenNguoiNhan;
    @Column(name = "dia_chi")
    private String diaChi;
    private String sdt;
}
