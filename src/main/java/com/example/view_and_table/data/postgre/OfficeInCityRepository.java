package com.example.view_and_table.data.postgre;

import com.example.view_and_table.model.postgre.OfficeInCity;
import org.springframework.data.repository.CrudRepository;

public interface OfficeInCityRepository extends CrudRepository<OfficeInCity, Long> {
    void deleteAllByCityId(Long cityId);
}
