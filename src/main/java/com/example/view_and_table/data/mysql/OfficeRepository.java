package com.example.view_and_table.data.mysql;

import com.example.view_and_table.model.mysql.Office;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfficeRepository extends CrudRepository<Office, Long> {
    List<Office> findByCity(String name);
}
