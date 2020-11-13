package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.demo.model.Venta;

import reactor.core.publisher.Mono;



public interface IVentaRepo extends JpaRepository<Venta,Integer>{
//Mono<Venta> listado(int idventa);
}
