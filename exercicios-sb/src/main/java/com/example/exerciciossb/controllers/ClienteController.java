package com.example.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exerciciossb.models.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@GetMapping(path = "/qualquer")
	public Cliente obterCliente() {
		return new Cliente(28, "Marcelo", "123.456.789-00");
	}

	@GetMapping("/{id}")
	public Cliente obterClientePorId1(@PathVariable int id) {
		return new Cliente(id, "Maria", "987.654.321-00");
	}

	@GetMapping
	public Cliente obterClienteporId2(@RequestParam(name = "id", defaultValue = "1") int id) {
		return new Cliente(id, "Marcelo", "123.456.789-00");
	}
}
