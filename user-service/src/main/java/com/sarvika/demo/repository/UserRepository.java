package com.sarvika.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarvika.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

