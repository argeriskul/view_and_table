package com.example.view_and_table.data.postgre;

import com.example.view_and_table.model.postgre.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Long> {

    List<City> findAllByCountryId(Long countryId);

    City findFirstByName(String name);
}
