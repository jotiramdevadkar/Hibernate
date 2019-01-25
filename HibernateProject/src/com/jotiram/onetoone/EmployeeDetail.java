package com.jotiram.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="employee_detail")
public class EmployeeDetail {

	@Id
	@Column(name="employee_id")
	@ForeignKey(name="FK_EMP_ID")
	@GenericGenerator(name="generator",strategy="foreign",parameters=@Parameter(name="property",value="employee"))
	@GeneratedValue(generator="generator")
	private Integer employeeId;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String Country;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="employee_id")
	@PrimaryKeyJoinColumn
	private Employee employee;

	public EmployeeDetail( String street, String city, String state, String country
			) {
		super();
		
		this.street = street;
		this.city = city;
		this.state = state;
		Country = country;
		
	}

	public EmployeeDetail() {
		super();
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeDetail [employeeId=" + employeeId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", Country=" + Country + ", employee=" + employee + "]";
	}
	
	
	
}
