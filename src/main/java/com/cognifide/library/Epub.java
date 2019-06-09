package com.cognifide.library;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Epub {
	private Boolean isAvailable;
	private String acsTokenLink;
	
	public Epub() {
		
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getAcsTokenLink() {
		return acsTokenLink;
	}

	public void setAcsTokenLink(String acsTokenLink) {
		this.acsTokenLink = acsTokenLink;
	}
	
	
}
