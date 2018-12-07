package com.amulya.annotation.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class Vendor {

@Autowired
Laptop laptop;




public Laptop getLaptop() {
	return laptop;
}




public void setLaptop(Laptop laptop) {
	this.laptop = laptop;
}




public void getLaptopInfo() {
	System.out.println("LaptopName : "+laptop.getLname());
}

}
