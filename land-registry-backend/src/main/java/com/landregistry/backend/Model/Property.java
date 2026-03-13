package com.landregistry.backend.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String city;

    private Double areaSqft;

    private Double price;

    private String status;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}
