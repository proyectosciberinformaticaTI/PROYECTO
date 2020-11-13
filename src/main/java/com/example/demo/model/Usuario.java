package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;




//@Entity
//@Data
//@Table(name = "Usuario")
public class Usuario {


	private int idusuario;
	private String usuario;
	private String clave;
	private Boolean estado;
	
	private List<Rol> roles;

	



}
