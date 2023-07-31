package com.example.demo.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
public class IdHoaDonChiTiet {
    @ManyToOne
    @JoinColumn(name = "id_hoa_don")
    private HoaDon hoaDon;
    @ManyToOne
    @JoinColumn(name = "id_chi_tiet_sp")
    private ChiTietSanPham chiTietSanPham;

    public IdHoaDonChiTiet(HoaDon hoaDon, ChiTietSanPham chiTietSanPham) {
        this.hoaDon = hoaDon;
        this.chiTietSanPham = chiTietSanPham;
    }
}
