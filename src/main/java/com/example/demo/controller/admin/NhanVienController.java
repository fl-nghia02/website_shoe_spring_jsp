package com.example.demo.controller.admin;

import com.example.demo.constVarible.constVariable;
import com.example.demo.entity.NhanVien;
import com.example.demo.service.ChucVuService;
import com.example.demo.service.CuaHangService;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Controller
public class NhanVienController extends AdminHref {
    final String headHref = "nhanvien";
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    ChucVuService chucVuService;
    @Autowired
    CuaHangService cuaHangService;

    @GetMapping(headHref + "/index")
    public String showData(Model model) {
        model.addAttribute("listNhanVien", this.nhanVienService.getAll());
        model.addAttribute("href", constVariable.headHref + "/admin/nhanvien/nhanVienManage.jsp");
        return "admin/adminIndex";
    }

    @GetMapping(headHref + "/create")
    public String create(Model model
    ) {
        model.addAttribute("listChucVu", this.chucVuService.getAll());
        model.addAttribute("listCuaHang", this.cuaHangService.getAll());
        model.addAttribute("href", constVariable.headHref + "/admin/nhanvien/createNhanVien.jsp");
        return "admin/adminIndex";
    }

    @PostMapping(headHref + "/save")
    public String save(Model model,
                       @RequestParam String ma,
                       @RequestParam String ten,
                       @RequestParam String tenDem,
                       @RequestParam String ho,
                       @RequestParam String diaChi,
                       @RequestParam String matKhau,
                       @RequestParam String sdt,
                       @RequestParam Date ngaySinh,
                       @RequestParam boolean gioiTinh,
                       @RequestParam String idCuaHang,
                       @RequestParam String idChucVu
    ) {
        NhanVien nhanVien = new NhanVien(ma, ten, tenDem, ho, gioiTinh, ngaySinh, diaChi,
                sdt, matKhau, this.cuaHangService.getById(UUID.fromString(idCuaHang)), this.chucVuService.getById(UUID.fromString(idChucVu)));
        this.nhanVienService.create(nhanVien);
        return "redirect:/admin/nhanvien/index";
    }

    @GetMapping(headHref + "/detail/{id}")
    public String detail(Model model,
                         @PathVariable UUID id
    ) {
        NhanVien nhanVien = this.nhanVienService.getById(id);
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("listChucVu", this.chucVuService.getAll());
        model.addAttribute("listCuaHang", this.cuaHangService.getAll());
        model.addAttribute("href", constVariable.headHref + "/admin/nhanvien/detailNhanVien.jsp");
        return "admin/adminIndex";
    }

    @PostMapping(headHref + "/modify/{id}")
    public String modify(Model model,
                         @PathVariable UUID id,
                         @RequestParam String ma,
                         @RequestParam String ten,
                         @RequestParam String tenDem,
                         @RequestParam String ho,
                         @RequestParam String diaChi,
                         @RequestParam String matKhau,
                         @RequestParam String sdt,
                         @RequestParam String ngaySinh,
                         @RequestParam boolean gioiTinh,
                         @RequestParam String idCuaHang,
                         @RequestParam String idChucVu,
                         @RequestParam boolean trangThai
    ) {
        this.nhanVienService.update(id, ma, ten, tenDem, ho, gioiTinh, Date.valueOf(ngaySinh), diaChi, sdt, matKhau,
                UUID.fromString(idCuaHang), UUID.fromString(idChucVu), trangThai);
        return "redirect:/admin/nhanvien/index";
    }
}
