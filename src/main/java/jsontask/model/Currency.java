package jsontask.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Currency {

    //{"r030":840,"txt":"Долар США","rate":26.988658,"cc":"USD","exchangedate":"26.02.2018"}
    @SerializedName("txt")
    private String name;
    @SerializedName("rate")
    private float rate;
    @SerializedName("cc")
    private String shortName;
    @SerializedName("exchangedate")
    private Date exchangeDate;


    public Currency() {
    }

    public Currency(String name, float rate, String shortName, Date exchangeDate) {
        this.name = name;
        this.rate = rate;
        this.shortName = shortName;
        this.exchangeDate = exchangeDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Date getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(Date exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", shortName='" + shortName + '\'' +
                ", exchangeDate=" + exchangeDate +
                '}';
    }
}
