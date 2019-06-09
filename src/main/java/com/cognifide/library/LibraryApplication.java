package com.cognifide.library;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication implements ApplicationRunner {

    public static void main(String... args) throws Exception {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
    	
    }

}
