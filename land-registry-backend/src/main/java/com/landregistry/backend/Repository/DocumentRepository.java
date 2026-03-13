package com.landregistry.backend.Repository;

import com.landregistry.backend.Model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
