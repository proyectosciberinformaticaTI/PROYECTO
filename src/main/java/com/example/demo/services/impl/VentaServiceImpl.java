package com.example.demo.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.cliente;
import com.example.demo.model.producto;
import com.example.demo.model.Venta;
import com.example.demo.services.IClienteRepo;
import com.example.demo.services.IVentaRepo;
import com.example.demo.services.IVentaService;

import io.reactivex.Maybe;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class VentaServiceImpl implements IVentaService{
	
	private IVentaRepo repo;
	
	
	public Mono<Venta> registrar(Venta t) {
		// TODO Auto-generated method stub
		return Mono.just(repo.save(t));
	}

	@Override
	public Flux<Venta> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Venta> listarPorId(int v) {
		// TODO Auto-generated method stub
	    Optional<Venta> cambiomonto = repo.findById(v);

	    if (cambiomonto.isPresent()) {
	      return Mono.just(cambiomonto.get());
	    } else {
	      return Mono.empty();
	    }
	}

	@Override
	public Maybe<Venta> findById(Integer id) {
	    Optional<Venta> clientes = repo.findById(id);

	    if (clientes.isPresent()) {
	      return Maybe.just(clientes.get());
	    } else {
	      return Maybe.empty();
	    }
	}

	@Override
	public Mono<Venta> actualizar(cliente t) {
		// TODO Auto-generated method stub
		return null;
	}

}
