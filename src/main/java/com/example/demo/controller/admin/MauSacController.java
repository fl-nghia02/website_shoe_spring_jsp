package com.example.demo.controller.admin;

import com.example.demo.constVarible.constVariable;
import com.example.demo.entity.MauSac;
import com.example.demo.service.MauSacService;
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
public class MauSacController extends AdminHref {
    final String href = "mausac";
    @Autowired
    MauSacService mauSacService;

    @GetMapping(href + "/index")
    public String showData(Model model) {
        List<MauSac> listMauSac = this.mauSacService.getAll();
        model.addAttribute("listMauSac", listMauSac);
        model.addAttribute("href", constVariable.headHref + "/admin/mausac/mauSacManage.jsp");
        return "admin/adminIndex";
    }

    @GetMapping(href+"/create")
    public String create(Model model){
        model.addAttribute("href", constVariable.headHref + "/admin/mausac/createMauSac.jsp");
        return "admin/adminIndex";
    }

    @PostMapping(href+"/save")
    public String save(Model model,
                       @RequestParam String ma,
                       @RequestParam String ten
    ){
        MauSac mauSac = new MauSac(ma, ten);
        this.mauSacService.create(mauSac);
        return "redirect:/admin/mausac/index";
    }
    @GetMapping(href+"/detail/{id}")
    public String detail(Model model,
                         @PathVariable UUID id
    ){
        MauSac mauSac = this.mauSacService.getById(id);
        model.addAttribute("mauSac",mauSac);
        model.addAttribute("href", constVariable.headHref + "/admin/mausac/detailMauSac.jsp");;
        return "admin/adminIndex";
    }
    @PostMapping(href+"/modify/{id}")
    public String modify(Model model,
                         @PathVariable UUID id,
                         @RequestParam String ma,
                         @RequestParam String ten){
        this.mauSacService.update(id, ma, ten);
        return "redirect:/admin/mausac/index";
    }
}
