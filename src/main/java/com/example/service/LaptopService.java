package com.example.service;

import com.example.model.Laptop;
import com.example.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    LaptopRepository repo;

    public Laptop save(Laptop laptop) {
        return repo.save(laptop);
    }

    public List<Laptop> getAll() {
        return repo.findAll();
    }
}
