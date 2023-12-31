package com.chatgpt.integration.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatgptRequest {
	
	private String model;
	private List<Message> messages = new ArrayList<>();
	
	public ChatgptRequest(String model, String query) {
		this.model = model;
		this.messages.add(new Message("user", query));
	}
	
	

}
