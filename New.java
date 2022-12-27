package student;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;







public class stud {
	
	public static  void delete1(String rn) {
		 getter_Setter f1=new getter_Setter();
		f1.setId(rn);
		
		SessionFactory sf= new Configuration().configure().addAnnotatedClass(getter_Setter.class).buildSessionFactory();	    Session s=sf.openSession();
		Transaction tx= s.beginTransaction();
		s.delete(f1);
		tx.commit();
		
	}
	
	public static  void update(String name,String rn,String m) {
		 getter_Setter f1=new getter_Setter();
		f1.setId(rn);
		f1.setName(name);
		f1.setMarks(m);
		SessionFactory sf= new Configuration().configure().addAnnotatedClass(getter_Setter.class).buildSessionFactory();	    Session s=sf.openSession();
	    Session st=sf.openSession();
		Transaction tx= s.beginTransaction();
		st.saveOrUpdate(f1);
		tx.commit();
		
	}
	
	public static void display() {
		getter_Setter f1=new getter_Setter();
		
		
		SessionFactory sf= new Configuration().configure().addAnnotatedClass(getter_Setter.class).buildSessionFactory();	    Session s=sf.openSession();
	    Session st=sf.openSession();
		Transaction tx= s.beginTransaction();
		org.hibernate.query.Query q=s.createQuery("from getter_Setter");
		List<getter_Setter> l =(List<getter_Setter>) ((org.hibernate.query.Query) q).list();
	
		Iterator it = l.iterator();
		System.out.println("List of students:");
		while (it.hasNext()) {
			f1 = (getter_Setter) it.next();
			System.out.println(f1.toString());
			
		}
		tx.commit();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 getter_Setter f=new getter_Setter();
    	 Scanner sc=new Scanner(System.in);
    while(true) {
    	
    	System.out.println("1-insert \n 2-delete \n 3-update \n 4-display \n 5-exit \n");
    	System.out.println("enter choice");
    	int i= sc.nextInt();
    	if(i==1) {
    		
    		System.out.println("enter the roll no");
    		String s1=sc.next();
    		System.out.println("enter the name");
    		String s=sc.next();
    		System.out.println("enter the Marks");
    		String s2=sc.next();
    		
    		 f.setId(s1);
    		f.setName(s);
    		f.setMarks(s2);	
    			
    			
    		
    		Configuration con =new Configuration().configure().addAnnotatedClass(getter_Setter.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    		SessionFactory sf= con.buildSessionFactory(reg);
		    Session st=sf.openSession();
			Transaction tx= st.beginTransaction();
			
			
			
			
			st.save(f);
			tx.commit();
			st.close();
    	}
    	else if(i ==2 ) {
    		System.out.println("enter the roll no");
    		String s1=sc.next();
    		delete1(s1);
    		
    	}
    	else if(i==3) {
    		System.out.println("enter the name");
    		String s=sc.next();
    		System.out.println("enter the roll no");
    		String s1=sc.next();
    		System.out.println("enter the roll no");
    		String s2=sc.next();
    		update(s,s1,s2);
    	}
    	else if(i==4) {
    		display();
    	}
    	else if(i==5) {
    		System.out.println("exiting..");
    		break;
    	}
    	else {
    		System.out.println("invalid choice");
    	}
    }
   	
	
	
}
}
