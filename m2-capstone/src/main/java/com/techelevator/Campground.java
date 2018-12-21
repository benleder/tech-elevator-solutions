package com.techelevator;

import java.math.BigDecimal;

public class Campground {

	private int campgroundId;
	private int parkId;
	private String name;
	private int openFromMonth;
	private int openToMonth;
	private BigDecimal dailyFee;
	
	
	public int getCampgroundId() {
		return campgroundId;
	}
	public void setCampgroundId(int campgroundId) {
		this.campgroundId = campgroundId;
	}
	public int getParkId() {
		return parkId;
	}
	public void setParkId(int parkId) {
		this.parkId = parkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOpenFromMonth() {
		return openFromMonth;
	}
	public void setOpenFromMonth(int openFromMonth) {
		this.openFromMonth = openFromMonth;
	}
	public int getOpenToMonth() {
		return openToMonth;
	}
	public void setOpenToMonth(int openToMonth) {
		this.openToMonth = openToMonth;
	}
	public BigDecimal getDailyFee() {
		return dailyFee;
	}
	public void setDailyFee(BigDecimal dailyFee) {
		this.dailyFee = dailyFee;
	}
	
	@Override
	public String toString() {
		String result = "   ";
		result += String.format("#" + getCampgroundId() + "  ");
		result += String.format("%-35s", getName());
		result += String.format("%-10s", Utility.month(getOpenFromMonth()));
		result += String.format("%-10s", Utility.month(getOpenToMonth()));
		result += String.format("%6.2f", getDailyFee());
		result += "\n";
		return result;
	}
	
	
	public static String toStringHeader() {
		String result = "   ";
		result += String.format("%-4s", "");
		result += String.format("%-35s", "Name");
		result += String.format("%-10s", "Open");
		result += String.format("%-10s", "");
		result += String.format("%-10s", "Nightly Rate");
		result += "\n";
		return result;

	}
}
