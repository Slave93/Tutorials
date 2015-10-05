package kom.slavko.tutorials.spring.springMVC.service;

import java.util.List;

import kom.slavko.tutorials.spring.springMVC.dao.Offer;
import kom.slavko.tutorials.spring.springMVC.dao.OffersDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("offersService")
public class OffersService {
	
	OffersDAO offersDAO;
	
	@Autowired
	public void setOffersDAO(OffersDAO offersDAO) {
		this.offersDAO = offersDAO;
	}
	
	public List<Offer> getCurrent(){		
		
		return offersDAO.getOffers();
	}

	public void createOffer(Offer offer) {
		offersDAO.create(offer);
	}

	public void throwTestException() {
		offersDAO.getOffer(-100);
		
	}
	
	
	
	
}
