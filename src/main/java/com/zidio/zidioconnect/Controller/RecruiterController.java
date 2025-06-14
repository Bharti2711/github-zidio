package com.zidio.zidioconnect.Controller;


import com.zidio.zidioconnect.DTO.RecruiterRequest;
import com.zidio.zidioconnect.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruiters")


public class RecruiterController{

    @Autowired
    private RecruiterService recruiterService;


    @PostMapping("/register")

    public ResponseEntity<RecruiterRequest> register (@RequestBody RecruiterRequest request){
        return ResponseEntity.ok(recruiterService.saveRecruiter(request));
    }


    @PostMapping ("/all")

    public ResponseEntity<List<RecruiterRequest>>getAll(){
        return ResponseEntity.ok(recruiterService.getAllRecruiters());
    }

    @GetMapping({"recruiterEmail"})
    public ResponseEntity<RecruiterRequest>getByRecruiterEmail(@PathVariable String recruiterEmail){
        return ResponseEntity.ok(recruiterService.getByRecruiterEmail(recruiterEmail));
    }
}
