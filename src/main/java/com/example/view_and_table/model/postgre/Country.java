package com.example.view_and_table.model.postgre;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Country {
    @Id
    @Column
    @GeneratedValue
    private long id;

    @Column(name = "country_name")
    private String name;
}
