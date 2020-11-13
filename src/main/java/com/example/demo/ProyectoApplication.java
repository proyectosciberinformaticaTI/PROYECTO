package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.configuration.valoresregistro;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	
	@Autowired
	  valoresregistro registrosmock;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
/*
	    ClassLoader classLoader = getClass().getClassLoader();
	    
        try (InputStream inputStream = classLoader.getResourceAsStream(registrosmock.getTipodecambio())) {
        	 StringBuilder fileContents = new StringBuilder();
            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
           System.out.println(result);
        
 
        } catch (IOException e) {
            e.printStackTrace();
        }*/
		
		
		Path filePath = Paths.get(registrosmock.getTipodecambio1());
		 
		try (Stream<String> lines = Files.lines(filePath)) 
		{
		 
		     List<String> filteredLines = lines
		                    .filter(s -> s.contains("Marco"))
		                    .collect(Collectors.toList());
		      
		     filteredLines.forEach(System.out::println);
		 
		} 
		catch (IOException e) {
		 
		    e.printStackTrace();
		}
		
	}

}
