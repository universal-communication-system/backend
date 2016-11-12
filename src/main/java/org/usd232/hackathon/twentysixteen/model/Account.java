package org.usd232.hackathon.twentysixteen.model;

import java.util.List;
import java.util.UUID;

public class Account {
	private String type;
	private String name;
	private String category;
	private UUID id;
	private List<Chat> chats;
	
	public Account(){
	    
	}

	public Account(String type, String name, String category, UUID id, List<Chat> chats)
    {
        this.type = type;
        this.name = name;
        this.category = category;
        this.id = id;
        this.chats = chats;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public List<Chat> getChats() {
		return chats;
	}

	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}
}
