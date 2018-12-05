package com.amulya.annotation.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Print {
@SuppressWarnings("resource")
public static void main(String[] args) {
	ApplicationContext context = new FileSystemXmlApplicationContext
	         ("C:\\Users\\KH2018\\workspace\\SpringProject\\src\\com\\amulya\\annotation\\spring\\Beans.xml");
	      
		  Vendor obj = (Vendor) context.getBean("vendor");
	      obj.getLaptopInfo();
	      System.out.println(obj.getLaptop());
}
}
