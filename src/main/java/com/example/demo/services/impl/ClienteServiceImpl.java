package com.example.demo.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.cliente;
import com.example.demo.services.IClienteRepo;
import com.example.demo.services.IClienteService;

import io.reactivex.Maybe;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements IClienteService{

	private IClienteRepo ser;
	
	
	@Override
	public Mono<cliente> registrar(cliente t) {
		// TODO Auto-generated method stub
		return Mono.just(ser.save(t));
	}

	@Override
	public Flux<cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Mono<cliente> actualizar(cliente t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maybe<cliente> findById(Integer id) {
		// TODO Auto-generated method stub
	    Optional<cliente> clientes = ser.findById(id);

	    if (clientes.isPresent()) {
	      return Maybe.just(clientes.get());
	    } else {
	      return Maybe.empty();
	    }
	}

}
