package com.fortegroupe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alex on 14.4.17.
 */
@Controller
public class MainController
{
    @RequestMapping(value = "/")
    public String home(){

        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
}
