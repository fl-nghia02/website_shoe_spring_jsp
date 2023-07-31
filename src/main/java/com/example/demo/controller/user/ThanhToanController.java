package com.example.demo.controller.user;

import com.example.demo.entity.*;
import com.example.demo.service.HoaDonChiTietService;
//import com.example.demo.service.HoaDonService;
import com.example.demo.service.HoaDonService;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.NhanVienService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.charset.Charset;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class ThanhToanController extends UserHref {
    //    @Autowired
//    HoaDonService hoaDonService;
    @Autowired
    HttpSession httpSession;
    @Autowired
    HoaDonChiTietService hoaDonChiTietService;
    @Autowired
    KhachHangService khachHangService;

    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    HoaDonService hoaDonService;
    private byte[] array;

    @GetMapping("thanhtoan")
    public String comfirm(Model model) {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));


        GioHang gioHang = (GioHang) this.httpSession.getAttribute("cart");
        List<GioHangChiTiet> listGhct = gioHang.getGioHangChiTiet();
        HoaDon hoaDon = new HoaDon(this.khachHangService.getByMa("KH03"),
                this.nhanVienService.getByMa("nv7"), generatedString,
                new Date(2023, 11, 11), new Date(2023, 11, 11), new Date(2023, 11, 11),
                new Date(2023, 11, 11),
                0);
        hoaDon = this.hoaDonService.create(hoaDon);
        for (int i = 0; i < listGhct.size(); i++) {
            ChiTietSanPham ctsp = listGhct.get(i).getId().getChiTietSanPham();
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(new IdHoaDonChiTiet(hoaDon, ctsp),
                    listGhct.get(i).getSoLuong(), listGhct.get(i).getDonGiaKhiGiam());
            this.hoaDonChiTietService.create(hoaDonChiTiet);
        }
        listGhct.clear();
        return "redirect:/webstore/giohang/detail";
    }
}
