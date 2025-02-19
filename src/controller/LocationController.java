package controller;

import model.City;
import model.Country;
import model.Department;

import java.util.ArrayList;
import java.util.List;

public class LocationController {
    private List<Country> countries;
    private List<Department> departments;
    private List<City> cities;

    public LocationController() {
        countries = new ArrayList<>();
        departments = new ArrayList<>();
        cities = new ArrayList<>();


        countries.add(new Country(01, "Colombia"));


        departments.add(new Department(01001, "Boyaca", 01));
        departments.add(new Department(01002, "Cundinamarca", 01));
        departments.add(new Department(01003, "Valle del Cauca", 01));

        cities.add(new City(01001001, "Sogamoso", 01001));
        cities.add(new City(01001002, "Duitama", 01001));

        cities.add(new City(01002001, "Bogotá", 01002));
        cities.add(new City(01002002, "Zipaquirá", 01002));

        cities.add(new City(01003001, "Cali", 01003));
        cities.add(new City(01003002, "Palmira", 01003));

        countries.add(new Country(02,"Chile"));

        departments.add(new Department(02001, "Santiago", 02));
        departments.add(new Department(02002, "Puente Alto", 02));
        departments.add(new Department(02003, "Biobío", 02));

        cities.add(new City(02001001, "Santiago", 02001));    
        cities.add(new City(02001002, "Puente Alto", 02001));

        cities.add(new City(02002001, "Valparaíso", 02002));
        cities.add(new City(02002002, "Viña del Mar", 02002));

        cities.add(new City(02003001, "Concepción", 02003));
        cities.add(new City(02003002, "Talcahuano", 02003));

    }

    public List<Country> getCountries() {
        return countries;
    }

    public List<Department> getDepartmentsByCountries(int countryId){
        List<Department> filteredDepartments = new ArrayList<>();
        for (Department department : departments){
           if(department.getCountryId()==countryId){
               filteredDepartments.add(department);
           }
        }
        return filteredDepartments;
    }

    public List<City> getCitiesByDepartments(int departmentId){
        List<City> filteredCities = new ArrayList<>();
        for (City city : cities){
            if(city.getDepartmentId() == departmentId){
                filteredCities.add(city);
            }
        }
        return filteredCities;
    }
}
