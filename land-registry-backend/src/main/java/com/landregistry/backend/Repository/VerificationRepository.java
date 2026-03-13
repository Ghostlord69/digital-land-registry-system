package com.landregistry.backend.Repository;

import com.landregistry.backend.Model.Verification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationRepository extends JpaRepository<Verification, Long> {

}
