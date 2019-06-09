package com.cognifide.library;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ReadingMode {
	private boolean text;
	private boolean image;
	
	public boolean getText() {
		return text;
	}
	public void setText(boolean text) {
		this.text = text;
	}
	public boolean getImage() {
		return image;
	}
	public void setImage(boolean image) {
		this.image = image;
	}
	

}
