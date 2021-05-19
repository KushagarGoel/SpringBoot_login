package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class control {
	
	 @Autowired
	 com.example.demo.UserRepository userRepository;
	
	@RequestMapping("/home")
	public String Hello() {
		return "NewFile.html";
	}
	
	@RequestMapping("/user/show_user")
	public String ShowUser(HttpServletRequest req, Model m) {
		 List<String> userNameList = new ArrayList<>();
		 String username = req.getParameter("username");
		 String password = req.getParameter("password");
		 String query = "select username from user_login where username="+'"'+username+'"'+"and password="+'"'+password+'"'+";";
		 userNameList = userRepository.CheckUser(query);
		 
		 if (userNameList.size() == 0) {
			 m.addAttribute("name", "User Not found");
			 return "NewFile1.html";
		 }
		 else {
			 m.addAttribute("name", username);
			 return "NewFile1.html";
		 }
		
	}


}
