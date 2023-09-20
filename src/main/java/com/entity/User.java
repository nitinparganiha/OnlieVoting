package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
private String email;
private String name;
private int pass;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPass() {
	return pass;
}
public void setPass(int pass) {
	this.pass = pass;
}

}
