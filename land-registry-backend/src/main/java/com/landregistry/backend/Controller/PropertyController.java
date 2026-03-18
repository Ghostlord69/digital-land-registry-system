package com.landregistry.backend.Controller;

import com.landregistry.backend.dto.PropertyDTO;
import com.landregistry.backend.response.ApiResponse;
import com.landregistry.backend.Service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public ApiResponse<PropertyDTO> addProperty(@Valid @RequestBody PropertyDTO propertyDTO) {

        PropertyDTO property = propertyService.addProperty(propertyDTO);

        return new ApiResponse<>(
                true,
                "Property created successfully",
                property
        );
    }

    @GetMapping
    public ApiResponse<List<PropertyDTO>> getAllProperties() {

        List<PropertyDTO> properties = propertyService.getAllProperties();

        return new ApiResponse<>(
                true,
                "Properties fetched successfully",
                properties
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<PropertyDTO> getPropertyById(@PathVariable Long id) {

        PropertyDTO property = propertyService.getPropertyById(id);

        return new ApiResponse<>(
                true,
                "Property fetched successfully",
                property
        );
    }
}