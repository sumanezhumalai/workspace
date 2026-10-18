package com.sumanezhumalai.jobapplicationmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sumanezhumalai.jobapplicationmvc.model.JobPost;
import com.sumanezhumalai.jobapplicationmvc.service.JobService;

@Controller
public class JobController {

    private final JobService service;

    public JobController(@Autowired JobService service) {
        this.service = service;
    }

    @GetMapping({ "/", "/home" })
    public String home() {
        return "home";
    }

    @GetMapping("addjob")
    public String addJob() {
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(@ModelAttribute JobPost jobPost) {
        service.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model model) {
        List<JobPost> jobs = service.getAllJob();
        model.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }
}
