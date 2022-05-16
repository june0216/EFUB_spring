package com.example.efub.tdd.repository;

import com.example.efub.tdd.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
