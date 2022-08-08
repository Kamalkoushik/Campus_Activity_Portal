package com.model;
import javax.ejb.Remote;
import com.entity.User;

@Remote
public interface UserRemote 
{
	public String saveData(User E) throws Exception;
	public String updateData(User E, String id) throws Exception;
}
