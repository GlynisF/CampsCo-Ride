package com.googleapis.maps.places;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TermsItem{

	@JsonProperty("offset")
	private int offset;

	@JsonProperty("value")
	private String value;

	public int getOffset(){
		return offset;
	}

	public String getValue(){
		return value;
	}
}