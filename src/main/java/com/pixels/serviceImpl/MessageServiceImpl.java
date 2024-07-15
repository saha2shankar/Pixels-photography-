package com.pixels.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixels.Repository.MessagesReprository;
import com.pixels.Service.MessagesService;
import com.pixels.models.Messages;

@Service
public class MessageServiceImpl implements MessagesService{
	
	@Autowired
	private MessagesReprository repo;

	@Override
	public void addmessge(Messages messages) {
		repo.save(messages);
		
		
		
	}

	@Override
	public List<Messages> getAllMessagesSortedByTimestampDesc() {
		 List<Messages> messages = repo.findAll(); // Fetch all messages from repository

	        // Sort messages by timestamp in descending order using Java Stream API
	        List<Messages> sortedMessages = messages.stream()
	                .sorted((m1, m2) -> m2.getTimestamp().compareTo(m1.getTimestamp()))
	                .collect(Collectors.toList());

	        return sortedMessages;
	}

}
