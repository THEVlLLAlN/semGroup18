package com.napier.sem;

public class city {

    private int ID;
    private String Name;
    private String CountryCode;
    private String District;
    private int Population;

    public int getID(){
        return this.ID;
    }
    public void setID(int value){
        this.ID = value;
    }

    public String getName(){
        return this.Name;
    }
    public void setName(String value){
        this.Name = value;
    }

    public String getCountryCode(){
        return this.CountryCode;
    }
    public void setCountryCode(String value){
        this.CountryCode = value;
    }

    public String getDistrict(){
        return this.District;
    }
    public void setDistrict(String value){
        this.District = value;
    }

    public int getPopulation(){
        return this.Population;
    }
    public void setPopulation(int value){
        this.Population = value;
    }

}
