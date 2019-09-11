package com.accenture.rentacar.app.service;

import java.util.List;


import com.accenture.rentacar.app.entity.Vehiculo;

public interface IVehiculoService {
	
	public Vehiculo guardar (Vehiculo vehiculo);

	public List<Vehiculo> guardar (Vehiculo[] vehiculos);
	
	public void borrar (Long id);
	
	public Vehiculo buscarVehiculoPorId (Long id);
	
	public List<Vehiculo> listarTodos ();
	public List<Vehiculo> guardarvarios (Vehiculo [] vehiculo);
	
	
	}


