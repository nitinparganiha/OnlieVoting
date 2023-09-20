package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
	@Id
private String email;
private int pass;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getPass() {
	return pass;
}
public void setPass(int pass) {
	this.pass = pass;
}

}
