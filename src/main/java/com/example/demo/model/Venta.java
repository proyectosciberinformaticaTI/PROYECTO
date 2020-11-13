package com.example.demo.model;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "venta")
public class Venta {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idventa;

//@JoinTable(name = "venta_rol", joinColumns = @JoinColumn(name = "idventa", referencedColumnName = "idventa"), inverseJoinColumns = @JoinColumn(name = "idcliente", referencedColumnName = "idcliente"))
//@OneToMany(fetch = FetchType.EAGER)
//	private List<cliente> Cliente;
	
	private int idcliente;
	
	private Date fecha;
	
	
	
	

}
