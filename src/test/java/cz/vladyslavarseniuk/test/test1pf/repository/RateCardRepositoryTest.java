package cz.vladyslavarseniuk.test.test1pf.repository;

import cz.vladyslavarseniuk.test.test1pf.entity.RateCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class RateCardRepositoryTest {

    @Autowired
    private RateCardRepository rateCardRepositoryUnderTest;

    @Test
    void ItShouldCheckIfCardExistsByShortName() {
        //give
        RateCard rateCard = new RateCard(1L,"USD", LocalDateTime.of(2022, 4, 26, 0, 0, 0),
                "Dollar", "USA", 1.07, 1.0, 22.0, 23.6, 22.798, 22.228, 23.368, 22.798, 1, 22.725, 1.075
        );
        rateCardRepositoryUnderTest.save(rateCard);
        //when
        RateCard rateCardUnderTest = rateCardRepositoryUnderTest.findByShortName("USD");
        //then
        assertNotNull(rateCardUnderTest, "RateCard with shortName 'USD' should exist");
        assertEquals(rateCard, rateCardUnderTest, "Saved RateCard should be equal to retrieved RateCard");
        rateCardRepositoryUnderTest.delete(rateCard);
    }
}