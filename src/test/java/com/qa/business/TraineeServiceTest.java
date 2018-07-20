package com.qa.business;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.business.TraineeServiceImpl;
import com.qa.repository.TraineeRepository;

@RunWith(MockitoJUnitRunner.class)
public class TraineeServiceTest {
	
private static final String MOCK_VALUE = "TestValue";
	
	private static final String MOCK_VALUE2 = "TestValue2";
	
	@InjectMocks
	TraineeServiceImpl service;
	
	@Mock
	TraineeRepository repo;
	
	@Before
	public void setUp() {
		service.setRepo(repo);
	}
	
	@Test
	public void testFindAllTrainees() {
		Mockito.when(repo.findAllTrainees()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.findAllTrainees());
	}
	
	@Test
	public void testCreateTrainee() {
		Mockito.when(repo.createTrainee(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.createTrainee(MOCK_VALUE2));
		Mockito.verify(repo).createTrainee(MOCK_VALUE2);
	}
	
	@Test
	public void testUpdateTrainee() {
		Mockito.when(repo.updateTrainee(1L, MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.updateTrainee(1L, MOCK_VALUE2));
		Mockito.verify(repo).updateTrainee(1L, MOCK_VALUE2);
	}
	
	@Test
	public void testDeleteTrainee() {
		Mockito.when(repo.deleteTrainee(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.deleteTrainee(1L));
		Mockito.verify(repo).deleteTrainee(1L);
	}

}
