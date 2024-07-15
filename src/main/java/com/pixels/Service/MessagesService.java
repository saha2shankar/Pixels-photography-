package com.pixels.Service;

import java.util.List;

import com.pixels.models.Messages;

public interface MessagesService {
	
	void addmessge(Messages messages);
	List<Messages> getAllMessagesSortedByTimestampDesc();

}
