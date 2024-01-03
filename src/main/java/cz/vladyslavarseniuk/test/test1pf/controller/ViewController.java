package cz.vladyslavarseniuk.test.test1pf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//Assistant controller for FE part creation
@Controller
public class ViewController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}