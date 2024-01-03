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

    @GetMapping("/detail/{shortName}")
    public String showExchangeRateDetail(@RequestParam String shortName,Model model) {
        model.addAttribute("shortName", shortName);
        return "detail";
    }
}