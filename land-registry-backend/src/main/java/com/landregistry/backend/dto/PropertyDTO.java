package com.landregistry.backend.dto;

import lombok.Data;

@Data
public class PropertyDTO {

    private Long id;
    private String address;
    private String city;
    private Double areaSqft;
    private Double price;
    private String status;
    private Long ownerId;

}