package com.napier.sem;

// Class to store the language of each country.
public class countrylanguage {

    // Stores code of country the language is spoken in.
    private String CountryCode;
    // Stores name of language.
    private String Language;
    // Stores whether the language is the official language of the country.
    private char IsOfficial;
    // Stores percentage of language speakers in the population.
    private float Percentage;

    // Get country code.
    public String getCountryCode(){
        return this.CountryCode;
    }
    // Set country code.
    public void setCountryCode(String value){
        this.CountryCode = value;
    }

    // Get language name.
    public String getLanguage(){
        return this.Language;
    }
    // Set language name.
    public void setLanguage(String value){
        this.Language = value;
    }

    // Get official status of language.
    public char getIsOfficial(){
        return this.IsOfficial;
    }
    //Set official status of language.
    public void setIsOfficial(char value){
        this.IsOfficial = value;
    }

    // Get percentage of speakers.
    public float getPercentage(){
        return this.Percentage;
    }
    // Set percentage of speakers.
    public void setPercentage(float value){
        this.Percentage = value;
    }

}
