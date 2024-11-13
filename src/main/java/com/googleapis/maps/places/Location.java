package com.googleapis.maps.places;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location{

	@JsonProperty("lng")
	private Object lng;

	@JsonProperty("lat")
	private Object lat;

	public Object getLng(){
		return lng;
	}

	public Object getLat(){
		return lat;
	}

	@Override
	public String toString() {
		return "Location{" +
				"lng=" + lng +
				", lat=" + lat +
				'}';
	}
}