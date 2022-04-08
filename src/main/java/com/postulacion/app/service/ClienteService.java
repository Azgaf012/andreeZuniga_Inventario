package com.postulacion.app.service;

import com.postulacion.app.enitity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {

    boolean crearCliente(Cliente cliente);
    Cliente actualizarCliente(Cliente cliente);
    Cliente obtenerCliente(String id);
    boolean eliminarCliente(String id);
    List<Cliente> listarClientes();
}