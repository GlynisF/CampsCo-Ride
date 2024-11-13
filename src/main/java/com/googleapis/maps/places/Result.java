package com.googleapis.maps.places;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result{

	@JsonProperty("name")
	private String name;

	@JsonProperty("geometry")
	private Geometry geometry;

	@JsonProperty("address_components")
	private List<AddressComponentsItem> addressComponents;

	public String getName(){
		return name;
	}

	public Geometry getGeometry(){
		return geometry;
	}

	public List<AddressComponentsItem> getAddressComponents(){
		return addressComponents;
	}

	@Override
	public String toString() {
		return "Result{" +
				"name='" + name + '\'' +
				", geometry=" + geometry +
				", addressComponents=" + addressComponents +
				'}';
	}
}