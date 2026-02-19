package com.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // One Brand → Many Laptops
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Laptop> laptops;
}
