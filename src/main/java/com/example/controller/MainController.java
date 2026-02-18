package com.example.controller;

import com.example.model.Laptop;
import com.example.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/laptop")
public class MainController {

    @Autowired
    LaptopService lr;

    @PostMapping("/add")
    public ResponseEntity<String> addLaptop(@RequestBody Laptop lp) {
        lr.addLaptop(lp);
        return ResponseEntity.ok("Laptop added successfully");
    }

    @GetMapping("/list")
    public List<Laptop> list() {
        return lr.listLaptop();
    }

    @GetMapping("/findOne/{index}")
    public ResponseEntity<Laptop> findOne(@PathVariable int index) {
        Optional<Laptop> laptop = lr.findOneLaptop(index);
        return laptop.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{index}")
    public ResponseEntity<Laptop> update(@PathVariable int index,
                                         @RequestBody Laptop newLaptop) {

        Laptop updated = lr.updateLaptop(index, newLaptop);

        if (updated == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity<String> delete(@PathVariable int index) {
        lr.deleteLaptop(index);
        return ResponseEntity.ok("Laptop deleted successfully");
    }

    @GetMapping("/findByBrand/{brand}")
    public List<Laptop> findByBrandName(@PathVariable String brand) {
        return lr.findByBrand(brand);
    }
}
