package com.qa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class Trainee {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "TraineeId")
	private Long id;
	private String name;
	@JoinColumn(name = "TraineeId")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Subjects> subjects;
		
	
	
	public Trainee() {
		
	}
	public Trainee(String name, List<Subjects> subjects) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void addSubject(Subjects subject) {
		subjects.add(subject);
	}
	public void removeTransaction(Subjects subject) {
		subjects.remove(subject);
	}
}
