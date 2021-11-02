package com.example.view_and_table.service;

import com.example.view_and_table.data.postgre.CityRepository;
import com.example.view_and_table.model.mysql.Office;
import com.example.view_and_table.model.postgre.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CityService {

    @Autowired
    private CityRepository repo;
    @Autowired
    private OfficeService officeService;


    public List<City> findCitiesByCountryId(Long countryId) {
        return repo.findAllByCountryId(countryId);
    }

    public List<City> allCities() {
        List<City> result = new ArrayList<>();
        repo.findAll().forEach(result::add);
        return result;
    }

    @Transactional
    public List<City> updateActivity() {
        Set<String> cityList = officeService.cityNamesWithOffices();
        List<City> result = new ArrayList<>(cityList.size());
        cityList.forEach(it->{
            City city = repo.findFirstByName(it);
            city.setLastActive(LocalDateTime.now());
        });
        return result;
    }
}
