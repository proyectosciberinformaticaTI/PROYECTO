package com.example.demo.configuration;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.example.demo.controller.ProductoController;
import com.example.demo.model.producto;
import com.example.demo.services.IUsuarioService;
import com.example.demo.services.impl.ProductoServiceimpl;
 
//@Configuration
//@ComponentScan(basePackages = {"com.example.demo.services.IClienteRepo","com.example.demo.services.IUsuarioService"})
public class AppConfig
{

	
//	@Bean
//	public producto productos() {
//	    return new producto();
//	}
////	
////	
//	@Bean
//	public IUsuarioService uprod() {
//	 return  new  ProductoServiceimpl();
//	}
//	
//	
//	
//	
//	

}