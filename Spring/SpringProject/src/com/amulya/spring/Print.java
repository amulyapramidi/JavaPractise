package com.amulya.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Print {
@SuppressWarnings("resource")
public static void main(String[] args) {
	ApplicationContext context = new FileSystemXmlApplicationContext
	         ("C:\\Users\\KH2018\\workspace\\SpringProject\\src\\Beans.xml");
	      
		  Vendor obj = (Vendor) context.getBean("Vendor");
	      obj.getLaptopInfo();
	      System.out.println(obj.getLaptop());
}
}
