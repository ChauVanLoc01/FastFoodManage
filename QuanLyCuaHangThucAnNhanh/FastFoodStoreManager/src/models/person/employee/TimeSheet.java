package models.person.employee;

import java.util.Date;

import constant.Time;

public class TimeSheet {
	private String title;
	private Date day;
	private boolean isLate = false;

	public TimeSheet() {
		this.day = new Date();
		this.title = "Working day is " + this.lableTime();
		if (isLate()) {
			this.isLate = true;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public void setLate(boolean isLate) {
		this.isLate = isLate;
	}

	public boolean getIsLate() {
		return this.isLate;
	}

	public Date startTime() {
		return new Date(this.day.getYear(), this.day.getMonth(), this.day.getDate(), Time.hour, Time.minute,
				Time.second);
	}

	private boolean isLate() {
		return this.day.after(startTime());
	}

	public String lableTime() {
		return this.day.getHours() + ":" + this.day.getMinutes() + ":" + this.day.getSeconds() + "  "
				+ this.day.getDate() + "/" + this.day.getMonth() + "/" + this.day.getYear();
	}
}
