package com.example.demo.entity;


import javax.persistence.*;
import lombok.Data;


import java.time.LocalDate;

@Entity
@Data
@Table(name = "data")
public class GraphicDataEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    double temperature;

    LocalDate date;


}
