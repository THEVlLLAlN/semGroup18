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

        //city cityStr = a.getCity(cityName);
        int n = 0;

        ArrayList<city> Cities = a.getCities(n, where);

        for (city CityA : Cities){
            if (CityA == null)
                continue;
            String city_string = CityA.getName() + " " + CityA.getCountryCode();
            System.out.println(city_string);
        }

        //ArrayList<city> largestToSmallestCapital = a.getLargestToSmallestCapitalWorld();
        //ArrayList<country> largestToSmallestCountryWorld = a.getLargestToSmallestCountryWorld();

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
                c.setID(rset.getInt("ID"));
                c.setName(rset.getString("Name"));
                c.setDistrict(rset.getString("District"));
                c.setPopulation(rset.getInt("Population"));
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

    public ArrayList<city> getCities(int n, String where) {
        try {
            String select = "SELECT city.Name, country.Name, city.District, city.CountryCode, city.Population ";
            String from = "FROM city, country ";
            String orderBy = "ORDER BY city.Population DESC";

            /*
            int iterationCounter = 0;
            if (n == 0){
                n = 99999;
            }
            */

            // execute the sql statement
            ResultSet resultset = sql(select, from, where, orderBy);

            ArrayList<city> cities = new ArrayList<>();

            while (resultset.next())
            {
                city c = new city();
                c.setName(resultset.getString("city.Name"));
                c.setCountryCode(resultset.getString("city.CountryCode"));
                c.setDistrict(resultset.getString("city.District"));
                c.setPopulation(resultset.getInt("city.Population"));
                cities.add(c);
                //iterationCounter++;
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities");
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

    public ResultSet sql(String select, String table, String where, String order){
        try
        {
            Statement stmnt = con.createStatement();
            String strSelect = select + table + where + order;

            ResultSet results = stmnt.executeQuery(strSelect);

            return results;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Statement Creation Failed.");
            return null;
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