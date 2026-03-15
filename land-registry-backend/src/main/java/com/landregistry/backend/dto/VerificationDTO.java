package com.landregistry.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class VerificationDTO {

    private Long id;
    private Long transferId;
    private Long officerId;
    private String status;
    private String remarks;
    private LocalDateTime verifiedAt;

}