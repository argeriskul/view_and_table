package com.example.view_and_table.data.mysql;

import com.example.view_and_table.model.mysql.Office;
import org.springframework.data.repository.CrudRepository;

public interface OfficeRepository extends CrudRepository<Office, Long> {
}
