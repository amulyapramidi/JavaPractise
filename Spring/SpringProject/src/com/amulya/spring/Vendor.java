package com.amulya.spring;

public class Vendor {

Laptop Laptop;


public Laptop getLaptop() {
	return Laptop;
}


public void setLaptop(Laptop laptop) {
	Laptop = laptop;
}


public void getLaptopInfo() {
	System.out.println("LaptopName : "+Laptop.getLname());
}
public void init() {
	System.out.println("[Vendor] init");

}
public void destroy() {
	System.out.println("[Vendor] destroy");

}
}
