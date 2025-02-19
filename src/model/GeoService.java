package model;

import controller.LocationController;

import javax.swing.*;
import java.util.List;

public class GeoService {
    private LocationController controller;

    public GeoService() {
        this.controller = new LocationController();
    }

    public void loadCountries(JComboBox<Country> countryBox) {
        countryBox.removeAllItems();
        countryBox.addItem(new Country(0, "Seleccionar"));

        List<Country> countries = controller.getCountries();
        for (Country country : countries) {
            countryBox.addItem(country);
        }
    }

    public void loadDepartments(JComboBox<Department> departmentBox, JComboBox<City> cityBox, Country selectedCountry) {
        departmentBox.removeAllItems();
        departmentBox.addItem(new Department(0, "Seleccionar", 0));
        cityBox.removeAllItems();

        if (selectedCountry != null && selectedCountry.getId() != 0) {
            List<Department> departments = controller.getDepartmentsByCountries(selectedCountry.getId());
            for (Department department : departments) {
                departmentBox.addItem(department);
            }
        }
    }

    public void loadCities(JComboBox<City> cityBox, Department selectedDepartment) {
        cityBox.removeAllItems();
        cityBox.addItem(new City(0, "Seleccionar", 0));

        if (selectedDepartment != null && selectedDepartment.getId() != 0) {
            List<City> cities = controller.getCitiesByDepartments(selectedDepartment.getId());
            for (City city : cities) {
                cityBox.addItem(city);
            }
        }
    }
}
