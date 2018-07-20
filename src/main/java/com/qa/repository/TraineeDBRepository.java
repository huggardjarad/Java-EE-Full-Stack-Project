package com.qa.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.constants.Constants;
import com.qa.domain.Trainee;



import com.qa.utils.*;

public class TraineeDBRepository implements TraineeRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JsonUtil util;  
	
	public String findAllTrainees(){
		TypedQuery<Trainee> query = manager.createQuery("SELECT a FROM Trainee a", Trainee.class);
		
		List<Trainee> trainee = query.getResultList();
		
		return util.getJsonForObject(trainee);
	}
	
	public Trainee getATrainee(Long id) {
		return manager.find(Trainee.class, id) ;
	}
	
	@Transactional(TxType.REQUIRED)
	public String createTrainee(String trainee) {
		
		Trainee trainee1  = util.getObjectForJson(trainee, Trainee.class);
		manager.persist(trainee1);
		return Constants.ACCOUNTCREATED;
	}
	
	@Transactional(TxType.REQUIRED)
	public String deleteTrainee(Long id) {
		Trainee traineeInDB = getATrainee(id);
		if(traineeInDB != null) {
			manager.remove(traineeInDB);
		}
	 return Constants.ACCOUNTDELETED;
	}
	
	@Transactional(TxType.REQUIRED)
	public String updateTrainee(Long id, String traineeToUpdate){
		Trainee updatedTrainee = util.getObjectForJson(traineeToUpdate, Trainee.class);
		Trainee traineeFromDB = getATrainee(id);
		if (traineeToUpdate != null) {
			traineeFromDB = updatedTrainee;
			traineeFromDB.setId(id);
			manager.merge(traineeFromDB);
		}
	
		return Constants.ACCOUNTUPDATED;
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JsonUtil util) {
		this.util = util;
	}
}
