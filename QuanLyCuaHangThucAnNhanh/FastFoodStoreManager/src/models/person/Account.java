package models.person;

import java.util.Date;

import constant.Rule;

public class Account {
	private String email;
	private String password;
	private boolean status = true;
	private Date createdDate = new Date();
	private Date expireDate = null;

	public Account(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Account(String email, String password, Date expireDate) {
		this.email = email;
		this.password = password;
		this.expireDate = expireDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public boolean checkFormatEmail(String email) {
		return true;
	}

	public boolean checkFormatPassword(String password) {
		return true;
	}

	public boolean validateAccount(String email, String password) {
		return this.status && checkFormatEmail(email) && checkFormatPassword(password) && this.email.equals(email)
				&& this.password.equals(password);
	}

	public boolean changePassword(String currentPassword, String newPassword) {
		if (this.password.equals(currentPassword)) {
			setPassword(newPassword);
			return true;
		}
		return false;
	}

}
