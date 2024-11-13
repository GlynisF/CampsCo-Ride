package com.googleapis.maps.places;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressComponentsItem{

	@JsonProperty("types")
	private List<String> types;

	@JsonProperty("short_name")
	private String shortName;

	@JsonProperty("long_name")
	private String longName;

	public List<String> getTypes(){
		return types;
	}

	public String getShortName(){
		return shortName;
	}

	public String getLongName(){
		return longName;
	}

	@Override
	public String toString() {
		return "AddressComponentsItem{" +
				"types=" + types +
				", shortName='" + shortName + '\'' +
				", longName='" + longName + '\'' +
				'}';
	}
}