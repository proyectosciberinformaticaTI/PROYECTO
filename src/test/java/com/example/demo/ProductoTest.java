package com.example.demo;


import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.example.demo.model.producto;
import com.example.demo.services.IUsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.core.ParameterizedTypeReference;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductoTest {

//	@MockBean
//	IUsuarioRepo repository;
//
	@Autowired
	private WebTestClient client;
	@Autowired
	private IUsuarioService service;
	
	
//	private WireMockServer wireMockServer;
//  
	
//  @Before
//  public void setup() {
//      wireMockServer = new WireMockServer(wireMockConfig().dynamicPort());
//      wireMockServer.start();
//      configureFor("localhost", wireMockServer.port());
//      client = WebClient.create("http://localhost:" + wireMockServer.port());
//  }

	
//	@Test
//	public void create() {
//		producto pro = new producto();
//		 pro.setIdproducto(1);
//		pro.setPrecio(15.6);
//		pro.setNombre("pol");
//		pro.setProducto("BIMBOoooooooo");
//
//		Mockito.when(repository.save(pro)).thenReturn(pro);
//
//		client.post().uri("/principal/registrar").contentType(MediaType.APPLICATION_JSON)
//		.body(BodyInserters.fromObject(pro))
//		.exchange().expectStatus().isCreated();
//
//		Mockito.verify(repository, times(1)).save(pro);
//		
//		
//		
//		
////		
////		client.post()
////		.uri("/principal/registrar")
////		.contentType(MediaType.APPLICATION_STREAM_JSON)
////		.accept(MediaType.APPLICATION_STREAM_JSON)
////		.body(Mono.just(pro), producto.class)
////		.exchange()
////		.expectStatus().isCreated()
////		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
////		.expectBody()
////		.jsonPath("$.nombre").isNotEmpty()
////		.jsonPath("$.precio").isNumber();
//		
//		
//		
////		Mockito.when(repository.save(pro)).thenReturn(pro);
////
////		client.post()
////			.uri("/principal/registrar")
////			.contentType(MediaType.APPLICATION_JSON)
////			.body(BodyInserters.fromObject(pro))
////			.exchange()
////			.expectStatus().isCreated();
////
////		Mockito.verify(repository, times(1)).save(pro);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test
//	public void listartodoporId() {
//	
//		
//		
//		producto pro = new producto();
//		pro.setIdproducto(1);
//		pro.setNombre("Test");
//		pro.setPrecio(15.6);
//		pro.setProducto("Producto");
//		
//		Optional<producto> list = Optional.of(pro);
//	
		
		//Flux<producto> employeeFlux = Flux.fromIterable(list);
		
	//	Optional<producto> employees = Optional.of(employeeFlux);
//      Mockito
//          .when(repository.findById(1))
//          .thenReturn(list);
//
//      client.get().uri("/principal/listar/{id}", 1)
//      	.header(HttpHeaders.ACCEPT, "application/json")
//	        .exchange()
//	        .expectStatus().isOk()
//	        .expectBodyList(producto.class);
//      
//      Mockito.verify(repository, times(1)).findById(3);
//
//	
//	}
	
//	
	@Test
	public void listartodo() {
		
		client.get()
		.uri("/principal/listartodo")
		.accept(MediaType.APPLICATION_STREAM_JSON)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_STREAM_JSON)
		.expectBodyList(producto.class)
		.hasSize(3);
		
	}
	
	@Test
	public void listarTest() {
		
		client.get()
		.uri("/principal/listartodo")
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBodyList(producto.class)
		.consumeWith(response -> {
			List<producto> productos = response.getResponseBody();
			productos.forEach(p -> {
				System.out.println(p.getNombre());
			});
			
			Assertions.assertThat(productos.size()>0).isTrue();
		});;
	}
	
	
	
	
	@Test
	public void verTest() {
		
		
		
		client.get()
		.uri("/principal/listar" + "/{id}", Collections.singletonMap("id", 1))
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody(producto.class)
		.consumeWith(response -> {
			producto p = response.getResponseBody();
			Assertions.assertThat(p.getIdproducto()).isNotNull();
			Assertions.assertThat(p.getIdproducto().toString().length()>0).isTrue();
			Assertions.assertThat(p.getNombre()).isEqualTo("Hola mundo");
		});
	
	}
	
	
	
	@Test
	public void verTest1() {
	
		client.get()
		.uri("/principal/listar" + "/{id}", Collections.singletonMap("id", 1))
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody()
		.jsonPath("$.id").isNotEmpty()
		.jsonPath("$.nombre").isEqualTo("Producto");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void crearTest() {
		
		producto pro = new producto();
		 pro.setIdproducto(1);
		pro.setPrecio(15.6);
		pro.setNombre("pol");
		pro.setProducto("BIMBOoooooooo");
		
		client.post().uri("/principal/registrar")
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.body(Mono.just(pro), producto.class)
		.exchange()
		.expectStatus().isCreated()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody()
		.jsonPath("$.id").isNotEmpty()
		.jsonPath("$.nombre").isEqualTo("HJ")
		.jsonPath("$.nombre").isEqualTo("PL");
	}
	
	
	
	
	
	
	
	
	
	@Test
	public void crear2Test() {
		
		producto pro = new producto();
		 pro.setIdproducto(3);
		pro.setPrecio(15.67);
		pro.setNombre("pollll");
		pro.setProducto("BIM");
		
		client.post().uri("/principal/registrar")
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.body(Mono.just(pro), producto.class)
		.exchange()
		.expectStatus().isCreated()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody(new ParameterizedTypeReference<LinkedHashMap<String, Object>>() {})
		.consumeWith(response -> {
			Object o = response.getResponseBody().get("producto");
			producto p = new ObjectMapper().convertValue(o, producto.class);
			Assertions.assertThat(p.getIdproducto()).isNotNull();
			Assertions.assertThat(p.getNombre()).isEqualTo("hola mundo");
		
		});
	}
	
	
	
	
	
	
	
	@Test
	public void updateTest() {
		
		Mono<producto> edit=service.listarPorId(1);
		
		producto pro = new producto();
		 pro.setIdproducto(3);
		pro.setPrecio(15.67);
		pro.setNombre("pollll");
		pro.setProducto("BIM");
		
		
		
		
		
		
		client.put().uri("/principal/actualizar" + "/{id}", Collections.singletonMap("id", pro.getIdproducto()))
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.body(Mono.just(edit), producto.class)
		.exchange()
		.expectStatus().isCreated()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody()
		.jsonPath("$.id").isNotEmpty()
		.jsonPath("$.nombre").isEqualTo("Hola Mundo")
		.jsonPath("$.precio").isEqualTo(15.8);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void eliminarTest() {
		producto producto = service.listarPorId(2).block();
		client.delete()
		.uri("/principal/eliminar" + "/{id}", Collections.singletonMap("id", producto.getIdproducto()))
		.exchange()
		.expectStatus().isNoContent()
		.expectBody()
		.isEmpty();
		
		client.get()
		.uri("/principal/listar" + "/{id}", Collections.singletonMap("id", producto.getIdproducto()))
		.exchange()
		.expectStatus().isNotFound()
		.expectBody()
		.isEmpty();
	}
	
	
	
	
	
	

	
}
