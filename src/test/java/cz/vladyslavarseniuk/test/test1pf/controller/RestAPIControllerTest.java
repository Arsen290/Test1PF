package cz.vladyslavarseniuk.test.test1pf.controller;

import cz.vladyslavarseniuk.test.test1pf.entity.RateCard;
import cz.vladyslavarseniuk.test.test1pf.repository.RateCardRepository;
import cz.vladyslavarseniuk.test.test1pf.service.RateCardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.*;

@SpringBootTest
class RestAPIControllerTest {

    @Autowired
    private RestAPIController restAPIController;

    @MockBean
    private RateCardService rateCardService;

    @Test
    void testGetRateCards() {
        // Given
        List<RateCard> mockRateCards = Arrays.asList(
                new RateCard(1L, "USD", LocalDateTime.of(2022, 4, 26, 0, 0, 0),
                        "Dollar", "USA", 1.07, 1.0, 22.0, 23.6, 22.798, 22.228, 23.368, 22.798, 1, 22.725, 1.075
                ),
                new RateCard(2L, "UA", LocalDateTime.of(2022, 4, 26, 0, 0, 0),
                        "Dollar", "UKR", 1.07, 1.0, 22.0, 23.6, 22.798, 22.228, 23.368, 22.798, 1, 22.725, 1.075
                ));
        when(rateCardService.getRateCards(true)).thenReturn(mockRateCards);//when usedb=true is called, return mockRateCards

        // When
        List<RateCard> result = restAPIController.getRateCards(true);//call method getRateCards with param useDb=true

        // Then
        assertEquals(mockRateCards, result);//check that result is equal to mockRateCards
        verify(rateCardService, times(1)).getRateCards(true);//verify that method getRateCards with param useDb=true was called only once
    }
}
