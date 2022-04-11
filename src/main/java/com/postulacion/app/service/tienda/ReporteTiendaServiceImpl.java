package com.postulacion.app.service.tienda;

import com.postulacion.app.dto.tienda.ReporteTransaccionesTienda;
import com.postulacion.app.dto.tienda.ReporteVentasProductoTienda;
import com.postulacion.app.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteTiendaServiceImpl implements ReporteTiendaService {

    @Autowired
    private TiendaRepository tiendaRepository;

    @Override
    public List<ReporteTransaccionesTienda> generarReporteTransaccionesTienda() {
        return tiendaRepository.reporteTransaccionesTienda();
    }

    @Override
    public List<ReporteVentasProductoTienda> generarReporteVentasTiendaProducto() {
        return tiendaRepository.reporteVentasTiendaProducto();
    }


}
