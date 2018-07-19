package com.qa.repository;

public interface AccountRepository {

	public String findAllTrainees();
	
	public String createTrainee(String trainee); 
	
	public String deleteTrainee(Long id);
	
	public String updateTrainee(Long id, String traineeToUpdate);
}
