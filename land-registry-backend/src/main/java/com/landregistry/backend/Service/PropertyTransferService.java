package com.landregistry.backend.Service;

import com.landregistry.backend.dto.PropertyTransferDTO;
import com.landregistry.backend.exception.ResourceNotFoundException;
import com.landregistry.backend.mapper.PropertyTransferMapper;
import com.landregistry.backend.Model.PropertyTransfer;
import com.landregistry.backend.Repository.PropertyTransferRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyTransferService {

    private final PropertyTransferRepository transferRepository;

    public PropertyTransferService(PropertyTransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public PropertyTransferDTO createTransfer(PropertyTransferDTO transferDTO) {

        PropertyTransfer transfer = PropertyTransferMapper.toEntity(transferDTO);

        PropertyTransfer savedTransfer = transferRepository.save(transfer);

        return PropertyTransferMapper.toDTO(savedTransfer);
    }

    public List<PropertyTransferDTO> getAllTransfers() {

        return transferRepository.findAll()
                .stream()
                .map(PropertyTransferMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PropertyTransferDTO getTransferById(Long id) {

        PropertyTransfer transfer = transferRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transfer not found"));

        return PropertyTransferMapper.toDTO(transfer);
    }
}