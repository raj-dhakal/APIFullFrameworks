package com.rajdhakal.stepdefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		
		StepDefination step = new StepDefination();
		if(StepDefination.place_id == null) {  // placie-id is static method so we are using class name to call that methods
			
			step.add_place_playload_with("Raj Dhakal", "Nepali", "Nepal");
			step.user_calls_with_http_request("AddPlaceAPI", "POST");
			step.veryfy_place_id_created_maps_to_using("Raj Dhakal", "getPlaceAPI");
			
		}
		
	}

}
