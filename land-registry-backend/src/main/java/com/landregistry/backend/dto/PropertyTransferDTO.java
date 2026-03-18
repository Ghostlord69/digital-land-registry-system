package com.landregistry.backend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PropertyTransferDTO {

    private Long id;

    @NotNull(message = "Property ID is required")
    private Long propertyId;

    @NotNull(message = "Seller ID is required")
    private Long sellerId;

    @NotNull(message = "Buyer ID is required")
    private Long buyerId;

    @NotNull(message = "Price is required")
    private Double price;

    @NotBlank(message = "Status is required")
    private String status;

    private LocalDateTime requestDate;
}