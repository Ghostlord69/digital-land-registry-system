package com.landregistry.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DocumentDTO {

    private Long id;
    private String documentType;
    private String filePath;
    private Long propertyId;
    private Long uploadedBy;
    private LocalDateTime uploadedAt;

}