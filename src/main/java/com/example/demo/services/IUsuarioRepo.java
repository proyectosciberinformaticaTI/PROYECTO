package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.producto;
import com.example.demo.model.Usuario;

import reactor.core.publisher.Mono;


public interface IUsuarioRepo extends JpaRepository<producto,Integer>{
	// Mono<Usuario> findOneByUsuario(String usuario);
}
