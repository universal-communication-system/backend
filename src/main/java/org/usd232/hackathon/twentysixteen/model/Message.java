package org.usd232.hackathon.twentysixteen.model;

import java.util.List;
import java.util.Map;

public class Message {
	private String sender;
	private String message;
	private long time;
	private Map<String, List<String>> reactions;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public Map<String, List<String>> getReactions() {
		return reactions;
	}

	public void setReactions(Map<String, List<String>> reactions) {
		this.reactions = reactions;
	}
}
