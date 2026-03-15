package com.landregistry.backend.Controller;

import com.landregistry.backend.dto.PropertyTransferDTO;
import com.landregistry.backend.response.ApiResponse;
import com.landregistry.backend.Service.PropertyTransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfers")
public class PropertyTransferController {

    private final PropertyTransferService transferService;

    public PropertyTransferController(PropertyTransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ApiResponse<PropertyTransferDTO> createTransfer(@RequestBody PropertyTransferDTO transferDTO) {

        PropertyTransferDTO transfer = transferService.createTransfer(transferDTO);

        return new ApiResponse<>(
                true,
                "Transfer created successfully",
                transfer
        );
    }

    @GetMapping
    public ApiResponse<List<PropertyTransferDTO>> getAllTransfers() {

        List<PropertyTransferDTO> transfers = transferService.getAllTransfers();

        return new ApiResponse<>(
                true,
                "Transfers fetched successfully",
                transfers
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<PropertyTransferDTO> getTransferById(@PathVariable Long id) {

        PropertyTransferDTO transfer = transferService.getTransferById(id);

        return new ApiResponse<>(
                true,
                "Transfer fetched successfully",
                transfer
        );
    }
}