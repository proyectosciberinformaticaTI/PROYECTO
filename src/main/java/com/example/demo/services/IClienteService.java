package com.example.demo.services;

import com.example.demo.model.cliente;

import io.reactivex.Maybe;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClienteService {

	
	Mono<cliente> registrar(cliente t);

	Flux<cliente> findAll();

	// Mono<Producto> listarPorId(int v);
	  Maybe<cliente> findById(Integer id);

	Mono<cliente> actualizar(cliente t);

}
