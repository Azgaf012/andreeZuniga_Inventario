package com.postulacion.app.controller.producto;

import com.postulacion.app.enitity.Producto;
import com.postulacion.app.service.producto.ListarProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/productos")
public class ListarProductoController {

    @Autowired
    private ListarProductoService listarProductoService;

    @RequestMapping("/listar")
    public ResponseEntity<List<Producto>> listarProducto() {
        return ResponseEntity.ok(listarProductoService.listarProductos());
    }

}
