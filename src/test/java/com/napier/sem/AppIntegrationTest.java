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
        String where = "";

        int n = 0;

        app.getCities(n, where);
    }

    @Test
    void testGetCitiesLimited() {
        String where = "";

        int n = 10;

        app.getCities(n, where);
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

        app.getPopulation(type, where);
    }


    @Test
    void populationTestInvalidCity(){
        String type = "City";
        String where = "jsjdhghdjsd";

        app.getPopulation(type, where);
    }


    @Test
    void populationTestCountry(){
        String type = "Country";
        String where = "France";

        app.getPopulation(type, where);
    }

    @Test
    void populationTestInvalidCountry(){
        String type = "Country";
        String where = "12345678dhds";

        app.getPopulation(type, where);

    }

    @Test
    void populationTestInvalidType(){
        String type = "xxxxxxx";
        String where = "France";

        app.getPopulation(type, where);

    }
}