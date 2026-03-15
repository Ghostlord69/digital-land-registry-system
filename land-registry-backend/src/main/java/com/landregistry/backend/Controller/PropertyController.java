package com.landregistry.backend.Controller;

import com.landregistry.backend.dto.PropertyDTO;
import com.landregistry.backend.Service.PropertyService;
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
    public PropertyDTO addProperty(@RequestBody PropertyDTO propertyDTO) {
        return propertyService.addProperty(propertyDTO);
    }

    @GetMapping
    public List<PropertyDTO> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/{id}")
    public PropertyDTO getPropertyById(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }
}