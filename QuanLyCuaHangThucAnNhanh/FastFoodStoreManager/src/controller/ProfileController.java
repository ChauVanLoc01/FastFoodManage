package controller;

import java.util.Date;

import models.PersonObserver;
import views.Profile;

public class ProfileController {
	private PersonObserver personObserver;

	public ProfileController(PersonObserver personObserver) {
		this.personObserver = personObserver;
	}

	public PersonObserver getPersonObserver() {
		return personObserver;
	}

	public PersonObserver updateProfile(String cccd, String name, Date dob, String sex, String phone, String email,
			String address) {
		this.personObserver.updateInformation(cccd, name, dob, sex, phone, email, address);
		Date date = this.personObserver.getPerson().getDateOfBirth();
		return personObserver;
	}
	
	public boolean changePassword(String currentPassword, String newPassword) {
		return this.personObserver.changePassword(currentPassword, newPassword);
	}

}
