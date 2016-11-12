package org.usd232.hackathon.twentysixteen.providers.slack.json;

public class ApiTestResponse {
	private boolean ok;
	private String url;
	private String team;
	private String user;
	private String team_id;
	private String user_id;

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTeamId() {
		return team_id;
	}

	public void setTeamId(String team_id) {
		this.team_id = team_id;
	}

	public String getUserId() {
		return user_id;
	}

	public void setUserId(String user_id) {
		this.user_id = user_id;
	}
}
