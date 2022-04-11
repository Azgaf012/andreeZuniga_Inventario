package com.postulacion.app.repository;

import com.postulacion.app.dto.cliente.ReporteTransaccionesCliente;
import com.postulacion.app.enitity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Query(value = "select p.fecha, p.total as monto from pedido p where p.cliente_id=:clienteId and p.fecha>=:fechaInicio and p.fecha<=:fechaFin and p.fecha<=:fechaFin order by p.fecha desc;", nativeQuery = true)
    List<ReporteTransaccionesCliente> reporteVentasTiendaProducto(Long clienteId, Date fechaInicio, Date fechaFin);

}
