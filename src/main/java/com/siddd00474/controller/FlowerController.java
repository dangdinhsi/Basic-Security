package com.siddd00474.controller;

import com.siddd00474.entity.Flower;
import com.siddd00474.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin/flowers")
public class FlowerController {
    @Autowired
    private FlowerService flowerService;
    @GetMapping()
    public String getList(Model model){
        model.addAttribute("list",flowerService.getList());
        return "admin/flowers/list";
    }
    @GetMapping(value = "/{name}")
    public String getListByName(@PathVariable String name, Model model){
        model.addAttribute("list",flowerService.getListByName(name));
        return "admin/flowers/list";
    }
    @GetMapping(value = "/add")
    public String callFormFlower(Model model){
        model.addAttribute("flower",new Flower());
        return "admin/flowers/form";
    }
    @PostMapping(value = "/add")
    public String addNewFlower(@Valid Flower flower, BindingResult result){
        if (result.hasErrors()){
            return "admin/flowers/form";
        }
        flowerService.addFlower(flower);
        return "admin/flowers/success";
    }
}
