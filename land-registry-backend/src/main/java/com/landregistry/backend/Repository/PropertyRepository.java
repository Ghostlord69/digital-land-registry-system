package com.landregistry.backend.Repository;

import com.landregistry.backend.Model.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Query("""
    SELECT p FROM Property p
    WHERE (:city IS NULL OR p.city = :city)
    AND (:minPrice IS NULL OR p.price >= :minPrice)
    AND (:maxPrice IS NULL OR p.price <= :maxPrice)
    AND (:minArea IS NULL OR p.areaSqft >= :minArea)
    AND (:maxArea IS NULL OR p.areaSqft <= :maxArea)
""")
    List<Property> searchProperties(
            @Param("city") String city,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            @Param("minArea") Double minArea,
            @Param("maxArea") Double maxArea
    );

}
