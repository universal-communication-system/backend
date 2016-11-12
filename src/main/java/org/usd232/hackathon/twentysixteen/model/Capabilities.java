package org.usd232.hackathon.twentysixteen.model;

public class Capabilities {
	private boolean membersModifiable;
	private boolean messageEditable;
	private boolean unreactable;
	private boolean reactable;
	private boolean chatCreatable;
	private boolean chatDeletable;
	private boolean messageDeletable;

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
}
