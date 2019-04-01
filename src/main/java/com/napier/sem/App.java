package com.napier.sem;
import java.util.ArrayList;
import java.sql.*;

public class App
{
    // Create variable to store connection.
    private Connection con = null;

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect("localhost:33060");

        String where = "";
        int n = 0;

        ArrayList<city> Cities = a.getCities(n, where);

        for (city CityA : Cities){
            if (CityA == null)
                continue;
            String city_string = CityA.getName() + " " + CityA.getCountryCode();
            System.out.println(city_string);
        }

        // Disconnect from database
        a.disconnect();
    }

    public ArrayList<city> getCities(int n, String where) {
        try {
            StringBuilder stmnt = new StringBuilder();
            stmnt.append("SELECT city.Name, city.District, city.CountryCode, city.Population ");
            stmnt.append("FROM city, country ");
            stmnt.append("WHERE city.CountryCode = country.Code ");
            if (!where.isEmpty()) {
                stmnt.append(where);
            }
            stmnt.append(" ORDER BY city.Population DESC");

            if (n != 0) {
                stmnt.append("LIMIT ");
                stmnt.append(n);
            }

            String statement = stmnt.toString();

            // execute the sql statement
            ResultSet resultset = sql(statement);

            ArrayList<city> cities = new ArrayList<>();

            while (resultset.next()) {
                city c = new city();
                c.setName(resultset.getString("city.Name"));
                c.setCountryCode(resultset.getString("city.CountryCode"));
                c.setDistrict(resultset.getString("city.District"));
                c.setPopulation(resultset.getInt("city.Population"));
                cities.add(c);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities");
            return null;
        }
    }

    public ArrayList<country> getCountries(int n, String where) {
        try {
            StringBuilder stmnt = new StringBuilder();
            stmnt.append("SELECT Code, Name, Continent, Region, Population, Capital");
            stmnt.append("FROM country ");
            if (!where.isEmpty()) {
                stmnt.append("WHERE ");
                stmnt.append(where);
            }
            stmnt.append(" ORDER BY Population DESC");

            if (n != 0) {
                stmnt.append(" LIMIT ");
                stmnt.append(n);
            }

            String statement = stmnt.toString();

            // execute the sql statement
            ResultSet resultset = sql(statement);

            ArrayList<country> countries = new ArrayList<>();

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

    public int getPopulation(String type, String where) {
        try {
            StringBuilder stmnt = new StringBuilder();
            stmnt.append("SELECT SUM(Population) ");
            if (type.equalsIgnoreCase("World")){
                stmnt.append("FROM country");
            }
            if (type.equalsIgnoreCase("Continent") || type.equalsIgnoreCase("Region") || type.equalsIgnoreCase("Country")){
                stmnt.append("FROM country ");
                if (type.equalsIgnoreCase("Continent")) {
                    stmnt.append("WHERE Continent = '");
                    stmnt.append(where);
                    stmnt.append("'");
                }
                if (type.equalsIgnoreCase("Region")) {
                    stmnt.append("WHERE Region = '");
                    stmnt.append(where);
                    stmnt.append("'");
                }
                if (type.equalsIgnoreCase("Country")) {
                    stmnt.append("WHERE Country = '");
                    stmnt.append(where);
                    stmnt.append("'");
                }
            }
            if (type.equalsIgnoreCase("District") || type.equalsIgnoreCase("City")) {
                if (type.equalsIgnoreCase("District")) {
                    stmnt.append("WHERE District = '");
                    stmnt.append(where);
                    stmnt.append("'");
                }
                if (type.equalsIgnoreCase("City")) {
                    stmnt.append("WHERE City = '");
                    stmnt.append(where);
                    stmnt.append("'");
                }
            }

            String statement = stmnt.toString();

            // execute the sql statement
            ResultSet resultset = sql(statement);

            int pop = 0;

            while (resultset.next()) {
                pop = resultset.getInt(1);
            }
            return pop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population.");
            return 0;
        }
    }

    public ResultSet sql(String statement){
        try
        {
            Statement stmnt = con.createStatement();

            ResultSet results = stmnt.executeQuery(statement);

            return results;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Statement Creation Failed.");
            return null;
        }
    }

    public void connect(String location)
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


    public void disconnect()
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