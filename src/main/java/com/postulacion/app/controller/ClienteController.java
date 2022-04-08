package com.postulacion.app.controller;

import com.postulacion.app.enitity.Cliente;
import com.postulacion.app.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listar(){
        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(Cliente cliente){
        boolean estado = clienteService.crearCliente(cliente);
        return ResponseEntity.ok("Cliente registrado");
    }


}
