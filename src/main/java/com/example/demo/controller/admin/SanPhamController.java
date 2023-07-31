package com.example.demo.controller.admin;

import com.example.demo.constVarible.constVariable;
import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.SanPham;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class SanPhamController extends AdminHref {

    final String href = "sanpham";
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    NsxService nsxService;
    @Autowired
    MauSacService mauSacService;
    @Autowired
    DongSPService dongSPService;

    @GetMapping(href + "/index")
    public String showData(Model model) {
        model.addAttribute("listCtsp", this.chiTietSanPhamService.getAll());
        model.addAttribute("listSanPham", this.sanPhamService.getAll());
        model.addAttribute("href", constVariable.headHref + "/admin/sanpham/sanPhamManage.jsp");
        return "admin/adminIndex";
    }

    @GetMapping(href + "/create")
    public String create(Model model) {
        model.addAttribute("listNsx", this.nsxService.getAll());
        model.addAttribute("listMauSac", this.mauSacService.getAll());
        model.addAttribute("listDongSp", this.dongSPService.getAll());
        model.addAttribute("href", constVariable.headHref + "/admin/sanpham/createSanPham.jsp");
        return "admin/adminIndex";
    }

    @PostMapping(href + "/save")
    public String save(Model model,
                       @RequestParam String ma,
                       @RequestParam String ten,
                       @RequestParam UUID idNsx,
                       @RequestParam UUID idMauSac,
                       @RequestParam UUID idDongSp,
                       @RequestParam String namBH,
                       @RequestParam String moTa,
                       @RequestParam String soLuongTon,
                       @RequestParam String giaNhap,
                       @RequestParam String giaBan
    ) {
        SanPham sanPham = new SanPham(ma, ten);
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham(sanPham, this.nsxService.getById(idNsx), this.mauSacService.getById(idMauSac),
                this.dongSPService.getById(idDongSp), Integer.parseInt(namBH), moTa,
                Integer.parseInt(soLuongTon), Double.parseDouble(giaNhap), Double.parseDouble(giaBan)
        );
        this.sanPhamService.create(sanPham);
        this.chiTietSanPhamService.create(chiTietSanPham);
        return "redirect:/admin/sanpham/index";
    }

    @GetMapping(href + "/detail/{id}")
    public String detail(Model model,
                         @PathVariable UUID id
    ) {
        ChiTietSanPham chiTietSanPham = this.chiTietSanPhamService.getById(id);
        model.addAttribute("listNsx", this.nsxService.getAll());
        model.addAttribute("listMauSac", this.mauSacService.getAll());
        model.addAttribute("listDongSp", this.dongSPService.getAll());
        model.addAttribute("ctsp", chiTietSanPham);
        model.addAttribute("href", constVariable.headHref + "/admin/sanpham/detailSanPham.jsp");
        ;
        return "admin/adminIndex";
    }

    @PostMapping(href + "/modify/{id}")
    public String modify(Model model,
                         @PathVariable UUID id,
                         @RequestParam String ma,
                         @RequestParam String ten,
                         @RequestParam UUID idNsx,
                         @RequestParam UUID idMauSac,
                         @RequestParam UUID idDongSp,
                         @RequestParam String namBH,
                         @RequestParam String moTa,
                         @RequestParam String soLuongTon,
                         @RequestParam String giaNhap,
                         @RequestParam String giaBan
    ) {
        ChiTietSanPham chiTietSanPham = this.chiTietSanPhamService.getById(id);
        this.sanPhamService.update(chiTietSanPham.getSanPham().getId(), ma, ten);
        this.chiTietSanPhamService.update(id, chiTietSanPham.getSanPham().getId(), idNsx, idMauSac, idDongSp,
                Integer.parseInt(namBH), moTa, Integer.parseInt(soLuongTon), Double.parseDouble(giaNhap),
                Double.parseDouble(giaBan)
        );
        return "redirect:/admin/sanpham/index";
    }
}
