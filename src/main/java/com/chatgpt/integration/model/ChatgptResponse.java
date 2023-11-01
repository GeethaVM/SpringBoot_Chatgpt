package com.chatgpt.integration.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatgptResponse {

	private List<Choice> choices;
	
}
