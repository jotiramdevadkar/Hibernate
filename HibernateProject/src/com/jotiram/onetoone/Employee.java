package com.jotiram.onetoone;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Integer employeeId;
	
	@Column(name="first_name",nullable =false)
	private String firstName;
	
	@Column(name="last_name",nullable=true)
	private String lastName;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@Column(name="cell_phone")
	private String cellPhone;
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="employee")
	@JoinColumn(name="employee_id")
	private EmployeeDetail employeedetail;

	public Employee() {
		super();
	}

	public Employee( String firstName, String lastName, Date birthDate, String cellPhone
			) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.cellPhone = cellPhone;
		
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public EmployeeDetail getEmployeedetail() {
		return employeedetail;
	}

	public void setEmployeedetail(EmployeeDetail employeedetail) {
		this.employeedetail = employeedetail;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthDate=" + birthDate + ", cellPhone=" + cellPhone + ", employeedetail=" + employeedetail + "]";
	}
	
	
}
