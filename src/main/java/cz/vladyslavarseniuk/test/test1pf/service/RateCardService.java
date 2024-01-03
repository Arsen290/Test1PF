package cz.vladyslavarseniuk.test.test1pf.service;

import cz.vladyslavarseniuk.test.test1pf.DTO.RateCardDTO;
import cz.vladyslavarseniuk.test.test1pf.entity.RateCard;
import cz.vladyslavarseniuk.test.test1pf.repository.RateCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RateCardService {
    @Autowired
    private RateCardRepository rateCardRepository;

    public List<RateCard> getRateCards(boolean useDb) {
        if (useDb) {
            return rateCardRepository.findAll();
        } else {
            // GET HTTP request from system České spořitelny
            String apiUrl = "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e";
            // Take response from CS API
            ResponseEntity<RateCardDTO[]> responseEntity = new RestTemplate().getForEntity(apiUrl, RateCardDTO[].class);

            // DTO to Entity conversion
            List<RateCard> rateCards = Arrays.stream(responseEntity.getBody())//get body from response in JSON format and convert to stream of objects
                    .map(this::convertDtoToEntity)//convert each object to entity
                    .collect(Collectors.toList());//collect all objects to list
            //method for saving from Spring Data JPA
            rateCardRepository.saveAll(rateCards);

            return rateCards;
        }
    }

    //It is possibly to use pattern builder for this method
    public RateCard convertDtoToEntity(RateCardDTO dto) {
        RateCard rateCard = new RateCard();
        rateCard.setShortName(dto.getShortName());
        rateCard.setValidFrom(dto.getValidFrom());
        rateCard.setName(dto.getName());
        rateCard.setCountry(dto.getCountry());
        rateCard.setMove(dto.getMove());
        rateCard.setAmount(dto.getAmount());
        rateCard.setValBuy(dto.getValBuy());
        rateCard.setValSell(dto.getValSell());
        rateCard.setValMid(dto.getValMid());
        rateCard.setCurrBuy(dto.getCurrBuy());
        rateCard.setCurrSell(dto.getCurrSell());
        rateCard.setCurrMid(dto.getCurrMid());
        rateCard.setVersion(dto.getVersion());
        rateCard.setCnbMid(dto.getCnbMid());
        rateCard.setEcbMid(dto.getEcbMid());
        return rateCard;
    }
}
