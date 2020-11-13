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
import com.example.demo.services.IClienteService;
import com.example.demo.services.IUsuarioService;

import io.reactivex.Maybe;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientecontroller")
public class ClienteController {

	
	
	
	
	
	
	@Autowired
	private IClienteService uprod;
	
@PostMapping(value = "/registrar")
	public ResponseEntity<Mono<cliente>> registrar( @RequestBody cliente plato){
	
	
	Mono<cliente> tipoCambioMaybe =uprod.registrar(plato);
	    return ResponseEntity.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(tipoCambioMaybe);

}



@GetMapping(value = "/cliente/{id}")
public Maybe<ResponseEntity<cliente>> listadodetipocambioID(@PathVariable Integer id) {
  return uprod.findById(id).map(cliente ->ResponseEntity.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(cliente)).defaultIfEmpty(ResponseEntity.notFound().build());
}

	
	
}
