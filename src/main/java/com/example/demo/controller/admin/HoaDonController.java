package com.example.demo.controller.admin;

import com.example.demo.constVarible.constVariable;
import com.example.demo.entity.HoaDon;
import com.example.demo.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class HoaDonController extends  AdminHref{
    @Autowired
    HoaDonService hoaDonService;

    @GetMapping("hoadon/index")
    public String index(Model model){
        model.addAttribute("listHoaDon", hoaDonService.getAll());
        model.addAttribute("href", constVariable.headHref + "/admin/hoadon/hoaDonIndex.jsp");
        return "admin/adminIndex";
    }

    @GetMapping("hoadon/trangthai/{id}")
    public String trangThai(Model model,
                            @PathVariable UUID id
                            ){
        HoaDon hoaDon = this.hoaDonService.getHoaDon(id);
        if(hoaDon.getTinhTrang()<=2){
            hoaDon.setTinhTrang(hoaDon.getTinhTrang()+1);
        }
        this.hoaDonService.create(hoaDon);
        return "redirect:/admin/hoadon/index";
    }
}
