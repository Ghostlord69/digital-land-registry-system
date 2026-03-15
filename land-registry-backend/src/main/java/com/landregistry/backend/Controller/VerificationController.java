package com.landregistry.backend.Controller;

import com.landregistry.backend.dto.VerificationDTO;
import com.landregistry.backend.Service.VerificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/verifications")
public class VerificationController {

    private final VerificationService verificationService;

    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping
    public VerificationDTO verifyTransfer(@RequestBody VerificationDTO verificationDTO) {
        return verificationService.verifyTransfer(verificationDTO);
    }

    @GetMapping
    public List<VerificationDTO> getAllVerifications() {
        return verificationService.getAllVerifications();
    }

    @GetMapping("/{id}")
    public VerificationDTO getVerificationById(@PathVariable Long id) {
        return verificationService.getVerificationById(id);
    }
}