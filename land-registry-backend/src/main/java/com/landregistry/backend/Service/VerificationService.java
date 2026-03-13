package com.landregistry.backend.Service;

import com.landregistry.backend.Model.Verification;
import com.landregistry.backend.Repository.VerificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationService {

    private final VerificationRepository verificationRepository;

    public VerificationService(VerificationRepository verificationRepository) {
        this.verificationRepository = verificationRepository;
    }

    public Verification verifyTransfer(Verification verification) {
        return verificationRepository.save(verification);
    }

    public List<Verification> getAllVerifications() {
        return verificationRepository.findAll();
    }
}
