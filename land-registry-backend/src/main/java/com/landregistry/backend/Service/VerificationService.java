package com.landregistry.backend.Service;

import com.landregistry.backend.dto.VerificationDTO;
import com.landregistry.backend.exception.ResourceNotFoundException;
import com.landregistry.backend.mapper.VerificationMapper;
import com.landregistry.backend.Model.Verification;
import com.landregistry.backend.Repository.VerificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VerificationService {

    private final VerificationRepository verificationRepository;

    public VerificationService(VerificationRepository verificationRepository) {
        this.verificationRepository = verificationRepository;
    }

    public VerificationDTO verifyTransfer(VerificationDTO verificationDTO) {

        Verification verification = VerificationMapper.toEntity(verificationDTO);

        Verification savedVerification = verificationRepository.save(verification);

        return VerificationMapper.toDTO(savedVerification);
    }

    public List<VerificationDTO> getAllVerifications() {

        return verificationRepository.findAll()
                .stream()
                .map(VerificationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public VerificationDTO getVerificationById(Long id) {

        Verification verification = verificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Verification not found"));

        return VerificationMapper.toDTO(verification);
    }
}