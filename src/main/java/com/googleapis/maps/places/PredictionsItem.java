package com.googleapis.maps.places;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PredictionsItem{

	@JsonProperty("reference")
	private String reference;

	@JsonProperty("types")
	private List<String> types;

	@JsonProperty("terms")
	private List<TermsItem> terms;

	@JsonProperty("structured_formatting")
	private StructuredFormatting structuredFormatting;

	@JsonProperty("description")
	private String description;

	@JsonProperty("place_id")
	private String placeId;

	public String getReference(){
		return reference;
	}

	public List<String> getTypes(){
		return types;
	}

	public List<TermsItem> getTerms(){
		return terms;
	}

	public StructuredFormatting getStructuredFormatting(){
		return structuredFormatting;
	}

	public String getDescription(){
		return description;
	}

	public String getPlaceId(){
		return placeId;
	}

	@Override
	public String toString() {
		return "PredictionsItem{" +
				"reference='" + reference + '\'' +
				", types=" + types +
				", terms=" + terms +
				", structuredFormatting=" + structuredFormatting +
				", description='" + description + '\'' +
				", placeId='" + placeId + '\'' +
				'}';
	}
}