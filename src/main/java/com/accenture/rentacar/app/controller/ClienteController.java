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

import com.accenture.rentacar.app.entity.Cliente;

import com.accenture.rentacar.app.service.IClienteService;

@RestController
@RequestMapping("/api")

public class ClienteController {
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/cliente")
	public List<Cliente> listar(){
		return clienteService.listarTodos(); 
	}
	
	@GetMapping("/cliente/{id}")
	public Cliente buscarPorId(@PathVariable Long id ) {
		return clienteService.buscarClientePorId(id);
	}
	
	@PostMapping("/cliente")
	public Cliente guardar (@RequestBody Cliente cliente) {//lo recibo en el body del request
		return clienteService.guardar(cliente);
	}
	
	@PostMapping("/clientes")
	public List<Cliente> guardar (@RequestBody Cliente[] clientes) {//lo recibo en el body del request
		return  clienteService.guardar(clientes);
	}
	
	@SuppressWarnings("unused")//para quitr el warning cuando tengo varianles sin usarla
	@PostMapping("/actualizarcliente")
	public Cliente actualizar(@RequestBody Cliente cliente) {
		
		//Cliente ClienteNuevo= new Cliente("Juan");
		//Cliente clienteNuevoDos= new Cliente("Martinez");
		
		Cliente clienteAActualizar= new Cliente();
		Cliente clienteActual= clienteService.buscarClientePorId(cliente.getId());
		clienteAActualizar.setId(cliente.getId());
		clienteAActualizar.setCedula(cliente.getCedula());
		clienteAActualizar.setNombre(cliente.getNombre());
		clienteAActualizar.setApellido(cliente.getApellido());
		clienteAActualizar.setTelefono(cliente.getTelefono());
		clienteAActualizar.setDireccion(cliente.getDireccion());
		clienteAActualizar.setEmail(cliente.getEmail());
		
		return clienteService.guardar(clienteAActualizar) ;
	}
	
	@DeleteMapping("/clientes/{id}")
	public String borrar(@PathVariable Long id) {
		clienteService.borrar(id);
		return "El cliente se elimino correctamente";
	}
}
