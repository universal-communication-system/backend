package org.usd232.hackathon.twentysixteen.providers;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.message.Message;
import org.usd232.hackathon.twentysixteen.authentication.UserInfo;
import org.usd232.hackathon.twentysixteen.model.Capabilities;
import org.usd232.hackathon.twentysixteen.model.Chat;
import org.usd232.hackathon.twentysixteen.model.MemberChange;

public interface IMessageProvider {
	public UUID registerAccount(UserInfo user, String token);

	public Capabilities getCapabilities();

	public void modifyMembers(UserInfo user, UUID account, UUID chat, MemberChange change);

	public void editMessage(UserInfo user, UUID account, UUID chat, UUID message, String content);

	public void unreact(UserInfo user, UUID account, UUID chat, UUID message, String reaction);

	public List<Chat> getChats(UserInfo user, UUID account);

	public List<Message> getMessages(UserInfo user, UUID account, UUID chat);

	public Chat getChat(UserInfo user, UUID account, UUID chat);

	public Message getMessage(UserInfo user, UUID account, UUID chat, UUID message);

	public void postMessage(UserInfo user, UUID account, UUID chat, String content);

	public void react(UserInfo user, UUID account, UUID chat, UUID message, String reaction);

	public void createChat(UserInfo user, UUID account, String name, String type, List<String> users);

	public void deleteChat(UserInfo user, UUID account, UUID chat);

	public void deleteMessage(UserInfo user, UUID account, UUID chat, UUID message);
}
