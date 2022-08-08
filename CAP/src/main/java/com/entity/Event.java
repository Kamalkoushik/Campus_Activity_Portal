package com.entity;
import java.io.*;
import javax.persistence.*;

@Entity
@Table(name="events_table")
public class Event implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name="id")
	String id;
	@Id
	@Column(name="name")
	String name;
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
