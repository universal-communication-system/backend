package org.usd232.hackathon.twentysixteen.providers.slack.json;

import java.util.List;

public class UserList {
	private boolean ok;
	private List<User> members;

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}
}
