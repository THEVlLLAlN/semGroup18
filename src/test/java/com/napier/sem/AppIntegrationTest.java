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
    void testGetCity()
    {
        city c = app.getCity(4060);
        assertEquals(c.getID(), 4060);
        assertEquals(c.getName(),"Santa Monica");
        assertEquals(c.getDistrict(), "California");
        assertEquals(c.getPopulation(), 91084);
    }

    @Test
    void testGetCities() {
        String where = "WHERE city.CountryCode = country.Code ";

        int n = 0;

        ArrayList<city> Cities = app.getCities(n, where);

        int counter = 0;

        while (counter < Cities.size()){
            city CityA = Cities.get(counter);
            String city_string = CityA.getName() + " " + CityA.getCountryCode();
            System.out.println(city_string);
            counter++;
        }
    }


    
}