package com.postulacion.app.controller.cliente;

import com.postulacion.app.enitity.Cliente;
import com.postulacion.app.service.cliente.ActualizarClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/clientes")
public class ActualizarClienteController {

    @Autowired
    private ActualizarClienteService clienteService;

    @PutMapping("/actualizar")
    public ResponseEntity<Cliente> actualizar(@RequestBody Cliente cliente){
        Cliente clienteActualizado = clienteService.actualizarCliente(cliente);
        return ResponseEntity.ok(clienteActualizado);
    }

}
