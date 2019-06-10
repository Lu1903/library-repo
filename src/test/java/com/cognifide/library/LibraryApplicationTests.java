package com.cognifide.library;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	  public void evaluatesExpression() {
	    Book book = new Book();
	    book.setId("7tkN1CYzn2cC");
	    assertEquals("7tkN1CYzn2cC", book.getId());
	  }
	
}
