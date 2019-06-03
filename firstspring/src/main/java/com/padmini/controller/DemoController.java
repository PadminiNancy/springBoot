package com.padmini.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.padmini.model.UserInfo;
import com.padmini.service.BookService;
import com.padmini.service.LoginService;

@RestController
public class DemoController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(method=RequestMethod.GET,value="/hello")
	public String getExpenses(){
		//System.out.println(" userid "+userId);
		return "Hi there ..Whatsup!";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/allUsers")
	public List login()
	{
		UserInfo u = null;
		System.out.println("In Controller ");
		return loginService.allUsers(u);
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="mybrary/signin")
	public Boolean loginid(@RequestBody UserInfo u)
	{
		//UserInfo u = null;
		System.out.println("In Controller ");			
		return loginService.login(u);
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="mybrary/signUp")
	public String signUp(@RequestBody UserInfo u)
	{
		//UserInfo u = null;
		System.out.println("In Controller ");			
		return loginService.signUp(u);
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="mybrary/{userId}")
	public List allBooks(@PathVariable String userId)
	{
		//UserInfo u = null;
		System.out.println("In Controller ");			
		return bookService.allBooks(userId);
		
	}
	
	
	
	
}