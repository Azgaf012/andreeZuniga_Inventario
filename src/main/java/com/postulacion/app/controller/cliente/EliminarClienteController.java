package com.postulacion.app.controller.cliente;

import com.postulacion.app.service.cliente.EliminarClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/clientes")
public class EliminarClienteController {

    @Autowired
    private EliminarClienteService clienteService;

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Long id){
        boolean estado = clienteService.eliminarCliente(id);
        return ResponseEntity.ok("Cliente eliminado");
    }

}
