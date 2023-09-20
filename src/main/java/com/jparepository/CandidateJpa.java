package com.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Candidate;

public interface CandidateJpa extends JpaRepository<Candidate,String>{
public Candidate findByEmail(String email);
public List<Candidate> findByCandidate(String cand);
}
