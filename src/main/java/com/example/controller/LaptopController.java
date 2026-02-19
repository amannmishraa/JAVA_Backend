package com.example.controller;

import com.example.model.Laptop;
import com.example.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

    @Autowired
    LaptopService service;

    @PostMapping("/add")
    public Laptop add(@RequestBody Laptop laptop) {
        return service.save(laptop);
    }

    @GetMapping("/list")
    public List<Laptop> list() {
        return service.getAll();
    }
}
