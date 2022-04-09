package com.postulacion.app.controller.cliente;

import com.postulacion.app.enitity.Cliente;
import com.postulacion.app.service.cliente.ListarClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ListarClienteController {

    @Autowired
    private ListarClienteService clienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listar(){
        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Cliente> listar(@PathVariable("id") Long id){
        Cliente cliente = clienteService.obtenerCliente(id);
        return ResponseEntity.ok(cliente);
    }

}
