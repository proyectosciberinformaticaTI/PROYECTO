package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class valoresregistro {

	
	  @Value("${prue.total-cambio}")
	  private String tipodecambio;
	  
	  
	  @Value("${prue1.total-cambio}")
	  private String tipodecambio1;


}
