package com.postulacion.app.service.cliente;

import com.postulacion.app.enitity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ListarClienteService {
    Cliente obtenerCliente(Long idCliente);
    List<Cliente> listarClientes();
}
