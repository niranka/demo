package com.rnkt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rnkt.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
