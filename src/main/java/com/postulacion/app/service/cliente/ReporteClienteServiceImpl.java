package com.postulacion.app.service.cliente;

import com.postulacion.app.config.exception.BadRequestException;
import com.postulacion.app.dto.cliente.ReporteTransaccionesCliente;
import com.postulacion.app.enitity.Cliente;
import com.postulacion.app.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReporteClienteServiceImpl implements ReporteClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public List<ReporteTransaccionesCliente> reporteTransaccionesCliente(Long idCliente, String fechaInicio, String fechaFin) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        if(cliente == null){
            throw new BadRequestException("El cliente no existe");
        }
        try {
            Date fechaInicioDate = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio);
            Date fechaFinDate = new SimpleDateFormat("dd/MM/yyyy").parse(fechaFin);

            if(fechaInicioDate.after(fechaFinDate)){
                throw new BadRequestException("La fecha inicio no puede ser mayor a la fecha fin");
            }
            return clienteRepository.reporteVentasTiendaProducto(idCliente, fechaInicioDate,fechaFinDate);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }



    }
}
