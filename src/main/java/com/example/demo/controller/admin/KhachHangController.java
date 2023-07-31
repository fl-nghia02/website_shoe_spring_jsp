package com.example.demo.controller.admin;

import com.example.demo.constVarible.constVariable;
import com.example.demo.entity.KhachHang;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.UUID;

@Controller
public class KhachHangController extends AdminHref {
    final String href = "khachhang";

    @Autowired
    KhachHangService khachHangService;

    @GetMapping(href + "/index")
    public String index(Model model) {
        model.addAttribute("listKhachHang", this.khachHangService.getAll());
        model.addAttribute("href", constVariable.headHref + "/admin/khachhang/khachHangManage.jsp");
        return "admin/adminIndex";
    }

    @GetMapping(href + "/create")
    public String create(Model model) {
        model.addAttribute("href", constVariable.headHref + "/admin/khachhang/createKhachHang.jsp");
        return "admin/adminIndex";
    }

    @PostMapping(href + "/save")
    public String save(Model model,
                       @RequestParam String ma,
                       @RequestParam String ten,
                       @RequestParam String tenDem,
                       @RequestParam String ho,
                       @RequestParam Date ngaySinh,
                       @RequestParam String sdt,
                       @RequestParam String diaChi,
                       @RequestParam String thanhPho,
                       @RequestParam String quocGia,
                       @RequestParam String matKhau
    ) {
        KhachHang khachHang = new KhachHang(ma, ten, tenDem, ho, ngaySinh, diaChi, sdt, thanhPho, quocGia, matKhau);
        this.khachHangService.create(khachHang);
        return "redirect:/admin/khachhang/index";
    }

    @GetMapping(href + "/detail/{id}")
    public String detail(Model model,
                         @PathVariable UUID id
    ) {
        System.out.println(id);
        KhachHang chucVu = this.khachHangService.getById(id);
        model.addAttribute("khachHang", chucVu);
        model.addAttribute("href", constVariable.headHref + "/admin/khachhang/detailKhachHang.jsp");
        return "admin/adminIndex";
    }

    @PostMapping(href + "/modify/{id}")
    public String modify(Model model,
                         @PathVariable UUID id,
                         @RequestParam String ma,
                         @RequestParam String ten,
                         @RequestParam String tenDem,
                         @RequestParam String ho,
                         @RequestParam Date ngaySinh,
                         @RequestParam String sdt,
                         @RequestParam String diaChi,
                         @RequestParam String thanhPho,
                         @RequestParam String quocGia,
                         @RequestParam String matKhau
    ) {
        this.khachHangService.update(id, ma, ten, tenDem, ho, ngaySinh,
                sdt, diaChi, thanhPho, quocGia, matKhau);
        return "redirect:/admin/khachhang/index";
    }
}
