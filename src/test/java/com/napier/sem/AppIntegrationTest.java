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
        app.connect("db");
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
    void testGetLargestToSmallestCityWorld() {
        ArrayList<city> c = app.getLargestToSmallestCityWorld(0);
        assertNotNull(c);
        assertEquals(c.size(), 4079);
    }

    @Test
    void testGetLargestToSmallestCountryWorld() {
        ArrayList<country> c = app.getLargestToSmallestCountryWorld();
        assertNotNull(c);
        assertEquals(c.size(),238);
    }

    @Test
    void testGetLargestToSmallestCapitalWorld() {
        ArrayList<city> c = app.getLargestToSmallestCapitalWorld();
        assertNotNull(c);
        assertEquals(c.size(),238);
    }
}