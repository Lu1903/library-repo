package com.cognifide.library;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
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
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
public class HelloController {

    @Value("${books.path:books.json}")
    public String name;
    public String books;
    JSONObject jsonObject;

    
	@GetMapping
    public String hello() throws Exception {
		/*Object obj = new JSONParser().parse(new FileReader(new java.io.File(".").getCanonicalPath()+"\\"+name)); 
        
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj; 

        // getting firstName and lastName 
        String firstName = (String) jo.get("firstName"); 
          
        return (firstName); */
        
        
        
		JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(name);
        //System.out.println(jsonObject);
		//JSONArray jsonArray = (JSONArray) jsonObject.get("firstName");
		JSONArray goodArray=(JSONArray) jsonObject.get("items");
		int ile = goodArray.size();
		//String dane="";
		/*for(int i=0; i<ile; i++) {
			JSONObject obj = (JSONObject) goodArray.get(i);
			dane=dane+obj.get("id");
		}
        //return (String) jsonObject.get("firstName");
		return dane;*/
		String booki ="";
		ObjectMapper mapper = new ObjectMapper();
		/*ArrayList <Book> books = new ArrayList<Book>();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		for(int i=0; i<ile; i++) {
			books.add(mapper.readValue(goodArray.get(i).toString(), Book.class));
			booki=booki+ow.writeValueAsString(books.get(i));
		}
	    //Book dtoObject = mapper.readValue(goodArray.toString(), Book.class);
    	
	    return booki;*/
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
	/*@RequestMapping(value = "/category/{someID}")
	@ResponseBody
	public List<ResponseEntity<?>> getBooksByCategory(@PathVariable("someID") String id) throws Exception {
		Book [] list = getAListOfBooks();
		List<Book> booksByCategory = new ArrayList<>();
		for(Book book : list) {
		if(doesObjectContainField(book, "categories")) {
			for(String category : book.getVolumeInfo().getCategories()) {
				if(category.equals(id)) {
					booksByCategory.add(book);
				}
			}
		}
		}
				
		List<ResponseEntity<?>> returningbooks = new ArrayList<>();
		if(booksByCategory.size()>0) {
			List<ReturningBook> bookstoview = new ArrayList<ReturningBook>();
			for(Book book : booksByCategory) {
				bookstoview.add(new ReturningBook(book));
			}
			
			for(ReturningBook book : bookstoview) {
				returningbooks.add(new ResponseEntity<ReturningBook>(book, HttpStatus.OK));
			}
			return returningbooks;
		}else {
			return returningbooks;
		}
	}*/
    
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
				
		//List<ResponseEntity<?>> returningbooks = new ArrayList<>();
		if(booksByCategory.size()>0) {
			List<ReturningBook> bookstoview = new ArrayList<ReturningBook>();
			for(Book book : booksByCategory) {
				bookstoview.add(new ReturningBook(book));
			}
			
			//for(ReturningBook book : bookstoview) {
			//	returningbooks.add(new ResponseEntity<ReturningBook>(book, HttpStatus.OK));
			//}
			return bookstoview;
		}else {
			return new ArrayList<ReturningBook>();
		}
		//return booksByCategory;
	}
	
    public Book[] getAListOfBooks() throws Exception {
    	JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(name);
    	JSONArray goodArray=(JSONArray) jsonObject.get("items");
    	ObjectMapper mapper = new ObjectMapper();
    	Book [] listOfBooks = mapper.readValue(goodArray.toJSONString(), Book[].class);
    	return listOfBooks;
    }
    public static boolean doesObjectContainField(Object object, String fieldName) {
    	Field[] fields = object.getClass().getDeclaredFields();
    	List<String> actualFieldNames = getFieldNames(fields);
        if(actualFieldNames.contains(fieldName)) {
        	return true;
        }else {
        	return false;
        }
    }
    private static List<String> getFieldNames(Field[] fields) {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
          fieldNames.add(field.getName());
        return fieldNames;
    }
}