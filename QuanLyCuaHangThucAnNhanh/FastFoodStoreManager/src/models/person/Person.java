package models.person;

import java.util.Date;

import constant.Password;
import models.PersonObserver;

public class Person {
	private String id;
	private String cccd;
	private String name;
	private Date dateOfBirth;
	private String sex;
	private String image;
	private String address;
	private String phone;
	private Account account;

	public Person(String name, String phone, String email, String password) {
		this.name = name;
		this.phone = phone;
		this.account = new Account(email, password);
	}

	public Person(String cccd, String name, Date dateOfBirth, String sex, String address, String email, String phone,
			Date expiredDate) {
		this.cccd = cccd;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.account = new Account(email, Password.DEFAULT_PASSWORD, expiredDate);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void updateInformation(String cccd, String name, Date dob, String sex, String phone, String email,
			String address) {
		setCccd(cccd);
		setName(name);
		setDateOfBirth(dob);
		setSex(sex);
		setPhone(phone);
		setAddress(address);
		this.account.setEmail(email);
	}

	public boolean login(String email, String password) {
		return this.account.validateAccount(email, password);
	}

	public boolean changePassword(String currentPassword, String newPassword) {
		return this.account.changePassword(currentPassword, newPassword);
	}

	public boolean equalPerson(Person person) {
		return this.account.getEmail().equals(person.getAccount().getEmail());
	}

	@Override
	public String toString() {
		return null;
	}

}
