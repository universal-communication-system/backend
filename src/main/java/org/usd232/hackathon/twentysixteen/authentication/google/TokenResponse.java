package org.usd232.hackathon.twentysixteen.authentication.google;

public class TokenResponse {
	private String access_token;
	private String id_token;
	private String expires_in;
	private String token_type;
	private String refresh_token;

	public String getAccessToken() {
		return access_token;
	}

	public void setAccessToken(String access_token) {
		this.access_token = access_token;
	}

	public String getIdToken() {
		return id_token;
	}

	public void setIdToken(String id_token) {
		this.id_token = id_token;
	}

	public String getExpiresIn() {
		return expires_in;
	}

	public void setExpiresIn(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getTokenType() {
		return token_type;
	}

	public void setTokenType(String token_type) {
		this.token_type = token_type;
	}

	public String getRefreshToken() {
		return refresh_token;
	}

	public void setRefreshToken(String refresh_token) {
		this.refresh_token = refresh_token;
	}
}
