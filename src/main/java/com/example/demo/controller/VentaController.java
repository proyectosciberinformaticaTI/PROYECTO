package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.cliente;
import com.example.demo.model.producto;
import com.example.demo.model.Venta;
import com.example.demo.services.IVentaService;

import io.reactivex.Maybe;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
@RequestMapping("/ventaprincipal")
public class VentaController {

	
	
	private IVentaService repo;
	
	
	
	
	
	@GetMapping(value = "/venta/{id}")
	public Maybe<ResponseEntity<Venta>> listadodetipocambioID(@PathVariable Integer id) {
	  return repo.findById(id).map(cliente ->ResponseEntity.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(cliente)).defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	
	
	
	
	

	@GetMapping("/listarventas/{id}")
	public Mono<Object> listarPorId(@PathVariable("id") Integer id){
		return repo.listarPorId(id)
			
				.map(p -> ResponseEntity.ok()
						.contentType(MediaType.APPLICATION_STREAM_JSON)
						.body(p)
				);
	}
	
	
	
	
	@PostMapping(value = "/registrar")
	public ResponseEntity<Mono<Venta>> registrar(@RequestBody Venta plato){
	
	
	Mono<Venta> tipoCambioMaybe =repo.registrar(plato);
	    return ResponseEntity.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(tipoCambioMaybe);

}
	
	
	
	
}
