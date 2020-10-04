package com.endie.avizandum.gameplay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    private Counter counter;

    @GetMapping(path = "/")
    public String index() {
        return "welcome";
    }

    @GetMapping("/test")
    public @ResponseBody
    String testResponse() {
        return "Hello, World";
    }

    @GetMapping(path = "/playerhome")
    public String playerhome(HttpServletRequest request) throws ServletException {

        return "player/playerhome";
    }

    @GetMapping(path = "/countme")
    public String countMe(HttpServletRequest request) throws ServletException {
        String user = "test"; // request.getRemoteUser();
        increaseCount(user, "counted");
        return "welcome";
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        String user = request.getRemoteUser();
        request.logout();
        return "welcome";
    }

    private void increaseCount(String user, String state) {
        counter = Metrics.counter("request.countMe", "User", user, "State", state);
        counter.increment();

    }
}