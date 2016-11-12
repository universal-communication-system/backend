package org.usd232.hackathon.twentysixteen.authentication;

public class UserInfo {
	private final int id;
	private final String name;

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public UserInfo(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
