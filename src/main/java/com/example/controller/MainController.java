package com.example.controller;

import com.example.model.Laptop;
import com.example.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/laptop")
public class MainController {

    @Autowired
    LaptopRepository lr;

    // POST to add a laptop
    @PostMapping("/add")
    public void addLaptop(@RequestBody Laptop lp) {
        lr.save(lp);
    }
}
