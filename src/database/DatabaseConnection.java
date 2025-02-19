package database;

import model.City;
import model.Country;
import model.Department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private static final String URL = "jdbc:ucanaccess://resources/DataBase.accdb";
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        String query = "SELECT id, CountryName FROM Country";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("CountryName");
                countries.add(new Country(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public static List<Department> getDepartments(int countryId) {
        List<Department> departments = new ArrayList<>();
        String query = "SELECT id, DepartmentName FROM Department WHERE CountryID = " + countryId;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("DepartmentName");
                departments.add(new Department(id, name, countryId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    public static List<City> getCities(int departmentId) {
        List<City> cities = new ArrayList<>();
        String query = "SELECT id, CityName FROM City WHERE DepartmentID = " + departmentId;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("CityName");
                cities.add(new City(id, name, departmentId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }
}
