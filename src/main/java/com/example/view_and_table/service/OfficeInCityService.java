package com.example.view_and_table.service;

import com.example.view_and_table.data.mysql.OfficeRepository;
import com.example.view_and_table.data.postgre.CityRepository;
import com.example.view_and_table.data.postgre.OfficeInCityRepository;
import com.example.view_and_table.model.mysql.Office;
import com.example.view_and_table.model.postgre.City;
import com.example.view_and_table.model.postgre.OfficeInCity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OfficeInCityService {
    private final CityRepository cityRepository;
    private final OfficeRepository officeRepository;
    private final OfficeInCityRepository officeInCityRepository;

    public OfficeInCityService(CityRepository cityRepository, OfficeRepository officeRepository, OfficeInCityRepository officeInCityRepository) {
        this.cityRepository = cityRepository;
        this.officeRepository = officeRepository;
        this.officeInCityRepository = officeInCityRepository;
    }


    @Transactional
    public List<OfficeInCity> rewriteOfficeInCity(Long cityId) {
        Optional<City> maybeCity = cityRepository.findById(cityId);
        if (!maybeCity.isPresent()) { // isNull() method was introduced in Java 11
            log.warn("City not found by id="+cityId);
            return Collections.emptyList();
        }
        City city = maybeCity.get();
        List<Office> offices = officeRepository.findByCity(city.getName());

        // удалять и вставлять значит потерять данные, но для прототипа пойдет.
        // К тому же в БД проще проверять, что данные обновились
        officeInCityRepository.deleteAllByCityId(cityId);
        List<OfficeInCity> result = offices.stream().map(office -> new OfficeInCity(null, city, office.getName()))
                .collect(Collectors.toList());
        officeInCityRepository.saveAll(result);

        return result;
    }
}
