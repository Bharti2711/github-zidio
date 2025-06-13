package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.entity.JobListing;
import com.zidio.zidioconnect.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<JobListing> searchByCompanyName(String companyName) {
        return jobRepository.findByCompanyName(companyName);
    }
    public List<JobListing> getJobsByTitle(String title) {
        return jobRepository.findByTitle(title);
    }
    public JobListing postJob(JobListing job) {
        return jobRepository.save(job);
    }
}