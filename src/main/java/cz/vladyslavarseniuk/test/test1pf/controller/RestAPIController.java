package cz.vladyslavarseniuk.test.test1pf.controller;

import cz.vladyslavarseniuk.test.test1pf.entity.RateCard;
import cz.vladyslavarseniuk.test.test1pf.service.RateCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class RestAPIController {

    @Autowired
    private RateCardService rateCardService;

    @GetMapping("/ratecards")
    public List<RateCard> getRateCards(@RequestParam boolean useDb) {
        return rateCardService.getRateCards(useDb);
    }

}