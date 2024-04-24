package org.example;

import kong.unirest.Unirest;

public class catFactAPI {
    public static void main(String[] args) {
        String url = "https://catfact.ninja/fact";
        //String fact = Unirest.get(url).asString().getBody();
        //unirest makes the request to the url then decide how we want this data to be formatted and that is why
        //we use .asString.  .getBody will convert the data into string
        //JSON is technically string

        CatFact catFact = Unirest.get(url).asObject(CatFact.class).getBody();
        String fact = catFact.getFact();

        //CatFact catFactLength = Unirest.get(url).asObject(CatFact.class).getBody();
        int length = catFact.getLength();
        System.out.println("A cat fact is: \n" +fact);
        System.out.println("The length of this fact is :\n "+ length);
    }

}

class CatFact{
    private String fact;

    private int length;
//getters and setters
    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
