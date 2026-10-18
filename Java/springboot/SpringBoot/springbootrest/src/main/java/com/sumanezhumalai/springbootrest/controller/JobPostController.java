package com.sumanezhumalai.springbootrest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sumanezhumalai.springbootrest.model.JobPost;
import com.sumanezhumalai.springbootrest.service.JobPostService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobPostController {
    private JobPostService service;

    JobPostController(JobPostService service) {
        this.service = service;
    }

    @GetMapping(path = "jobs", produces = { "application/json", "application/xml" })
    public List<JobPost> getAllJobs() {
        return service.getAllJob();
    }

    @GetMapping("job/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJob(postId).orElse(new JobPost());
    }

    @PostMapping("job")
    public void addJob(@RequestBody JobPost job) {
        service.addJob(job);
    }

    @PutMapping(path = "job", consumes = { "application/json", "application/xml" })
    public JobPost updateJob(@RequestBody JobPost job) {
        return service.updateJob(job);
    }

    @DeleteMapping("job/{postId}")
    public void removeJob(@PathVariable("postId") int postId) {
        service.remove(postId);
    }

    @GetMapping("job/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
        return service.searchByKeyword(keyword);
    }

    @GetMapping("load")
    public String loadData() {
        service.load();
        return new String();
    }

}
