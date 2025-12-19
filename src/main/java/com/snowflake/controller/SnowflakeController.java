package com.snowflake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.snowflake.service.SnowflakeService;

@Controller
@RequestMapping("/")
public class SnowflakeController {

	@Autowired
    private SnowflakeService service;

    @GetMapping("test")
    public String test(Model model) throws Exception {
     System.out.println("App is working");
    	return "home";
    }
    @GetMapping("home")
    public String home(Model model) throws Exception {
        model.addAttribute("version", service.fetchVersion());
        return "home";
    }
    
    @GetMapping("getEmployeeList")
    public String getEmployeeList(Model model) throws Exception {
    	model.addAttribute("version", service.fetchVersion());
        model.addAttribute("empList", service.getEmployeeList());
        return "home";
    }
    
    @RequestMapping("updateNameById")
    public String updateNameById(
            @RequestParam("name") String name,
            Model model) throws Exception {

        boolean status = service.updateNameById(name);

        model.addAttribute("status", status);
        return "home";
    }
}



