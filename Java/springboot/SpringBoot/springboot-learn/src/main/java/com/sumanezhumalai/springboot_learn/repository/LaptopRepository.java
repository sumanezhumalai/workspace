package com.sumanezhumalai.springboot_learn.repository;

import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {
    public void save() {
        System.out.println("Saved - Dummy");
    }
}
