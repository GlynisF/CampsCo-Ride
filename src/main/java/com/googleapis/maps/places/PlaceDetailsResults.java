package com.googleapis.maps.places;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceDetailsResults{

	@JsonProperty("result")
	private Result result;

	@JsonProperty("html_attributions")
	private List<Object> htmlAttributions;

	@JsonProperty("status")
	private String status;

	public Result getResult(){
		return result;
	}

	public List<Object> getHtmlAttributions(){
		return htmlAttributions;
	}

	public String getStatus(){
		return status;
	}

	@JsonProperty("formatted_address")
	private String formattedAddress;

	public String getFormattedAddress(){return formattedAddress;}

	@Override
	public String toString() {
		return "PlaceDetailsResults{" +
				"result=" + result +
				", htmlAttributions=" + htmlAttributions +
				", status='" + status + '\'' +
				", formattedAddress='" + formattedAddress + '\'' +
				'}';
	}
}