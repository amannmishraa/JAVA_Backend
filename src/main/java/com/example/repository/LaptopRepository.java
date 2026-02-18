package com.example.repository;

import com.example.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
    @Query(value="select l from Laptop l where l.brand=?1")
    List<Laptop> findByBrand(String brand);

}
