package com.rajdhakal.resources;

import java.util.ArrayList;
import java.util.List;

import com.rajdhakal.pojo.AddPlace;
import com.rajdhakal.pojo.Location;

public class TestDataBuild {
	
	
	public AddPlace addPlacePayLoad(String name, String language, String address) {
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		p.setName("Frontline house");
		List<String> list = new ArrayList<String>();
		list.add(name);
		list.add("shop");
		p.setTypes(list);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		return p;
		
	}
	
	public String deletePlacePayLoad(String place_id) {
		
		return "{\r\n    \"place_id\":\""+place_id+"\"\r\n}";
	}
	
	
	

}
