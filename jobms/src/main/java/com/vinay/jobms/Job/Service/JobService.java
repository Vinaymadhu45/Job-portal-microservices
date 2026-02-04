package com.vinay.jobms.Job.Service;
import com.vinay.jobms.Job.JobDTO;
import com.vinay.jobms.Job.Model.Job;

import java.util.List;


public interface JobService {

List<JobDTO> findAll();
void createJob(Job job);

    JobDTO findById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
