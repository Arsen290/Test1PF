package cz.vladyslavarseniuk.test.test1pf.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "rate_cards")
//@Data by using lombok
public class RateCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "short_name")
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

    public RateCard(String shortName, LocalDateTime validFrom, String name, String country, double move, double amount, double valBuy, double valSell, double valMid, double currBuy, double currSell, double currMid, int version, double cnbMid, double ecbMid) {
        this.shortName = shortName;
        this.validFrom = validFrom;
        this.name = name;
        this.country = country;
        this.move = move;
        this.amount = amount;
        this.valBuy = valBuy;
        this.valSell = valSell;
        this.valMid = valMid;
        this.currBuy = currBuy;
        this.currSell = currSell;
        this.currMid = currMid;
        this.version = version;
        this.cnbMid = cnbMid;
        this.ecbMid = ecbMid;
    }

    public RateCard() {
    }
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getMove() {
        return move;
    }

    public void setMove(double move) {
        this.move = move;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getValBuy() {
        return valBuy;
    }

    public void setValBuy(double valBuy) {
        this.valBuy = valBuy;
    }

    public double getValSell() {
        return valSell;
    }

    public void setValSell(double valSell) {
        this.valSell = valSell;
    }

    public double getValMid() {
        return valMid;
    }

    public void setValMid(double valMid) {
        this.valMid = valMid;
    }

    public double getCurrBuy() {
        return currBuy;
    }

    public void setCurrBuy(double currBuy) {
        this.currBuy = currBuy;
    }

    public double getCurrSell() {
        return currSell;
    }

    public void setCurrSell(double currSell) {
        this.currSell = currSell;
    }

    public double getCurrMid() {
        return currMid;
    }

    public void setCurrMid(double currMid) {
        this.currMid = currMid;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public double getCnbMid() {
        return cnbMid;
    }

    public void setCnbMid(double cnbMid) {
        this.cnbMid = cnbMid;
    }

    public double getEcbMid() {
        return ecbMid;
    }

    public void setEcbMid(double ecbMid) {
        this.ecbMid = ecbMid;
    }



}
