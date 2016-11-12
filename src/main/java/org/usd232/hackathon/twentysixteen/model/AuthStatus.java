package org.usd232.hackathon.twentysixteen.model;

public class AuthStatus {
	private boolean authenticated;
	private String name;

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
