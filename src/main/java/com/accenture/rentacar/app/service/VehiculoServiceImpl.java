package com.accenture.rentacar.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.rentacar.app.dao.IVehiculoDao;
import com.accenture.rentacar.app.entity.Vehiculo;


@Service
public class VehiculoServiceImpl implements IVehiculoService {
	
	@Autowired
	private IVehiculoDao vehiculoDao;

	@Override
	public Vehiculo guardar(Vehiculo vehiculo) {		
		return vehiculoDao.save(vehiculo);
	}
	
	@Override
	public List<Vehiculo> guardar(Vehiculo[] vehiculos) {		
		return (List<Vehiculo>) vehiculoDao.saveAll(Arrays.asList(vehiculos));
	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub
		vehiculoDao.deleteById(id);
	}

	@Override
	public Vehiculo buscarVehiculoPorId(Long id) {
		// TODO Auto-generated method stub
		return vehiculoDao.findById(id).orElse(null);
	}

	@Override
	public List<Vehiculo> listarTodos() {
		// TODO Auto-generated method stub
		return (List<Vehiculo>) vehiculoDao.findAll();
	}
	
	@Override
	
	public List<Vehiculo> guardarvarios (Vehiculo [] vehiculos){
		
		List <Vehiculo> retorno= new ArrayList<Vehiculo>(); 
	
		for(Vehiculo vehiculo:vehiculos){
			
  retorno.add(vehiculoDao.save(vehiculo));}
		return retorno; 
	
	}

}
