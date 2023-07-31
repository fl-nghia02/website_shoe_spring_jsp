package com.example.demo.controller.admin;

import com.example.demo.entity.ChucVu;
import com.example.demo.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.constVarible.constVariable;

import java.util.List;
import java.util.UUID;

@Controller
public class ChucVuController extends AdminHref {
    final String href = "chucvu";
    @Autowired
    ChucVuService chucVuService;

    @GetMapping(href + "/index")
    public String showData(Model model) {
        List<ChucVu> listChucVu = this.chucVuService.getAll();
        model.addAttribute("listChucVu", listChucVu);
        model.addAttribute("href", constVariable.headHref + "/admin/chucvu/chucVuManage.jsp");
        return "admin/adminIndex";
    }

    @GetMapping(href+"/create")
    public String create(Model model){
        model.addAttribute("href", constVariable.headHref + "/admin/chucvu/createChucVu.jsp");
        return "admin/adminIndex";
    }

    @PostMapping(href+"/save")
    public String save(Model model,
                       @RequestParam String ma,
                       @RequestParam String ten
                       ){
        ChucVu chucVu = new ChucVu(ma, ten);
        this.chucVuService.create(chucVu);
        return "redirect:/admin/chucvu/index";
    }
    @GetMapping(href+"/detail/{id}")
    public String detail(Model model,
                       @PathVariable UUID id
                       ){
        System.out.println(id);
        ChucVu chucVu = this.chucVuService.getById(id);
        model.addAttribute("chucVu",chucVu);
        model.addAttribute("href", constVariable.headHref + "/admin/chucvu/detailChucVu.jsp");;
        return "admin/adminIndex";
    }
    @PostMapping(href+"/modify/{id}")
    public String modify(Model model,
                         @PathVariable UUID id,
                         @RequestParam String ma,
                         @RequestParam String ten){
        this.chucVuService.update(id, ma, ten);
        return "redirect:/admin/chucvu/index";
    }
}
