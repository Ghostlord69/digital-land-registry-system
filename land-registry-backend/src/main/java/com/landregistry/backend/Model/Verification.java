package com.landregistry.backend.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Verification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "transfer_id")
    private PropertyTransfer transfer;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    private User officer;

    private String status;

    private String remarks;

    private LocalDateTime verifiedAt;
}