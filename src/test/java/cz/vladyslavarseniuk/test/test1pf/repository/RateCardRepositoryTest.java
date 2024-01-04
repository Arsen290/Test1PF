package cz.vladyslavarseniuk.test.test1pf.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class RateCardRepositoryTest {

    @Autowired
    private RateCardRepository rateCardRepositoryUnderTest;

    @Test
    void ItShouldCheckIfCardExistsByShortName() {
    }
}