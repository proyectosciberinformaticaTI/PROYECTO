package com.example.demo;

import static org.mockito.Mockito.times;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.demo.controller.ProductoController;
import com.example.demo.model.producto;
import com.example.demo.services.IUsuarioRepo;
import com.example.demo.services.IUsuarioService;

//@ExtendWith(SpringExtension.class)
//@WebFluxTest(controllers = ProductoController.class)
//@Import(IUsuarioService.class)


//@AutoConfigureWebTestClient
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)


//@WebFluxTest(controllers = ProductoController.class)
//@Import(ProductoController.class)


@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = ProductoController.class)
@Import(IUsuarioService.class)
public class ProductoTest01 {
	
	   @MockBean
	    IUsuarioRepo repository;
	 
	    @Autowired
	    private WebTestClient webClient;
	

	    
	    
	    
	    
	    @Test
	public   void testGetEmployeeById() 
	    {
	        producto pr = new producto();
	        pr.setIdproducto(1);
	        pr.setNombre("Test");
	        pr.setPrecio(1000.5);
	        pr.setProducto("PL");
	    Optional<producto> lista=Optional.of(pr);
	        
	        Mockito
	            .when(repository.findById(1))
	            .thenReturn(lista);
	 
	        webClient.get().uri("/principal/listar/{id}", 1)
	            .exchange()
	            .expectStatus().isOk()
	            .expectBody()
	            .jsonPath("$.name").isNotEmpty()
	            .jsonPath("$.id").isEqualTo(100)
	            .jsonPath("$.name").isEqualTo("Test")
	            .jsonPath("$.salary").isEqualTo(1000);
	         
	        Mockito.verify(repository, times(1)).findById(1);
	    }
}
