package com.napier.sem;
import java.sql.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

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

        countryA.setCode("XD");
        assertEquals(countryA.getCode(), "XD");

        countryA.setName("Jon Callahan");
        assertEquals(countryA.getName(), "Jon Callahan");

        countryA.setContinent("Irozan");
        assertEquals(countryA.getContinent(), "Irozan");

        countryA.setRegion("asujas");
        assertEquals(countryA.getRegion(), "asujas");

        countryA.setIndepYear(2012);
        assertEquals(countryA.getIndepYear(), 2012);

        countryA.setSurfaceArea(12345);
        assertEquals(countryA.getSurfaceArea(), 12345);

        countryA.setPopulation(450000);
        assertEquals(countryA.getPopulation(), 450000);

        countryA.setLifeExpectancy(12345);
        assertEquals(countryA.getLifeExpectancy(), 12345);

        countryA.setGNP(12345);
        assertEquals(countryA.getGNP(), 12345);

        countryA.setGNPOld(12345);
        assertEquals(countryA.getGNPOld(), 12345);

        countryA.setLocalName("ASDf");
        assertEquals(countryA.getLocalName(), "ASDf");

        countryA.setGovernmentForm("Democracy");
        assertEquals(countryA.getGovernmentForm(), "Democracy");

        countryA.setHeadOfState("Dr Eggman");
        assertEquals(countryA.getHeadOfState(), "Dr Eggman");

        countryA.setCapital(123);
        assertEquals(countryA.getCapital(), 123);

        countryA.setCode2("Uwu");
        assertEquals(countryA.getCode2(), "Uwu");

    }

    @Test
    void countrylanguageTest() {
        countrylanguage countrylanguageA = new countrylanguage();

        countrylanguageA.setCountryCode("Dr Eggman");
        assertEquals(countrylanguageA.getCountryCode(), "Dr Eggman");

        countrylanguageA.setLanguage("Eggish");
        assertEquals(countrylanguageA.getLanguage(), "Eggish");

        countrylanguageA.setIsOfficial('E');
        assertEquals(countrylanguageA.getIsOfficial(), 'E');

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

        cityA.setCountryCode("boop!");
        assertEquals(cityA.getCountryCode(), "boop!");

        cityA.setDistrict("East end");
        assertEquals(cityA.getDistrict(), "East end");

        cityA.setPopulation(123456789);
        assertEquals(cityA.getPopulation(), 123456789);
    }


    @Test
    void populationTestNull(){
        String typenull = "";
        String wherenull = "";

        app.getPopulation(typenull, wherenull);

    }

    @Test
    void populationTestCity(){
        String type = "City";
        String where = "Kabul";

        int population = app.getPopulation(type, where);

        assertEquals(population, 1780000);

    }

}