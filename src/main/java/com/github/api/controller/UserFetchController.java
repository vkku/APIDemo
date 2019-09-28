package com.github.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.api.service.UserFetchService;

@Controller
public class UserFetchController {

	@Autowired
	UserFetchService fetchService;

	@GetMapping("/user/{username}")
	public ResponseEntity<?> fetchUserDetails(@PathVariable String username) {

		String responseJSON = fetchService.getUserDetails(username);
		ResponseEntity<String> responseEntity = ResponseEntity.status(HttpStatus.OK).body(responseJSON);
		return responseEntity;

	}

}
