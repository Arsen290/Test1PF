package cz.vladyslavarseniuk.test.test1pf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


//Assistant controller for FE part creation
@Controller
public class ViewController {

    @GetMapping("/")
    public String showAllCurrencyRate() {
        return "index";
    }

    @GetMapping("/detail")
    public String showExchangeRateDetail() {
        return "detail";
    }
}