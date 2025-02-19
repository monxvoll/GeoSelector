package controller;

import database.DatabaseConnection;
import model.City;
import model.Country;
import model.Department;

import java.util.List;

public class LocationController {

    public List<Country> getCountries() {
        return DatabaseConnection.getCountries();
    }

    public List<Department> getDepartmentsByCountries(int countryId) {
        return DatabaseConnection.getDepartments(countryId);
    }

    public List<City> getCitiesByDepartments(int departmentId) {
        return DatabaseConnection.getCities(departmentId);
    }
}
