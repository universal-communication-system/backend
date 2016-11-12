package org.usd232.hackathon.twentysixteen.providers.slack.json;

public class Topic {
	private String value;
	private String creator;
	private long last_set;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public long getLastSet() {
		return last_set;
	}

	public void setLastSet(long last_set) {
		this.last_set = last_set;
	}
}
