package com.example.controller;

import com.example.model.Laptop;
import com.example.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/laptop")
public class MainController {

    @Autowired
    LaptopRepository lr;

    // POST to add a laptop
    @PostMapping("/add")
    public ResponseEntity<String> addLaptop(@RequestBody Laptop lp) {
        // Check if the laptop is null before saving
        if (lp == null) {
            return ResponseEntity.badRequest().body("Laptop data is missing");
        }

        lr.save(lp);
        return ResponseEntity.ok("Laptop added successfully");
    }

    // GET all laptops
    @GetMapping("/list")
    public List<Laptop> list() {
        return lr.findAll();
    }

    // GET one laptop by ID
    @GetMapping("/findOne/{index}")
    public ResponseEntity<Laptop> findOne(@PathVariable int index) {
        Optional<Laptop> laptop = lr.findById(index);

        if (laptop.isPresent()) {
            return ResponseEntity.ok(laptop.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT to update an existing laptop
    @PutMapping("/update/{index}")
    public ResponseEntity<Laptop> update(@PathVariable int index, @RequestBody Laptop newLaptop) {
        Optional<Laptop> oldLaptop = lr.findById(index);

        if (!oldLaptop.isPresent()) {
            return ResponseEntity.notFound().build();  // Return 404 if laptop not found
        }

        Laptop laptop = oldLaptop.get();
        laptop.setBrand(newLaptop.getBrand());
        laptop.setModel(newLaptop.getModel());
        laptop.setPrice(newLaptop.getPrice());
        lr.save(laptop);

        return ResponseEntity.ok(laptop);  // Return the updated laptop
    }

    // DELETE a laptop by ID
    @DeleteMapping("/delete/{index}")
    public ResponseEntity<String> delete(@PathVariable int index) {
        Optional<Laptop> laptop = lr.findById(index);

        if (!laptop.isPresent()) {
            return ResponseEntity.notFound().build();  // Return 404 if laptop not found
        }

        lr.deleteById(index);
        return ResponseEntity.ok("Laptop deleted successfully");
    }
}
