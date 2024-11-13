package com.googleapis.maps.places;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry{

	@JsonProperty("location")
	private Location location;

	public Location getLocation(){
		return location;
	}

	@Override
	public String toString() {
		return "Geometry{" +
				"location=" + location +
				'}';
	}
}