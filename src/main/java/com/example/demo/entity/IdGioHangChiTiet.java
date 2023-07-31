package com.example.demo.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Embeddable
@Data
@ToString
public class IdGioHangChiTiet {
    @ManyToOne
    @JoinColumn(name = "id_gio_hang")
    private GioHang gioHang;
    @ManyToOne
    @JoinColumn(name = "id_chi_tiet_sp")
    private ChiTietSanPham chiTietSanPham;

    public IdGioHangChiTiet(GioHang gioHang, ChiTietSanPham chiTietSanPham) {
        this.gioHang = gioHang;
        this.chiTietSanPham = chiTietSanPham;
    }
}
