package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.DTO.RecruiterRequest;
import com.zidio.zidioconnect.entity.RecruiterProfile;
import com.zidio.zidioconnect.entity.Users;
import com.zidio.zidioconnect.repository.RecruiterRepository;
import com.zidio.zidioconnect.repository.UsersRepository;
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

    @Autowired
    private UsersRepository usersRepository;


    public RecruiterRequest saveRecruiter(RecruiterRequest request) {
        Users fullUser = usersRepository.findById(request.userId.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        RecruiterProfile recruiter = new RecruiterProfile();
        recruiter.setUserId(fullUser); // set full user entity
        recruiter.setRecruiterName(request.recruiterName);
        recruiter.setCompanyName(request.companyName);
        recruiter.setRecruiterEmail(request.recruiterEmail);
        recruiter.setDesignation(request.designation);

        RecruiterProfile saved = recruiterRepository.save(recruiter);

        RecruiterRequest response = new RecruiterRequest();
        response.userId = saved.getUserId(); // now this includes full fields
        response.recruiterName = saved.getRecruiterName();
        response.recruiterEmail = saved.getRecruiterEmail();
        response.companyName = saved.getCompanyName();
        response.designation = saved.getDesignation();

        return response;
    }

    public List<RecruiterRequest> getAllRecruiters(){
        return recruiterRepository.findAll().stream().map(r ->{
            RecruiterRequest dto = new RecruiterRequest();
            dto.userId = r.getUserId(); // manual mapping
            dto.recruiterName = r.getRecruiterName();
            dto.recruiterEmail = r.getRecruiterEmail();
            dto.companyName = r.getCompanyName();
            dto.designation = r.getDesignation();
            return dto;
        }).collect(Collectors.toList());
    }

    public RecruiterRequest getByRecruiterEmail(String recruiterEmail) {
        RecruiterProfile recruiter = recruiterRepository.findByRecruiterEmail(recruiterEmail)
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));

        RecruiterRequest dto = new RecruiterRequest();
        dto.userId = recruiter.getUserId();
        dto.recruiterName = recruiter.getRecruiterName();
        dto.recruiterEmail = recruiter.getRecruiterEmail();
        dto.companyName = recruiter.getCompanyName();
        dto.designation = recruiter.getDesignation();
        return dto;
    }
    }