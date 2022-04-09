package com.postulacion.app.controller.pedido;

import com.postulacion.app.enitity.Pedido;
import com.postulacion.app.service.pedido.CrearPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pedidos")
public class CrearPedidoController {

    @Autowired
    private CrearPedidoService crearPedidoService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarPedido(@RequestBody Pedido pedido){
        crearPedidoService.registrarPedido(pedido);
        return ResponseEntity.ok("Pedido registrado");
    }
}
