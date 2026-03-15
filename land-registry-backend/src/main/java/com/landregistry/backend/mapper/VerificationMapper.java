package com.landregistry.backend.mapper;

import com.landregistry.backend.dto.VerificationDTO;
import com.landregistry.backend.Model.Verification;
import com.landregistry.backend.Model.PropertyTransfer;
import com.landregistry.backend.Model.User;

public class VerificationMapper {

    public static VerificationDTO toDTO(Verification verification) {

        if (verification == null) {
            return null;
        }

        VerificationDTO dto = new VerificationDTO();

        dto.setId(verification.getId());
        dto.setStatus(verification.getStatus());
        dto.setRemarks(verification.getRemarks());
        dto.setVerifiedAt(verification.getVerifiedAt());

        if (verification.getTransfer() != null) {
            dto.setTransferId(verification.getTransfer().getId());
        }

        if (verification.getOfficer() != null) {
            dto.setOfficerId(verification.getOfficer().getId());
        }

        return dto;
    }

    public static Verification toEntity(VerificationDTO dto) {

        if (dto == null) {
            return null;
        }

        Verification verification = new Verification();

        verification.setId(dto.getId());
        verification.setStatus(dto.getStatus());
        verification.setRemarks(dto.getRemarks());
        verification.setVerifiedAt(dto.getVerifiedAt());

        if (dto.getTransferId() != null) {
            PropertyTransfer transfer = new PropertyTransfer();
            transfer.setId(dto.getTransferId());
            verification.setTransfer(transfer);
        }

        if (dto.getOfficerId() != null) {
            User officer = new User();
            officer.setId(dto.getOfficerId());
            verification.setOfficer(officer);
        }

        return verification;
    }
}