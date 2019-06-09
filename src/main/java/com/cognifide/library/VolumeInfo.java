package com.cognifide.library;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class VolumeInfo {
	private String title;
	private String subtitle;
	private String[] authors;
	private String publishedDate;
	private String description;
	private String publisher;
	private List<IndustryIdentifier> industryIdentifiers;
	private ReadingMode readingModes;
	private Integer pageCount;
	private String printType;
	private String[] categories;
	private double averageRating;
	private double ratingsCount;
	private String maturityRating;
	private Boolean allowAnonLogging;
	private String contentVersion;
	private ImageLink imageLinks;
	private String language;
	private String previewLink;
	private String infoLink;
	private String canonicalVolumeLink;
	
	public VolumeInfo() {
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public List<IndustryIdentifier> getIndustryIdentifiers() {
		return industryIdentifiers;
	}
	public void setIndustryIdentifiers(List<IndustryIdentifier> industryIdentifiers) {
		this.industryIdentifiers = industryIdentifiers;
	}
	public ReadingMode getReadingModes() {
		return readingModes;
	}
	public void setReadingModes(ReadingMode readingModes) {
		this.readingModes = readingModes;
	}
	public String getPrintType() {
		return printType;
	}
	public void setPrintType(String printType) {
		this.printType = printType;
	}
	public String getMaturityRating() {
		return maturityRating;
	}
	public void setMaturityRating(String maturityRating) {
		this.maturityRating = maturityRating;
	}
	public Boolean getAllowAnonLogging() {
		return allowAnonLogging;
	}
	public void setAllowAnonLogging(Boolean allowAnonLogging) {
		this.allowAnonLogging = allowAnonLogging;
	}
	public String getContentVersion() {
		return contentVersion;
	}
	public void setContentVersion(String contentVersion) {
		this.contentVersion = contentVersion;
	}
	public ImageLink getImageLinks() {
		return imageLinks;
	}
	public void setImageLinks(ImageLink imageLinks) {
		this.imageLinks = imageLinks;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getPreviewLink() {
		return previewLink;
	}
	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}
	public String getInfoLink() {
		return infoLink;
	}
	public void setInfoLink(String infoLink) {
		this.infoLink = infoLink;
	}
	public String getCanonicalVolumeLink() {
		return canonicalVolumeLink;
	}
	public void setCanonicalVolumeLink(String canonicalVolumeLink) {
		this.canonicalVolumeLink = canonicalVolumeLink;
	}
	public String[] getAuthors() {
		return authors;
	}
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public String[] getCategories() {
		return categories;
	}
	public void setCategories(String[] categories) {
		this.categories = categories;
	}
	public double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}
	public double getRatingsCount() {
		return ratingsCount;
	}
	public void setRatingsCount(double ratingsCount) {
		this.ratingsCount = ratingsCount;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
