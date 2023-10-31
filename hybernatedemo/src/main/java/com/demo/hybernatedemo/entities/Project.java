package com.demo.hybernatedemo.entities;
 
import java.util.List;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
 
@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prjId;
	private String prjName;
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;
	public Project(int prjId, String prjName) {
		this.prjId = prjId;
		this.prjName = prjName;
	}
	public Project(String prjName) {
		this.prjName = prjName;
	}
	public Project() {
	}
	public int getPrjId() {
		return prjId;
	}
	public void setPrjId(int prjId) {
		this.prjId = prjId;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Project [prjId=" + prjId + ", prjName=" + prjName + "]";
	}
	
	
 
}
 