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
    }

    @Test
    void largesttosmallestcountrypopN() {
        int n = 3;
        ArrayList<city> largestToSmallestCityWorld = app.getLargestToSmallestCityWorld(n);
        System.out.println(largestToSmallestCityWorld);

        ArrayList<city> largestToSmallestCapital = app.getLargestToSmallestCapitalWorld();
        assertNotNull(largestToSmallestCapital);

        countrylanguage countrylanguageA = new countrylanguage();

        countrylanguageA.setCountryCode("Dr Eggman");
        assertEquals(countrylanguageA.getCountryCode(), "Dr Eggman");



    }
}