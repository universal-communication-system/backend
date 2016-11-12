package org.usd232.hackathon.twentysixteen.providers;

import java.util.UUID;

public interface IMessageProvider {

	public boolean isReactable();

	public void unreact(UUID message, UUID chat, UUID account, UUID user, String reaction);

	public void react(UUID message, UUID chat, UUID account, UUID user, String reaction);

	public boolean isMessageEditable();

	public void editMessage(UUID accounts, UUID chat, UUID messageId, String messageContent);

	public boolean isChatEditable();

	public boolean isMessageDeletable();

	public void deleteMessage(UUID accounts, UUID chat, UUID message);

	public boolean isMessageChatDeletable();

	public void deleteChat(UUID accounts, UUID chat);

	public void createChat(UUID accounts, String chat);
}
