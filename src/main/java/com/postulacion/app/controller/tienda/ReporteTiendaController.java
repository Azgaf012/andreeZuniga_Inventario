package com.postulacion.app.controller.tienda;

import com.postulacion.app.dto.tienda.ReporteTransaccionesTienda;
import com.postulacion.app.dto.tienda.ReporteVentasProductoTienda;
import com.postulacion.app.service.tienda.ReporteTiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/tiendas")
public class ReporteTiendaController {

    @Autowired
    private ReporteTiendaService reporteTiendaService;

    @GetMapping("/reporte-transacciones")
    public ResponseEntity<List<ReporteTransaccionesTienda>> generarReporteTransaccionesTienda() {
        List<ReporteTransaccionesTienda> reporteTransaccionesTienda = reporteTiendaService.generarReporteTransaccionesTienda();
        return ResponseEntity.ok(reporteTransaccionesTienda);
    }

    @GetMapping("/reporte-ventas-producto")
    public ResponseEntity<List<ReporteVentasProductoTienda>> generarReporteVentaProductoTienda() {
        List<ReporteVentasProductoTienda> reporteVentasProductoTiendas = reporteTiendaService.generarReporteVentasTiendaProducto();
        return ResponseEntity.ok(reporteVentasProductoTiendas);
    }

}
