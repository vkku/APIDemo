package com.github.api.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.api.model.GithubInfoDTO;
import com.github.api.service.UserFetchService;

@Controller
public class UserFetchController {

	@Autowired
	UserFetchService fetchService;
	ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	@GetMapping("/user/{username}")
	public ResponseEntity<?> fetchUserDetails(@PathVariable String username) throws IOException {

		String responseJSON = fetchService.getUserDetails(username);

		// Pretty Print Logic
		GithubInfoDTO prettyPrintMessage = mapper.readValue(responseJSON, GithubInfoDTO.class);
		String prettyResponse = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(prettyPrintMessage);

		ResponseEntity<String> responseEntity = ResponseEntity.status(HttpStatus.OK).body(prettyResponse);
		return responseEntity;

	}

}
