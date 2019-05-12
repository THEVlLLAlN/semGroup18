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
    void populationTestWorld(){
        System.out.println("TEST GET WORLD POPULATION");
        String where = "";

        app.getPopulationCountry(where);

        System.out.println(" ");
    }

    @Test
    void populationTestCity(){
        System.out.println("TEST GET POPULATION - CITY");
        String where = "Kabul";

        app.getPopulationCity(where);

        System.out.println(" ");
    }


    @Test
    void populationTestInvalidCity(){
        System.out.println("TEST GET POPULATION - INVALID CITY");
        String where = "jsjdhghdjsd";

        app.getPopulationCity(where);

        System.out.println(" ");
    }


    @Test
    void populationTestCountry(){
        System.out.println("TEST GET POPULATION - COUNTRY");
        String where = "France";

        app.getPopulationCountry(where);

        System.out.println(" ");
    }

    @Test
    void populationTestInvalidCountry(){
        System.out.println("TEST GET POPULATION - INVALID COUNTRY");
        String where = "12345678dhds";

        app.getPopulationCountry(where);

        System.out.println(" ");
    }

    @Test
    void populationInOutCities(){
        System.out.println("TEST GET POPULATION IN AND OUT OF CITIES");
        String where = "country.Continent = 'Asia'";

        app.showPopulations(where);

        System.out.println(" ");
    }

    @Test
    void languagesTest(){
        System.out.println("TEST GET LANGUAGE DATA");

        app.getLanguageData();
        System.out.println(" ");
    }

}