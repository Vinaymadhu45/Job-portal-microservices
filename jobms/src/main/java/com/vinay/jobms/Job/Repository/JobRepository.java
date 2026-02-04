package com.vinay.jobms.Job.Repository;


import com.vinay.jobms.Job.Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {

}
