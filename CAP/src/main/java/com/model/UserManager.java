package com.model;
import javax.ejb.*;
import javax.persistence.*;
import com.entity.User;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserManager implements UserRemote
{	
	@Override
	public String saveData(User usr) throws Exception 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CAP");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(usr);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return "Object Inserted Successfully";
	}
	
	@Override
	public String updateData(User usr, String id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CAP");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		User user = entityManager.find(User.class, id);
		user.setId(usr.getId());
		user.setUsername(usr.getUsername());
		user.setEmail(usr.getEmail());
		user.setPassword(usr.getPassword());
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return "Object Updated Successfuly";
	}
}
