package com.napier.sem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;

@SpringBootApplication
@RestController
public class App
{
    // Create variable to store connection.
    private static Connection con = null;

    public static void main(String[] args)
    {
        // Connect to database.
        if (args.length < 1)
        {
            connect("localhost:33060");
        }
        else
        {
            connect(args[0]);
        }
        // Run app.
        SpringApplication.run(App.class, args);
    }


    @RequestMapping("getCities")
    public ArrayList<city> getCities(@RequestParam(value = "where") String where, @RequestParam(value = "limit") String limit ) {
        try {
            // Create string builder to hold sql statement.
            StringBuilder stmnt = new StringBuilder();
            // Add sql text.
            stmnt.append("SELECT city.Name, city.District, city.CountryCode, city.Population ");
            stmnt.append("FROM city JOIN country ON city.CountryCode = country.Code");
            // If where conditions are present add to sql statement.
            if (!where.equalsIgnoreCase("World")) {
                stmnt.append(" WHERE ");
                stmnt.append(where);
            }

            // Add order by condition to sql statement.
            stmnt.append(" ORDER BY city.Population DESC");

            // Convert string parameter to int.
            int n = Integer.parseInt(limit);
            // If limiter is present add to sql statement.
            if(n > 0)  {
                stmnt.append(" LIMIT ");
                stmnt.append(n);
            }

            // Convert string builder to string.
            String statement = stmnt.toString();

            // Execute the sql statement
            ResultSet resultset = sql(statement);

            // Create array list to store results.
            ArrayList<city> cities = new ArrayList<>();

            // Look at next set of result data.
            while (resultset.next()) {
                // Create new city variable.
                city c = new city();
                // Add data to new city variable.
                c.setName(resultset.getString("city.Name"));
                c.setCountryCode(resultset.getString("city.CountryCode"));
                c.setDistrict(resultset.getString("city.District"));
                c.setPopulation(resultset.getInt("city.Population"));
                // Add new city variable to array list of results.
                cities.add(c);

            }
            // Return array list with results.
            return cities;
        } catch (Exception e) {
            // Print error message.
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities");
            // Return to satisfy method.
            return null;
        }
    }



    @RequestMapping("getCountries")
    public ArrayList<country> getCountries(@RequestParam(value = "where") String where, @RequestParam(value = "limit") String limit) {
        try {
            // Create string builder to hold sql statement.
            StringBuilder stmnt = new StringBuilder();
            // Add sql text.
            stmnt.append("SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital ");
            stmnt.append("FROM country");
            // If where conditions are present add to sql statement.
            if (!where.equalsIgnoreCase("World")) {
                stmnt.append(" WHERE ");
                stmnt.append(where);
            }

            // Add order by condition to sql statement.
            stmnt.append(" ORDER BY country.Population DESC");

            // Convert string parameter to int.
            int n = Integer.parseInt(limit);
            // If limiter is present add to sql statement.
            if(n > 0)  {
                stmnt.append(" LIMIT ");
                stmnt.append(n);
            }

            // Convert string builder to string.
            String statement = stmnt.toString();

            // Execute the sql statement.
            ResultSet resultset = sql(statement);

            // Create array list to store results.
            ArrayList<country> countries = new ArrayList<>();

            // Look at next set of result data.
            while (resultset.next()) {
                country c = new country();
                c.setCode(resultset.getString("Code"));
                c.setName(resultset.getString("Name"));
                c.setContinent(resultset.getString("Continent"));
                c.setRegion(resultset.getString("Region"));
                c.setPopulation(resultset.getInt("Population"));
                c.setCapital(resultset.getInt("Capital"));
                countries.add(c);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries.");
            return null;
        }
    }

    @RequestMapping("showPopulations")
    public ArrayList<populationDataCities> showPopulations(@RequestParam(value = "where") String where) {
        try {
            // Create string builder to hold sql statement.
            StringBuilder stmnt = new StringBuilder();
            // Add sql text.
            stmnt.append("SELECT SUM(country.Population), SUM(city.Population), SUM(country.Population)-SUM(city.Population) ");
            stmnt.append("FROM city JOIN country ON city.CountryCode = country.Code");
            // If where conditions are present add to sql statement.
            if (!where.equalsIgnoreCase("World")) {
                stmnt.append(" WHERE ");
                stmnt.append(where);
            }

            // Convert string builder to string.
            String statement = stmnt.toString();

            // Execute the sql statement.
            ResultSet resultset = sql(statement);

            // Create array list to store results.
            ArrayList<populationDataCities> popData = new ArrayList<>();

            // Look at next set of result data.
            while(resultset.next()) {
                populationDataCities item = new populationDataCities();
                item.setPopTotal(resultset.getLong(1));
                item.setPopIn(resultset.getLong(2));
                item.setPopOut(resultset.getLong(3));
                popData.add(item);
            }
            return popData;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population information.");
            return null;
        }
    }

    @RequestMapping("getPopulationCountry")
    public ArrayList<populationData> getPopulationCountry(@RequestParam(value = "where") String where) {
        try {
            // Create string builder to hold sql statement.
            StringBuilder stmnt = new StringBuilder();
            // Add sql text.
            stmnt.append("SELECT SUM(Population) FROM country");
            // If where conditions are present add to sql statement.
            if (!where.equalsIgnoreCase("World")) {
                stmnt.append(" WHERE ");
                stmnt.append(where);
            }

            // Convert string builder to string.
            String statement = stmnt.toString();

            // Execute the sql statement.
            ResultSet resultset = sql(statement);

            // Create array list to store results.
            ArrayList<populationData> popData = new ArrayList<>();

            // Look at next set of result data.
            while (resultset.next()) {
                populationData item = new populationData();
                item.setPop(resultset.getLong(1));
                popData.add(item);
            }
            return popData;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population.");
            return null;
        }
    }

    @RequestMapping("getPopulationCity")
    public ArrayList<populationData> getPopulationCity(@RequestParam(value = "where") String where) {
        try {
            // Create string builder to hold sql statement.
            StringBuilder stmnt = new StringBuilder();
            // If where conditions are present add to sql statement.
            // Else add sql text.
            if (!where.equalsIgnoreCase("World")) {
                stmnt.append("SELECT SUM(Population) FROM city WHERE ");
                stmnt.append(where);
            }else{
                stmnt.append("SELECT SUM(Population) FROM country");
            }

            // Convert string builder to string.
            String statement = stmnt.toString();

            // Execute the sql statement.
            ResultSet resultset = sql(statement);

            // Create array list to store results.
            ArrayList<populationData> popData = new ArrayList<>();

            // Look at next set of result data.
            while (resultset.next()) {
                populationData item = new populationData();
                item.setPop(resultset.getLong(1));
                popData.add(item);
            }
            return popData;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population with city data.");
            return null;
        }
    }

    @RequestMapping("getLanguageData")
    public ArrayList<languageData> getLanguageData() {
        try {
            // Create string builder to hold sql statement.
            StringBuilder stmnt = new StringBuilder();
            // Add sql text.
            stmnt.append("SELECT Language, SUM(Population), AVG(Percentage)");
            stmnt.append(" FROM countrylanguage JOIN country ON CountryCode = Code ");
            stmnt.append("WHERE Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic')");
            stmnt.append(" GROUP BY Language ORDER BY AVG(Percentage) DESC");

            // Convert string builder to string.
            String statement = stmnt.toString();

            // Execute the sql statement.
            ResultSet resultset = sql(statement);

            // Create array list to store results.
            ArrayList<languageData> langData = new ArrayList<>();

            // Look at next set of result data.
            while (resultset.next()) {
                languageData item = new languageData();
                item.setLanguageName(resultset.getString(1));
                item.setPopNum(resultset.getLong(2));
                item.setPercentage(resultset.getFloat(3));
                langData.add(item);
            }
            return langData;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get language data.");
            return null;
        }
    }

    public ResultSet sql(String statement){
        try
        {
            // Create sql statement.
            Statement stmnt = con.createStatement();
            // Generate result set with passed in statement.
            ResultSet results = stmnt.executeQuery(statement);
            // Return result set.
            return results;
        }
        catch (Exception e)
        {
            // Print error messages.
            System.out.println(e.getMessage());
            System.out.println("Statement Creation Failed.");
            // Return to satisfy method.
            return null;
        }
    }

    public static void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            // Print error message.
            System.out.println("Could not load SQL driver");
            // Exit with status.
            System.exit(-1);
        }

        // Set number of retries.
        int retries = 10;
        // Loop for number of retries.
        for (int i = 0; i < retries; ++i)
        {
            // Print message to console to update user.
            System.out.println("Connecting to database...");

            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                // Print message to console to update user.
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }


    public static void disconnect()
    {
        // Checks a connection is present.
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                // Print error message.
                System.out.println("Error closing connection to database");
            }
        }
    }
}