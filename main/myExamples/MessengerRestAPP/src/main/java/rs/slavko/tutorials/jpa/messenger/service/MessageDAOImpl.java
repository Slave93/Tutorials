package rs.slavko.tutorials.jpa.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import rs.slavko.tutorials.jpa.messenger.database.DatabaseClass;
import rs.slavko.tutorials.jpa.messenger.model.Comment;
import rs.slavko.tutorials.jpa.messenger.model.Message;
import rs.slavko.tutorials.jpa.messenger.model.Profile;

public class MessageDAOImpl implements MessageDAO {	
	
	
	public List<Message> getAllMessages() {
		EntityManager em = DatabaseClass.getEntityManagerFactoryInstance()
				.createEntityManager();
		List<Message> results = em.createQuery("Select m from Message m",
				Message.class).getResultList();
		em.close();
		return results;
	}
	
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : getAllMessages()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		List<Message> list = getAllMessages();		
		if (start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size); 
	}
	
	
	public Message getMessage(long id) {
		return DatabaseClass.getEntityManagerFactoryInstance().createEntityManager().find(Message.class, id);
	}
	
	public Message addMessage(Message message) {
		EntityManager em = DatabaseClass.getEntityManagerFactoryInstance()
				.createEntityManager();
		em.getTransaction().begin();
		Message m = new Message();
		m.setAuthor(message.getAuthor());
		m.setMessage(message.getMessage());
		em.persist(m);
		em.getTransaction().commit();
		em.close();
		return m;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		EntityManager em = DatabaseClass.getEntityManagerFactoryInstance()
				.createEntityManager();
		em.getTransaction().begin();
		Message m = getMessage(message.getId());
		m.setMessage(message.getMessage());
		m.setAuthor(message.getAuthor());
		//em.persist(m);
		em.getTransaction().commit();
		em.close();
		return message;
	}
	
	public Message removeMessage(long id) {
		EntityManager em = DatabaseClass.getEntityManagerFactoryInstance()
				.createEntityManager();
		em.getTransaction().begin();
		Message m = getMessage(id);
		em.remove(m);
		em.getTransaction().commit();
		return m;
	}
}
