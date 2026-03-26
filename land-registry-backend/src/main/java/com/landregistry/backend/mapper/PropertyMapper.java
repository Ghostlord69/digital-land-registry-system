package com.landregistry.backend.mapper;

import com.landregistry.backend.dto.PropertyDTO;
import com.landregistry.backend.Model.Property;
import com.landregistry.backend.Model.User;

import java.util.List;

public class PropertyMapper {

    private PropertyMapper(){}
    public static PropertyDTO toDTO(Property property) {

        if (property == null) {
            return null;
        }

        PropertyDTO dto = new PropertyDTO();

        dto.setId(property.getId());
        dto.setAddress(property.getAddress());
        dto.setCity(property.getCity());
        dto.setState(property.getState());
        dto.setCountry(property.getCountry());
        dto.setPincode(property.getPincode());
        dto.setAreaSqft(property.getAreaSqft());
        dto.setPrice(property.getPrice());
        dto.setStatus(property.getStatus());

        if (property.getOwner() != null) {
            dto.setOwnerId(property.getOwner().getId());
        }
        if (property.getDocuments() != null) {
            List<String> imageUrls = property.getDocuments()
                    .stream()
                    .map(doc -> "http://localhost:8080/" + doc.getFilePath())
                    .toList();

            dto.setImages(imageUrls);
        }
        return dto;
    }

    public static Property toEntity(PropertyDTO dto) {

        if (dto == null) {
            return null;
        }

        Property property = new Property();

        property.setId(dto.getId());
        property.setAddress(dto.getAddress());
        property.setCity(dto.getCity());
        property.setState(dto.getState());
        property.setCountry(dto.getCountry());
        property.setPincode(dto.getPincode());
        property.setAreaSqft(dto.getAreaSqft());
        property.setPrice(dto.getPrice());
        property.setStatus(dto.getStatus());

        if (dto.getOwnerId() != null) {
            User owner = new User();
            owner.setId(dto.getOwnerId());
            property.setOwner(owner);
        }

        return property;
    }
}