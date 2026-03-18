package com.landregistry.backend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class VerificationDTO {

    private Long id;

    @NotNull(message = "Transfer ID is required")
    private Long transferId;

    @NotNull(message = "Officer ID is required")
    private Long officerId;

    @NotBlank(message = "Status is required")
    private String status;

    private String remarks;

    private LocalDateTime verifiedAt;
}