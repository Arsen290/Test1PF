package cz.vladyslavarseniuk.test.test1pf.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "rate_cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "short_name")
    private String shortName;

    @Column(name = "valid_from")
    private LocalDateTime validFrom;

    private String name;
    private String country;
    private double move;
    private double amount;

    @Column(name = "val_buy")
    private double valBuy;

    @Column(name = "val_sell")
    private double valSell;

    @Column(name = "val_mid")
    private double valMid;

    @Column(name = "curr_buy")
    private double currBuy;

    @Column(name = "curr_sell")
    private double currSell;

    @Column(name = "curr_mid")
    private double currMid;

    private int version;

    @Column(name = "cnb_mid")
    private double cnbMid;

    @Column(name = "ecb_mid")
    private double ecbMid;

}
