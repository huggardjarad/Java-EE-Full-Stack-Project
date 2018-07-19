package com.qa.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Subjects {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	private String subjectName;
	@Size(min = 1, max = 5)
	private int subjectRating; 
	
	
	public Subjects(Long id, String subjectName, int subjectRating) {
		this.id = id;
		this.subjectName = subjectName;
		this.subjectRating = subjectRating;
	}
	
	public Subjects() {}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getSubjectRating() {
		return subjectRating;
	}
	public void setSubjectRating(int subjectRating) {
		this.subjectRating = subjectRating;
	}

}
