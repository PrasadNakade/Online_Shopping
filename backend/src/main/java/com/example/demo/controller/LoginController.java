package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginReturn;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("login/")
public class LoginController {
	
	@Autowired
	UserRepo userrepo;
	
	
	@RequestMapping("register")
	public int registerYourself(@RequestBody User obj) 
	{
		try 
		{
			if(userrepo.existsByUsername(obj.getUsername()))
				return 2; //userName Exists
			
			if(userrepo.existsByName(obj.getName()))
				return 3; //name already exists
			
			userrepo.save(obj);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	

	
	@RequestMapping("getName{id}")
	public String[] getName(@PathVariable int id) 
	{
		User user= userrepo.findById(id).get();
		String[] s=new String[1];
		s[0]=user.getName();
		return s;
	}
	
	
	@RequestMapping("log")
	public LoginReturn login(@RequestBody String[] sa) {
		if(sa == null)
			return new LoginReturn(-1, -1, "Corrupted data");
		
        String username = sa[0];
		if(username == null || username.length() < 1)
			return new LoginReturn(-1, -1, "EnterUserName");
		
		String password = sa[1];
		if(password == null || password.length() < 1)
			return new LoginReturn(-1, -1, "EnterPassword");
		
		int count = userrepo.countByUsername(username);
		if(count == 0) 
			return new LoginReturn(-1, -1, "UserNameWrong");
		
		if(count > 1)
			return new LoginReturn(-1, -1, "Something went wrong with the user data");
		
        User user = userrepo.findByUsername(username);
		if(user.getPassword().equals(password)) {
			return new LoginReturn(user.getId(), user.getAccountType(), null);
		} else {
			return new LoginReturn(-1, -1, "PasswordWrong");
		}
	}
}