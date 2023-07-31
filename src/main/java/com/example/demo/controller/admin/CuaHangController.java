package com.example.demo.controller.admin;

import com.example.demo.constVarible.constVariable;
import com.example.demo.entity.CuaHang;
import com.example.demo.service.CuaHangService;
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
public class CuaHangController extends AdminHref{
    final String href = "cuahang";
    @Autowired
    CuaHangService cuaHangService;

    @GetMapping(href + "/index")
    public String showData(Model model) {
        List<CuaHang> listCuaHang = this.cuaHangService.getAll();
        model.addAttribute("listCuaHang", listCuaHang);
        model.addAttribute("href", constVariable.headHref + "/admin/cuahang/cuaHangManage.jsp");
        return "admin/adminIndex";
    }

    @GetMapping(href+"/create")
    public String create(Model model){
        model.addAttribute("href", constVariable.headHref + "/admin/cuahang/createCuaHang.jsp");
        return "admin/adminIndex";
    }

    @PostMapping(href+"/save")
    public String save(Model model,
                       @RequestParam String ma,
                       @RequestParam String ten,
                       @RequestParam String diaChi,
                       @RequestParam String thanhPho,
                       @RequestParam String quocGia
    ){
        CuaHang cuaHang = new CuaHang(ma, ten, diaChi, thanhPho, quocGia);
        this.cuaHangService.create(cuaHang);
        return "redirect:/admin/cuahang/index";
    }
    @GetMapping(href+"/detail/{id}")
    public String detail(Model model,
                         @PathVariable UUID id
    ){
        CuaHang cuaHang = this.cuaHangService.getById(id);
        model.addAttribute("cuaHang",cuaHang);
        model.addAttribute("href", constVariable.headHref + "/admin/cuahang/detailCuaHang.jsp");;
        return "admin/adminIndex";
    }
    @PostMapping(href+"/modify/{id}")
    public String modify(Model model,
                         @PathVariable UUID id,
                         @RequestParam String ma,
                         @RequestParam String ten,
                         @RequestParam String diaChi,
                         @RequestParam String thanhPho,
                         @RequestParam String quocGia
    ){
        this.cuaHangService.update(id, ma, ten, diaChi, thanhPho, quocGia);
        return "redirect:/admin/cuahang/index";
    }
}
