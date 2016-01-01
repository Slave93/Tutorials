package rs.slavko.tutorials.jpa.messenger.database;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import rs.slavko.tutorials.jpa.messenger.model.Message;
import rs.slavko.tutorials.jpa.messenger.model.Profile;

public class DatabaseClass {
	
	
	
	private static EntityManagerFactory emf;
	
	public static EntityManagerFactory getEntityManagerFactoryInstance(){
		if(emf==null){
			emf = Persistence.createEntityManagerFactory("jpa-example");
		}
		return emf;
	}
	
	private DatabaseClass(){
		
	}

	

	
	
	
}
