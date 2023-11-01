package com.chatgpt.integration.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chatgpt.integration.model.ChatgptRequest;
import com.chatgpt.integration.model.ChatgptResponse;

@RestController
@RequestMapping("/api/v1")
public class ChatgptController {
	
	@Value("${chatgpt.model}")
	private String model;
	
	@Value("${chatgpt.api.url}")
	private String apiUrl;
	
	@Value("${chatgpt.api.key}")
	private String apiKey;
	
	@Autowired
	private static RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(value="/ask", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String ask(@RequestParam String query) {
		ChatgptRequest request = new ChatgptRequest(model, query);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer "+apiKey);
		ChatgptResponse response = restTemplate.postForObject(apiUrl, new HttpEntity<>(request, headers), ChatgptResponse.class);
		
		return response.getChoices().get(0).getMessage().getContent();
	}
	

}
