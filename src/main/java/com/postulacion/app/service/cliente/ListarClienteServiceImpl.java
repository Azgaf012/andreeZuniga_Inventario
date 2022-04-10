package com.postulacion.app.service.cliente;

import com.postulacion.app.enitity.Cliente;
import com.postulacion.app.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarClienteServiceImpl implements ListarClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente obtenerCliente(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        return cliente;
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}
