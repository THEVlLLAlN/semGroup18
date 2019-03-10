package com.napier.sem;

public class country {

    // Stores code of country.
    private String Code;
    // Stores name of country.
    private String Name;
    // Stores continent country is in.
    private String Continent;
    // Stores region country is in.
    private String Region;
    // Stores surface area of country.
    private float SurfaceArea;
    // Stores year country became independent.
    private int IndepYear;
    // Stores population of country.
    private int Population;
    // Stores average life expectancy of population in country.
    private float LifeExpectancy;
    // Stores gross national product of country.
    private float GNP;
    // Stores old gross national product of country.
    private float GNPOld;
    // Stores local name of country.
    private String LocalName;
    // Stores form of governance.
    private String GovernmentForm;
    // Stores name of head of state.
    private String HeadOfState;
    // Stores code of country's capital city
    private int Capital;
    // Stores alternate code of country.
    private String Code2;

    // Get code of country.
    public String getCode(){
        return this.Code;
    }
    // Set code of country.
    public void setCode(String value){
        this.Code = value;
    }

    // Get country name.
    public String getName(){
        return this.Name;
    }
    // Set country name.
    public void setName(String value){
        this.Name = value;
    }

    // Get continent name.
    public String getContinent(){
        return this.Continent;
    }
    // Set continent name.
    public void setContinent(String value){
        this.Continent = value;
    }

    // Get region name.
    public String getRegion(){
        return this.Region;
    }
    // Set region name.
    public void setRegion(String value){
        this.Region = value;
    }

    // Get surface area.
    public float getSurfaceArea(){
        return this.SurfaceArea;
    }
    // Set surface area.
    public void setSurfaceArea(float value){
        this.SurfaceArea = value;
    }

    // Get independence year.
    public int getIndepYear(){
        return this.IndepYear;
    }
    // Set independence year
    public void setIndepYear(int value){
        this.IndepYear = value;
    }

    // Get population.
    public int getPopulation(){
        return this.Population;
    }
    // Set population.
    public void setPopulation(int value){
        this.Population = value;
    }

    // Get life expectancy.
    public float getLifeExpectancy(){
        return this.LifeExpectancy;
    }
    // Set life expectancy.
    public void setLifeExpectancy(float value){
        this.LifeExpectancy = value;
    }

    // Get GNP.
    public float getGNP(){
        return this.GNP;
    }
    // Set GNP.
    public void setGNP(float value){
        this.GNP = value;
    }

    // Get old GNP.
    public float getGNPOld(){
        return this.GNPOld;
    }
    // Set old GNP.
    public void setGNPOld(float value){
        this.GNPOld = value;
    }

    // Get local country name.
    public String getLocalName(){
        return this.LocalName;
    }
    // Set local country name.
    public void setLocalName(String value){
        this.LocalName = value;
    }

    // Get form of government.
    public String getGovernmentForm(){
        return this.GovernmentForm;
    }
    // Set form of government.
    public void setGovernmentForm(String value){
        this.GovernmentForm = value;
    }

    // Get name of head of state.
    public String getHeadOfState(){
        return this.HeadOfState;
    }
    // Set name of head of state.
    public void setHeadOfState(String value){
        this.HeadOfState = value;
    }

    // Get name of capital city.
    public int getCapital(){
        return this.Capital;
    }
    // Set name of capital city.
    public void setCapital(int value){
        this.Capital = value;
    }

    // Get alternate country code.
    public String getCode2() {
        return this.Code2;
    }
    // Set alternate country code.
    public void setCode2(String value){
        this.Code2 = value;
    }

}
