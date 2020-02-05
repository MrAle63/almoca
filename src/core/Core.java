package core;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import engine.*;
import entity.*;


public class Core {
	
	public static void main(String[] args) {
		initDavidTest();
		
	}
	
	private static void initDavidTest() {
		Instructor david = new Instructor();
		Course c1 = new Course();
		Course c2 = new Course();
		Review r1 = new Review();
		Review r2 = new Review();
		Review r3 = new Review();
		Student alejandro = new Student();
		Student kevin = new Student();
		List<Object> list_object = new ArrayList<Object>();
		
		david.setFirst_name("David");
		david.setLast_name("GoodEnough");
		david.setEmail("David.GoodEnough@GoodForyou.fr");
		
		c1.setTitle("KravMaga");
		c1.setInstructor(david);
		c2.setTitle("Mathématiques");
		c2.setInstructor(david);
		
		alejandro.setFirst_name("Alejandro");
		alejandro.setLast_name("yoloSwalou");
		alejandro.setEmail("monmail.com");
		
		alejandro.setOneCourse_list(c1);
		//c1.setOneStudent_list(alejandro);
		
		kevin.setFirst_name("Kevin");
		kevin.setLast_name("DeGuerre");
		kevin.setEmail("jevinou.com");
		
		kevin.setOneCourse_list(c2);
		//c2.setOneStudent_list(kevin);
		
		
		r1.setComment("Incroyable");
		r2.setComment("Epatant");
		r3.setComment("Dangereux");
		
		c1.setOneReview_list(r1);
		c1.setOneReview_list(r2);
		c2.setOneReview_list(r3);
		list_object.add(david);
		list_object.add(c1);
		list_object.add(c2);
		list_object.add(r1);
		list_object.add(r2);
		list_object.add(r3);
		list_object.add(alejandro);
		list_object.add(kevin);
		
		SessionManager sM = new SessionManager();	
		Insert.insert(list_object,sM);
		
		
	}
	
	
}
