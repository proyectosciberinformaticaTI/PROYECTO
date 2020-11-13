package com.example.demo.controller;

import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.linkTo;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;
import static reactor.function.TupleUtils.function;

import java.io.File;
import java.net.URI;
import java.util.Optional;
import java.util.UUID;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.producto;
import com.example.demo.services.IUsuarioService;
import com.example.demo.services.impl.ProductoServiceimpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/principal")
public class ProductoController {
	
	
	@Autowired
	private IUsuarioService uprod;
	
@PostMapping(value = "/registrar")
	public ResponseEntity<Mono<producto>> registrar( @RequestBody producto plato){
	
	
	Mono<producto> tipoCambioMaybe =uprod.registrar(plato);
	    return ResponseEntity.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(tipoCambioMaybe);

}
	
	
	
	@GetMapping(value = "/listartodo")
	public Mono<ResponseEntity<Flux<producto>>> listar(){
		Flux<producto> platosFlux = uprod.findAll();
		
		return Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_STREAM_JSON)
				.body(platosFlux));
	}
	
	
	

	@GetMapping("/listar/{id}")
	public Mono<Object> listarPorId(@PathVariable("id") Integer id){
		return uprod.listarPorId(id)
			
				.map(p -> ResponseEntity.ok()
						.contentType(MediaType.APPLICATION_STREAM_JSON)
						.body(p)
				);
	}
	
	
	
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Mono<producto>> modificar(@RequestBody producto plato, @PathVariable Integer id){
	    Mono<producto> tipoCambioMaybe = uprod.listarPorId(id).flatMap(responsetipo -> {plato.setIdproducto(responsetipo.getIdproducto());
	    return uprod.registrar(plato);
	        });
	    return ResponseEntity.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(tipoCambioMaybe);
	}
	
	
	
	
	
	
	 @DeleteMapping(value = "/eliminar/{id}")
	    public ResponseEntity<Mono<Void>> delete(@PathVariable("id") Integer id) {
	  Mono<producto> e = uprod.listarPorId(id);
	  HttpStatus status = e.equals(Mono.empty()) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
	  if(e.equals(Mono.empty())) {
	   return new ResponseEntity<Mono<Void>>(Mono.empty(), status);
	  }
	  return new ResponseEntity<Mono<Void>>(uprod.eliminar(id), status);
	    }
	
	
}
