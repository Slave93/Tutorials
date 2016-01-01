package rs.slavko.tutorials.jpa.messenger.dao;

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
	
	private ProfileDAO pd = new ProfileDAOImpl();
	
	
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

	@Override
	public List<Message> getAllMessagesForProfile(String profileName) {
		EntityManager em = DatabaseClass.getEntityManagerFactoryInstance()
				.createEntityManager();		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery cqry = cb.createQuery();
		Root<Message> root = cqry.from(Message.class);
		cqry.select(root);		
		Predicate pname = cb.equal(root.get("author").get("profileName"), profileName);
		cqry.where(pname);		
		Query qry = em.createQuery(cqry);
		List<Message> results = qry.getResultList();
		em.close();		
		return results;		
	}

	@Override
	public Message getMessage(String profileName, int messageNumber) {
		return getAllMessagesForProfile(profileName).get(messageNumber);
	}	
	
	public Message getMessage(long id) {
		return DatabaseClass.getEntityManagerFactoryInstance().createEntityManager().find(Message.class, id);
	}
	
	public Message addMessage(String profileName, Message message) {
		EntityManager em = DatabaseClass.getEntityManagerFactoryInstance()
				.createEntityManager();
		em.getTransaction().begin();
		message.setCreated(new Date());
		Profile p = pd.getProfile(profileName);
		message.setAuthor(p);
		em.persist(message);
		em.getTransaction().commit();
		em.close();
		return message;
	}	
	
	public Message removeMessage(long id) {
		EntityManager em = DatabaseClass.getEntityManagerFactoryInstance()
				.createEntityManager();
		em.getTransaction().begin();
		Message m = getMessage(id);
		m = em.merge(m);
		em.remove(m);
		em.getTransaction().commit();
		em.close();
		return m;
	}


}
