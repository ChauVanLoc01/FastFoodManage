package models;

import java.util.Date;

import constant.GenerateId;

public class Vourcher {
	private String code;
	private double cost;
	private Date startDate;
	private Date expiredDate;

	public Vourcher(String code, double cost, Date startDate, Date expiredDate) {
		this.code = code;
		this.cost = cost;
		this.startDate = startDate;
		this.expiredDate = expiredDate;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public boolean equal(Vourcher vourcher) {
		if (this.code.equals(vourcher.code)) {
			return true;
		}
		return false;
	}

}
