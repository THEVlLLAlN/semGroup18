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
}