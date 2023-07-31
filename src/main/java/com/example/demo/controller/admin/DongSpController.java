package com.example.demo.controller.admin;

import com.example.demo.constVarible.constVariable;
import com.example.demo.entity.DongSP;
import com.example.demo.service.DongSPService;
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
public class DongSpController extends AdminHref {
    final String href = "dongsp";
    @Autowired
    DongSPService dongSPService;

    @GetMapping(href + "/index")
    public String showData(Model model) {
        List<DongSP> listDongSp = this.dongSPService.getAll();
        model.addAttribute("listDongSp", listDongSp);
        model.addAttribute("href", constVariable.headHref + "/admin/dongsp/dongSpManage.jsp");
        return "admin/adminIndex";
    }

    @GetMapping(href + "/create")
    public String create(Model model) {
        model.addAttribute("href", constVariable.headHref + "/admin/dongsp/createDongSp.jsp");
        return "admin/adminIndex";
    }

    @PostMapping(href + "/save")
    public String save(Model model,
                       @RequestParam String ma,
                       @RequestParam String ten
    ) {
        DongSP dongSp = new DongSP(ma, ten);
        this.dongSPService.create(dongSp);
        return "redirect:/admin/dongsp/index";
    }

    @GetMapping(href + "/detail/{id}")
    public String detail(Model model,
                         @PathVariable UUID id
    ) {
        DongSP dongSp = this.dongSPService.getById(id);
        model.addAttribute("dongSp", dongSp);
        model.addAttribute("href", constVariable.headHref + "/admin/dongsp/detailDongSp.jsp");
        ;
        return "admin/adminIndex";
    }

    @PostMapping(href + "/modify/{id}")
    public String modify(Model model,
                         @PathVariable UUID id,
                         @RequestParam String ma,
                         @RequestParam String ten) {
        this.dongSPService.update(id, ma, ten);
        return "redirect:/admin/dongsp/index";
    }
}
