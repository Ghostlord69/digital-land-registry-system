package com.landregistry.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PropertyTransferDTO {

    private Long id;
    private Long propertyId;
    private Long sellerId;
    private Long buyerId;
    private Double price;
    private String status;
    private LocalDateTime requestDate;

}