package com.postulacion.app.controller.tienda;

import com.postulacion.app.service.tienda.AsignacionProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tiendas")
public class AsignarProductoController {

    @Autowired
    private AsignacionProductoService asignarProductoService;

    @PostMapping("/asignar-producto")
    public ResponseEntity<String> asignarProducto(@RequestParam("idTienda") Long idTienda, @RequestParam("idProducto") Long idProducto) {
        asignarProductoService.asignarProducto(idTienda, idProducto);
        return ResponseEntity.ok("Producto asignado correctamente");
    }

}
