package com.qa.business;

import javax.inject.Inject;


import com.qa.repository.TraineeRepository;




public class TraineeServiceImpl implements TraineeService {
	
	@Inject
	private TraineeRepository repo;
	
	public String createTrainee(String trainee) {	
		return repo.createTrainee(trainee);	
	}

	public String deleteTrainee(Long id) {
		
		return repo.deleteTrainee(id);
	}

	public String updateTrainee(Long id, String accountToUpdate) {
		
		
		return repo.updateTrainee(id, accountToUpdate);
		
	}
	
	public void setRepo(TraineeRepository repo) {
		this.repo = repo;
	}


	public String findAllTrainees() {
		
	 return repo.findAllTrainees();
	}
}
