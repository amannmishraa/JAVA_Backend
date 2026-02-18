package com.example.controller;

import com.example.model.Laptop;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    List<Laptop> list = new ArrayList<>();

    public MainController() {
        list.add(new Laptop(1, "Dell", "Inspiron", 55000));
        list.add(new Laptop(2, "HP", "Pavilion", 60000));
        list.add(new Laptop(3, "Lenovo", "ThinkPad", 75000));
    }

    // Get all laptops
    @GetMapping("/listi")
    public List<Laptop> list() {
        return list;
    }

    // Get one laptop by index
    @GetMapping("/findOne/{index}")
    public Laptop findOne(@PathVariable int index) {
        return list.get(index);
    }

    // Add new laptop
    @PostMapping("/add")
    public String add(@RequestBody Laptop laptop) {
        list.add(laptop);
        return "Laptop Added Successfully";
    }

    // Update laptop
    @PutMapping("/update/{index}")
    public String update(@PathVariable int index,
                         @RequestBody Laptop laptop) {

        if (index >= 0 && index < list.size()) {
            list.set(index, laptop);
            return "Laptop Updated Successfully";
        } else {
            return "Index Not Found";
        }
    }

    // Delete laptop
    @DeleteMapping("/delete/{index}")
    public String delete(@PathVariable int index) {

        if (index >= 0 && index < list.size()) {
            list.remove(index);
            return "Laptop Deleted Successfully";
        } else {
            return "Index Not Found";
        }
    }
}
