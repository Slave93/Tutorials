package rs.slavko.tutorials.jpa.test;

import java.util.List;

import javax.persistence.EntityManager;

import rs.slavko.tutorials.jpa.messenger.dao.CommentDAO;
import rs.slavko.tutorials.jpa.messenger.dao.CommentDAOImpl;
import rs.slavko.tutorials.jpa.messenger.dao.MessageDAO;
import rs.slavko.tutorials.jpa.messenger.dao.MessageDAOImpl;
import rs.slavko.tutorials.jpa.messenger.dao.ProfileDAO;
import rs.slavko.tutorials.jpa.messenger.dao.ProfileDAOImpl;
import rs.slavko.tutorials.jpa.messenger.database.DatabaseClass;
import rs.slavko.tutorials.jpa.messenger.model.Comment;
import rs.slavko.tutorials.jpa.messenger.model.Message;
import rs.slavko.tutorials.jpa.messenger.model.Profile;

public class TestApp {
	public static void main(String[] args) {
		EntityManager em = DatabaseClass.getEntityManagerFactoryInstance().createEntityManager();
		MessageDAO md = new MessageDAOImpl();
		CommentDAO cd = new CommentDAOImpl();
		ProfileDAO pd = new ProfileDAOImpl();
		
		//pd.removeProfile("Novica");
		/*Profile p = pd.getProfile("Novica");
		p.setFirstName("Novara");
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();*/
		
		/*Profile p  = em.find(Profile.class, "Novica");
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();*/
		List<Message> lm = md.getAllMessages();
		for(Message m : lm){
			System.out.println(m);
		}
		
		
		/*Message m = em.find(Message.class, 1l);
		em.getTransaction().begin();
		em.remove(m);
		em.getTransaction().commit();*/
		
		/*
		Profile p = new Profile(5, "vvv", "vvv", "vvv");
		pd.updateProfile(p);
	
		EntityManager em = DatabaseClass.getEntityManagerFactoryInstance().createEntityManager();
		Profile p = em.find(Profile.class, "Slave");
		System.out.println(p);
		p.setFirstName("Slavko");
		p.setLastName("Komarica");
		em.getTransaction().begin();
		
		//em.flush();
		em.getTransaction().commit();
		
		
		Message m = new Message();
		m.setAuthor("Mirko");
		m.setMessage("How are you");		
		md.addMessage(m);
		Comment c = new Comment();
		c.setAuthor("Slavko");		
		c.setMessageTxt("Ha ha ha i am talking to myself");
		cd.addComment(1, c);
		for(Comment com : cd.getAllComments(1)){
			System.out.println(com.getMessageTxt());
		}*/
		
		
		
	}
}
