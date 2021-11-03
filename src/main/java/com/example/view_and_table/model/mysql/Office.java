package com.example.view_and_table.model.mysql;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "office_view")
@Data
@NoArgsConstructor
public class Office {
    @Id
    @Column
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String city;
}
