package com.napier.sem;
import java.util.ArrayList;
import java.sql.*;

public class App
{
    private Connection con = null;

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect("localhost:33060");

        //city cityStr = a.getCity(cityName);
        int n = 0;
        ArrayList<city> largestToSmallestCityWorld = a.getLargestToSmallestCityWorld(n);
        ArrayList<city> largestToSmallestCapital = a.getLargestToSmallestCapitalWorld();
        ArrayList<country> largestToSmallestCountryWorld = a.getLargestToSmallestCountryWorld();

        // Disconnect from database
        a.disconnect();
    }

    public city getCity(int n)
    {
        try
        {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT ID, Name, District, CountryCode, Population " +
                            "FROM city " +
                            "WHERE city.id = " + n;
            ResultSet rset = stmt.executeQuery(strSelect);

            if (rset.next())
            {
                city c = new city();
                c.setID(rset.getInt("city.getID"));
                c.setName(rset.getString("city.getName"));
                c.setDistrict(rset.getString("c.District"));
                c.setPopulation(rset.getInt("c.Population"));
                return c;
            }
            else
                return null;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public ArrayList<city> getLargestToSmallestCityWorld(int n) {
        try {
            // creating the sql statement
            Statement st = con.createStatement();
            // creating the sql string
            String strSelect = "";

            if (n==0)
            {
                strSelect =
                        "SELECT city.Name, country.Name, city.District, city.CountryCode, city.Population \n" +
                                "FROM city, country \n" +
                                "WHERE city.CountryCode = country.Code \n" +
                                "ORDER BY city.Population DESC";
            } else
            {
                strSelect =
                        "SELECT city.Name, country.Name, city.District, city.CountryCode, city.Population \n" +
                                "FROM city, country \n" +
                                "WHERE city.CountryCode = country.Code \n" +
                                "ORDER BY city.Population DESC" +
                                "LIMIT '" + n + "'\n";
            }

            // execute the sql statement
            ResultSet resultset = st.executeQuery(strSelect);

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
            System.out.println("failed to get largest to smallest populated cities");
            return null;
        }
    }


    public ArrayList<country> getLargestToSmallestCountryWorld() {
        try {
            // creating the sql statement
            Statement st = con.createStatement();
            // creating the sql string Code.
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name, country.Capital \n" +
                            "FROM country, city \n" +
                            "WHERE city.ID = country.Capital \n" +
                            "ORDER BY country.Population DESC";
            // execute the sql statement
            ResultSet resultset = st.executeQuery(strSelect);

            ArrayList<country> countries = new ArrayList<>();

            while (resultset.next()) {
                country c = new country();
                c.setCode(resultset.getString("country.Code"));
                c.setName(resultset.getString("country.Name"));
                c.setContinent(resultset.getString("country.Continent"));
                c.setRegion(resultset.getString("country.Region"));
                c.setPopulation(resultset.getInt("country.Population"));
                c.setCapital(resultset.getInt("country.Capital"));
                countries.add(c);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("failed to get largest to smallest populated countries");
            return null;
        }
    }


    public ArrayList<city> getLargestToSmallestCapitalWorld() {
        try {
            // creating the sql statement
            Statement st = con.createStatement();
            // creating the sql string
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.CountryCode, city.Population \n" +
                            "FROM city, country \n" +
                            "WHERE city.CountryCode = country.Code \n" +
                            "AND city.ID = country.Capital \n" +
                            "ORDER BY city.Population DESC";
            // execute the sql statement
            ResultSet resultset = st.executeQuery(strSelect);

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
            System.out.println("failed to get largest to smallest populated cities");
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
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
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
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
}