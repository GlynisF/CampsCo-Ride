package com.googleapis.maps.places;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AutocompletePredictions{

	@JsonProperty("predictions")
	private List<PredictionsItem> predictions;

	@JsonProperty("status")
	private String status;

	public List<PredictionsItem> getPredictions(){
		return predictions;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public String toString() {
		return "AutocompletePredictions{" +
				"predictions=" + predictions +
				", status='" + status + '\'' +
				'}';
	}
}