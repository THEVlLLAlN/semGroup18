package com.napier.sem;

public class populationDataCities {

    private long population;

    private long populationInCities;

    private long populationOutsideCities;

    public long getPopTotal(){
        return this.population;
    }

    public void setPopTotal(long value){
        this.population = value;
    }

    public long getPopIn(){
        return this.populationInCities;
    }

    public void setPopIn(long value){
        this.populationInCities = value;
    }

    public long getPopOut(){
        return this.populationOutsideCities;
    }

    public void setPopOut(long value){
        this.populationOutsideCities = value;
    }

}
