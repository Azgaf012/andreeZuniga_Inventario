package com.postulacion.app.controller.cliente;

import com.postulacion.app.enitity.Cliente;
import com.postulacion.app.service.cliente.RegistrarClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/clientes")
public class RegistrarClienteController {

    @Autowired
    private RegistrarClienteService clienteService;

    @PostMapping("/registrar")
    public ResponseEntity<Cliente> registrar(@RequestBody Cliente cliente){
        Cliente clienteCreado = clienteService.registrarCliente(cliente);
        return ResponseEntity.ok(clienteCreado);
    }
}
