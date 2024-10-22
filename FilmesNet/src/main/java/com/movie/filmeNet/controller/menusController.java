package com.movie.filmeNet.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menus")
public class menusController {

    @GetMapping("/principal")
    public String menu(){
        return "/menus/principal";
    }
}
