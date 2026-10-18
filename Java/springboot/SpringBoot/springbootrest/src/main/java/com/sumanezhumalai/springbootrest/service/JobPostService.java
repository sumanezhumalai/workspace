package com.sumanezhumalai.springbootrest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sumanezhumalai.springbootrest.model.JobPost;
import com.sumanezhumalai.springbootrest.repository.JobPostRepository;

@Service
public class JobPostService {

    private final JobPostRepository repo;

    public JobPostService(JobPostRepository repo) {
        this.repo = repo;
    }

    public void addJob(JobPost job) {
        repo.save(job);
    }

    public List<JobPost> getAllJob() {
        return repo.findAll();
    }

    public Optional<JobPost> getJob(int id) {
        return repo.findById(id);
    }

    public JobPost updateJob(JobPost job) {
        return repo.save(job);
    }

    public void remove(int postId) {
        repo.deleteById(postId);
    }

    public List<JobPost> searchByKeyword(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(

                new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

                new JobPost(2, "Frontend Developer",
                        "Experience in building responsive web applications using React", 3,
                        List.of("HTML", "CSS", "JavaScript", "React")),

                new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),

                new JobPost(4, "Network Engineer",
                        "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching")),

                new JobPost(5, "Mobile App Developer",
                        "Experience in mobile app development for iOS and Android", 3,
                        List.of("iOS Development", "Android Development", "Mobile App"))));

        repo.saveAll(jobs);
    }

}
