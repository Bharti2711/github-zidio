package com.zidio.zidioconnect.Controller;


import com.zidio.zidioconnect.DTO.ApplicationRequest;
import com.zidio.zidioconnect.DTO.ApplicationResponse;
import com.zidio.zidioconnect.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")

public class ApplicationController{



    @Autowired


    private ApplicationService applicationService;



    @PostMapping("/apply")
    public ApplicationResponse apply(@RequestBody ApplicationRequest request){

        return applicationService.apply(request);
    }

    @GetMapping("/student/{studentEmail}")

    public List<ApplicationResponse> getByStudentEmail(@PathVariable String studentEmail){

        return applicationService.getApplicationsByStudent(studentEmail);
    }


    @GetMapping("/job/{jobId}")

    public List<ApplicationResponse>getByJobId(@PathVariable Long jobId){

        return applicationService.getApplicationByJob(jobId);

    }
}
