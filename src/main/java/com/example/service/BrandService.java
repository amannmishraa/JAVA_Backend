package com.example.service;

import com.example.model.Brand;
import com.example.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    BrandRepository repo;

    public Brand save(Brand brand) {
        return repo.save(brand);
    }

    public List<Brand> getAll() {
        return repo.findAll();
    }
}
