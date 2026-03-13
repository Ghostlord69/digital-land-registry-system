package com.landregistry.backend.Controller;

import com.landregistry.backend.Model.Verification;
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
    public Verification verifyTransfer(@RequestBody Verification verification) {
        return verificationService.verifyTransfer(verification);
    }

    @GetMapping
    public List<Verification> getAllVerifications() {
        return verificationService.getAllVerifications();
    }
}
