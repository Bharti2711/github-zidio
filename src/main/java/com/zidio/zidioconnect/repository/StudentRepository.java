package com.zidio.zidioconnect.repository;

import com.zidio.zidioconnect.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentProfile, Long> {
    Optional<StudentProfile> findByEmail(String email);
}