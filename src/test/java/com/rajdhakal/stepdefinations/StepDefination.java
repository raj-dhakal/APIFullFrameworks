package com.rajdhakal.stepdefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.rajdhakal.resources.APIResources;
import com.rajdhakal.resources.TestDataBuild;
import com.rajdhakal.resources.Utils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefination extends Utils {
	
	public RequestSpecification req;
	public RequestSpecification request;
	public ResponseSpecification response;
	public Response responseString;
	public TestDataBuild data = new TestDataBuild();
	public JsonPath js;
	public static String place_id;
	
	
	@Given("Add Place Playload with {string} {string} {string}")
	public void add_place_playload_with(String name, String language, String address) throws IOException {
		
		 request = given().spec(requestSpecification()).body(data.addPlacePayLoad(name,language,address));
		 //response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		
		
	   
	}
	
	
	@Then("{string} in reponse body is {string}")
	public void in_reponse_body_is(String keyValue, String expectedValue) {
	  /*String resp = responseString.asString();
	  js = new JsonPath(resp);
	  place_id = js.get("place_id");
	  */
	  assertEquals(getJsonPath(responseString,keyValue),expectedValue);
	}
	
	
	
	@Then("The Api call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	  assertEquals(responseString.getStatusCode(),200);
	}
	
	
	
	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		
		APIResources resourceAPI=APIResources.valueOf(resource);
		//resourceAPI.getResource();
		response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST")) {
			responseString = request.when().post(resourceAPI.getResource());
		}else if(method.equalsIgnoreCase("GET")) {
			responseString = request.when().get(resourceAPI.getResource());
		}
		
				//.then().spec(response).extract().response();
		
		
	}
	
	
	
	@Then("veryfy place_Id created maps to {string} using {string}")
	public void veryfy_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
		place_id = getJsonPath(responseString, "place_id");
		request = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource,"GET");
		//String actualName = getJsonPath(responseString, "name");
		//assertEquals(actualName,expectedName);
	}
	
	
	
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
		request = given().spec(requestSpecification()).body(data.deletePlacePayLoad(place_id));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
