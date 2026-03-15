package com.landregistry.backend.mapper;

import com.landregistry.backend.dto.PropertyTransferDTO;
import com.landregistry.backend.Model.PropertyTransfer;
import com.landregistry.backend.Model.Property;
import com.landregistry.backend.Model.User;

public class PropertyTransferMapper {

    public static PropertyTransferDTO toDTO(PropertyTransfer transfer) {

        if (transfer == null) {
            return null;
        }

        PropertyTransferDTO dto = new PropertyTransferDTO();

        dto.setId(transfer.getId());
        dto.setPrice(transfer.getPrice());
        dto.setStatus(transfer.getStatus());
        dto.setRequestDate(transfer.getRequestDate());

        if (transfer.getProperty() != null) {
            dto.setPropertyId(transfer.getProperty().getId());
        }

        if (transfer.getSeller() != null) {
            dto.setSellerId(transfer.getSeller().getId());
        }

        if (transfer.getBuyer() != null) {
            dto.setBuyerId(transfer.getBuyer().getId());
        }

        return dto;
    }

    public static PropertyTransfer toEntity(PropertyTransferDTO dto) {

        if (dto == null) {
            return null;
        }

        PropertyTransfer transfer = new PropertyTransfer();

        transfer.setId(dto.getId());
        transfer.setPrice(dto.getPrice());
        transfer.setStatus(dto.getStatus());
        transfer.setRequestDate(dto.getRequestDate());

        if (dto.getPropertyId() != null) {
            Property property = new Property();
            property.setId(dto.getPropertyId());
            transfer.setProperty(property);
        }

        if (dto.getSellerId() != null) {
            User seller = new User();
            seller.setId(dto.getSellerId());
            transfer.setSeller(seller);
        }

        if (dto.getBuyerId() != null) {
            User buyer = new User();
            buyer.setId(dto.getBuyerId());
            transfer.setBuyer(buyer);
        }

        return transfer;
    }
}