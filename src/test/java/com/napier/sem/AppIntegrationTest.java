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

        ArrayList<city> arrayList = app.getCities(where, n);

        int counter = 0;

        while (counter < arrayList.size()){
            city c = arrayList.get(counter);
            String string = c.getName() + " " + c.getCountryCode();
            System.out.println(string);
            counter++;
        }

        System.out.println(" ");
    }

    @Test
    void testGetCapitalCities() {
        System.out.println("TEST GET CAPITAL CITIES");
        String where = "country.Capital = city.ID";

        String n = "0";

        ArrayList<city> arrayList = app.getCities(where, n);

        int counter = 0;

        while (counter < arrayList.size()){
            city c = arrayList.get(counter);
            String string = c.getName() + " " + c.getCountryCode();
            System.out.println(string);
            counter++;
        }

        System.out.println(" ");
    }

    @Test
    void testGetCapitalCitiesLimited() {
        System.out.println("TEST GET CAPITAL CITIES WITH LIMIT");
        String where = "country.Capital = city.ID";

        String n = "10";

        ArrayList<city> arrayList = app.getCities(where, n);

        int counter = 0;

        while (counter < arrayList.size()){
            city c = arrayList.get(counter);
            String string = c.getName() + " " + c.getCountryCode();
            System.out.println(string);
            counter++;
        }

        System.out.println(" ");
    }

    @Test
    void testGetCitiesLimited() {
        System.out.println("TEST GET CITIES WITH LIMIT");
        String where = "World";

        String n = "10";

        ArrayList<city> arrayList = app.getCities(where, n);

        int counter = 0;

        while (counter < arrayList.size()){
            city CityA = arrayList.get(counter);
            String city_string = CityA.getName() + " " + CityA.getCountryCode();
            System.out.println(city_string);
            counter++;
        }

        System.out.println(" ");
    }

    @Test
    void testGetCountries() {
        System.out.println("TEST GET COUNTRIES");
        String where = "country.Continent = 'Asia'";

        String n = "0";

        ArrayList<country> arrayList = app.getCountries(where, n);

        int counter = 0;

        while (counter < arrayList.size()){
            country c = arrayList.get(counter);
            String string = c.getName() + " " + c.getCode();
            System.out.println(string);
            counter++;
        }

        System.out.println(" ");
    }

    @Test
    void testGetCountriesLimited() {
        System.out.println("TEST GET COUNTRIES WITH LIMIT");
        String where = "World";

        String n = "10";

        ArrayList<country> arrayList = app.getCountries(where, n);

        int counter = 0;

        while (counter < arrayList.size()){
            country c = arrayList.get(counter);
            String string = c.getName() + " " + c.getCode();
            System.out.println(string);
            counter++;
        }

        System.out.println(" ");
    }

    @Test
    void populationTestWorld(){
        System.out.println("TEST GET WORLD POPULATION");
        String where = "World";

        ArrayList<populationData> arrayList = app.getPopulationCountry(where);

        int counter = 0;

        while (counter < arrayList.size()){
            populationData c = arrayList.get(counter);
            String string = "Population: " + c.getPop();
            System.out.println(string);
            counter++;
        }

        System.out.println(" ");
    }

    @Test
    void populationTestCity(){
        System.out.println("TEST GET POPULATION - CITY");
        String where = "city.Name = 'Kabul'";

        ArrayList<populationData> arrayList = app.getPopulationCity(where);

        int counter = 0;

        while (counter < arrayList.size()){
            populationData c = arrayList.get(counter);
            String string = "Population: " + c.getPop();
            System.out.println(string);
            counter++;
        }

        System.out.println(" ");
    }


    @Test
    void populationTestInvalidCity(){
        System.out.println("TEST GET POPULATION - INVALID CITY");
        String where = "city.Name = 'jsjdhghdjsd'";

        ArrayList<populationData> arrayList = app.getPopulationCity(where);

        int counter = 0;

        while (counter < arrayList.size()){
            populationData c = arrayList.get(counter);
            String string = "Population: " + c.getPop();
            System.out.println(string);
            counter++;
        }

        System.out.println(" ");
    }


    @Test
    void populationTestCountry(){
        System.out.println("TEST GET POPULATION - COUNTRY");
        String where = "country.Name = 'France'";

        ArrayList<populationData> arrayList = app.getPopulationCountry(where);

        int counter = 0;

        while (counter < arrayList.size()){
            populationData c = arrayList.get(counter);
            String string = "Population: " + c.getPop();
            System.out.println(string);
            counter++;
        }

        System.out.println(" ");
    }

    @Test
    void populationTestInvalidCountry(){
        System.out.println("TEST GET POPULATION - INVALID COUNTRY");
        String where = "country.Name = '12345678dhds'";

        ArrayList<populationData> arrayList = app.getPopulationCountry(where);

        int counter = 0;

        while (counter < arrayList.size()){
            populationData c = arrayList.get(counter);
            String string = "Population: " + c.getPop();
            System.out.println(string);
            counter++;
        }

        System.out.println(" ");
    }

    @Test
    void populationInOutCitiesWorld(){
        System.out.println("TEST GET POPULATION IN AND OUT OF CITIES - WORLD");
        String where = "world";

        ArrayList<populationDataCities> arrayList = app.showPopulations(where);

        int counter = 0;

        while (counter < arrayList.size()){
            populationDataCities c = arrayList.get(counter);
            String string = "Population Total: " + c.getPopTotal() + " In Cities: " + c.getPopIn() + " Out of Cities: " + c.getPopOut();
            System.out.println(string);
            counter++;
        }


        System.out.println(" ");
    }

    @Test
    void populationInOutCities(){
        System.out.println("TEST GET POPULATION IN AND OUT OF CITIES - FRANCE");
        String where = "country.Name = 'France'";

        ArrayList<populationDataCities> arrayList = app.showPopulations(where);

        int counter = 0;

        while (counter < arrayList.size()){
            populationDataCities c = arrayList.get(counter);
            String string = "Population Total: " + c.getPopTotal() + " In Cities: " + c.getPopIn() + " Out of Cities: " + c.getPopOut();
            System.out.println(string);
            counter++;
        }

        System.out.println(" ");
    }

    @Test
    void languagesTest(){
        System.out.println("TEST GET LANGUAGE DATA");

        ArrayList<languageData> arrayList = app.getLanguageData();

        int counter = 0;

        while (counter < arrayList.size()){
            languageData c = arrayList.get(counter);
            String string = c.getLanguageName() + " No of Speakers: " + c.getPopNum() + " Percentage: " + c.getPercentage();
            System.out.println(string);
            counter++;
        }

        System.out.println(" ");
    }

}