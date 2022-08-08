package com.controller;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.User;
import com.model.UserRemote;

@ManagedBean(name = "user", eager = true)
public class UserData {

	String id, username, email, password, response;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	@EJB(lookup = "java:global/CAP/UserManager!com.model.UserRemote")
	UserRemote UR;
	
	public void save() {
			try{
				User U = new User();
				U.setId(id);
				U.setUsername(username);
				U.setEmail(email);
				U.setPassword(password);
				response = UR.saveData(U);
			}
			catch(Exception e){
				response = e.getMessage();
			}
	}
	
	public void update() {
		try{
			User U = new User();
			U.setId(id);
			U.setUsername(username);
			U.setEmail(email);
			U.setPassword(password);
			response = UR.updateData(U,id);
		}
		catch(Exception e){
			response = e.getMessage();
		}
	}
	
}
