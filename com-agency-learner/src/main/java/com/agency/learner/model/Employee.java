package com.agency.learner.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private String staffid;
	private String name;
	
	public String getStaffId()
	{
		return staffid;
	}
	public String getName()
	{
		return name;
	}
	public void setId(String staffid)
	{
		this.staffid=staffid;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	@Override
    public String toString() {
        return "Employee{" + "staffid='" + staffid + '\'' + ", name='" + name +  '\'' + '}';
    }
}
