package com.example.view_and_table.service;

import com.example.view_and_table.data.mysql.OfficeRepository;
import com.example.view_and_table.model.mysql.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OfficeService {

    @Autowired
    private OfficeRepository repository;

    public List<Office> allOffices() {
        List<Office> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    public Set<String> cityNamesWithOffices() {
        Iterable<Office> allOffices = repository.findAll();
        return StreamSupport.stream(allOffices.spliterator(), false)
                .map(Office::getCity)
                .collect(Collectors.toSet());
    }
}
