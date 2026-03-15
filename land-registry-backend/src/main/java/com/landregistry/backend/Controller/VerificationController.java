package com.landregistry.backend.Controller;

import com.landregistry.backend.dto.VerificationDTO;
import com.landregistry.backend.response.ApiResponse;
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
    public ApiResponse<VerificationDTO> verifyTransfer(@RequestBody VerificationDTO verificationDTO) {

        VerificationDTO verification = verificationService.verifyTransfer(verificationDTO);

        return new ApiResponse<>(
                true,
                "Verification completed successfully",
                verification
        );
    }

    @GetMapping
    public ApiResponse<List<VerificationDTO>> getAllVerifications() {

        List<VerificationDTO> verifications = verificationService.getAllVerifications();

        return new ApiResponse<>(
                true,
                "Verifications fetched successfully",
                verifications
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<VerificationDTO> getVerificationById(@PathVariable Long id) {

        VerificationDTO verification = verificationService.getVerificationById(id);

        return new ApiResponse<>(
                true,
                "Verification fetched successfully",
                verification
        );
    }
}