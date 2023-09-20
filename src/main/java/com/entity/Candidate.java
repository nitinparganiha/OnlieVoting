package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Candidate {
	@Id
private String email;
private String candidate;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCandidate() {
	return candidate;
}
public void setCandidate(String candidate) {
	this.candidate = candidate;
}


}
