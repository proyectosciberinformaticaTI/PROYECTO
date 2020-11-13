package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.cliente;



public interface IClienteRepo extends JpaRepository<cliente,Integer>{

}
