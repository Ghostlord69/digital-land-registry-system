package com.landregistry.backend.Service;

import com.landregistry.backend.dto.PropertyDTO;
import com.landregistry.backend.mapper.PropertyMapper;
import com.landregistry.backend.Model.Property;
import com.landregistry.backend.Repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public PropertyDTO addProperty(PropertyDTO propertyDTO) {

        Property property = PropertyMapper.toEntity(propertyDTO);

        Property savedProperty = propertyRepository.save(property);

        return PropertyMapper.toDTO(savedProperty);
    }

    public List<PropertyDTO> getAllProperties() {

        return propertyRepository.findAll()
                .stream()
                .map(PropertyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PropertyDTO getPropertyById(Long id) {

        Property property = propertyRepository.findById(id).orElse(null);

        return PropertyMapper.toDTO(property);
    }
}