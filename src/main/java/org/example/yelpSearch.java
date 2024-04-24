package org.example;

import kong.unirest.Unirest;

import java.util.Map;

import static input.InputUtils.stringInput;

public class yelpSearch {
    public static void main(String[] args) {
        String yelpURL= "https://api.yelp.com/v3/businesses/search";
        String YELP_API_KEY = System.getenv("YELP_API_KEY");

       String typeOfRestaurant = stringInput("What type of restaurant would you like to search for?");

        Map<String, Object> yelpQuery = Map.of(
                "term",typeOfRestaurant,
                "location","Minneapolis, MN",
                "categories","restaurants",
                "price","1",
                "open now",true);

        yelpResponse response = Unirest
                .get(yelpURL)
                .queryString(yelpQuery)
                .header("Authorization", "Bearer " + YELP_API_KEY)
                .asObject(yelpResponse.class)
                .getBody();

        System.out.println(response);
        for ( Business business: response.businesses) {
            System.out.println(business.name);
            System.out.println("Rating: "+ business.rating);
            System.out.println(business.location.address1 + ","+ business.location.city + ", "+business.openNow.open_now);
        }

    }
}
