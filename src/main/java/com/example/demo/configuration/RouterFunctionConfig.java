package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

//import com.example.demo.handler.ProductoHandler;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

//@Configuration
public class RouterFunctionConfig {

//	@Bean
//	public RouterFunction<ServerResponse> routes(ProductoHandler handler){
//		
//		return route((GET("/principal/listartodo")), handler::listar);
//	}

}
