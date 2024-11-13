package com.googleapis.maps.places;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StructuredFormatting{

	@JsonProperty("secondary_text")
	private String secondaryText;

	@JsonProperty("main_text")
	private String mainText;

	public String getSecondaryText(){
		return secondaryText;
	}

	public String getMainText(){
		return mainText;
	}
}