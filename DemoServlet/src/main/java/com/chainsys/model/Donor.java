package com.chainsys.model;

public class Donor {
	int id;
	String donorName;
	int age;
	String mobileNumber;
	String bloodGrp;
	String location;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getBloodGrp() {
		return bloodGrp;
	}
	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "DonorModel [donorName=" + donorName + ", age=" + age + ", mobileNumber=" + mobileNumber + ", bloodGrp="
				+ bloodGrp + ", location=" + location + "]";
	}
	public Donor(String donorName, int age, String mobileNumber, String bloodGrp, String location) {
		
		this.donorName = donorName;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.bloodGrp = bloodGrp;
		this.location = location;
	}
	public Donor()
	{
		
	}
}
