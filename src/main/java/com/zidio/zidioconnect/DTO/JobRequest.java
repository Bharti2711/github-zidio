package com.zidio.zidioconnect.DTO;

import com.zidio.zidioconnect.entity.JobListing;
import com.zidio.zidioconnect.entity.Users;

public class JobRequest {

    public Users recruiter;
    public String title;
    public String description;
    public String location;
    public JobListing.JobType type;
    public String companyName;
}
