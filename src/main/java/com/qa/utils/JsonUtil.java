package com.qa.utils;

import com.google.gson.Gson;
import com.qa.domain.Trainee;

public class JsonUtil {

	private Gson gson;
	
	public JsonUtil() {
		
		this.gson = new Gson();
	}
	
	public String getJsonForObject(Object obj) {
		return gson.toJson(obj);
	}
	
	public Trainee getObjectForJson(String jSonString, Class<Trainee> trainee) {
		return gson.fromJson(jSonString, trainee);
	}
}
