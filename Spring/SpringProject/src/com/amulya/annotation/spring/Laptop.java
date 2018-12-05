package com.amulya.annotation.spring;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
	String lname;
	String lid;
	List configurations;
	public String getLname() {
		return lname;
	}
	public List getConfigurations() {
		return configurations;
	}
	public void setConfigurations(List configurations) {
		this.configurations = configurations;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	@Override
	public String toString() {
		return "Laptop [lname=" + lname + ", lid=" + lid + ", configurations=" + configurations + "]";
	}
	
	
}
