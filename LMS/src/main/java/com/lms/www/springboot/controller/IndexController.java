package com.lms.www.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/index/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index/api/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/index/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/index/student")
    public String student() {
        return "student";
    }

    @GetMapping("/index/professor")
    public String professor() {
        return "professor";
    }

}
