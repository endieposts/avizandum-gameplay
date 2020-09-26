package com.endie.avizandum.gameplay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class WebController {


    @GetMapping(path = "/")
    public String index() {
        return "welcome";
    }

    @GetMapping(path = "/playerhome")
    public String playerhome(HttpServletRequest request) throws ServletException {

        return "player/playerhome";
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "welcome";
    }
}