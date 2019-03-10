package com.napier.sem;

public class city {

    // Stores city identification number.
    private int ID;
    // Stores name of city.
    private String Name;
    // Stores code of country the city is in.
    private String CountryCode;
    // Stores name of district that city is in.
    private String District;
    // Stores population of city.
    private int Population;

    // Get city id.
    public int getID(){
        return this.ID;
    }
    // Set city id.
    public void setID(int value){
        this.ID = value;
    }

    // Get city name.
    public String getName(){
        return this.Name;
    }
    // Set city name.
    public void setName(String value){
        this.Name = value;
    }

    // Get country code.
    public String getCountryCode(){
        return this.CountryCode;
    }
    // Set country code.
    public void setCountryCode(String value){
        this.CountryCode = value;
    }

    // Get district name.
    public String getDistrict(){
        return this.District;
    }
    // Set district name.
    public void setDistrict(String value){
        this.District = value;
    }

    // Get city population.
    public int getPopulation(){
        return this.Population;
    }
    // Set city population.
    public void setPopulation(int value){
        this.Population = value;
    }

}
