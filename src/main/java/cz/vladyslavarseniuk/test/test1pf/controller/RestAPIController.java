package cz.vladyslavarseniuk.test.test1pf.controller;

import cz.vladyslavarseniuk.test.test1pf.entity.RateCard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class RestAPIController {

    @GetMapping("/")
    public List<RateCard> getAllRatesCard() {
        return RatesCardService.getAllRatesCard();// ? Maybe i use only repository
    }

}