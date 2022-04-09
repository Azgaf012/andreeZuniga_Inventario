package com.postulacion.app.controller.producto;

import com.postulacion.app.service.producto.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/productos")
public class StockProductoController {

    @Autowired
    private StockService stockService;

    @PatchMapping("/actualizarStock")
    public ResponseEntity<String> actualizarStock(@RequestParam(name = "idProducto") Long idProducto, @RequestParam(name="cantidad") int cantidad) {
        stockService.actualizarStock(idProducto, cantidad);
        return ResponseEntity.ok("Stock actualizado");
    }
}
