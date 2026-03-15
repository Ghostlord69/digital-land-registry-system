package com.landregistry.backend.Controller;

import com.landregistry.backend.dto.PropertyTransferDTO;
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
    public PropertyTransferDTO createTransfer(@RequestBody PropertyTransferDTO transferDTO) {
        return transferService.createTransfer(transferDTO);
    }

    @GetMapping
    public List<PropertyTransferDTO> getAllTransfers() {
        return transferService.getAllTransfers();
    }

    @GetMapping("/{id}")
    public PropertyTransferDTO getTransferById(@PathVariable Long id) {
        return transferService.getTransferById(id);
    }
}