package com.example.controller;

import com.example.model.Warranty;
import com.example.service.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warranty")
public class WarrantyController {

    @Autowired
    WarrantyService service;

    @PostMapping("/add")
    public Warranty add(@RequestBody Warranty warranty) {
        return service.save(warranty);
    }

    @GetMapping("/list")
    public List<Warranty> list() {
        return service.getAll();
    }
}
