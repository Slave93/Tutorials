package templateapp.core.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import templateapp.core.database.DatabaseClass;
import templateapp.core.model.Message;
import templateapp.core.model.Profile;

public class ProfileDAOImpl implements ProfileDAO {

	public List<Profile> getAllProfiles() {
		EntityManager em = DatabaseClass.getEntityManagerFactoryInstance()
				.createEntityManager();
		List<Profile> results = em.createQuery("Select p from Profile p",
				Profile.class).getResultList();
		em.close();
		return results;
	}

	public Profile getProfile(String profileName) {
		EntityManager em = DatabaseClass.getEntityManagerFactoryInstance()
				.createEntityManager();
		Profile p = DatabaseClass.getEntityManagerFactoryInstance().createEntityManager().find(Profile.class, profileName);
		em.close();
		return p;
		//before altering table and setting profileName to be primaryKey
		//Code is left here because it is a nice example
		/*CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery cqry = cb.createQuery();
		Root<Profile> root = cqry.from(Profile.class);
		cqry.select(root);		
		Predicate pname = cb.equal(root.get("profileName"), profileName);
		cqry.where(pname);		
		Query qry = em.createQuery(cqry);
		List<Profile> results = qry.getResultList();
		em.close();*/		
	}

	public Profile addProfile(Profile profile) {
		EntityManager em = DatabaseClass.getEntityManagerFactoryInstance()
				.createEntityManager();
		em.getTransaction().begin();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
	    String encodedPassword = passwordEncoder.encode(profile.getPassword());  
	    System.out.println(encodedPassword);
	    profile.setPassword(encodedPassword);
		em.persist(profile);
		em.getTransaction().commit();
		em.close();		
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {		
		EntityManager em = DatabaseClass.getEntityManagerFactoryInstance()
				.createEntityManager();
		em.getTransaction().begin();
		//because passed profile is a new detached profile(not persisted by em)
		//you can merge it with session object, that is with object in memory 
		//with id that is id of passed object , and when you commit it will be persistend
		//in the database
		//if you've got an object from entity manager you wouldn't need merge
		//just edit and commit to the database
		em.merge(profile);		
		//you dont need flush. Flush only executes query immediately  and not waiting 
		//for commit
		//em.flush();
		em.getTransaction().commit();
		em.close();
		return profile;		
	}
	
	public Profile removeProfile(String profileName) {
		EntityManager em = DatabaseClass.getEntityManagerFactoryInstance()
				.createEntityManager();
		em.getTransaction().begin();
		Profile p = getProfile(profileName);
		//nice trick if you are shure you wanna do the merge
		//em.remove(em.contains(p) ? p : em.merge(p));
		//you had to merge here because you've used 
		//a method and not directly em.finnd() to get profile
		//so when a method em was closed this Profile instance was detached
		//so you had to attach it again!
		p = em.merge(p);
		em.remove(p);
		em.getTransaction().commit();
		em.close();
		return p;
	}
	

}
