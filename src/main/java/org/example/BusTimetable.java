package org.example;

import kong.unirest.Unirest;

public class BusTimetable {

    public static void main(String[] args) {
        String url = "https://svc.metrotransit.org/NexTrip/17940?format=json";

        Bus[] buses = Unirest.get(url).asObject(Bus[].class).getBody();

        System.out.printf("%-10s %-40s %-20s \n ","Route", "Description", "Arrival Time");

        for (Bus bus: buses){
            System.out.printf("%-10s %-40Uns %-20s\n ", bus.route_id, bus.description_id, bus.departure_text);
        }

    }
}class Bus{
    public String departure_text;
    public String route_id;
    public String description_id;
}