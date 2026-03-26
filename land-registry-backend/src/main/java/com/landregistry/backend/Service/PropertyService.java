package com.landregistry.backend.Service;

import com.landregistry.backend.dto.PaginationResponse;
import com.landregistry.backend.dto.PropertyDTO;
import com.landregistry.backend.exception.ResourceNotFoundException;
import com.landregistry.backend.mapper.PropertyMapper;
import com.landregistry.backend.Model.Property;
import com.landregistry.backend.Repository.PropertyRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
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

    public PaginationResponse<PropertyDTO> getAllProperties(int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());

        Page<Property> propertyPage = propertyRepository.findAll(pageable);

        PaginationResponse<PropertyDTO> response = new PaginationResponse<>();

        response.setContent(
                propertyPage.getContent()
                        .stream()
                        .map(PropertyMapper::toDTO)
                        .toList()
        );

        response.setPage(propertyPage.getNumber());
        response.setSize(propertyPage.getSize());
        response.setTotalElements(propertyPage.getTotalElements());
        response.setTotalPages(propertyPage.getTotalPages());

        return response;
    }

    public PropertyDTO getPropertyById(Long id) {

        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        return PropertyMapper.toDTO(property);
    }

    public List<PropertyDTO> searchProperties(String city,
                                              Double minPrice,
                                              Double maxPrice,
                                              Double minArea,
                                              Double maxArea) {

        return propertyRepository.searchProperties(city, minPrice, maxPrice, minArea, maxArea)
                .stream()
                .map(PropertyMapper::toDTO)
                .toList();
    }
}