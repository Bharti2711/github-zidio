package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.entity.RecruiterProfile;
import com.zidio.zidioconnect.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service


public class RecruiterService {
    @Autowired
    private RecruiterRepository recruiterRepository;
    public Optional<RecruiterProfile> getByCompanyName(String name) {
        return recruiterRepository.findByCompanyName(name);
    }
    public RecruiterProfile saveRecruiter(RecruiterProfile recruiterProfile) {
        return recruiterRepository.save(recruiterProfile);
    }
}