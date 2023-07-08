package models.person.employee;

import java.util.ArrayList;
import java.util.List;

public class TimeWork {
	private int month;
	private int year;
	private List<TimeSheet> timeSheeats;

	public TimeWork(int month, int year) {
		this.month = month;
		this.year = year;
		this.timeSheeats = new ArrayList<>();
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<TimeSheet> getTimeSheeats() {
		return timeSheeats;
	}

	public void setTimeSheeats(List<TimeSheet> timeSheeats) {
		this.timeSheeats = timeSheeats;
	}

	public void addTime(TimeSheet timeSheet) {
		this.timeSheeats.add(timeSheet);
	}
}
