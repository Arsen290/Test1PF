package cz.vladyslavarseniuk.test.test1pf.service;

import cz.vladyslavarseniuk.test.test1pf.DTO.RateCardDTO;
import cz.vladyslavarseniuk.test.test1pf.entity.RateCard;
import cz.vladyslavarseniuk.test.test1pf.repository.RateCardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class RateCardServiceTest {

    @Autowired
    private RateCardService rateCardService;

    @MockBean
    private RateCardRepository rateCardRepository;

    @Test
    void testGetRateCardsFromApi() {
        // Given
        when(rateCardRepository.findByShortName(anyString())).thenReturn(null); // We think that there is no RateCard in DB
        when(rateCardRepository.save(any(RateCard.class))).thenAnswer(invocation -> invocation.getArgument(0)); // Mocking save method to return the same object that was passed to it

        String apiUrl = "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e";
        ResponseEntity<RateCardDTO[]> responseEntity = new RestTemplate().getForEntity(apiUrl, RateCardDTO[].class);// GET HTTP request from system České spořitelny  and get response in JSON format of massive of objects
        List<RateCard> mockRateCards = Arrays.stream(responseEntity.getBody())//get body from response in JSON format and convert to stream of objects
                .map(rateCardService::convertDtoToEntity)//convert each object to entity
                .collect(Collectors.toList());//collect all objects to list

        // When
        List<RateCard> result = rateCardService.getRateCards(false);

        // Then
        assertEquals(mockRateCards, result);//check that result is equal to mockRateCards
        verify(rateCardRepository, times(mockRateCards.size())).save(any(RateCard.class)); // Check that save method was called as many times as there are objects in mockRateCards
    }

    @Test
    void testGetRateCardsFromDb() {
        // Given
        List<RateCard> mockRateCardsFromDb = Arrays.asList(
                new RateCard(1L, "USD", LocalDateTime.of(2022, 4, 26, 0, 0, 0),
                        "Dollar", "USA", 1.07, 1.0, 22.0, 23.6, 22.798, 22.228, 23.368, 22.798, 1, 22.725, 1.075
                ),
                new RateCard(2L, "UA", LocalDateTime.of(2022, 4, 26, 0, 0, 0),
                        "Dollar", "UKR", 1.07, 1.0, 22.0, 23.6, 22.798, 22.228, 23.368, 22.798, 1, 22.725, 1.075
                ));
        when(rateCardRepository.findAll()).thenReturn(mockRateCardsFromDb);//when findAll method is called, return mockRateCardsFromDb

        // When
        List<RateCard> result = rateCardService.getRateCards(true);// call method getRateCards with param useDb=true

        // Then
        assertEquals(mockRateCardsFromDb, result);//check that result is equal to mockRateCardsFromDb
        verify(rateCardRepository, times(1)).findAll(); // Check that findAll method was called only once
    }

}