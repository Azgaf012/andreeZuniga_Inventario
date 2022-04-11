package com.postulacion.app.service.tienda;

import com.postulacion.app.dto.tienda.ReporteTransaccionesTienda;
import com.postulacion.app.dto.tienda.ReporteVentasProductoTienda;

import java.util.List;

public interface ReporteTiendaService {

    List<ReporteTransaccionesTienda> generarReporteTransaccionesTienda();

    List<ReporteVentasProductoTienda> generarReporteVentasTiendaProducto();

}
