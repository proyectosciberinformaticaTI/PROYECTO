package com.example.demo.services;

import com.example.demo.model.cliente;
import com.example.demo.model.Venta;

import io.reactivex.Maybe;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IVentaService {

	
	
	Mono<Venta> registrar(Venta t);

	Flux<Venta> findAll();

	 Mono<Venta> listarPorId(int v);
	  Maybe<Venta> findById(Integer id);

	Mono<Venta> actualizar(cliente t);
}
