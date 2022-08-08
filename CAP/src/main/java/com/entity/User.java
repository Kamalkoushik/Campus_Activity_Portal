package com.entity;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name = "user_table")
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	String id; 
	@Column(name="username")
	String username;
	@Column(name="email")
	String email;
	@Column(name="password")
	String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
