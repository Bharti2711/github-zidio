package com.zidio.zidioconnect.service;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.zidio.zidioconnect.DTO.ApplicationRequest;
import com.zidio.zidioconnect.DTO.ApplicationResponse;
import com.zidio.zidioconnect.entity.Application;
import com.zidio.zidioconnect.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service


public class ApplicationService{


    @Autowired
    private ApplicationRepository applicationRepository;


    public ApplicationResponse apply(ApplicationRequest request){
        applicationRepository.findByStudentEmailAndJobId(request.studentEmail,request.jobId).
                ifPresent(a->{throw new RuntimeException("Already applied");});


        Application app = Application.builder().studentEmail(request.studentEmail).jobId(request.jobId).status("applied").build();

        app = applicationRepository.save(app);
        return mapToResponse(app);

    }



    public List<ApplicationResponse> getApplicationsByStudent(String studentEmail){
        return applicationRepository.findByStudentEmail(studentEmail).stream().map(this::mapToResponse).collect(Collectors.toList());
    }


    public List<ApplicationResponse> getApplicationByJob(Long jobId){
        return applicationRepository.findByJobId(jobId).stream().map(this::mapToResponse).collect(Collectors.toList());
    }


    private ApplicationResponse mapToResponse(Application app) {
        return ApplicationResponse.builder().id(app.getId()).studentEmail(app.getStudentEmail())
                .jobId(app.getJobId()).status(app.getStatus()).build();
    }
}