package com.chainsys.servlet;

import java.util.ArrayList;

import com.chainsys.model.Donor;

public class Donors {
	ArrayList<Donor> donorRegister= new ArrayList<>();
	public void addDonor(String name,int age,String mobileNumber,String bloodGrp,String location) {
		Donor donarData =new Donor(name,age,mobileNumber,bloodGrp,location);
		donorRegister.add(donarData);
		System.out.println(donorRegister);
		 
	}
	public ArrayList<Donor> getDonorRegister() {
        return donorRegister;
    }
}

