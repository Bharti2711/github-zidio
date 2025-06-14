package com.zidio.zidioconnect.repository;


import com.zidio.zidioconnect.entity.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobRepository extends JpaRepository<JobListing, Long> {
    List<JobListing> findByCompanyName(String companyName);
    List<JobListing> findByTitle(String title);

    List<JobListing> findAll();
}