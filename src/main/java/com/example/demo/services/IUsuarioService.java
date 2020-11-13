package com.example.demo.services;

import java.util.Optional;

import com.example.demo.model.producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUsuarioService {
	Mono<producto> registrar(producto t);
	 Flux<producto> findAll();
	// Mono<Producto> listarPorId(int v);
	 Mono<producto> listarPorId(int v); 
 Mono<producto> actualizar (producto t); 
 Mono<Void> eliminar(int pro);
}
