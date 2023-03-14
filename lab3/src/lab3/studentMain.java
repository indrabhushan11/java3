package lab3;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class studentMain {

	SessionFactory sc1=new Configuration().configure().buildSessionFactory();
	Scanner sc=new Scanner(System.in);
	
	Session session = sc1.openSession();
	
	Transaction t1 = session.beginTransaction();


	
	public void insert(int usn, String name) {
		student st1 = new student();
		st1.setUsn(usn);
		st1.setName(name);
		Session s=sc1.openSession();
		Transaction t1= s.beginTransaction();
		s.save(st1);
		t1.commit();
		}

	public void delete(int usn) {
    	student st1 = new student();
    	
        st1.setUsn(usn);
        
        Session s=sc1.openSession();
		Transaction t1= s.beginTransaction();
		s.delete(st1);
		t1.commit();
		}
	
	public void update(int usn, String name) {
		
    	student st1 = new student();
    	
     	   st1.setUsn(usn);
            st1.setName(name);
             Session s=sc1.openSession();
			Transaction t1= s.beginTransaction();
			s.saveOrUpdate(st1);
			t1.commit();
                             
} 
	 	   
            		
	public  void display() {
		Session s=sc1.openSession();
		Transaction t1= s.beginTransaction();
		Query q = s.createQuery("from student");
		List l = q.getResultList();

		Iterator it = l.iterator();
		System.out.println("List of students:");
		while (it.hasNext()) {
			student stud = (student) it.next();
			System.out.println(stud.getName().toString()+":"+stud.getUsn());	
		}
		t1.commit();
	}

	public static void main(String[] args)
	{
		studentMain stud = new studentMain();
		Scanner sc = new Scanner(System.in); 

		flag: while (true) 
		{
			System.out.println("\n Menu \n1:Insert \n2:Update \n3:Delete \n4:Display \n5:Search \n6:Exit");
			System.out.print("Enter your choice: ");
			int ch = sc.nextInt(); 
			switch (ch) {
			case 1: 
				System.out.print("Enter the student Details to insert \n");
				System.out.print("Enter the usn \n");
				int usn = sc.nextInt();
				System.out.print("Enter the student name \n");
				String name = sc.next();
				stud.insert(usn,name);
				break;			
			case 2:
				System.out.print("Enter the Usn \n");
				int usn1 = sc.nextInt();
				System.out.print("Enter the student name \n");
				String name1 = sc.next();
				stud.update(usn1,name1);
				break;
				
				
			case 3:
				System.out.print("Enter the Usn \n");
				int usn2 = sc.nextInt();
				stud.delete(usn2);
				break;
			case 4:
				stud.display();
				break;
			case 6:
				break flag;
	
	        default:
				System.out.println("Invalid choice! \n\n");
			}
		}
	}
}
