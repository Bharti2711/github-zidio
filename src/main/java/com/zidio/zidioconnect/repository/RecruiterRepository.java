package com.zidio.zidioconnect.repository;

import com.zidio.zidioconnect.entity.RecruiterProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface RecruiterRepository extends JpaRepository<RecruiterProfile, Long> {
    Optional<RecruiterProfile> findByCompanyName(String CompanyName);
}
