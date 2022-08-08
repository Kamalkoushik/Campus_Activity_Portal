package com.model;
import javax.ejb.*;
import javax.persistence.*;
import com.entity.Event;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class EventManager implements EventRemote{

	@Override
	public String register(Event e) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CAP");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(e);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return "Registered Successfully";
	}
}
