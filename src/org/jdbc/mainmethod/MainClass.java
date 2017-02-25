package org.jdbc.mainmethod;

import org.jdbc.dao.DaoImpl;
import org.jdbc.model.Triangle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String args[]  ) {
		
		System.out.println("aftr main");
     
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
      DaoImpl dao = ctx.getBean("daoImpl", DaoImpl.class);
           
     Triangle triangle = dao.getTriangle(2);
      
      System.out.println("dao");
    
		
	
		if(triangle != null){
			System.out.println("there is a value");
		}
		else{
			System.out.println("null value");
		}
		System.out.println(triangle.getName());
		
		
           
	}

}
