package com.accenture.rentacar.app.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cliente_x_vehiculo")
public class ClienteVehiculo {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne (fetch= FetchType.LAZY)//carga perezosa cuando llame a la tabla , no me traiga a todos los clientes y todas sus facturas, solo traea las cosas a medida que ls voy solicitando
	private Cliente cliente;//relacion de uno a muchos un cliente puede tener muchos vehiculo
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Vehiculo>vehiculos;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion_registro")
	private Date fechaCreacionRegistro;
	
	private String observaciones;
	
	@PrePersist
	public void prePersist() {
		fechaCreacionRegistro= new Date();
	}
}
