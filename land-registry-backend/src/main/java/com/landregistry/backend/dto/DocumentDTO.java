package com.landregistry.backend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DocumentDTO {

    private Long id;

    @NotBlank(message = "Document type is required")
    private String documentType;

    @NotBlank(message = "File path is required")
    private String filePath;

    @NotNull(message = "Property ID is required")
    private Long propertyId;

    @NotNull(message = "UploadedBy ID is required")
    private Long uploadedBy;

    private LocalDateTime uploadedAt;
}