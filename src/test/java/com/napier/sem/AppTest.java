package com.napier.sem;
import java.sql.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();

    }

    @Test
    void disconnect() {
        Connection con = null;
        con = null;
        app.disconnect();
    }


    @Test
    void countryTest() {

        country countryA = new country();

        countryA.setCode("ABC");
        assertEquals(countryA.getCode(), "ABC");

        countryA.setName("CountryName");
        assertEquals(countryA.getName(), "CountryName");

        countryA.setContinent("Asia");
        assertEquals(countryA.getContinent(), "Asia");

        countryA.setRegion("RegionName");
        assertEquals(countryA.getRegion(), "RegionName");

        countryA.setIndepYear(2012);
        assertEquals(countryA.getIndepYear(), 2012);

        countryA.setSurfaceArea(12345);
        assertEquals(countryA.getSurfaceArea(), 12345);

        countryA.setPopulation(450000);
        assertEquals(countryA.getPopulation(), 450000);

        countryA.setLifeExpectancy(100);
        assertEquals(countryA.getLifeExpectancy(), 100);

        countryA.setGNP(12345);
        assertEquals(countryA.getGNP(), 12345);

        countryA.setGNPOld(12345);
        assertEquals(countryA.getGNPOld(), 12345);

        countryA.setLocalName("OurCountry");
        assertEquals(countryA.getLocalName(), "OurCountry");

        countryA.setGovernmentForm("Democracy");
        assertEquals(countryA.getGovernmentForm(), "Democracy");

        countryA.setHeadOfState("Mr President");
        assertEquals(countryA.getHeadOfState(), "Mr President");

        countryA.setCapital(123);
        assertEquals(countryA.getCapital(), 123);

        countryA.setCode2("CBA");
        assertEquals(countryA.getCode2(), "CBA");
    }

    @Test
    void countrylanguageTest() {
        countrylanguage countrylanguageA = new countrylanguage();

        countrylanguageA.setCountryCode("ABC");
        assertEquals(countrylanguageA.getCountryCode(), "ABC");

        countrylanguageA.setLanguage("Gibberish");
        assertEquals(countrylanguageA.getLanguage(), "Gibberish");

        countrylanguageA.setIsOfficial('T');
        assertEquals(countrylanguageA.getIsOfficial(), 'T');

        countrylanguageA.setPercentage(100);
        assertEquals(countrylanguageA.getPercentage(), 100);
    }


    @Test
    void cityTest(){
        city cityA = new city();

        cityA.setID(123);
        assertEquals(cityA.getID(), 123);

        cityA.setName("Coolsville");
        assertEquals(cityA.getName(), "Coolsville");

        cityA.setCountryCode("ABC");
        assertEquals(cityA.getCountryCode(), "ABC");

        cityA.setDistrict("East end");
        assertEquals(cityA.getDistrict(), "East end");

        cityA.setPopulation(123456789);
        assertEquals(cityA.getPopulation(), 123456789);
    }

    @Test
    void languageDataTest(){
        languageData language = new languageData();

        language.setLanguageName("English");
        assertEquals(language.getLanguageName(), "English");

        language.setPopNum(1000);
        assertEquals(language.getPopNum(), 1000);

        language.setPercentage(100);
        assertEquals(language.getPercentage(), 100);
    }

    @Test
    void populationDataTest(){
        populationData popData = new populationData();

        popData.setPop(100);
        assertEquals(popData.getPop(), 100);
    }

    @Test
    void populationDataCitiesTest(){
        populationDataCities popDataC = new populationDataCities();

        popDataC.setPopTotal(1000);
        assertEquals(popDataC.getPopTotal(), 1000);

        popDataC.setPopOut(400);
        assertEquals(popDataC.getPopOut(), 400);

        popDataC.setPopIn(600);
        assertEquals(popDataC.getPopIn(), 600);
    }

}