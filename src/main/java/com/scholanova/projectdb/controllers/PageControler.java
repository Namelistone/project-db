package com.scholanova.projectdb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.scholanova.projectdb.models.Message;
import com.scholanova.projectdb.repositories.MessageRepositories;
import com.scholanova.projectdb.services.MessagesService;



@Controller
public class PageControler {

	private MessagesService messagesService;
	private MessageRepositories messageRepositories;
	public PageControler(MessagesService messagesService,MessageRepositories messageRepositories) {
		this.messagesService = messagesService;
		this.messageRepositories=messageRepositories;
		
	}
	
	@GetMapping("/message")
	public String greetingFormModel(Model model) {
		model.addAttribute("message", new Message() );
		return "message";
	}
	
	@PostMapping("/message")
	public String greetingSubmit(@ModelAttribute Message message,Model model) {
		messageRepositories.insert(message);
		model.addAttribute("messages", this.messageRepositories.listAll() );
		return "listemessage";
	}
	
	@GetMapping("/messages")
	public String listeMessages(Model model) {
		model.addAttribute("messages", this.messageRepositories.listAll() );
		return "listemessage";
	}
	
}
