package kom.slavko.tutorials.spring.springMVC.service;

import java.util.List;

import kom.slavko.tutorials.spring.springMVC.dao.Offer;
import kom.slavko.tutorials.spring.springMVC.dao.OffersDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("offersService")
public class OffersService {
	
	OffersDao offersDao;
	
	@Autowired
	public void setOffersDao(OffersDao offersDAO) {
		this.offersDao = offersDAO;
	}
	
	public List<Offer> getCurrent(){		
		
		return offersDao.getOffers();
	}

	public void createOffer(Offer offer) {
		offersDao.create(offer);
	}

	public void throwTestException() {
		offersDao.getOffer(-100);
		
	}
	
	
	
	
}
