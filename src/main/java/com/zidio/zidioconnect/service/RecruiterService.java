package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.DTO.RecruiterRequest;
import com.zidio.zidioconnect.entity.RecruiterProfile;
import com.zidio.zidioconnect.repository.RecruiterRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service


public class RecruiterService {
    @Autowired
    private RecruiterRepository recruiterRepository;

    public RecruiterRequest saveRecruiter(RecruiterRequest request) {
        RecruiterProfile recruiter = new RecruiterProfile();
        recruiter.setUserId(request.userId);
        recruiter.setRecruiterName(request.recruiterName);
        recruiter.setCompanyName(request.companyName);
        recruiter.setRecruiterEmail(request.recruiterEmail);
        recruiter.setDesignation(request.designation);

        RecruiterProfile saved = recruiterRepository.save(recruiter);

        RecruiterRequest response = new RecruiterRequest();
        BeanUtils.copyProperties(saved, response);
        return response;
    }
    public List<RecruiterRequest> getAllRecruiters(){
        return recruiterRepository.findAll().stream().map(r ->{
            RecruiterRequest dto = new RecruiterRequest();
            BeanUtils.copyProperties(r, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    public RecruiterRequest getByRecruiterEmail(String recruiterEmail) {
        RecruiterProfile recruiter = recruiterRepository.findByRecruiterEmail(recruiterEmail)
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));

        RecruiterRequest dto = new RecruiterRequest();
        BeanUtils.copyProperties(recruiter, dto);
        return dto;
    }

    }