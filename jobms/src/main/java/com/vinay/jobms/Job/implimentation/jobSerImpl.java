package com.vinay.jobms.Job.implimentation;


import com.vinay.jobms.Clients.CompanyClient;
import com.vinay.jobms.Clients.ReviewClient;
import com.vinay.jobms.External.Company;
import com.vinay.jobms.External.Review;
import com.vinay.jobms.Job.JobDTO;
import com.vinay.jobms.Job.Model.Job;
import com.vinay.jobms.Job.Repository.JobRepository;
import com.vinay.jobms.Job.Service.JobService;
import com.vinay.jobms.Job.jobMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class jobSerImpl implements JobService {

    private final JobRepository jobRepository;
    @Autowired
    RestTemplate restTemplate;

   private CompanyClient companyClient;
   private ReviewClient reviewClient;

    public jobSerImpl(JobRepository jobRepository,CompanyClient companyClient,ReviewClient reviewClient) {
        this.jobRepository = jobRepository;
        this.companyClient=companyClient;
        this.reviewClient= reviewClient;
    }

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        List<JobDTO> jobDTOS = new ArrayList<>();



        return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private JobDTO convertToDto(Job job){
        Company company= companyClient.getCompany(job.getCompanyId());

       List<Review> reviews= reviewClient.getReviews(job.getCompanyId());
        JobDTO jobDTO = jobMapper.maptojobwithcompanydto(job,company,reviews);
//        jobDTO.setCompany(company);
        return jobDTO;
    }


    @Override
    @Transactional
    public void createJob(Job job) {
        // ensure this is an INSERT, not a merge/update of an existing id
        job.setId(null);
        jobRepository.save(job);
    }

    @Override
    @Transactional
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> optionalJob = jobRepository.findById(id);

        if (optionalJob.isPresent()) {
            Job job = optionalJob.get();
            // copy only updatable fields — do NOT change the id
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());

            jobRepository.save(job); // persist changes
            return true;
        }
        return false;
    }

    @Override
    public JobDTO findById(Long id) {

        Job job= jobRepository.findById(id).orElse(null);
        return convertToDto(job);
    }
}
