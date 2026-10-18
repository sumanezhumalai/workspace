package com.sumanezhumalai.springbootrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sumanezhumalai.springbootrest.model.JobPost;

public interface JobPostRepository extends JpaRepository<JobPost, Integer> {

        List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfileString, String postDString);

        // ArrayList to store JobPost objects
        // List<JobPost> jobs = new ArrayList<>(Arrays.asList(

        // new JobPost(1, "Java Developer", "Must have good experience in core Java and
        // advanced Java", 2,
        // List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

        // new JobPost(2, "Frontend Developer",
        // "Experience in building responsive web applications using React", 3,
        // List.of("HTML", "CSS", "JavaScript", "React")),

        // new JobPost(3, "Data Scientist", "Strong background in machine learning and
        // data analysis", 4,
        // List.of("Python", "Machine Learning", "Data Analysis")),

        // new JobPost(4, "Network Engineer",
        // "Design and implement computer networks for efficient data communication", 5,
        // List.of("Networking", "Cisco", "Routing", "Switching")),

        // new JobPost(5, "Mobile App Developer",
        // "Experience in mobile app development for iOS and Android", 3,
        // List.of("iOS Development", "Android Development", "Mobile App"))));

        // public List<JobPost> getAllJobs() {
        // return jobs;
        // }

        // public boolean addJob(JobPost job) {
        // // Check if a job with the same ID already exists
        // boolean exists = jobs.stream()
        // .anyMatch(j -> j.getPostId() == job.getPostId());

        // if (!exists) {
        // jobs.add(job);
        // return true;
        // }
        // return false;
        // }

        // public JobPost getJobById(int id) {
        // return jobs.stream().filter(j -> j.getPostId() ==
        // id).findFirst().orElse(null);
        // }

        // public JobPost updateJob(JobPost updatedJob) {
        // JobPost job = jobs.stream()
        // .filter(j -> j.getPostId() ==
        // updatedJob.getPostId()).findFirst().orElse(null);
        // if (job != null) {
        // job.setPostProfile(updatedJob.getPostProfile());
        // job.setPostDesc(updatedJob.getPostDesc());
        // job.setReqExperience(updatedJob.getReqExperience());
        // job.setPostTechStack(updatedJob.getPostTechStack());
        // } else {
        // return null;
        // }

        // return job;
        // }

        // public JobPost remove(int postId) {
        // JobPost jobToDelete = jobs.stream()
        // .filter(j -> j.getPostId() == postId)
        // .findFirst()
        // .orElse(null);

        // if (jobToDelete != null) {
        // jobs.remove(jobToDelete);
        // }

        // return jobToDelete;
        // }
}
