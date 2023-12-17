package com.in28minutes.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.in28minutes.springmvc.UserValidationService;

@Controller
public class LoginController {

	private UserValidationService service = new UserValidationService();
	
	//Using spring mvc concept
	@RequestMapping(value="/login" , method= RequestMethod.GET)
	public String showLoginPage() {
		System.out.println("step 1 --  LoginController doGet");
		return "login";
	}
	
	@RequestMapping(value="/login" , method= RequestMethod.POST)
	public String handelLoginRequest(@RequestParam String user, @RequestParam String password,ModelMap model ) {
		System.out.println("step 2 --  LoginController doPost");
		if(!service.isUserValid(user, password)) {
			model.put("errorMessage", "Invalid Credential");
			return "login";
		}
		model.put("user", user);
		model.put("password", password);
		return "welcome";
	}
}
