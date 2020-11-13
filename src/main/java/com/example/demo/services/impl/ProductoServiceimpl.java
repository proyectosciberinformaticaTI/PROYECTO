package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.producto;
import com.example.demo.services.IUsuarioRepo;
import com.example.demo.services.IUsuarioService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductoServiceimpl implements IUsuarioService{

	@Autowired
	private IUsuarioRepo ser;
	
	

	@Override
	public Flux<producto> findAll() {
		// TODO Auto-generated method stub
		
       return Flux.fromIterable(ser.findAll());
	}



	@Override
	public Mono<producto> registrar(producto t) {
		// TODO Auto-generated method stub
		return Mono.just(ser.save(t));
	}



	@Override
	public Mono<producto> listarPorId(int v) {
		// TODO Auto-generated method stub
		
	    Optional<producto> cambiomonto = ser.findById(v);

	    if (cambiomonto.isPresent()) {
	      return Mono.just(cambiomonto.get());
	    } else {
	      return Mono.empty();
	    }
		
		
//	return Mono.just(ser.findById(v));
	}



	@Override
	public Mono<producto> actualizar(producto t) {
		// TODO Auto-generated method stub
		return Mono.just(ser.save(t));
	}



	@Override
	public Mono<Void> eliminar(int pro) {
		// TODO Auto-generated method stub
		ser.deleteById(pro);
       return Mono.empty();
		
	
	}

}
