package com.postulacion.app.service;

import com.postulacion.app.enitity.Cliente;
import com.postulacion.app.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public boolean crearCliente(Cliente cliente) {
        Cliente clienteCreated = clienteRepository.save(cliente);
        return true;
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente obtenerCliente(String idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        return cliente;
    }

    @Override
    public boolean eliminarCliente(String id) {
        Cliente cliente = this.obtenerCliente(id);
        clienteRepository.delete(cliente);
        return true;
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}
