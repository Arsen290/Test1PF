package cz.vladyslavarseniuk.test.test1pf.repository;

import cz.vladyslavarseniuk.test.test1pf.entity.RateCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateCardRepository extends JpaRepository<RateCard, Long>{
    RateCard findByShortName(String shortName);
}

