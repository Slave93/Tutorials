package kom.slavko.tutorials.spring.springMVC.controllers;

import java.util.List;

import javax.validation.Valid;

import kom.slavko.tutorials.spring.springMVC.dao.Offer;
import kom.slavko.tutorials.spring.springMVC.dao.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/newaccount")
	public String crateUser(Model model) {
		model.addAttribute("user",new User());
		return "newaccount";
	}
	
	@RequestMapping("/accountcreated")
	public String doCreate() {
		return "accountcreated";
	}
}
