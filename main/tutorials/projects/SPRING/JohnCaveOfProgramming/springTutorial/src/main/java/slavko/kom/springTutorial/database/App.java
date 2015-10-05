package slavko.kom.springTutorial.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;



public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"slavko/kom/springTutorial/beans/beansDatabase.xml");

		try {
			OffersDAO offersDao = (OffersDAO) context.getBean("offersDAO");
			/*
			List<Offer> offersList = new ArrayList<Offer>();

			offersList.add(new Offer("Slavko", "slavko@programming.com",
					"ProProKiloEr"));
			offersList.add(new Offer(2,"Pera", "pera@caveofprogramming.com",
					"PHP INGENEER"));

			int[] rvals = offersDao.create(offersList);

			for (int value : rvals) {
				System.out.println("Updated " + value + " rows.");
			}

			/*Offer offer1 = new Offer("Dave", "dave@email.com", "Coding Java");
			Offer offer2 = new Offer("John", "john@email.com", "Coding PHP");

			if (offersDao.create(offer1)) {
				System.out.println("Created offer object.");
			}
			if (offersDao.create(offer2)) {
				System.out.println("Created offer object.");
			}*/

			List<Offer> offers = offersDao.getOffers();
			for (Offer offer : offers) {
				System.out.println(offer);
			}
			Offer offer = offersDao.getOffer(2);
			System.out.println("Should be Mike: " + offer);
		} catch (CannotGetJdbcConnectionException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();
	}

}
