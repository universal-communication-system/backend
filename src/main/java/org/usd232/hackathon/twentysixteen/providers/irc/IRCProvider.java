package org.usd232.hackathon.twentysixteen.providers.irc;

import java.util.List;
import java.util.UUID;

import org.usd232.hackathon.twentysixteen.authentication.UserInfo;
import org.usd232.hackathon.twentysixteen.model.Capabilities;
import org.usd232.hackathon.twentysixteen.model.Chat;
import org.usd232.hackathon.twentysixteen.model.MemberChange;
import org.usd232.hackathon.twentysixteen.model.Message;
import org.usd232.hackathon.twentysixteen.providers.IMessageProvider;

public class IRCProvider implements IMessageProvider {
	@Override
	public UUID registerAccount(UserInfo user, String token) {
		return null;
	}

	@Override
	public Capabilities getCapabilities() {
		return new Capabilities(false, false, false, false, false, false, false, false, false, true, false);
	}

	@Override
	public void modifyMembers(UserInfo user, UUID account, UUID chat, MemberChange change) {
	}

	@Override
	public void editMessage(UserInfo user, UUID account, UUID chat, UUID message, String content) {
	}

	@Override
	public void unreact(UserInfo user, UUID account, UUID chat, UUID message, String reaction) {
	}

	@Override
	public List<Chat> getChats(UserInfo user, UUID account) {
		return null;
	}

	@Override
	public List<Message> getMessages(UserInfo user, UUID account, UUID chat) {
		return null;
	}

	@Override
	public Chat getChat(UserInfo user, UUID account, UUID chat) {
		return null;
	}

	@Override
	public Message getMessage(UserInfo user, UUID account, UUID chat, UUID message) {
		return null;
	}

	@Override
	public void postMessage(UserInfo user, UUID account, UUID chat, String content) {
	}

	@Override
	public void react(UserInfo user, UUID account, UUID chat, UUID message, String reaction) {
	}

	@Override
	public void createChat(UserInfo user, UUID account, String name, String type, List<String> users) {
	}

	@Override
	public void deleteChat(UserInfo user, UUID account, UUID chat) {
	}

	@Override
	public void deleteMessage(UserInfo user, UUID account, UUID chat, UUID message) {
	}
}
