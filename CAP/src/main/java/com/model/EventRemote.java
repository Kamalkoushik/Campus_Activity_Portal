package com.model;
import javax.ejb.Remote;
import com.entity.Event;

@Remote
public interface EventRemote {
	public String register(Event e) throws Exception;;
	
}
