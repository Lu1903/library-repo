package com.cognifide.library;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AccessInfo {
	private String country;
	private String viewability;
	private Boolean embeddable;
	private Boolean publicDomain;
	private String textToSpeechPermission;
	private Epub epub;
	private Pdf pdf;
	
	public AccessInfo() {
		
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getViewability() {
		return viewability;
	}

	public void setViewability(String viewability) {
		this.viewability = viewability;
	}

	public Boolean getEmbeddable() {
		return embeddable;
	}

	public void setEmbeddable(Boolean embeddable) {
		this.embeddable = embeddable;
	}

	public Boolean getPublicDomain() {
		return publicDomain;
	}

	public void setPublicDomain(Boolean publicDomain) {
		this.publicDomain = publicDomain;
	}

	public String getTextToSpeechPermission() {
		return textToSpeechPermission;
	}

	public void setTextToSpeechPermission(String textToSpeechPermission) {
		this.textToSpeechPermission = textToSpeechPermission;
	}

	public Epub getEpub() {
		return epub;
	}

	public void setEpub(Epub epub) {
		this.epub = epub;
	}

	public Pdf getPdf() {
		return pdf;
	}

	public void setPdf(Pdf pdf) {
		this.pdf = pdf;
	}
	
	
}
