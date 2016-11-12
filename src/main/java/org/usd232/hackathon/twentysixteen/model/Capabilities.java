package org.usd232.hackathon.twentysixteen.model;

public class Capabilities {
	private boolean membersModifiable;
	private boolean messageEditable;
	private boolean unreactable;
	private boolean reactable;
	private boolean chatCreatable;
	private boolean chatDeletable;
	private boolean messageDeletable;
	private boolean directMessages;
	private boolean groupMessages;
	private boolean publicMessages;
	private boolean objectMessages;

	public boolean isMembersModifiable() {
		return membersModifiable;
	}

	public void setMembersModifiable(boolean membersModifiable) {
		this.membersModifiable = membersModifiable;
	}

	public boolean isMessageEditable() {
		return messageEditable;
	}

	public void setMessageEditable(boolean messageEditable) {
		this.messageEditable = messageEditable;
	}

	public boolean isUnreactable() {
		return unreactable;
	}

	public void setUnreactable(boolean unreactable) {
		this.unreactable = unreactable;
	}

	public boolean isReactable() {
		return reactable;
	}

	public void setReactable(boolean reactable) {
		this.reactable = reactable;
	}

	public boolean isChatCreatable() {
		return chatCreatable;
	}

	public void setChatCreatable(boolean chatCreatable) {
		this.chatCreatable = chatCreatable;
	}

	public boolean isChatDeletable() {
		return chatDeletable;
	}

	public void setChatDeletable(boolean chatDeletable) {
		this.chatDeletable = chatDeletable;
	}

	public boolean isMessageDeletable() {
		return messageDeletable;
	}

	public void setMessageDeletable(boolean messageDeletable) {
		this.messageDeletable = messageDeletable;
	}

	public boolean isDirectMessages() {
		return directMessages;
	}

	public void setDirectMessages(boolean directMessages) {
		this.directMessages = directMessages;
	}

	public boolean isGroupMessages() {
		return groupMessages;
	}

	public void setGroupMessages(boolean groupMessages) {
		this.groupMessages = groupMessages;
	}

	public boolean isPublicMessages() {
		return publicMessages;
	}

	public void setPublicMessages(boolean publicMessages) {
		this.publicMessages = publicMessages;
	}

	public boolean isObjectMessages() {
		return objectMessages;
	}

	public void setObjectMessages(boolean objectMessages) {
		this.objectMessages = objectMessages;
	}

	public Capabilities() {
	}

	public Capabilities(boolean membersModifiable, boolean messageEditable, boolean unreactable, boolean reactable,
			boolean chatCreatable, boolean chatDeletable, boolean messageDeletable, boolean directMessages,
			boolean groupMessages, boolean publicMessages, boolean objectMessages) {
		this.membersModifiable = membersModifiable;
		this.messageEditable = messageEditable;
		this.unreactable = unreactable;
		this.reactable = reactable;
		this.chatCreatable = chatCreatable;
		this.chatDeletable = chatDeletable;
		this.messageDeletable = messageDeletable;
		this.directMessages = directMessages;
		this.groupMessages = groupMessages;
		this.publicMessages = publicMessages;
		this.objectMessages = objectMessages;
	}
}
