package com.cognifide.library;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ViewController {

    @Value("${books.path:books.json}")
    public String name;

	@GetMapping
    public String hello() throws Exception {
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(name);
        JSONArray goodArray=(JSONArray) jsonObject.get("items");
		String booki ="";
		ObjectMapper mapper = new ObjectMapper();
		Book [] x = mapper.readValue(goodArray.toJSONString(), Book[].class);
		for(Book a : x) {
			booki+=a.getVolumeInfo().getIndustryIdentifiers().get(0).getIdentifier();
		}
		return booki;
	}
	
	public static Object readJsonSimpleDemo(String filename) throws Exception {  
		FileReader reader = new FileReader(filename);
	    JSONParser jsonParser = new JSONParser();
	    return jsonParser.parse(reader);
	}
	
	@RequestMapping(value = "/isbn/{someID}")
	@ResponseBody
	public ResponseEntity<?> getBookByIsbn(@PathVariable("someID") String id) throws Exception {
		Book [] list = getAListOfBooks();
		Book bookByIsbn = new Book();
		boolean flag=false;
		for(Book book : list) {
			for(IndustryIdentifier ii : book.getVolumeInfo().getIndustryIdentifiers()) {
				if(ii.getIdentifier().equals(id)) {
					bookByIsbn=book;
					flag=true;
				}
			}
		}
		
		if(flag) {
			ReturningBook booktoview = new ReturningBook(bookByIsbn);
			return new ResponseEntity<ReturningBook>(booktoview, HttpStatus.OK);
		}else {
			return new ResponseEntity<Error>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value = "/category/{someID}")
	@ResponseBody
	public List<ReturningBook> getBooksByCategory(@PathVariable("someID") String id) throws Exception {
		Book [] list = getAListOfBooks();
		List<Book> booksByCategory = new ArrayList<>();
		for(Book book : list) {
			try {
				for(String category : book.getVolumeInfo().getCategories()) {
					if(category.equals(id)) {
						booksByCategory.add(book);
					}
				}
			}catch(NullPointerException e) {
			
			}
		}
		if(booksByCategory.size()>0) {
			List<ReturningBook> bookstoview = new ArrayList<ReturningBook>();
			for(Book book : booksByCategory) {
				bookstoview.add(new ReturningBook(book));
			}
			return bookstoview;
		}else {
			return new ArrayList<ReturningBook>();
		}
	}
	@RequestMapping(value = "/authorsRating")
	@ResponseBody
	public List<String> getAuthorsRating() throws Exception {
		List<String> allAuthors = new ArrayList<>();
		Book [] list = getAListOfBooks();
		for(Book book : list) {
			try {
				for(String author : book.getVolumeInfo().getAuthors()) {
					if(!allAuthors.contains(author)) {
						allAuthors.add(author);
					}
				}
			}catch(NullPointerException e) {
				
			}
		}
		List<String> listWithAuthorsAndTheirRating = new ArrayList<>();
		int howMuch=0;
		double allRatings=0;
		for(String author : allAuthors) {
			howMuch=0;
			allRatings=0;
			for(Book book : list) {
				try {
					for(String author1 : book.getVolumeInfo().getAuthors()) {
						if(author.equals(author1)) {
							howMuch++;
							allRatings+=book.getVolumeInfo().getAverageRating();
						}
					}
				}catch(NullPointerException e) {
					
				}
			}
			if(allRatings>0) {
				listWithAuthorsAndTheirRating.add(author);
				listWithAuthorsAndTheirRating.add(String.valueOf((double)allRatings/(double)howMuch));
			}
		}
		return listWithAuthorsAndTheirRating;
	}
    public Book[] getAListOfBooks() throws Exception {
    	JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(name);
    	JSONArray goodArray=(JSONArray) jsonObject.get("items");
    	ObjectMapper mapper = new ObjectMapper();
    	Book [] listOfBooks = mapper.readValue(goodArray.toJSONString(), Book[].class);
    	return listOfBooks;
    }
}