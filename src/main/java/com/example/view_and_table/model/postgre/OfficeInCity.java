package com.example.view_and_table.model.postgre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="city_office")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeInCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private City city;

    @Column
    private String name;
}
