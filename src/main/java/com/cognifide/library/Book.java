package com.cognifide.library;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Book {

	private String kind;
	private String id;
	private String etag;
	private String selfLink;
	private VolumeInfo volumeInfo;
	private SaleInfo saleInfo;
	private AccessInfo accessInfo;
	private String webReaderLink;
	private String accessViewStatus;
	private Boolean quoteSharingAllowed;

	public Book() {
		//need empty constructor
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEtag() {
		return etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

	public String getSelfLink() {
		return selfLink;
	}

	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}

	public VolumeInfo getVolumeInfo() {
		return volumeInfo;
	}

	public void setVolumeInfo(VolumeInfo volumeInfo) {
		this.volumeInfo = volumeInfo;
	}

	public SaleInfo getSaleInfo() {
		return saleInfo;
	}

	public void setSaleInfo(SaleInfo saleInfo) {
		this.saleInfo = saleInfo;
	}

	public AccessInfo getAccessInfo() {
		return accessInfo;
	}

	public void setAccessInfo(AccessInfo accessInfo) {
		this.accessInfo = accessInfo;
	}

	public String getWebReaderLink() {
		return webReaderLink;
	}

	public void setWebReaderLink(String webReaderLink) {
		this.webReaderLink = webReaderLink;
	}

	public String getAccessViewStatus() {
		return accessViewStatus;
	}

	public void setAccessViewStatus(String accessViewStatus) {
		this.accessViewStatus = accessViewStatus;
	}

	public Boolean getQuoteSharingAllowed() {
		return quoteSharingAllowed;
	}

	public void setQuoteSharingAllowed(Boolean quoteSharingAllowed) {
		this.quoteSharingAllowed = quoteSharingAllowed;
	}
	
}
