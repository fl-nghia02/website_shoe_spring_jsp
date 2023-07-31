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
@Table(name = "khach_hang")
public class KhachHang {
    @Id
    @Column(length = 32)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String ma;
    private String ten;
    @Column(name = "ten_dem")
    private String tenDem;
    private String ho;
    @Column(name = "ngay_sinh")
    private Date ngaySinh;
    @Column(name = "dia_chi")
    private String diaChi;
    private String sdt;
    @Column(name = "thanh_pho")
    private String thanhPho;
    @Column(name = "quoc_gia")
    private String quocGia;
    @Column(name = "mat_khau")
    private String matKhau;

    public KhachHang(String ma, String ten, String tenDem, String ho, Date ngaySinh,
                     String diaChi, String sdt, String thanhPho, String quocGia, String matKhau) {
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.matKhau = matKhau;
    }
}
