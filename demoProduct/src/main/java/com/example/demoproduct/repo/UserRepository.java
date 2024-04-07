package com.example.demoproduct.repo;


import com.example.demoproduct.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}