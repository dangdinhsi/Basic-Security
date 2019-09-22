package com.siddd00474.controller;

import com.siddd00474.entity.Account;
import com.siddd00474.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    //list
    @GetMapping(value = "/list")
    public String getList(Model model){
        model.addAttribute("list",accountService.getList());
        model.addAttribute("size",accountService.getList().size());
        return "list";
    }
    //create new account
    //b1. call form
    @GetMapping(value = "/create")
    public String formAccount(Model model){
        model.addAttribute("roles",Account.Role.values());
        model.addAttribute("account",new Account());
        return "form";
    }
    //b2. add new account
    @PostMapping(value = "/create")
    public String addAccount(@Valid Account account, BindingResult result,Model model){
       if(result.hasErrors()){
           model.addAttribute("result",result);
           return "form";
       }
       accountService.createNewAccount(account);
       return "success";
    }

    //trang login
    @GetMapping(value = "/login")
    public String showLoginPage(){
        return "login";
    }
    //trang danh rieng admin
    @GetMapping(value = "/admin")
    public String adminPage(){
        return "admin";
    }
    //trang danh rieng user
    @GetMapping(value = "/user")
    public String userPage(){
        return "user";
    }
    //trang danh rieng employee
    @GetMapping(value = "/employee")
    public String employeePage(){
        return "employee";
    }
}
