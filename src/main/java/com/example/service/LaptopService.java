package com.example.service;

import com.example.model.Laptop;
import com.example.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    LaptopRepository lr;

    public void addLaptop(Laptop lp) {
        lr.save(lp);
    }

    public List<Laptop> listLaptop() {
        return lr.findAll();
    }

    public Optional<Laptop> findOneLaptop(int index) {
        return lr.findById(index);
    }

    public Laptop updateLaptop(int index, Laptop newLaptop) {
        Optional<Laptop> oldLaptop = lr.findById(index);

        if (oldLaptop.isPresent()) {
            Laptop laptop = oldLaptop.get();
            laptop.setBrand(newLaptop.getBrand());
            laptop.setModel(newLaptop.getModel());
            laptop.setPrice(newLaptop.getPrice());
            return lr.save(laptop);
        }

        return null;
    }

    public void deleteLaptop(int index) {
        lr.deleteById(index);
    }

    public List<Laptop> findByBrand(String brand) {
        return lr.findByBrand(brand);
    }
}
