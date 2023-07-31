package com.example.demo.controller.admin;

import com.example.demo.constVarible.constVariable;
import com.example.demo.entity.Nsx;
import com.example.demo.service.NsxService;
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
public class NsxController extends AdminHref{
    @Autowired
    NsxService nsxService;
    final String href = "nsx";
    @GetMapping(href + "/index")
    public String showData(Model model) {
        List<Nsx> listNsx = this.nsxService.getAll();
        model.addAttribute("listNsx", listNsx);
        model.addAttribute("href", constVariable.headHref + "/admin/nsx/nsxManage.jsp");
        return "admin/adminIndex";
    }

    @GetMapping(href+"/create")
    public String create(Model model){
        model.addAttribute("href", constVariable.headHref + "/admin/nsx/createNsx.jsp");
        return "admin/adminIndex";
    }

    @PostMapping(href+"/save")
    public String save(Model model,
                       @RequestParam String ma,
                       @RequestParam String ten
    ){
        Nsx chucVu = new Nsx(ma, ten);
        this.nsxService.create(chucVu);
        return "redirect:/admin/nsx/index";
    }
    @GetMapping(href+"/detail/{id}")
    public String detail(Model model,
                         @PathVariable UUID id
    ){
        Nsx nsx = this.nsxService.getById(id);
        model.addAttribute("nsx",nsx);
        model.addAttribute("href", constVariable.headHref + "/admin/nsx/detailNsx.jsp");;
        return "admin/adminIndex";
    }
    @PostMapping(href+"/modify/{id}")
    public String modify(Model model,
                         @PathVariable UUID id,
                         @RequestParam String ma,
                         @RequestParam String ten){
        this.nsxService.update(id, ma, ten);
        return "redirect:/admin/nsx/index";
    }
}
