package org.usd232.hackathon.twentysixteen.providers.slack.json;

public class UserChannelRequest extends TokenRequest {
	private String channel;
	private String user;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public UserChannelRequest() {
	}

	public UserChannelRequest(String channel, String user, String token) {
		super(token);
		this.channel = channel;
		this.user = user;
	}
}
