package com.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.User;

public interface UserJpa extends JpaRepository<User, String>{
public User findByEmailAndPass(String email,int pass);
}
