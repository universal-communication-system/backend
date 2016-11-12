package org.usd232.hackathon.twentysixteen.providers.slack.json;

public class Channel {
	private String id;
	private String name;
	private long created;
	private boolean is_archived;
	private boolean is_member;
	private int num_members;
	private Topic topic;
	private Topic purpose;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCreated() {
		return created;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	public boolean isIsArchived() {
		return is_archived;
	}

	public void setIsArchived(boolean is_archived) {
		this.is_archived = is_archived;
	}

	public boolean isIsMember() {
		return is_member;
	}

	public void setIsMember(boolean is_member) {
		this.is_member = is_member;
	}

	public int getNumMembers() {
		return num_members;
	}

	public void setNumMembers(int num_members) {
		this.num_members = num_members;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Topic getPurpose() {
		return purpose;
	}

	public void setPurpose(Topic purpose) {
		this.purpose = purpose;
	}
}
