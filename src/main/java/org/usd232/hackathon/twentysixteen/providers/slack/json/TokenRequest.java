package org.usd232.hackathon.twentysixteen.providers.slack.json;

public class TokenRequest {
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public TokenRequest() {
	}

	public TokenRequest(String token) {
		this.token = token;
	}
}
