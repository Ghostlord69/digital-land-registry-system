package com.landregistry.backend.Repository;

import com.landregistry.backend.Model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findByCity(String city);

}
