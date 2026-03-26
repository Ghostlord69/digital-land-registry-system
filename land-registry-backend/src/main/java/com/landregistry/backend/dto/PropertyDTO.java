package com.landregistry.backend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class PropertyDTO {

    private Long id;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Pincode is required")
    private String pincode;

    @NotNull(message = "Area is required")
    private Double areaSqft;

    @NotNull(message = "Price is required")
    private Double price;

    @NotBlank(message = "Status is required")
    private String status;

    @NotNull(message = "Owner ID is required")
    private Long ownerId;

    private List<String> images;
}