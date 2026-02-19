package com.example.controller;

import com.example.model.Brand;
import com.example.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandService service;

    @PostMapping("/add")
    public Brand add(@RequestBody Brand brand) {
        return service.save(brand);
    }

    @GetMapping("/list")
    public List<Brand> list() {
        return service.getAll();
    }
}
