Feature: Validating Place API's

@AddPlace
Scenario Outline: Verify if place is being Successfully added using AddPlaceAPI
Given Add Place Playload with "<name>" "<language>" "<address>"
When User calls "AddPlaceAPI" with "Post" http request
Then The Api call got success with status code 200
And "status" in reponse body is "OK"
And veryfy place_Id created maps to "<name>" using "getPlaceAPI"

Examples:
		|name					|language					|address								|
		|AAhouse			|English					|World Cross Center			|
	#	|BBhouse			|Spanish					|Sea Cross Center				|		
	
@DeletePlace	
Scenario: Verify if Delete Place functionality is working
	Given DeletePlace Payload
	When User calls "deletePlaceAPI" with "Post" http request
	Then The Api call got success with status code 200
	And "status" in reponse body is "OK"
