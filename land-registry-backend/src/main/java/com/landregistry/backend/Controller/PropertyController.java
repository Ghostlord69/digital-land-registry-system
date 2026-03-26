package com.landregistry.backend.Controller;

import com.landregistry.backend.dto.PropertyDTO;
import com.landregistry.backend.response.ApiResponse;
import com.landregistry.backend.Service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ApiResponse<PropertyDTO> addProperty(@Valid @RequestBody PropertyDTO propertyDTO) {

        PropertyDTO property = propertyService.addProperty(propertyDTO);

        return new ApiResponse<>(
                true,
                "Property created successfully",
                property
        );
    }
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping
    public ApiResponse<Page<PropertyDTO>> getAllProperties(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {

        return new ApiResponse<>(
                true,
                "Properties fetched successfully",
                propertyService.getAllProperties(page, size, sortBy)
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
    @GetMapping("/search")
    public ApiResponse<List<PropertyDTO>> searchProperties(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Double minArea,
            @RequestParam(required = false) Double maxArea
    ) {

        return new ApiResponse<>(
                true,
                "Filtered properties fetched successfully",
                propertyService.searchProperties(city, minPrice, maxPrice, minArea, maxArea)
        );
    }
}