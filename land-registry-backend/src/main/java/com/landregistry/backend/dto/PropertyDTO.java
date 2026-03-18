package com.landregistry.backend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PropertyDTO {

    private Long id;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "City is required")
    private String city;

    @NotNull(message = "Area is required")
    private Double areaSqft;

    @NotNull(message = "Price is required")
    private Double price;

    @NotBlank(message = "Status is required")
    private String status;

    @NotNull(message = "Owner ID is required")
    private Long ownerId;
}