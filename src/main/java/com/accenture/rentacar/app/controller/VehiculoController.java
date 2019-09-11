package com.accenture.rentacar.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.rentacar.app.entity.Vehiculo;
import com.accenture.rentacar.app.service.IVehiculoService;

@RestController
@RequestMapping("/api")
public class VehiculoController {

	@Autowired
	private IVehiculoService vehiculoService;
	
	@GetMapping("/vehiculos")
	public List<Vehiculo> listar(){
		return vehiculoService.listarTodos(); 
	}
	
	@GetMapping("/vehiculos/{id}")
	public Vehiculo buscarPorId(@PathVariable Long id ) {
		return vehiculoService.buscarVehiculoPorId(id);
	}
	
	@PostMapping("/vehiculo")
	public Vehiculo guardar (@RequestBody Vehiculo vehiculo) {//lo recibo en el body del request
		return  vehiculoService.guardar(vehiculo);
	}
	
	@PostMapping("/vehiculos")
	public List<Vehiculo> guardar (@RequestBody Vehiculo[] vehiculos) {//lo recibo en el body del request
		return  vehiculoService.guardar(vehiculos);
		
	}
	
	@PostMapping ("/variosvehiculos")
	 public List<Vehiculo>  guardarvarios (@RequestBody Vehiculo [] vehiculo) {
		return vehiculoService.guardarvarios(vehiculo);
		
		
	}
	
	@PostMapping("/actualizar")
	public Vehiculo actualizar(@RequestBody Vehiculo vehiculo) {

		Vehiculo vehiActual= vehiculoService.buscarVehiculoPorId(vehiculo.getId());
		vehiActual.setColor(vehiculo.getColor());
		vehiActual.setLinea(vehiculo.getLinea());
		vehiActual.setMarca(vehiculo.getMarca());
		vehiActual.setModelo(vehiculo.getModeloAuto());
		vehiActual.setPlaca(vehiculo.getPlaca());
				
		return vehiculoService.guardar(vehiActual) ;
	}
	
	@DeleteMapping("/vehiculos/{id}")
	public String borrar(@PathVariable Long id) {
		vehiculoService.borrar(id);
		return "El vehiculo se elimino correctamente";
	}
	
	
}
