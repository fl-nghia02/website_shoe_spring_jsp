package com.example.demo.controller.user;

import com.example.demo.constVarible.constVariable;
import com.example.demo.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrangChuController extends UserHref {
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;

    @GetMapping("/trangchu")
    public String showData(Model model) {
        model.addAttribute("listCtsp", chiTietSanPhamService.getAll());
        model.addAttribute("href", constVariable.headHref + "/user/trangchu.jsp");
        return "/user/userIndex";
    }

}
