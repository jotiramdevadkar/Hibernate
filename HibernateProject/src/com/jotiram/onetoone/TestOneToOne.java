package com.jotiram.onetoone;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jotiram.util.HibernateUtil;

public class TestOneToOne {

	
	public static void main(String[] args) {
		Session session=HibernateUtil.getSession();
		Employee emp=new Employee("Jotiram", "Devadkar", new Date(0), "");
		session.save(emp);
		
		System.out.println(emp.getEmployeeId());
		EmployeeDetail empDetail= new EmployeeDetail( "street1", "Pune", "Maharashtra", "India");
		emp.setEmployeedetail(empDetail);
		
		empDetail.setEmployee(emp);
		session.saveOrUpdate(emp);
		
		session.beginTransaction().commit();
		session.close();
		
		
		session =HibernateUtil.getSession();
		Employee employee=(Employee) session.get(Employee.class.getCanonicalName(),emp.getEmployeeId());
		//session.delete(employee);
		
		session.beginTransaction().commit();
		System.out.println(employee.getFirstName()+" : "+employee.getEmployeedetail().getCity());
		session.close();
		
		session =HibernateUtil.getSession();
		EmployeeDetail eDetail=(EmployeeDetail) session.get(EmployeeDetail.class, employee.getEmployeeId());
		System.out.println(eDetail.getCity()+" : "+eDetail.getEmployee().getFirstName());
		System.out.println("Hibernate one-to-one example (Annotation) ");
		
		session=HibernateUtil.getSession();
		EmployeeDetail employeeDetail =new EmployeeDetail("10th street", "LA", "san Francisco", "U.S");
				
		Employee employee2=new Employee("Nina", "mayers", new Date(121212), "114-857-965");
		employee.setEmployeedetail(employeeDetail);
		employeeDetail.setEmployee(employee2);
		session.save(employeeDetail);
		session.beginTransaction().commit();
		
		System.out.println("=============Querying all Results=========");
		List<Employee> employees =session.createQuery("from Employee").list();
		for(Employee employee1 : employees)
		{
			System.out.println(employee1.getFirstName()+","+employee1.getLastName()+","+employee1.getEmployeedetail().getState());
		}
		
		session.beginTransaction().commit();
		session.close();
	}
}
