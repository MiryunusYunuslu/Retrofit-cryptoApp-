package com.example.retrofit;
import com.google.gson.annotations.SerializedName;
public class TimeAze {

    @SerializedName("currency")
    private String currency;

    @SerializedName("price")
    private String price;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
