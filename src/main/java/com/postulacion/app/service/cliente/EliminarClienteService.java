package com.postulacion.app.service.cliente;

import com.postulacion.app.enitity.Cliente;
import org.springframework.stereotype.Service;


public interface EliminarClienteService {
    boolean eliminarCliente(Long id);
}
