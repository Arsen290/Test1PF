package cz.vladyslavarseniuk.test.test1pf.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class RateCardDTO {
    private String shortName;
    private LocalDateTime validFrom;
    private String name;
    private String country;
    private double move;
    private double amount;
    private double valBuy;
    private double valSell;
    private double valMid;
    private double currBuy;
    private double currSell;
    private double currMid;
    private int version;
    private double cnbMid;
    private double ecbMid;
}
