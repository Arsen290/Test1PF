package cz.vladyslavarseniuk.test.test1pf.service;

import cz.vladyslavarseniuk.test.test1pf.entity.RateCard;
import cz.vladyslavarseniuk.test.test1pf.repository.RateCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateCardService {
    @Autowired
    private RateCardRepository rateCardRepository;

    public List<RateCard> getRateCards(boolean useDb) {
        if (useDb) {
            return rateCardRepository.findAll();
        } else {
            // Take data from APi ČS and save to DB
            return null;
        }
    }
}
