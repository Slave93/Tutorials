package templateapp.core.database;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import templateapp.core.model.Message;
import templateapp.core.model.Profile;

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
