package models;

import java.util.Date;

public class Notification {
	private String title;
	private String content;
	private Date sendingDate;
	private boolean isRead = false;
	private Vourcher vourcher = null;

	public Notification(String title, String content) {
		this.title = title;
		this.content = content;
		this.sendingDate = new Date();
	}

	public Notification(String title, String content, Vourcher vourcher) {
		this.title = title;
		this.content = content;
		this.vourcher = vourcher;
		this.sendingDate = new Date();
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendingDate() {
		return sendingDate;
	}

	public void setSendingDate(Date sendingDate) {
		this.sendingDate = sendingDate;
	}

	public Vourcher getVourcher() {
		return vourcher;
	}

	public void setVourcher(Vourcher vourcher) {
		this.vourcher = vourcher;
	}

}
