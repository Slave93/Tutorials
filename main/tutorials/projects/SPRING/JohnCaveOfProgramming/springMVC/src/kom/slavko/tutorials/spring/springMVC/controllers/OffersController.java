package kom.slavko.tutorials.spring.springMVC.controllers;

import java.lang.reflect.Method;
import java.util.List;

import javax.validation.Valid;

import kom.slavko.tutorials.spring.springMVC.dao.Offer;
import kom.slavko.tutorials.spring.springMVC.service.OffersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class OffersController {
	
	private OffersService offersService;
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}
	
	/*@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseExceptions(DataAccessException ex){
		return "error";
	}*/
	
	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		
		
		//offersService.throwTestException();
		
		
		List<Offer> offers = offersService.getCurrent();
		
		model.addAttribute("offers", offers);
		
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		model.addAttribute("offer",new Offer());
		return "createoffer";
	}
	
	@RequestMapping(value="/doCreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult res) {
		if(res.hasErrors()){
			System.out.println("Form does not validate");
			List<ObjectError> errors = res.getAllErrors();
			for (ObjectError objectError : errors) {
				System.out.println(objectError.getDefaultMessage());
			}			
			return "createoffer";
		}
		
		offersService.createOffer(offer);
		return "offercreated";
	}
}
