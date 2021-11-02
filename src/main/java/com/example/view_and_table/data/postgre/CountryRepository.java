package com.example.view_and_table.data.postgre;

import com.example.view_and_table.model.postgre.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {

}
