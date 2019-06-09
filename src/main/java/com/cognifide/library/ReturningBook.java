package com.cognifide.library;

public class ReturningBook {
	
	private String isbn;
	private String title;
	private String subtitle;
	private String publisher;
	private String publishedDate;
	private String descritpion;
	private Integer pageCount;
	private String thumbnailUrl;
	private String language;
	private String previewLink;
	private double averageRating;
	private String [] authors;
	private String [] categories;
	
	public ReturningBook(Book book) {
		setIsbn(book);
		setTitle(book);
		setSubtitle(book);
		setPublisher(book);
		setPublishedDate(book);
		setDescription(book);
		setPageCount(book);
		setThumbnailUrl(book);
		setLanguage(book);
		setPreviewLink(book);
		setAverageRating(book);
		setAuthors(book);
		setCategories(book);
		
		//this.isbn=book.getVolumeInfo().getIndustryIdentifiers().get(index);
	}
	
	public void setIsbn(Book book) {
		this.isbn = book.getVolumeInfo().getIndustryIdentifiers().get(0).getIdentifier();
	}
	
	public void setTitle(Book book) {
		this.title = book.getVolumeInfo().getTitle();
	}
	
	public void setSubtitle(Book book) {
		this.subtitle = book.getVolumeInfo().getSubtitle();
	}
	
	public void setPublisher(Book book) {
		this.publisher = book.getVolumeInfo().getPublisher();
	}
	
	public void setPublishedDate(Book book) {
		this.publishedDate = book.getVolumeInfo().getPublishedDate();
	}
	
	public void setDescription(Book book) {
		this.descritpion = book.getVolumeInfo().getDescription();
	}
	
	public void setPageCount(Book book) {
		this.pageCount = book.getVolumeInfo().getPageCount();
	}
	
	public void setThumbnailUrl(Book book) {
		this.thumbnailUrl = book.getVolumeInfo().getImageLinks().getThumbnail();
	}
	
	public void setLanguage(Book book) {
		this.language=book.getVolumeInfo().getLanguage();
	}
	
	public void setPreviewLink(Book book) {
		this.previewLink=book.getVolumeInfo().getPreviewLink();
	}

	public void setAverageRating(Book book) {
		this.averageRating=book.getVolumeInfo().getAverageRating();
	}
	
	public void setAuthors(Book book) {
		this.authors = book.getVolumeInfo().getAuthors();
	}
	
	public void setCategories(Book book) {
		this.categories = book.getVolumeInfo().getCategories();
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public String getDescritpion() {
		return descritpion;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public String getLanguage() {
		return language;
	}

	public String getPreviewLink() {
		return previewLink;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public String[] getAuthors() {
		return authors;
	}

	public String[] getCategories() {
		return categories;
	}
	
	
}
