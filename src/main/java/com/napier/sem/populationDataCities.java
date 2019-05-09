package com.napier.sem;

public class populationDataCities {

    private int population;

    private int populationInCities;

    private int populationOutsideCities;

    public int getPopTotal(){
        return this.population;
    }

    public void setPopTotal(int value){
        this.population = value;
    }

    public int getPopIn(){
        return this.populationInCities;
    }

    public void setPopIn(int value){
        this.populationInCities = value;
    }

    public int getPopOut(){
        return this.populationOutsideCities;
    }

    public void setPopOut(int value){
        this.populationOutsideCities = value;
    }

}
