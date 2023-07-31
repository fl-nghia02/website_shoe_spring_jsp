package com.example.demo.controller.user;

import com.example.demo.constVarible.constVariable;
import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.GioHang;
import com.example.demo.entity.GioHangChiTiet;
import com.example.demo.entity.IdGioHangChiTiet;
import com.example.demo.repository.GioHangRepo;
import com.example.demo.service.ChiTietSanPhamService;
import com.example.demo.service.KhachHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class GioHangController extends UserHref {
    @Autowired
    private HttpSession httpSession;
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    GioHangRepo gioHangRepo;
    @Autowired
    KhachHangService khachHangService;

    @GetMapping("giohang/them/{id}")
    public String addToCart(Model model,
                            @PathVariable UUID id
    ) {
        ChiTietSanPham chiTietSanPham = this.chiTietSanPhamService.getById(id);
        GioHang gioHang = (GioHang) this.httpSession.getAttribute("cart");
        IdGioHangChiTiet idGioHangChiTiet = null;
        if (gioHang == null) {
            GioHang gioHangNew = new GioHang(UUID.randomUUID(),
                    this.khachHangService.getByMa("KH03"),
                    "GH-01", new Date(500), new Date(500),
                    "nguoi nhan hehe", "dia chi", "sdt", 5
            );

            idGioHangChiTiet = new IdGioHangChiTiet(gioHangNew, chiTietSanPham);
            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet(idGioHangChiTiet, 1,
                    chiTietSanPham.getGiaBan(), chiTietSanPham.getGiaBan() * 0.9);
            List<GioHangChiTiet> listGioHangChiTiet = new ArrayList<>();
            listGioHangChiTiet.add(gioHangChiTiet);
            gioHangNew.setGioHangChiTiet(listGioHangChiTiet);
            this.httpSession.setAttribute("cart", gioHangNew);
        } else {
            List<GioHangChiTiet> listGhct = gioHang.getGioHangChiTiet();
            for (GioHangChiTiet ghct : listGhct
            ) {
                if (ghct.getId().getChiTietSanPham().getId().equals(id)) {
                    ghct.setSoLuong(ghct.getSoLuong() + 1);
                    System.out.println("them so luong");
                    return "redirect:/webstore/trangchu";
                }
            }
            listGhct.add(new GioHangChiTiet(new IdGioHangChiTiet(gioHang, chiTietSanPham), 1,
                    chiTietSanPham.getGiaBan(), chiTietSanPham.getGiaBan() * 0.9));
        }

        return "redirect:/webstore/trangchu";
    }

    @GetMapping("giohang/detail")
    public String gioHang(Model model) {
        GioHang gioHang = (GioHang) this.httpSession.getAttribute("cart");
        List<GioHangChiTiet> listGhct = gioHang.getGioHangChiTiet();
        model.addAttribute("listGhct", listGhct);
        model.addAttribute("href", constVariable.headHref + "/user/giohang.jsp");
        return "/user/userIndex";
    }

    @GetMapping("giohang/xoa/{id}")
    public String delete(Model model,
                         @PathVariable UUID id
    ) {
        GioHang gioHang = (GioHang) this.httpSession.getAttribute("cart");
        List<GioHangChiTiet> listGhct = gioHang.getGioHangChiTiet();
        for (int i = 0; i < listGhct.size(); i++) {
            if (listGhct.get(i).getId().getChiTietSanPham().getId().equals(id)) {
                listGhct.remove(listGhct.get(i));
            }
        }
        return "redirect:/webstore/giohang/detail";
    }
}
