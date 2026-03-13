package com.landregistry.backend.Service;

import com.landregistry.backend.Model.PropertyTransfer;
import com.landregistry.backend.Repository.PropertyTransferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyTransferService {

    private final PropertyTransferRepository transferRepository;

    public PropertyTransferService(PropertyTransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public PropertyTransfer createTransfer(PropertyTransfer transfer) {
        return transferRepository.save(transfer);
    }

    public List<PropertyTransfer> getAllTransfers() {
        return transferRepository.findAll();
    }
}
