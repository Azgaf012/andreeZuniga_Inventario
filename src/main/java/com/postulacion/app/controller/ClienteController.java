package com.postulacion.app.controller;

import com.postulacion.app.enitity.Cliente;
import com.postulacion.app.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

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

    @PostMapping("/registrar")
    public ResponseEntity<Cliente> registrar(@RequestBody Cliente cliente){
        Cliente clienteCreado = clienteService.crearCliente(cliente);
        return ResponseEntity.ok(clienteCreado);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Cliente> actualizar(@RequestBody Cliente cliente){
        Cliente clienteActualizado = clienteService.actualizarCliente(cliente);
        return ResponseEntity.ok(clienteActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Long id){
        boolean estado = clienteService.eliminarCliente(id);
        return ResponseEntity.ok("Cliente eliminado");
    }

}
