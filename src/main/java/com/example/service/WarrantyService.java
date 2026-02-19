package com.example.service;

import com.example.model.Warranty;
import com.example.repository.WarrantyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarrantyService {

    @Autowired
    WarrantyRepository repo;

    public Warranty save(Warranty warranty) {
        return repo.save(warranty);
    }

    public List<Warranty> getAll() {
        return repo.findAll();
    }
}
