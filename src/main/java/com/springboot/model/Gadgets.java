package com.springboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Electronic_gadgets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Gadgets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String gadgetName;
    private  String gadgetType;
    private double cost;
    private String manufactureCompany;
    private LocalDate manufactureDate;


}
