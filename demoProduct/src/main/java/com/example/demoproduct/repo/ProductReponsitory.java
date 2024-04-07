package com.example.demoproduct.repo;

import com.example.demoproduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReponsitory extends JpaRepository<Product, Integer> {
}
