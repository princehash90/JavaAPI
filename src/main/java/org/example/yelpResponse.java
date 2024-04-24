package org.example;

public class yelpResponse {
    //field for businesses and it is for array
    public  Business[] businesses;

}

class Business{
    //represent one business object
    public String name;
    public double rating;
    public location location;
    public openNow openNow;

}
class location {
    public String city;
    public String address1;
}

class openNow{
    public boolean open_now;
}
