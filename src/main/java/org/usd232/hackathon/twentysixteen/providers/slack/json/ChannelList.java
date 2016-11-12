package org.usd232.hackathon.twentysixteen.providers.slack.json;

import java.util.List;

public class ChannelList {
	private boolean ok;
	private List<Channel> channels;

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
}
