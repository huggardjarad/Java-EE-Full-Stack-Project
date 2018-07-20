package com.qa.interoperability;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.business.TraineeService;

@RunWith(MockitoJUnitRunner.class)
public class TraineeEndpointTest {

	private static final String MOCK_VALUE = "testValue";
	
	private static final String MOCK_VALUE2 = "testValue2";
	
	
	
	@InjectMocks
	private TraineeEndpoint endpoint;
	
	@Mock
	private TraineeService service;
	
	@Before
	public void setUp() {
		endpoint.setService(service);
	}
	
	
	@Test
	public void testFindAllTrainees() {
		Mockito.when(service.findAllTrainees()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.findAllTrainees());
	}
	
	@Test
	public void testCreateTrainee() {
		Mockito.when(service.createTrainee(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.createTrainee(MOCK_VALUE2));
		Mockito.verify(service).createTrainee(MOCK_VALUE2);
	}
	@Test
	public void testUpdateTrainee() {
		Mockito.when(service.updateTrainee(1L, MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.updateTrainee(1L, MOCK_VALUE2));
		Mockito.verify(service).updateTrainee(1L, MOCK_VALUE2);
	}
	@Test 
	public void testDeleteTrainee() {
		Mockito.when(service.deleteTrainee(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.deleteTrainee(1L));
		Mockito.verify(service).deleteTrainee(1L);
	}
}
