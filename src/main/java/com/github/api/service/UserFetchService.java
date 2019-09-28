package com.github.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserFetchService {

	private static final String GITHUB_API_URL = "https://api.github.com";

	public String getUserDetails(String username) {

		StringBuilder url = new StringBuilder();
		url.append(GITHUB_API_URL).append("/users/").append(username);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(url.toString(), String.class);

		return response.getBody();
	}

}
