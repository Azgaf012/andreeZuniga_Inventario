package com.postulacion.app.service;

import com.postulacion.app.enitity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {

    Cliente crearCliente(Cliente cliente);
    Cliente actualizarCliente(Cliente cliente);
    Cliente obtenerCliente(Long id);
    boolean eliminarCliente(Long id);
    List<Cliente> listarClientes();
}