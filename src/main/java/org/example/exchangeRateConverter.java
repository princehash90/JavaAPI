package org.example;

import kong.unirest.Unirest;

import java.util.Map;

import static input.InputUtils.doubleInput;

public class exchangeRateConverter {
    public static void main(String[] args) {
        String url = "https://1150-exchange-rates.azurewebsites.net/latest?";
        Map<String, Object> queryParameters = Map.of("Base", "USD","symbols","EUR");
        RateResponse response = Unirest.get(url)
                .queryString(queryParameters)
                .asObject(RateResponse.class)
                .getBody();

        String dateRequested = response.date;
        double rate = response.rates.EUR;
        double amountOfDollars = doubleInput("How many US Dollars to convert to Euros?");// getting user input
        double converted= amountOfDollars * rate;// doing the calculation of the amount dollars entered by the user
        System.out.println("On "+ dateRequested +" the exchange rate  from " +response.base +" to Euros is " +rate);
        System.out.println("Your "+amountOfDollars + "$ is equivalent to "+ converted+ "Euros");
    }
}

class RateResponse{
    public String base;
    public String date;
    public Rates rates;
}
class Rates {
    public double EUR;

}




