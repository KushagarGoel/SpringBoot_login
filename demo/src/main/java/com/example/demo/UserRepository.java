package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	 @Autowired
	 JdbcTemplate jdbcTemplate;
	 
	 
	 public List<String> CheckUser(String query) {
		  List<String> userNameList = new ArrayList<>();
		  userNameList.addAll(jdbcTemplate.queryForList(query, String.class));
		  return userNameList;
		 }
	 
	 public List<String> getAllUserNames() {
	  List<String> userNameList = new ArrayList<>();
	  userNameList.addAll(jdbcTemplate.queryForList("select username from user_login;", String.class));
	  return userNameList;
	 }
}
