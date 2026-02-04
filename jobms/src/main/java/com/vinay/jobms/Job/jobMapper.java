package com.vinay.jobms.Job;

import com.vinay.jobms.External.Company;
import com.vinay.jobms.External.Review;
import com.vinay.jobms.Job.Model.Job;

import java.util.List;

//mapper maps job and company with jobwithcompanydto
public class jobMapper {
    public static JobDTO maptojobwithcompanydto(Job job, Company company, List<Review> reviews){
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setCompany(company);
        jobDTO.setReview(reviews);
        return jobDTO;
    }


}
