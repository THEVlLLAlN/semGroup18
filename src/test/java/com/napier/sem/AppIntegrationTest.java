package com.napier.sem;
import java.sql.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void testGetCities() {
        System.out.println("TEST GET CITIES");
        String where = "country.Continent = 'Asia'";

        String n = "0";

        app.getCities(where, n);

        System.out.println(" ");
    }

    @Test
    void testGetCitiesLimited() {
        System.out.println("TEST GET CITIES WITH LIMIT");
        String where = "World";

        String n = "10";

        app.getCities(where, n);

        System.out.println(" ");
    }

    @Test
    void testGetCountries() {
        System.out.println("TEST GET COUNTRIES");
        String where = "country.Continent = 'Asia'";

        String n = "0";

        app.getCountries(where, n);

        System.out.println(" ");
    }

    @Test
    void testGetCountriesLimited() {
        System.out.println("TEST GET COUNTRIES WITH LIMIT");
        String where = "World";

        String n = "10";

        app.getCountries(where, n);

        System.out.println(" ");
    }

    @Test
    void populationTestNull(){
        System.out.println("TEST GET POPULATION NULL");
        String typenull = "";
        String wherenull = "";

        //app.getPopulation(typenull, wherenull);

        System.out.println(" ");
    }

    @Test
    void populationTestCity(){
        System.out.println("TEST GET POPULATION - CITY");
        String type = "City";
        String where = "Kabul";

        //app.getPopulation(type, where);

        System.out.println(" ");
    }


    @Test
    void populationTestInvalidCity(){
        System.out.println("TEST GET POPULATION - INVALID CITY");
        String type = "City";
        String where = "jsjdhghdjsd";

        //app.getPopulation(type, where);

        System.out.println(" ");
    }


    @Test
    void populationTestCountry(){
        System.out.println("TEST GET POPULATION - COUNTRY");
        String type = "Country";
        String where = "France";

        //app.getPopulation(type, where);

        System.out.println(" ");
    }

    @Test
    void populationTestInvalidCountry(){
        System.out.println("TEST GET POPULATION - INVALID COUNTRY");
        String type = "Country";
        String where = "12345678dhds";

        //app.getPopulation(type, where);

        System.out.println(" ");
    }

    @Test
    void populationTestInvalidType(){
        System.out.println("TEST GET POPULATION - INVALID TYPE");
        String type = "xxxxxxx";
        String where = "France";

        //app.getPopulation(type, where);

        System.out.println(" ");
    }
}