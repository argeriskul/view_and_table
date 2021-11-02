package com.example.view_and_table.model.postgre;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class City {

    @Id
    @Column
    @GeneratedValue
    private long id;

    @Column
    @NonNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "country")
    private Country country;

    @Column(name = "active")
    private LocalDateTime lastActive;
}
