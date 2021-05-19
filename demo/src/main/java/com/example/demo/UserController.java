package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//Unused file

@RestController
@RequestMapping(path = "/user")
public class UserController {
	

	 // autowiring user repository
	 @Autowired
	 com.example.demo.UserRepository userRepository;

	 @GetMapping
	 public String toTest() {
	  return "Welcome";
	 }
	 


	 @GetMapping(path = "/getusernames")
	 public String getAllUserNames(HttpServletRequest req) {
		 List<String> userNameList = new ArrayList<>();
		 String username = req.getParameter("username");
		 String password = req.getParameter("password");
		 System.out.println(username);
		 String query = "select username from user_login where username="+'"'+username+'"'+"and password="+'"'+password+'"'+";";
		 System.out.println(query);
		 userNameList = userRepository.CheckUser(query);
		 if (userNameList.size() == 0) {
			 return "User not found";
		 }
		 else {
			 return "Hello " + userNameList.get(0);
		 }
	 }
	 
	 

}
