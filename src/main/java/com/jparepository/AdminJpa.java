package com.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Admin;
import com.entity.Candidate;

public interface AdminJpa extends JpaRepository<Admin,String>{
	public Admin findByEmailAndPass(String email,int pass);
}
