package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.DTO.JobRequest;
import com.zidio.zidioconnect.entity.JobListing;
import com.zidio.zidioconnect.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService{

    @Autowired
    private JobRepository jobRepository;

    public String jobPost(JobRequest request){
        JobListing jobListing = new JobListing();
        jobListing.setTitle(request.title);
        jobListing.setDescription(request.description);
        jobListing.setCompanyName(request.companyName);
        jobListing.setLocation(request.location);
        jobListing.setType(request.type);

        jobRepository.save(jobListing);

        return "Job post got saved";
    }

    public List<JobListing> getAllJobs(){
        return jobRepository.findAllJobs();
    }
    public List<JobListing>searchByTitle(String title){
        return jobRepository.findByTitle(title);
    }
    public List<JobListing>searchByCompanyName(String companyName){
        return jobRepository.findByCompanyName(companyName);
    }
}
