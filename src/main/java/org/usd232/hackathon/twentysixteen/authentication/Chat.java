package org.usd232.hackathon.twentysixteen.authentication;

import java.util.UUID;

public class Chat {
	private final String type;
	private final String name;
	private final String category;
	private final UUID id;

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}
	
	public String getCategory(){
		return category;
	}
	
	public UUID getUUID(){
		return id;
	}
	
	public Chat(UUID id, String type, String name, String category) {
			this.id = id;
			this.type = type;
			this.name = name;
			this.category = category;
	}

}
