package org.usd232.hackathon.twentysixteen.providers.mock;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.usd232.hackathon.twentysixteen.authentication.UserInfo;
import org.usd232.hackathon.twentysixteen.model.Capabilities;
import org.usd232.hackathon.twentysixteen.model.Chat;
import org.usd232.hackathon.twentysixteen.model.MemberChange;
import org.usd232.hackathon.twentysixteen.model.Message;
import org.usd232.hackathon.twentysixteen.providers.IMessageProvider;

public class MockProvider implements IMessageProvider {
	@Override
	public UUID registerAccount(UserInfo user, String token) {
		return null;
	}

	@Override
	public Capabilities getCapabilities() {
		return new Capabilities(true, true, true, true, true, true, true, true, true, true, false);
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
		if ( account == UUID.fromString("00000000-0000-0000-0000-000100000000") ) {
			return Arrays
					.asList(new Chat("direct", "alexwebber", UUID.fromString("00000000-0000-0000-0001-000000000000"),
							Arrays.asList(new Message("zachdeibert", "Hello, world!", 12345678, null),
									new Message("hanavankuhn", "Hello!", 12355678, null), new Message("zachdeibert",
											"This is <b>bolded</b>!", 12359678, null))));
		} else {
			return null;
		}
	}

	@Override
	public List<Message> getMessages(UserInfo user, UUID account, UUID chat) {
		if ( account == UUID.fromString("00000000-0000-0000-0000-000100000000")
				&& chat == UUID.fromString("00000000-0000-0000-0001-000000000000") ) {
			return Arrays.asList(new Message("zachdeibert", "Hello, world!", 12345678, null),
					new Message("hanavankuhn", "Hello!", 12355678, null),
					new Message("zachdeibert", "This is <b>bolded</b>!", 12359678, null));
		}
		return null;
	}

	@Override
	public Chat getChat(UserInfo user, UUID account, UUID chat) {
		return getChats(user, account).get(0);
	}

	@Override
	public Message getMessage(UserInfo user, UUID account, UUID chat, UUID message) {
		return getMessages(user, account, chat).get(0);
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
