package com.napier.sem;

public class countrylanguage {

    private String CountryCode;
    private String Language;
    private char IsOfficial;
    private float Percentage;

    public String getCountryCode(){
        return this.CountryCode;
    }
    public void setCountryCode(String value){
        this.CountryCode = value;
    }

    public String getLanguage(){
        return this.Language;
    }
    public void setLanguage(String value){
        this.Language = value;
    }

    public char getIsOfficial(){
        return this.IsOfficial;
    }
    public void setIsOfficial(char value){
        this.IsOfficial = value;
    }

    public float getPercentage(){
        return this.Percentage;
    }
    public void setPercentage(float value){
        this.Percentage = value;
    }

}
