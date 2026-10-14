package com.sumanezhumalai.springboot_learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumanezhumalai.springboot_learn.model.Laptop;
import com.sumanezhumalai.springboot_learn.repository.LaptopRepository;

@Service // same as Component , NO difference , yet prefferred for Documenting and
         // Developing style
public class LaptopService {

    private final LaptopRepository repo;

    LaptopService(@Autowired LaptopRepository repo) {
        this.repo = repo;
    }

    public void addLaptop(Laptop laptop) {
        repo.save();
        System.out.println("Laptop Added - Dummy");
    }

    public boolean isGoodForCodeing(Laptop laptop) {
        return true;
    }
}
