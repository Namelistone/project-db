package com.scholanova.projectdb.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scholanova.projectdb.models.Message;

@Service
public class MessagesService {
	public MessagesService() {
		
	}
	
	public List<Message> getListeMessages() {
		
		return Arrays.asList(new Message(0,"Message 0 "),new Message(1,"Message 1 "));
	}

}
