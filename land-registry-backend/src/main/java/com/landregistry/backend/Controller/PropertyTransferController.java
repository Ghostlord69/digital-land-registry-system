package com.landregistry.backend.Controller;

import com.landregistry.backend.Model.PropertyTransfer;
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
    public PropertyTransfer createTransfer(@RequestBody PropertyTransfer transfer) {
        return transferService.createTransfer(transfer);
    }

    @GetMapping
    public List<PropertyTransfer> getAllTransfers() {
        return transferService.getAllTransfers();
    }
}