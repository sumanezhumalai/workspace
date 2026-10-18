package com.sumanezhumalai.jobapplicationmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sumanezhumalai.jobapplicationmvc.model.JobPost;
import com.sumanezhumalai.jobapplicationmvc.repository.JobRepository;

@Service
public class JobService {

    private final JobRepository repo;

    public JobService(JobRepository repo) {
        this.repo = repo;
    }

    public void addJob(JobPost jobPost) {
        repo.addJob(jobPost);
    }

    public List<JobPost> getAllJob() {
        return repo.getAllJobs();
    }

}
