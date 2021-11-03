package com.example.view_and_table.controller;

import com.example.view_and_table.model.mysql.Office;
import com.example.view_and_table.model.postgre.City;
import com.example.view_and_table.model.postgre.OfficeInCity;
import com.example.view_and_table.service.CityService;
import com.example.view_and_table.service.OfficeInCityService;
import com.example.view_and_table.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SilverBulletRestController {

    @Autowired
    private CityService cityService;
    @Autowired
    private OfficeService officeService;
    @Autowired
    private OfficeInCityService officeInCityService;

    @GetMapping("/all_cities")
    public List<City> allCities() {
        return cityService.allCities();
    }
    @GetMapping("/by_country")
    public List<City> findCitiesByCountry(@Param("countryId") Long countryId) {
        return cityService.findCitiesByCountryId(countryId);
    }

    @GetMapping("/all_offices")
    public List<Office> allOfficies() {
        return officeService.allOffices();
    }

    @RequestMapping("/update_activity") // принимает GET и POST, т.к. тестить проще GET
    public List<City> updateCitiesWithOffice() {
        return cityService.updateActivity();
    }

    @RequestMapping("/count_office") // принимает GET и POST, т.к. тестить проще GET
    public List<OfficeInCity> countOfficesInCity(@Param("cityId") Long cityId) {
        return officeInCityService.rewriteOfficeInCity(cityId);
    }

}
