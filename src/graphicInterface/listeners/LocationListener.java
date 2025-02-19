package graphicInterface.listeners;

import model.Country;
import model.Department;
import model.City;
import model.GeoService;


import javax.swing.*;
import java.awt.event.ActionListener;

public class LocationListener {
    private GeoService geoService;
    private JComboBox<Country > countryBox;
    private JComboBox<Department> departmentBox;
    private JComboBox<City> cityBox;

    public LocationListener(GeoService geoService, JComboBox<Country> countryBox,
                            JComboBox<Department> departmentBox, JComboBox<City> cityBox) {
        this.geoService = geoService;
        this.countryBox = countryBox;
        this.departmentBox = departmentBox;
        this.cityBox = cityBox;
    }

    public ActionListener getCountryBoxListener() {
        return e -> {
            Country selectedCountry = (Country) countryBox.getSelectedItem();

            for (ActionListener al : departmentBox.getActionListeners()) {
                departmentBox.removeActionListener(al);
            }

            geoService.loadDepartments(departmentBox, cityBox, selectedCountry);

            departmentBox.addActionListener(getDepartmentBoxListener());
        };
    }

    public ActionListener getDepartmentBoxListener() {
        return e -> {
            Department selectedDepartment = (Department) departmentBox.getSelectedItem();

            for (ActionListener al : cityBox.getActionListeners()) {
                cityBox.removeActionListener(al);
            }

            geoService.loadCities(cityBox, selectedDepartment);


        };
    }

}

