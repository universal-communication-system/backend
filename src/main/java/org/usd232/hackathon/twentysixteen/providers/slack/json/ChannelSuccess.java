package org.usd232.hackathon.twentysixteen.providers.slack.json;

public class ChannelSuccess {
	private boolean ok;
	private Channel channel;

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
}
