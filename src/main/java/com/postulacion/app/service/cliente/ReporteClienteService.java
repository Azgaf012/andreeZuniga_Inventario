package com.postulacion.app.service.cliente;

import com.postulacion.app.dto.cliente.ReporteTransaccionesCliente;

import java.util.List;

public interface ReporteClienteService {

    List<ReporteTransaccionesCliente> reporteTransaccionesCliente(Long idCliente, String fechaInicio, String fechaFin);
}
