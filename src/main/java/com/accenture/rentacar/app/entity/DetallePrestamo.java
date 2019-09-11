package com.accenture.rentacar.app.entity;

import java.io.Serializable;
import java.time.DateTimeException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.accenture.rentacar.app.util.utilDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Detalle_Prestamo")
public class DetallePrestamo implements Serializable {

	private static final long serialVersionID= 11; //TRANSFORMACION
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Generar primary key 
    private long id; 
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="vehiculo_id") //CONSTRUYE RELACIONES 
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	
	private Vehiculo vehiculo; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_prestamo")
	private Date fechaInicioPrestamo; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_prestamo")
	private Date fechaFinPrestamo; 
	
	@Column(name="total_dias_prestamo")
	private int totalDiasprestamo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFechaInicioPrestamo() {
		return fechaInicioPrestamo;
	}

	public void setFechaInicioPrestamo(Date fechaInicioPrestamo) {
		this.fechaInicioPrestamo = fechaInicioPrestamo;
	}

	public Date getFechaFinPrestamo() {
		return fechaFinPrestamo;
	}

	public void setFechaFinPrestamo(Date fechaFinPrestamo) {
		this.fechaFinPrestamo = fechaFinPrestamo;
	}

	public int getTotalDiasprestamo() {
		return totalDiasprestamo;
	}

	public void setTotalDiasprestamo(int totalDiasprestamo) {
		this.totalDiasprestamo = totalDiasprestamo;
	} 
	
	@PrePersist
	public void calcularDias() throws DateTimeException {
		utilDate.calcularDias(fechaInicioPrestamo, fechaFinPrestamo); 
	
		
	} 
	
	
	
	
	
	
	
	
	
	
	
	
}
