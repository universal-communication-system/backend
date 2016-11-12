package org.usd232.hackathon.twentysixteen.model;

import java.util.List;
import java.util.UUID;

public class Chat {
	private String type;
	private String name;
	private UUID id;
	private List<Message> messages;
	
	public Chat(){
	    
	}
	
	public Chat(String type, String name, UUID id, List<Message> messages){
	    this.type = type;
	    this.name = name;
	    this.id = id;
	    this.messages = messages;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
}
