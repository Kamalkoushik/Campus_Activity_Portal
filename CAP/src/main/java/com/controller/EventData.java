package com.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.Event;
import com.model.EventRemote;


@ManagedBean(name = "event", eager = true)
public class EventData {
	String id;
	String name;
	String date;	
	String start_time;
	String end_time;
	String description;
	String response;
	
	@EJB(lookup = "java:global/CAP/EventManager!com.model.EventRemote")
	EventRemote eventremote;
	
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String registerEvent()
	{
		try
		{
			Event event = new Event();
			event.setId(id);
	
			response = eventremote.register(event);
		}
		catch(Exception e)
		{
			response = e.getMessage();
		}
		return response;
	}
}
