package com.in28minutes.springmvc;

public class UserValidationService {
	
	public boolean isUserValid(String user , String password)
	{    System.out.println("step 3 --  UserValidation");
		if(user.equals("Aditi") && password.equals("Samrit")) {
			return true;
		}
		else
		{
			return false;
		}
	}

}
