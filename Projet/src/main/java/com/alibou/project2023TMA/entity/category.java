package com.alibou.project2023TMA.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "category")
public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger category_id;
    private String name_category;
    private String status;

    @ManyToMany(mappedBy = "category")
    @JsonManagedReference
    private Set<transactions> transactions;
}