package com.amulya.spring;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class Laptop implements InitializingBean,DisposableBean{
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
	
	public void init1() {
		
		System.out.println("[Laptop] Init using legacy way");
	}

	public void destroy2() {
		System.out.println("[Laptop] destroy using legacy way");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("[Laptop] Init using interface way");
		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("[Laptop] destroy using interface way");
		
	}
	
	
}
