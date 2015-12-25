package rs.slavko.tutorials.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;

import rs.slavko.tutorials.jpa.model.Address;
import rs.slavko.tutorials.jpa.model.Student;


/**
 * Hello world!
 *
 */
public class App 
{
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
    static EntityManager em = emf.createEntityManager();
	
	 public static void main(String[] args) {		 
	        
	 createStudent("Slavko","14/12",createAddress("Beograd","Srbija","11100","Rakovica", "Ljubomira Ivkovića Šuce 32"));
	        
	 
	    }
	 
	    private static Address createAddress(String grad, String drzava, String kod,String opstina,String adresa) {
	        em.getTransaction().begin();
	        Address ad = new Address();
	        ad.setCity(grad);
	        ad.setCountry(drzava);	        
	        ad.setPostcode(kod);
	        ad.setProvince(opstina);
	        ad.setStreet(adresa);	        
	        em.persist(ad);
	        em.getTransaction().commit();
	        return ad;
	    }
	    
	    private static Student createStudent(String name, String index, Address ad){
	    	em.getTransaction().begin();
	    	Student st = new Student();
	    	st.setAddres(ad);
	    	st.setIndex(index);
	    	st.setName(name);
	    	em.persist(st);
	        em.getTransaction().commit();
	        return st;
	    }
	    
	   
}
