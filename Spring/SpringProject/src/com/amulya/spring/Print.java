package com.amulya.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Print {
@SuppressWarnings("resource")
public static void main(String[] args) {
	      ApplicationContext context = new FileSystemXmlApplicationContext
	         ("C:\\MyRepo\\JavaPractise\\Spring\\SpringProject\\src\\com\\amulya\\spring\\Beans.xml");
	     
		  Vendor obj = (Vendor) context.getBean("Vendor");
	      obj.getLaptopInfo();
	      System.out.println(obj.hashCode());
	      Vendor obj1 = (Vendor) context.getBean("Vendor");
	      obj1.getLaptopInfo();
	      System.out.println(obj1.hashCode());
	      
	      ((AbstractApplicationContext)context).registerShutdownHook();
}
}
